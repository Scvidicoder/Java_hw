package semestr4.lab6;

public class abstractPattern {
    public static void main(String[] args) {
    // Интерфейс продукта А
    interface ProductA {
        void doSomething();
    }

    // Конкретная реализация продукта А1
    class ConcreteProductA1 implements ProductA {
        @Override
        public void doSomething() {
            System.out.println("Doing something in ConcreteProductA1");
        }
    }

    // Конкретная реализация продукта А2
    class ConcreteProductA2 implements ProductA {
        @Override
        public void doSomething() {
            System.out.println("Doing something in ConcreteProductA2");
        }
    }

    // Интерфейс продукта B
    interface ProductB {
        void doSomethingElse();
    }

    // Конкретная реализация продукта B1
    class ConcreteProductB1 implements ProductB {
        @Override
        public void doSomethingElse() {
            System.out.println("Doing something else in ConcreteProductB1");
        }
    }

    // Конкретная реализация продукта B2
    class ConcreteProductB2 implements ProductB {
        @Override
        public void doSomethingElse() {
            System.out.println("Doing something else in ConcreteProductB2");
        }
    }

    // Интерфейс абстрактной фабрики
    interface AbstractFactory {
        ProductA createProductA();
        ProductB createProductB();
    }

    // Конкретная реализация абстрактной фабрики 1
    class ConcreteFactory1 implements AbstractFactory {
        @Override
        public ProductA createProductA() {
            return new ConcreteProductA1();
        }

        @Override
        public ProductB createProductB() {
            return new ConcreteProductB1();
        }
    }

    // Конкретная реализация абстрактной фабрики 2
    class ConcreteFactory2 implements AbstractFactory {
        @Override
        public ProductA createProductA() {
            return new ConcreteProductA2();
        }

        @Override
        public ProductB createProductB() {
            return new ConcreteProductB2();
        }
    }

    // Тестовый класс


            // Создаем фабрику 1 и используем ее для создания продуктов
            AbstractFactory factory1 = new ConcreteFactory1();
            ProductA productA1 = factory1.createProductA();
            ProductB productB1 = factory1.createProductB();

            productA1.doSomething();
            productB1.doSomethingElse();

            // Создаем фабрику 2 и используем ее для создания продуктов
            AbstractFactory factory2 = new ConcreteFactory2();
            ProductA productA2 = factory2.createProductA();
            ProductB productB2 = factory2.createProductB();

            productA2.doSomething();
            productB2.doSomethingElse();
        }


}
