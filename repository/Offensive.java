package repository;

import players.Player;

public class Offensive implements BattleStrategy
{

  @Override
  public double getAttack(double health, double str)
  {
    return ((str / Player.HEALTH_SCALE) * health);
  }
  
  @Override
  public String toString()
  {
    return "Offensive";
  }
  
}
