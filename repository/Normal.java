package repository;

import players.Player;
import utility.SingleRandom;

public class Normal implements BattleStrategy
{
  @Override
  public double getAttack(double health, double str)
  {
    double attack = 0;
    if(SingleRandom.getInstance().nextInt(0,1) == 0)
    {
      attack = ((str / Player.HEALTH_SCALE) * health);
    }
    return attack;
  }
  
  @Override
  public String toString()
  {
    return "Normal";
  }
}
