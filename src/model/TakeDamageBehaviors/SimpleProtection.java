package model.TakeDamageBehaviors;

import model.TakeDamageBehavior;

// Класс реализации конкретной атаки. Персонаж без брони.
public class SimpleProtection extends TakeDamageBehavior {
    public SimpleProtection() {
        super(1);
    }

    @Override
    public int TakeDamage(int damageValue) {
        System.out.println("Ай. -" + damageValue + "xp");
        return damageValue;
    }
}
