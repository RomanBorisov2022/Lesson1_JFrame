package Dev;

public class Backender extends Developer implements BackAction{
    @Override
    public void back() {
        System.out.println("Backender is working");
    }
}
