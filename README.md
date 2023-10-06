# # HaHTestTask

tg: [@MatveyOzolin](https://t.me/MatveyOzolin)

Для реализации проекта по [заданию Heads x Hands](https://docs.google.com/document/d/1lfpe1JDCuGMQ3cFyn5oNk2PqRO94z6IqCq6yoTaUsYo/edit) я решил использовать паттерн проектирования Стратегия, это позволяет оставить код закрытым для изменений, но открытым для расширения.

Таким образом, создан класс Actor с основными параметрами здоровья, параметры Атаки и Урона были вынесены в абстрактный класс AttackBehavior, а параметр Защиты в TakeDamageBehavior (см. диаграмму классов).

![Диаграмма классов](https://i.imgur.com/ebPpi9m.png)
Диаграмма классов

В объектах Actor хранится ссылка на определенную реализацию Атаки и Защиты, что позволяет менять их на этапе выполнения и хранить типовые параметры, как в приведенных примерах в виде SimpleAttack, SimpleProtection и т.д. Вызывая у Actor PerfomAttack, вызывается определенная реализация attackBehavior.Attack(), так и с PerfomTakeDamage (это метод, посредством которого персонаж получает урон). Эта архитектура так же позволяет при расширении переопределять принципы получения модификатора атаки и вычисления урона (например при каких-то необычных видах оружия). Таким же образом работает и с получением урона.

(Можно было бы завернуть все в декораторы, но это уже лишнее, на мой взгляд)

Класс Player расширяет Actor возможностью лечиться с ограниченным количеством раз.

В задании не было ничего сказано про Display методы, потому в классах наследниках местами встречаются не совсем уместные системауты, которые нужно было бы вынести в отдельные методы, вызывающие реализацию какого-нибудь интерфейса, чтобы “визуальная” составляющая объектов не находилась в классе.