import java.util.Random;

class Game {
    public void battle(Team team, Villain enemy) {
        team.resetTeamHp();
        enemy.resetHp();
        enemy.resetCd();

        int roundNumber = 1;
        Random rand = new Random();

        while (team.getHp() > 0 && enemy.getHp() > 0) {
            System.out.println("Round " + roundNumber);
            System.out.println("Enemy's current CD: " + enemy.getCurrentCd());

            String[] elements = { "Water", "Fire", "Earth", "Light", "Dark" };
            String[] runestonesDissolved = new String[3];
            for (int i = 0; i < 3; i++) {
                runestonesDissolved[i] = elements[rand.nextInt(elements.length)];
            }
            System.out.println("Runestones dissolved: ");
            for (String element : runestonesDissolved) {
                System.out.println(" - " + element);
            }
            System.out.println();

            boolean heroAttacked = false;
            for (Hero hero : team.getHeroList()) {
                if (contains(runestonesDissolved, hero.getElement())) {
                    int rsMultiplier = countOccurrences(runestonesDissolved, hero.getElement());
                    double damage = hero.calculateDamage(enemy, rsMultiplier);
                    enemy.getDamaged(damage);
                    System.out.println(hero.getName() + " dealt " + damage + " damage to " + enemy.getName());
                    heroAttacked = true;
                }
            }

            if (!heroAttacked) {
                System.out.println("No hero attacked in this round.");
            }

            if (enemy.getCurrentCd() == 1 && enemy.getHp() > 0) {
                team.getDamaged(enemy.getAttack());
                enemy.resetCd();
                System.out.println(enemy.getName() + " dealt " + enemy.getAttack() + " damage to the team");
            } else {
                enemy.decreaseCd();
            }
            System.out.println();
            System.out.println("Team's remaining HP: " + team.getHp());
            System.out.println("Enemy's remaining HP: " + enemy.getHp());
            System.out.println();
            roundNumber++;
        }

        if (team.getHp() <= 0) {
            System.out.println("The team lose.");
        } else if (enemy.getHp() <= 0) {
            System.out.println("The team won!");
        }
    }

    private boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    private int countOccurrences(String[] array, String value) {
        int count = 0;
        for (String element : array) {
            if (element.equals(value)) {
                count++;
            }
        }
        return count;
    }
}