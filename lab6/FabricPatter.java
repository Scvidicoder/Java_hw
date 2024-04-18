package semestr4.lab6;

public class FabricPatter {

    public static void main(String[] args) {

    interface Product {
        void doSomething();
    }
    class ConcreteProductA implements Product {
        @Override
        public void doSomething() {
            System.out.println("Doing something in ConcreteProductA");
        }
    }

    class ConcreteProductB implements Product {
        @Override
        public void doSomething() {
            System.out.println("Doing something in ConcreteProductB");
        }
    }
//определяет метод для создания объекта, но позволяет подклассам выбирать класс создаваемого объекта
    // Интерфейс фабрики
    interface Factory {
        Product createProduct();
    }

    // Реализация фабрики для продукта А
    class ConcreteFactoryA implements Factory {
        @Override
        public Product createProduct() {
            return new ConcreteProductA();
        }
    }

    // Реализация фабрики для продукта B
    class ConcreteFactoryB implements Factory {
        @Override
        public Product createProduct() {
            return new ConcreteProductB();
        }
    }

        // Используем фабрику для создания продукта А
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.createProduct();
        productA.doSomething();

        // Используем фабрику для создания продукта B
        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.createProduct();
        productB.doSomething();
    }

}
