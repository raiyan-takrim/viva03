class Hero {
    private String name;
    private String element;
    private double hp;
    private double attack;

    public Hero(String name, String element, double hp, double attack) {
        this.name = name;
        this.element = element;
        this.hp = hp;
        this.attack = attack;
    }

    public double calculateDamage(Villain enemy, int rsMultiplier) {
        double dominanceMultiplier = getDominanceMultiplier(enemy.getElement());
        double damage = this.attack * dominanceMultiplier * rsMultiplier - enemy.getDefense();
        return Math.max(damage, 1);
    }

    private double getDominanceMultiplier(String enemyElement) {
        switch (this.element) {
            case "Water":
                return enemyElement.equals("Fire") ? 1.5 : (enemyElement.equals("Earth") ? 0.5 : 1.0);
            case "Fire":
                return enemyElement.equals("Earth") ? 1.5 : (enemyElement.equals("Water") ? 0.5 : 1.0);
            case "Earth":
                return enemyElement.equals("Water") ? 1.5 : (enemyElement.equals("Fire") ? 0.5 : 1.0);
            case "Light":
                return enemyElement.equals("Dark") ? 1.5 : 1.0;
            case "Dark":
                return enemyElement.equals("Light") ? 1.5 : 1.0;
            default:
                return 1.0;
        }
    }

    public double getHp() {
        return this.hp;
    }

    public String getElement() {
        return this.element;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nElement: " + element + "\nHP: " + hp + "\nAttack: " + attack;
    }
}