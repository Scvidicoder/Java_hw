package semestr4.lab3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SynchronizedSetExample {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();


        Set<String> synchronizedSet = Collections.synchronizedSet(set);


    }
}
