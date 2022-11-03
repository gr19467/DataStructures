public class GiraffeDuck extends RubberDuck{

    @Override
    protected void chooseDuck() {
        System.out.println("Choose me, I'm a giraffe.");
    }

    @Override
    protected void consult() {
        System.out.println("You forgot to import your JAR files.");
    }
}
