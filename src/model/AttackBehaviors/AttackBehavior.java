package model.AttackBehaviors;

import model.Actor;

import java.util.Random;

// Абстрактный класс нанесения урона.
public abstract class AttackBehavior {

    // Урон существа.
    protected final int minDamage;
    protected final int maxDamage;

    // Параметр атаки.
    protected final int attack;


    public AttackBehavior(int minDamage, int maxDamage, int attack){
        if (attack < 1 || attack > 30) throw new IllegalArgumentException("attack - натуральное число от 1 до 30");
        this.attack = attack;

        if (maxDamage <= minDamage) throw new IllegalArgumentException("maxDamage не может быть меньше или равен minDamage");
        if (minDamage < 1) throw new IllegalArgumentException("maxDamage и minDamage - натуральные числа, больше 1");
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    // Метод расчета модификатора удара.
    protected int CountModifier(int protection){
        return attack - protection + 1;
    }

    // Метод расчета урона. Возвращает -1 при неудачной атаке.
    protected int AttackSuccess(int protection){
        int cubeCount = CountModifier(protection);
        cubeCount = Math.max(cubeCount, 1);

        Random random = new Random();
        for (int i = 1; i <= cubeCount; i++){
            if( random.nextInt(6) + 1 >= 5) {
                return  random.nextInt(maxDamage - minDamage + 1) + minDamage;
            }
        }

        return -1;
    }

    // Реализация нанесения урона.
    public abstract void Attack (Actor protector);
}
