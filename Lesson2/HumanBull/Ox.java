package Lesson2.HumanBull;

public class Ox implements Bull{
    @Override
    public void walk() {
        System.out.println("Walks on hooves");
    }

    @Override
    public void talk() {
        System.out.println("MoooOOooOOoo");
    }
}
