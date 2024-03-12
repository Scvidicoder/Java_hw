package semestr4.lab3;

public class LockedListExampleTest {

    public static void main(String[] args) throws InterruptedException {
        // Создаем экземпляр потокобезопасного списка
        LockedListExample<Integer> lockedListExample = new LockedListExample<>();

        // Создаем и запускаем два потока для добавления элементов
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                lockedListExample.addToList(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                lockedListExample.addToList(i);
            }
        });

        thread1.start();
        thread2.start();

        // Ждем завершения работы потоков
        thread1.join();
        thread2.join();

        // Печатаем размер списка после добавления элементов в нескольких потоках
        System.out.println("Size after adding elements: " + lockedListExample.getSize());

        // Печатаем наличие элементов в списке
        System.out.println("Contains 3: " + lockedListExample.containsElement(3));
        System.out.println("Contains 15: " + lockedListExample.containsElement(15));

        // Удаляем элемент из списка
        System.out.println("Removing 5: " + lockedListExample.removeFromList(5));

        // Печатаем размер после удаления элемента
        System.out.println("Size after removing element: " + lockedListExample.getSize());
    }
}
