package Module2.Prototype.PrototypeDP;

public class AI implements Prototype<AI>{
    String behavior;

    public AI(String behavior) {
        simulateLoad();
        this.behavior = behavior;
    }

    AI(AI ai){
        this. behavior = ai.behavior;
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

    @Override
    public AI clone(){
        return new AI(this);
    }
}
