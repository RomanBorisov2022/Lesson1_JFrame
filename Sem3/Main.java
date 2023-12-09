package Sem3;

import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) {
        String t = "Hello java";
        DataInputStream v = new DataInputStream(System.in);
        Integer k = new Integer(1);
        Class1<String, DataInputStream, Integer> class1 = new Class1<>(t, v, k);
        class1.printTypes();

        Number[] numArray = new Number[3];
        numArray[0] = 1;
        numArray[1] = 2.0f;
        numArray[2] = 1565765876L;
        MyList<Number> myList = new MyList<>(numArray);
        myList.printList();

        Integer num = 5;
        myList.addElement(num);
        myList.printList();
        System.out.println("Length: " + myList.getArrayLength());
        System.out.println("Size: " + myList.getSize());

        myList.removeElement(2);
        myList.printList();
    }
}
