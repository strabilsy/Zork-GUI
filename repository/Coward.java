package repository;

public class Coward implements BattleStrategy
{

  @Override
  public double getAttack(double health, double str)
  {
    return 0;
  }
  
  @Override
  public String toString()
  {
    return "Coward";
  }
  
}
