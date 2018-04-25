public class Soldier extends Human{
  public Soldier(String name, double strength){
      super(name, 1.0, 1.0, 1.0, strength, 0.0);
  }

  public String attackMessage(){
      return "Thrusts a spear";
  }

}
