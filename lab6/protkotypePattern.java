//который позволяет создавать новые объекты путем копирования существующих объектов, то есть путем клонирования

package semestr4.lab6;
import java.util.HashMap;
import java.util.Map;
public class protkotypePattern {


    public static void main(String[] args) {
    // Интерфейс Прототипа
    interface Prototype {
        Prototype clone();
    }

    // Конкретная реализация Прототипа
    class ConcretePrototype implements Prototype {
        private String name;

        public ConcretePrototype(String name) {
            this.name = name;
        }

        // Метод для клонирования объекта
        @Override
        public Prototype clone() {
            return new ConcretePrototype(this.name);
        }

        @Override
        public String toString() {
            return "ConcretePrototype{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    // Класс для управления прототипами
    class PrototypeManager {
        private static Map<String, Prototype> prototypes = new HashMap<>();

        // Добавление прототипа в менеджер
        public static void addPrototype(String key, Prototype prototype) {
            prototypes.put(key, prototype);
        }

        // Получение копии прототипа по ключу
        public static Prototype getPrototype(String key) {
            Prototype prototype = prototypes.get(key);
            if (prototype != null) {
                return prototype.clone();
            }
            return null;
        }
    }

    // Тестовый класс

            // Создаем и регистрируем прототип
            ConcretePrototype original = new ConcretePrototype("Original");
            PrototypeManager.addPrototype("Original", original);

            // Получаем копию прототипа по ключу
            Prototype clone = PrototypeManager.getPrototype("Original");

            // Проверяем, что клонирование прошло успешно
            if (clone != null) {
                System.out.println("Cloned: " + clone);
            } else {
                System.out.println("Clone not found");
            }
        }


}
