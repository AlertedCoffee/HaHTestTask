package model.Actors;

import model.Actor;
import model.AttackBehavior;
import model.TakeDamageBehavior;

public class Player extends Actor {
    private int healCount = 0;

    public void Heal() throws ExceesOfHealException {
        if (healCount >= 4) throw new ExceesOfHealException();
        setCurrentHealth((int)(getCurrentHealth() + (double)getMaxHealth()/100 * 30));
        healCount++;
        System.out.println("Отхилився. XP: "+ getCurrentHealth());
    }
    public Player(int maxHealth, AttackBehavior attackBehavior, TakeDamageBehavior takeDamageBehavior) {
        super(maxHealth, attackBehavior, takeDamageBehavior);
        System.out.println("Я игрок!");
    }
}

