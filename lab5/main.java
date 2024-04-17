package semestr4.lab5;


public class main {
    public static void main(String [] args){
        Singleton single1 = Singleton.getInstance();
        Singleton single2 = Singleton.getInstance();

        System.out.println("1 способ:");
        System.out.println(single1);
        System.out.println(single2);

        System.out.println("2 способ:");
        SingletonDoubleChecked single3 = SingletonDoubleChecked.getInstance();
        SingletonDoubleChecked single4 = SingletonDoubleChecked.getInstance();
        System.out.println(single3);
        System.out.println(single4);

        System.out.println("3 способ:");
        Singleton2 single5 = Singleton2.INSTANCE.getInstance();
        Singleton2 single6 = Singleton2.INSTANCE.getInstance();
        System.out.println(single5);
        System.out.println(single6);

    }
}
