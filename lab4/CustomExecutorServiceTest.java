package semestr4.lab4;

public class CustomExecutorServiceTest {
    public static void main(String[] args) {
        // Создаем экземпляр CustomExecutorService с тремя потоками
        CustomExecutorService executor = new CustomExecutorService(3);

        // Запускаем несколько задач
        executor.execute(() -> {
            System.out.println("Task 1 executed by thread " + Thread.currentThread().getName());
        });

        executor.execute(() -> {
            System.out.println("Task 2 executed by thread " + Thread.currentThread().getName());
        });

        executor.execute(() -> {
            System.out.println("Task 3 executed by thread " + Thread.currentThread().getName());
        });
    }
}
