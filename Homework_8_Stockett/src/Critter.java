public abstract class Critter implements Comparable<Critter>{
    private static int lastId = 1000;
    private int id;
    private String name;
    private double health;
    private double speed;
    private double agility;
    private double strength;
    private double armorStrength;

    public Critter(String name, double health, double speed, double agility,
                   double strength, double armorStrength){
        setId();
        setName(name);
        setHealth(health);
        setSpeed(speed);
        setAgility(agility);
        setStrength(strength);
        setArmorStrength(armorStrength);

    }

    private void setId(){
        this.id = ++lastId;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setHealth(double health){
        if(health < 0.0)
            health = 0.0;
        this.health = health;
    }

    private void setSpeed(double speed){
        if(speed < 0.0)
            speed = 0.0;
        this.speed = speed;
    }

    private void setAgility(double agility){
        if(agility < 0.0)
            agility = 0.0;
        this.agility = agility;
    }

    private void setStrength(double strength){
        if(strength < 0.0)
            strength = 0.0;
        this.strength = strength;
    }

    private void setArmorStrength(double armorStrength){
        if(armorStrength < 0.0)
            armorStrength = 0.0;
        this.armorStrength = armorStrength;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAgility() {
        return agility;
    }

    public double getStrength() {
        return strength;
    }

    public double getArmorStrength() {
        return armorStrength;
    }

    @Override
    public String toString(){
        return String.format(" %-7s Name: %-18s Id: %-5d  Health: %1.2f  Speed: %1.2f  Agility: %1.2f " +
                " Strength: %1.2f  Armor Strength: %1.2f", (this.getClass().toString()).substring(6), getName(),
                getId(),  getHealth(), getSpeed(), getAgility(), getStrength(), getArmorStrength());
    }
    public int compareTo(Critter other){
        int result;
        result = this.name.compareToIgnoreCase(other.name);
        if(result == 0){
            result = (int)((this.health - other.health) * 100000);
        }
        if(result == 0){
            result = this.id - other.id;
        }
        return result;
    }
    public double attackEffectiveness(){
            double effectivness = getStrength() * getAgility() * getSpeed() * getHealth();
            if(this instanceof VisionImpaired)
                effectivness *= ((VisionImpaired) this).impairment();
            if(effectivness < 0.0)
                effectivness = 0.0;
            return effectivness;
        }

    final public double acceptDamage(double damage){
        double healthReduction = 0.0;
        if(this.armorStrength > Math.random()){
            armorStrength -= damage/2;
        }else {
            healthReduction = damage;
        }
        health -= healthReduction;
        return healthReduction;
    }
    public boolean isDead(){
        return (health < 0.0);
    }
    public abstract String attackMessage();
}
