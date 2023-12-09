package PairClass;

public class Main {
    public static void main(String[] args) {

        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Double, Boolean> pair2 = new Pair<>(3.14, true);

        System.out.println("Pair 1: " + pair1.toString());
        System.out.println("Pair 2: " + pair2.toString());
    }
}
