import java.util.Scanner;

public class CardGame
{
    public static void main(String[] args)
    {
        // Gets the player's name
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = s.nextLine();

        // Starts the game
        Game game = new Game(name);
        game.playGame();;
    }
}
