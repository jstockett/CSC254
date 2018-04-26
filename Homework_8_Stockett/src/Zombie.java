public class Zombie extends Human implements VisionImpaired {
    public Zombie(){
        super("Zeke the Zombie", 0.5, 0.5, 0.25, 2.0, 0.0);
    }

    public String attackMessage(){
        return "Bites";
    }
    public double impairment(){
        return 1.0 - getHealth();
    }
}
