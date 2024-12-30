import java.util.Random;

class Team {
    private Hero[] deck;
    private Hero[] heroList;
    private double hp;

    public Team(Hero[] deck) {
        this.deck = deck;
        this.heroList = new Hero[4];
        this.hp = 0;
    }

    public void formTeam() {
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            Hero hero = deck[rand.nextInt(deck.length)];
            this.heroList[i] = hero;
        }
        this.hp = 0;
        for (Hero hero : this.heroList) {
            this.hp += hero.getHp();
        }
    }

    public void getDamaged(double damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void resetTeamHp() {
        this.hp = 0;
        for (Hero hero : this.heroList) {
            this.hp += hero.getHp();
        }
    }

    public double getHp() {
        return this.hp;
    }

    public Hero[] getHeroList() {
        return this.heroList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTeam's HP: ").append(hp).append("\n\n");
        for (int hero = 0; hero < heroList.length; hero++) {
            sb.append("Hero ").append(hero + 1).append("\n");
            sb.append(heroList[hero]).append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }
}