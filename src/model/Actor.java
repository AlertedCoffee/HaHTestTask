package model;


// Класс Существа
public abstract class Actor {

    // Ссылка на реализацию атаки. В реализации хранятся параметры Атаки и Урона.
    private AttackBehavior attackBehavior;

    // Ссылка на реализацию получения урона. В реализации хранятся параметры Защиты.
    private TakeDamageBehavior takeDamageBehavior;


    // Состояние персонажа: жив - true иначе false
    private boolean alive;

    // Текущее здоровье существа.
    private int currentHealth;

    // Максимально здоровье существа.
    private final int maxHealth;

    // Существо рождается с максимальным количеством здоровья, поэтому в конструкторе есть только один параметр здоровья.
    public Actor (int maxHealth, AttackBehavior attackBehavior, TakeDamageBehavior takeDamageBehavior){
        setAttackBehavior(attackBehavior);
        setTakeDamageBehavior(takeDamageBehavior);

        if (maxHealth < 0) throw new IllegalArgumentException("maxHealth не может быть меньше 0");
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;

        this.alive = (maxHealth != 0);
    }


    // Метод атаки, вызывающий конкретную реализацию атаки.
    public void PerformAttack(Actor protector){
        attackBehavior.Attack(protector);
    }

    // Метода получения урона, вызывающий конкретную реализацию.
    public void PerformTakeDamage(int damageValue){
        if (damageValue < 0) throw new IllegalArgumentException("Нельзя нанести отрицательный урон.");

        int damage = takeDamageBehavior.TakeDamage(damageValue);
        if (damage >= currentHealth) {
            currentHealth = 0;
            alive = false;
        }
        else {
            currentHealth -= damage;
        }
    }

    //region Свойства


    public int getMaxHealth() {
        return maxHealth;
    }

    protected void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) throw new IllegalArgumentException("Нельзя задать отрицательное число");
        if (currentHealth > maxHealth) currentHealth = maxHealth;
        this.currentHealth = currentHealth;
    }

    public int getProtection(){
        return takeDamageBehavior.getProtection();
    }

    public boolean getAlive(){
        return alive;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        if (attackBehavior == null) throw new IllegalArgumentException("attackBehavior не может быть null");
        this.attackBehavior = attackBehavior;
    }

    public void setTakeDamageBehavior(TakeDamageBehavior takeDamageBehavior) {
        if (takeDamageBehavior == null) throw new IllegalArgumentException("takeDamageBehavior не может быть null");
        this.takeDamageBehavior = takeDamageBehavior;
    }

    //endregion
}
