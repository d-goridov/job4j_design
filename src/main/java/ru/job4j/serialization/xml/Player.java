package ru.job4j.serialization.xml;

public class Player {
    final private int id;
    private double balance;
    private boolean hasPremium;
    private String nickName;
    private Hero hero;
    private String[] perk;

    public Player(int id, double balance, boolean hasPremium, String nickName, Hero hero, String... perk) {
        this.id = id;
        this.balance = balance;
        this.hasPremium = hasPremium;
        this.nickName = nickName;
        this.hero = hero;
        this.perk = perk;
    }

    @Override
    public String toString() {
        return "Player{"
                + "id=" + id
                + ", balance=" + balance
                + ", hasPremium=" + hasPremium
                + ", nickName='" + nickName + '\''
                + ", hero=" + hero
                + '}';
    }

    public static void main(String[] args) {
        Player player1 = new Player(94, 12.54, false,
                "pupsik", new Hero("Scorpion"), "Fire", "Teleport");
    }
}
