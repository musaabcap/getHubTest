import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Caracter playerCaracter;
    static Caracter opponentCaracter;


    public static void main(String[] args) {
        // Unikt objekt = Caracter1
        // Klassens namn = Caracter

        Scanner scan = new Scanner(System.in);
        boolean running = true;

        warrior warrior1 = new warrior("knight", "hero",3);

        orch orch1 = new orch("Orch","hunter",5);

        System.out.println("Choose your Caracter:");
        System.out.println("1.Warrior:");
        System.out.println("2.Orch:");
        int choice = scan.nextInt();

        Caracter playerCaracter = null;
        Caracter opponentCaracter = null;

        switch (choice){
            case 1:
                playerCaracter = warrior1;
                opponentCaracter = orch1;
                System.out.println("You have choosen Warrior");
                break;
            case 2:
                playerCaracter = orch1;
                opponentCaracter = warrior1;
                System.out.println("You have choosen Orch");
                break;
            default:
                System.out.println("You have to choose, defaulting to Warrior");
                playerCaracter = warrior1;
        }
        while(running){
            System.out.println("\n--- Game Menu ---");
            //System.out.println("1. Choose a name for you Caracter: ");
            System.out.println("1. View Character Stats");
            System.out.println("2. Heal Caracter");
            System.out.println("3. Attack opponent");
            System.out.println("4. End game");
            System.out.print("Enter your choice: ");

            int choice2 = scan.nextInt();
            switch (choice2){
                case 1:
                    playerCaracter.displayC();
                    opponentCaracter.displayC();
                    break;
                case 2:
                    playerCaracter.heal();
                    break;
                case 3:
                    System.out.println(playerCaracter.getName() + " attacks " + opponentCaracter.getName());
                    //betyder detta: "Om takeDamage returnerar true (vilket innebär att motståndaren har dött),
                    // så körs koden inne i if-blocket."
                    if (opponentCaracter.takeDamage(playerCaracter.basicAttack())) {
                        // Opponent died
                        System.out.println(opponentCaracter.getName() + " has been defeated! You win!");
                        running = false;
                        break;
                    }
                    // Opponent counter-attacks
                    System.out.println(opponentCaracter.getName() + " counter-attacks!");
                    if (playerCaracter.takeDamage(opponentCaracter.basicAttack())) {
                        // Player died
                        System.out.println(playerCaracter.getName() + " has been defeated! Game over.");
                        running = false;
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting game...");
                    break;
                default:
                    System.out.println("Invalid choice, please select again.");

            }
        }

        //warrior1.setName("king");
        //System.out.println(warrior1.getName());


        //orch1.displayC();

        /*
        System.out.println(warrior1.getName()+" Attacks "+orch1.getName());

        orch1.takeDamage(warrior1.attack());

        System.out.println(orch1.getName()+" is now angry and counterattacks!!!");

        warrior1.takeDamage(orch1.attack());

        warrior1.takeDamage(orch1.basicAttack());
        */


        //System.out.println(Caracter1.cName+" Attacks "+Caracter2.cName);

        //int damage = Caracter1.attack();

        //Caracter2.takeDamage(damage);

        //Caracter2.attack(Caracter1);
    }
}
