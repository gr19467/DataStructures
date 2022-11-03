public class SoccerDuck extends RubberDuck{
    @Override
    protected void chooseDuck() {
        System.out.println("Choose me, I play soccer.");
    }

    @Override
    protected void consult() {
        System.out.println("You're missing a semicolon on line 43.");
    }

    @Override
    protected void lost() {
        System.out.println("Your duck somehow has not been lost by the next class period.");
    }
}
