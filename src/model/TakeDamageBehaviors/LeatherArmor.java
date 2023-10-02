package model.TakeDamageBehaviors;

// Класс реализации конкретной атаки. Кожаная брони, поглощающий 25% урона.
public class LeatherArmor extends TakeDamageBehavior{
    public LeatherArmor() {
        super(5);
    }

    @Override
    public int TakeDamage(int damageValue) {
        int newDamageValue = (int) (damageValue - (double)damageValue / 100 * 25);
        System.out.println("Ай. -" + newDamageValue + "xp");
        return newDamageValue;
    }
}
