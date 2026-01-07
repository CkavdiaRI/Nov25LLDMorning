package Module2.Facade;

class Amplifier2 {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void off() {
        System.out.println("Amplifier is off");
    }
}

class DVDPlayer2 {
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Stopping DVD player");
    }
}

class Projector2 {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }
}

class Screen2 {
    public void down() {
        System.out.println("Screen is down");
    }

    public void up() {
        System.out.println("Screen is up");
    }
}

class Light2 {
    public void dim() {
        System.out.println("Lights are dimmed");
    }

    public void bright() {
        System.out.println("Lights are brightened");
    }
}

class PopcornPopper2 {
    public void pop() {
        System.out.println("Popcorn is popping");
    }

    public void stop() {
        System.out.println("Popcorn is stopped");
    }
}

class Helper{
    public static void watchMovie(String movie){
        PopcornPopper2 popcornPopper = new PopcornPopper2();
        Light2 light = new Light2();
        Screen2 screen = new Screen2();
        Projector2 projector = new Projector2();
        Amplifier2 amplifier = new Amplifier2();
        DVDPlayer2 dvdPlayer = new DVDPlayer2();

        popcornPopper.pop();
        light.dim();
        screen.down();
        projector.on();
        amplifier.on();
        dvdPlayer.play(movie);
    }
}

public class Sol2 {
    public static void main(String[] args) {
        Helper.watchMovie("Inception");
    }
}

// Pros :
// Clients interact with a simplified interface, reducing complexity.
// Client does not need to know about the subsystem components.
// Client would need to change if any component's interface changes.