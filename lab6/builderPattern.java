package semestr4.lab6;

public class builderPattern {
    public static void main(String[] args) {
    // Продукт, который мы будем строить
    class Product {
        private String part1;
        private String part2;
        private String part3;

        public void setPart1(String part1) {
            this.part1 = part1;
        }

        public void setPart2(String part2) {
            this.part2 = part2;
        }

        public void setPart3(String part3) {
            this.part3 = part3;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "part1='" + part1 + '\'' +
                    ", part2='" + part2 + '\'' +
                    ", part3='" + part3 + '\'' +
                    '}';
        }
    }

    // Интерфейс строителя
    interface Builder {
        void buildPart1();
        void buildPart2();
        void buildPart3();
        Product getResult();
    }

    // Конкретный строитель
    class ConcreteBuilder implements Builder {
        private Product product;

        public ConcreteBuilder() {
            this.product = new Product();
        }

        @Override
        public void buildPart1() {
            product.setPart1("Part 1");
        }

        @Override
        public void buildPart2() {
            product.setPart2("Part 2");
        }

        @Override
        public void buildPart3() {
            product.setPart3("Part 3");
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    // Директор, который управляет процессом строительства
    class Director {
        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public void construct() {
            builder.buildPart1();
            builder.buildPart2();
            builder.buildPart3();
        }
    }

    // Тестовый класс


            // Создаем конкретного строителя
            Builder builder = new ConcreteBuilder();

            // Создаем директора и передаем ему строителя
            Director director = new Director(builder);

            // Директор управляет процессом строительства
            director.construct();

            // Получаем результат от строителя
            Product product = builder.getResult();
            System.out.println(product);
        }


}
