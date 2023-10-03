package Tests;

import model.Actor;
import model.AttackBehaviors.AttackBehavior;
import model.AttackBehaviors.SimpleAttack;
import model.TakeDamageBehaviors.SimpleProtection;
import model.TakeDamageBehaviors.TakeDamageBehavior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeActor extends Actor {

    protected SomeActor(int maxHealth, AttackBehavior attackBehavior, TakeDamageBehavior takeDamageBehavior) {
        super(maxHealth, attackBehavior, takeDamageBehavior);
    }

    // Переопределение setCurrentHealth для получения доступа.
    @Override
    protected void setCurrentHealth(int currentHealth) {
        super.setCurrentHealth(currentHealth);
    }
}
class ActorTest{

    // Тест на отрицательное здоровье.
    @Test
    void testMaxHealth1(){
        try {
            SomeActor actor = new SomeActor(-5, new SimpleAttack(), new SimpleProtection());
        }
        catch (Exception ex){
            Assertions.assertEquals("maxHealth не может быть меньше 0", ex.getMessage());
            return;
        }
        Assertions.fail();
    }

    // Тест на нулевое здоровье. Персонаж должен быть мертв.
    @Test
    void testMaxHealth2(){
        SomeActor actor = new SomeActor(0, new SimpleAttack(), new SimpleProtection());
        Assertions.assertFalse(actor.getAlive());
    }

    // Проверка на нормально значение.
    @Test
    void testMaxHealth3(){
        try {
            SomeActor actor = new SomeActor(5, new SimpleAttack(), new SimpleProtection());
        }
        catch (Exception ex){
            Assertions.fail();
        }
    }

    // Отрицательное значение для setCurrentHealth.
    @Test
    void testSetCurrentHealth() {
        try {
            SomeActor actor = new SomeActor(5, new SimpleAttack(), new SimpleProtection());
            actor.setCurrentHealth(-5);
        }
        catch (Exception ex){
            Assertions.assertEquals("Нельзя задать отрицательное число", ex.getMessage());
            return;
        }
        Assertions.fail();
    }


    // Проверка на задание AttackBehavior значением null.
    @Test
    void testSetAttackBehavior() {
        SomeActor actor = new SomeActor(5, new SimpleAttack(), new SimpleProtection());
        try {
            actor.setAttackBehavior(null);
        }
        catch (Exception ex){
            Assertions.assertEquals("attackBehavior не может быть null", ex.getMessage());
            return;
        }
        Assertions.fail();
    }

    // // Проверка на задание TakeDamageBehavior значением null.
    @Test
    void testSetTakeDamageBehavior() {
        SomeActor actor = new SomeActor(5, new SimpleAttack(), new SimpleProtection());
        try {
            actor.setTakeDamageBehavior(null);
        }
        catch (Exception ex){
            Assertions.assertEquals("takeDamageBehavior не может быть null", ex.getMessage());
            return;
        }
        Assertions.fail();
    }
}