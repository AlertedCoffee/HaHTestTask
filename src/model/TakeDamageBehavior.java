
package model;

// Абстрактный класс получения урона.
public abstract class TakeDamageBehavior {

    // Параметр защиты.
    private final int protection;

    public int getProtection() {
        return protection;
    }
    public TakeDamageBehavior(int protection){
        if (protection < 1 || protection > 30) throw new IllegalArgumentException("protection - натуральное число от 1 до 30");
        this.protection = protection;
    }

    // Реализация получения урона.
    public abstract int TakeDamage(int damageValue);
}
