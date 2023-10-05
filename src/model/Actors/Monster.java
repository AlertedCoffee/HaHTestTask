package model.Actors;

import model.Actor;
import model.AttackBehavior;
import model.TakeDamageBehavior;

public class Monster extends Actor {
    public Monster(int maxHealth, AttackBehavior attackBehavior, TakeDamageBehavior takeDamageBehavior) {
        super(maxHealth, attackBehavior, takeDamageBehavior);
        System.out.println("Я монстр!");
    }
}
