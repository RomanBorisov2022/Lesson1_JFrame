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
        System.out.println("\n");
        Integer num = 5;
        myList.addElement(num);
        myList.printList();
        System.out.println("Length: " + myList.getArrayLength());
        System.out.println("Size: " + myList.getSize());
        System.out.println("\n");
        myList.removeElement(2);
        myList.printList();
        System.out.println("Length: " + myList.getArrayLength());
        System.out.println("Size: " + myList.getSize());
        System.out.println("\n");
        MyList<Number> myList1 = new MyList<>();
        myList1.addElement(1);
        myList1.addElement(3);
        myList1.addElement(6);
        myList1.printList();
    }
}
