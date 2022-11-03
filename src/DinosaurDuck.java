public class DinosaurDuck extends RubberDuck {
    @Override
    protected void chooseDuck() {
        System.out.println("Choose me, I'm a dinosaur.");
    }

    @Override
    protected void consult() {
        System.out.println("You didn't instantiate the object you're trying to use.");
    }
}
