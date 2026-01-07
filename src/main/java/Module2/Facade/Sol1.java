package Module2.Facade;

class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void off() {
        System.out.println("Amplifier is off");
    }
}

class DVDPlayer {
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Stopping DVD player");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }
}

class Screen {
    public void down() {
        System.out.println("Screen is down");
    }

    public void up() {
        System.out.println("Screen is up");
    }
}

class Light {
    public void dim() {
        System.out.println("Lights are dimmed");
    }

    public void bright() {
        System.out.println("Lights are brightened");
    }
}

class PopcornPopper {
    public void pop() {
        System.out.println("Popcorn is popping");
    }

    public void stop() {
        System.out.println("Popcorn is stopped");
    }
}

public class Sol1 {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        Light light = new Light();
        PopcornPopper popcornPopper = new PopcornPopper();

        // Simulating watching a movie without Facade
        popcornPopper.pop();
        light.dim();
        screen.down();
        projector.on();
        amplifier.on();
        dvdPlayer.play("Inception");
    }
}


// Cons :
// 1. Client needs to know about all the components
// if client messes up the order of operations, it can lead to errors
// Any change in the subsystem requires changes in the client code