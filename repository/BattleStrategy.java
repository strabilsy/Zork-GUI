package repository;

public interface BattleStrategy
{
  double getAttack(double health, double str);
  String toString();
}
