public class Scout extends Human{
    public Scout(String name, double health, double speed, double agility, double strength){
        super(name, health, speed, agility, strength, 0.0);
    }

    public String attackMessage(){
        return "Swings his fist";
    }
}
