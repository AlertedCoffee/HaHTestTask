package model.AttackBehaviors;

import model.Actor;

// Класс атаки ножом.
public class KnifeAttack extends AttackBehavior{
    public KnifeAttack() {
        super(2, 6, 7);
    }

    @Override
    public void Attack(Actor protector) {
        if (protector == null) throw new IllegalArgumentException("protector не может быть равным null");

        int damageValue = AttackSuccess(protector.getProtection());
        if (damageValue != -1) {
            System.out.println("Атака ножом " + damageValue);
            protector.PerformTakeDamage(damageValue);
        }
        else {
            System.out.println("Атака ножом не удалась");
        }
    }
}
