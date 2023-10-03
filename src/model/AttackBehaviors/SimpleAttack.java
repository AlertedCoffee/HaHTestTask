package model.AttackBehaviors;

import model.Actor;

// Класс простой атаки.
public class SimpleAttack extends AttackBehavior{
    public SimpleAttack() {
        super(1, 2, 5);
    }

    @Override
    public void Attack(Actor protector) {
        if (protector == null) throw new IllegalArgumentException("protector не может быть равным null");

        int damageValue = AttackSuccess(protector.getProtection());
        if (damageValue != -1) {
            System.out.println("Атака " + damageValue);
            protector.PerformTakeDamage(damageValue);
        }
        else {
            System.out.println("Атака не удалась");
        }
    }
}
