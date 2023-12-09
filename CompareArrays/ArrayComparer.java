package CompareArrays;

public class ArrayComparer {

    public static <T> String compareArrays(T[] array1, T[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Один из массивов равен null.");
        }

        int lengthComparison = Integer.compare(array1.length, array2.length);

        if (lengthComparison != 0) {
            return "Массивы разной длинны";
        }

        for (int i = 0; i < array1.length; i++) {
            int elementComparison = ((Comparable<T>) array1[i]).compareTo(array2[i]);
            if (elementComparison != 0) {
                return "Массивы различаются на позиции " + i + ".";
            }
        }

        // Если массивы одинаковые
        return "Массивы идентичны";
    }
}