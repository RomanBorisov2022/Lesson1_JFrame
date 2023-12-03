package Lesson2.HumanBull;

public class Man implements Human{
    @Override
    public void walk() {
        System.out.println("Walks on two feet");
    }

    @Override
    public void talk() {
        System.out.println("Talks meaningful words");
    }
}
