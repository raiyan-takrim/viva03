class Villain {
    private String name;
    private String element;
    private double maxHp;
    private double hp;
    private double attack;
    private double defense;
    private int initialCd;
    private int currentCd;

    public Villain(String name, String element, double maxHp, double attack, double defense, int initialCd) {
        this.name = name;
        this.element = element;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.initialCd = initialCd;
        this.currentCd = initialCd;
    }

    public String getElement() {
        return element;
    }

    public double getDefense() {
        return defense;
    }

    public double getHp() {
        return hp;
    }

    public int getCurrentCd() {
        return currentCd;
    }

    public String getName() {
        return name;
    }

    public double getAttack() {
        return attack;
    }

    public void getDamaged(double damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void resetHp() {
        this.hp = this.maxHp;
    }

    public void decreaseCd() {
        if (this.currentCd > 1) {
            this.currentCd--;
        }
    }

    public void resetCd() {
        this.currentCd = this.initialCd;
    }

    @Override
    public String toString() {
        return "Villain Name: " + name + ", Element: " + element + ", HP: " + hp + "/" + maxHp + ", Attack: " + attack
                + ", Defense: " + defense + ", Current CD: " + currentCd;
    }
}