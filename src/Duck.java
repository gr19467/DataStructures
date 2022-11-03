public class Duck implements Flyable, Throwable, Swimable{

    @Override
    public void startFlying() {
        System.out.println("The duck takes flight.");
    }

    @Override
    public void stopFlying() {
        System.out.println("The duck plummets from the sky, somehow surviving.");
    }

    @Override
    public void jumpInWater() {
        System.out.println("The duck jumps in the water.");
    }

    @Override
    public void dontDrown() {
        System.out.println("The duck swims, not drowning.");
    }

    @Override
    public void chuckTheDuck() {
        System.out.println("You chuck the duck across the room.");
    }
}
