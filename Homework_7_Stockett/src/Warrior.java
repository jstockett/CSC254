public class Warrior extends Human implements VisionImpaired{
    public Warrior(String name){
        super(name, 1.0, 0.90, 0.90, 1.20, 0.90);
    }

    public double impairment(){
        return getArmorStrength() / 2;
    }

    public String attackMessage(){
        return (Math.random() > 0.40) ? "Swings a massive sword" : "Thrusts a sword";
    }

}
