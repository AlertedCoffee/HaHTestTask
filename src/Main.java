import model.Actor;
import model.Actors.Monster;
import model.Actors.Player;
import model.AttackBehaviors.KnifeAttack;
import model.AttackBehaviors.SimpleAttack;
import model.TakeDamageBehaviors.LeatherArmor;
import model.TakeDamageBehaviors.SimpleProtection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Actor chel = new Player(15, new SimpleAttack(), new SimpleProtection());
        Actor neChel = new Monster(10, new SimpleAttack(), new SimpleProtection());
        System.out.println();



        System.out.println("XP монстра: " + neChel.getCurrentHealth() + (neChel.getAlive() ? " Жив" : " Мертв"));
        chel.PerformAttack(neChel);
        System.out.println("XP монстра: " + neChel.getCurrentHealth() + (neChel.getAlive() ? " Жив" : " Мертв"));
        System.out.println();



        chel.setAttackBehavior(new KnifeAttack());
        neChel.setTakeDamageBehavior(new LeatherArmor());

        chel.PerformAttack(neChel);
        System.out.println("XP монстра: " + neChel.getCurrentHealth() + (neChel.getAlive() ? " Жив" : " Мертв"));
        System.out.println();
        neChel.setTakeDamageBehavior(new SimpleProtection());



        chel.PerformAttack(neChel);
        chel.PerformAttack(neChel);
        System.out.println("XP монстра: " + neChel.getCurrentHealth() + (neChel.getAlive() ? " Жив" : " Мертв"));

    }
}