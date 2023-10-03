package Tests;

import model.Actor;
import model.Actors.ExceesOfHealException;
import model.Actors.Monster;
import model.Actors.Player;
import model.AttackBehaviors.AttackBehavior;
import model.AttackBehaviors.KnifeAttack;
import model.AttackBehaviors.SimpleAttack;
import model.TakeDamageBehaviors.SimpleProtection;
import model.TakeDamageBehaviors.TakeDamageBehavior;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    // Проверка лечения.
    @org.junit.jupiter.api.Test
    void heal() {
        Player player = new Player(15, new SimpleAttack(), new SimpleProtection());

        Monster monster = new Monster(5, new KnifeAttack(), new SimpleProtection());
        monster.PerformAttack(player);

        int saveHealth = player.getCurrentHealth();

        System.out.println("XP игрока: " + player.getCurrentHealth());
        try {
            player.Heal();
        }
        catch (Exception ex){ Assertions.fail();}

        Assertions.assertNotEquals(saveHealth, player.getCurrentHealth());
    }

    // Проверка левой границы количества лечений.
    @org.junit.jupiter.api.Test
    void healNoException() {
        Player player = new Player(15, new SimpleAttack(), new SimpleProtection());

        Monster monster = new Monster(5, new KnifeAttack(), new SimpleProtection());
        monster.PerformAttack(player);


        System.out.println("XP игрока: " + player.getCurrentHealth());
        try {
            player.Heal();
            player.Heal();
            player.Heal();
            player.Heal();
        }
        catch (Exception ex) {Assertions.fail(); }
    }

    @org.junit.jupiter.api.Test
    void healException() {
        Player player = new Player(15, new SimpleAttack(), new SimpleProtection());

        Monster monster = new Monster(5, new KnifeAttack(), new SimpleProtection());
        monster.PerformAttack(player);

        System.out.println("XP игрока: " + player.getCurrentHealth());
        try {
            player.Heal();
            player.Heal();
            player.Heal();
            player.Heal();
            player.Heal();
        }
        catch (ExceesOfHealException ex){
            Assertions.assertEquals("Превышено количество лечений", ex.getMessage());
            return;
        }
        Assertions.fail();
    }
}