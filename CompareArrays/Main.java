package CompareArrays;

import static CompareArrays.ArrayComparer.compareArrays;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray1 = {1, 2, 3, 4, 5};
        Integer[] intArray2 = {1, 2, 3, 4, 5, 6};
        System.out.println("Сравнение массивов целых чисел: " + compareArrays(intArray1, intArray2));

        String[] strArray1 = {"apple", "banana", "orange"};
        String[] strArray2 = {"apple", "banana", "orange", "kiwi"};
        System.out.println("Сравнение массивов строк: " + compareArrays(strArray1, strArray2));

        Double[] doubleArray1 = {1.5, 2.0, 3.7};
        Double[] doubleArray2 = {1.5, 2.0, 3.7};
        System.out.println("Сравнение массивов вещественных чисел: " + compareArrays(doubleArray1, doubleArray2));
    }
}
