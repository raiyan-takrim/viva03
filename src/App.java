public class App {
    public static void main(String[] args) {
        Hero[] heroes = {
                new Hero("Molly", "Water", 45, 20),
                new Hero("Sean", "Fire", 36, 24),
                new Hero("Duncan", "Earth", 53, 16),
                new Hero("Nathaniel", "Light", 37, 24),
                new Hero("Endor", "Dark", 43, 21),
                new Hero("Urd", "Water", 65, 17),
                new Hero("Skuld", "Fire", 66, 16),
                new Hero("Verthandi", "Earth", 74, 13),
                new Hero("Idun", "Light", 59, 19),
                new Hero("Valkyrie", "Dark", 61, 18),
                new Hero("Poseidon", "Water", 58, 19),
                new Hero("Hephaestus", "Fire", 51, 22),
                new Hero("Athena", "Earth", 61, 18),
                new Hero("Apollo", "Light", 55, 16),
                new Hero("Artemis", "Dark", 50, 23)
        };

        Villain[] villains = {
                new Villain("Giemsa", "Water", 100, 150, 15, 2),
                new Villain("Diablo", "Fire", 120, 163, 13, 3),
                new Villain("Nidhogg", "Earth", 130, 189, 11, 4),
                new Villain("Lucifer", "Light", 110, 207, 17, 3),
                new Villain("Odin", "Dark", 135, 196, 14, 5)
        };

        if (heroes.length < 4) {
            System.out.println("Not enough heroes to form a team.");
            return;
        }
        if (villains.length == 0) {
            System.out.println("No villains to fight.");
            return;
        }

        Team team = new Team(heroes);
        Game game = new Game();
        team.formTeam();
        System.out.println(team);
        game.battle(team, villains[0]);
    }
}
