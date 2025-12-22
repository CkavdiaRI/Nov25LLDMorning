package Module2.Prototype.BoilerPlate;

public class AI {
    String behavior;

    public AI(String behavior) {
        simulateLoad();
        this.behavior = behavior;
    }

    private void simulateLoad() {
        try {
            System.out.println("Configuring AI engine...");
            Thread.sleep(1000); // simulate setup
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getBehavior() {
        return behavior;
    }
}