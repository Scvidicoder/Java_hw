package semestr4.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedListExample<T> {
    private final List<T> list = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addToList(T element) {
        lock.lock();
        try {
            list.add(element);
        } finally {
            lock.unlock();
        }
    }

    public boolean removeFromList(T element) {
        lock.lock();
        try {
            return list.remove(element);
        } finally {
            lock.unlock();
        }
    }

    public boolean containsElement(T element) {
        lock.lock();
        try {
            return list.contains(element);
        } finally {
            lock.unlock();
        }
    }

    public int getSize() {
        lock.lock();
        try {
            return list.size();
        } finally {
            lock.unlock();
        }
    }




}
