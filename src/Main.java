import model.Actor;
import model.Actors.ExceesOfHealException;
import model.Actors.Monster;
import model.Actors.Player;
import model.AttackBehaviors.KnifeAttack;
import model.AttackBehaviors.SimpleAttack;
import model.TakeDamageBehaviors.LeatherArmor;
import model.TakeDamageBehaviors.SimpleProtection;

public class Main {
    public static void main(String[] args) throws ExceesOfHealException {

        Player player = new Player(15, new SimpleAttack(), new SimpleProtection());
        Monster monster = new Monster(10, new SimpleAttack(), new SimpleProtection());
        System.out.println();


        System.out.println("Удар игрока и демонстрация реакции монстра");
        System.out.println("XP монстра: " + monster.getCurrentHealth() + (monster.getAlive() ? " Жив" : " Мертв"));
        player.PerformAttack(monster);
        System.out.println("XP монстра: " + monster.getCurrentHealth() + (monster.getAlive() ? " Жив" : " Мертв"));
        System.out.println();

        System.out.println("Демонстрация лечения персонажа");
        monster.PerformAttack(player);
        System.out.println("XP игрока: " + player.getCurrentHealth() + (player.getAlive() ? " Жив" : " Мертв"));
        player.Heal();
        System.out.println();



        player.setAttackBehavior(new KnifeAttack());
        monster.setTakeDamageBehavior(new LeatherArmor());

        System.out.println("Демонстрация другого типа брони");
        player.PerformAttack(monster);
        System.out.println("XP монстра: " + monster.getCurrentHealth() + (monster.getAlive() ? " Жив" : " Мертв"));
        System.out.println();


        System.out.println("Демонстрация убийства");
        monster.setTakeDamageBehavior(new SimpleProtection());
        while (monster.getAlive()) {
            player.PerformAttack(monster);
        }
        System.out.println("XP монстра: " + monster.getCurrentHealth() + (monster.getAlive() ? " Жив" : " Мертв"));

    }
}