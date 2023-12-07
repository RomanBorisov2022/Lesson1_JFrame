package Dev;

public class Fullstack extends Developer implements BackAction, FrontAction{
    @Override
    public void back() {
        System.out.println("Back working");
    }

    @Override
    public void front() {
        System.out.println("Front working");
    }
}
