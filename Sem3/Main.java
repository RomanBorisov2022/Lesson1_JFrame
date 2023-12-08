package Sem3;

import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) {
        String t = "Hello java";
        DataInputStream v = new DataInputStream(System.in);
        Integer k = new Integer(1);
        Class1<String, DataInputStream, Integer> class1 = new Class1<>(t, v, k);
        class1.printTypes();
    }
}
