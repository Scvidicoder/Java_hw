package semestr4.lab4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomExecutorService {
    private final int nThreads;
    private final PoolWorker[] threads;
    private final BlockingQueue<Runnable> queue;

    public CustomExecutorService(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue<>();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable task;

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.err.println("An error occurred while waiting for task: " + e.getMessage());
                        }
                    }
                    task = queue.poll();
                }

                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.err.println("RuntimeException in task execution: " + e.getMessage());
                }
            }
        }
    }


}
