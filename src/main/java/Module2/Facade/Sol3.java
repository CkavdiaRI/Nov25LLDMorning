package Module2.Facade;

// Facade Design Pattern :
// facade simplifies the interaction with a complex system by providing a unified interface.

class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private Screen screen;
    private Light light;
    private PopcornPopper popper;

    public HomeTheaterFacade() {
        this.amp = new Amplifier();
        this.dvd = new DVDPlayer();
        this.projector = new Projector();
        this.screen = new Screen();
        this.light = new Light();
        this.popper = new PopcornPopper();
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.pop();
        light.dim();
        screen.down();
        projector.on();
        amp.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.stop();
        light.bright();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
    }
}

public class Sol3 {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchMovie("Inception");
        // To end the movie, you can call:
        // homeTheater.endMovie();
    }
}
