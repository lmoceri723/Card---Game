import java.util.Scanner;

public class Game
{
    // Instance variables for the player, the deck, and the card in the middle
    private Player player;
    private Deck deck;
    private Card middle;

    // Constructor that creates the deck and player, draws a card for the middle, and deals the player 7 cards
    public Game(String name)
    {
        player = new Player(name);
        deck = new Deck();
        middle = deck.draw();
        for (int i = 0; i < 7; i++)
        {
            drawFromDeck();
        }
    }

    // Prints out instructions
    public void printInstructions()
    {
        Scanner s = new Scanner(System.in);
        System.out.println(
                "Welcome to Uno!\n" +
                "The goal is to get an empty hand by placing all of your cards in the middle\n" +
                "Cards can be put in the middle if they match in color or number\n" +
                "(or if either card is wild)\n" +
                "You can do this by typing the index of the card you want to move\n" +
                "You can draw as many cards as you need by typing draw\n" +
                "but you lose when you run out of cards to draw\n" +
                        "Press enter to continue \nHave Fun!!!"
        );
        String st = s.nextLine();
    }

    // Takes a card from the deck and adds it to the player's hand
    public void drawFromDeck()
    {
        player.addCard(deck.draw());
    }

    // Places the card in the middle if it matches in suit or color, returns boolean based on whether it matches
    public boolean placeCard(int index)
    {
        Card toPlace = player.getHand().get(index);

        if (toPlace.matches(middle))
        {
            middle = player.rmCard(index);
            player.addPoints(middle.getPoints());
            return true;
        }
        return false;
    }

    // Prints all information about the game
    public String toString()
    {
        return Card.ANSI_WHITE + "Middle: " + middle + Card.ANSI_WHITE + "\n" + "Hand: " +
                player.printHand() + "\n" + Card.ANSI_WHITE + "Deck: " + deck +"\n";
    }

    // Checks to see if the player has won
    // The other case is checked during the game, as it needs to be checked later
    public boolean gameNotOver()
    {
        return !(player.handIsEmpty());
    }

    // Clears space so the terminal isn't cluttered
    public void clearSpace()
    {
        for (int i = 0; i < 15; i++)
        {
            System.out.println();
        }
    }

    // Waits for ms milliseconds
    // Found on StackOverflow by Hecanet and Azeem
    // https://stackoverflow.com/questions/
    // 24104313/how-do-i-make-a-delay-in-java
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    // Plays the game
    public void playGame()
    {
        // Prepares for the first turn
        Scanner s = new Scanner(System.in);
        printInstructions();
        clearSpace();
        // Loop runs for each turn, stopping if the player wins
        while (gameNotOver())
        {
            // Prints all information about the game
            System.out.print(middle.printLarge());
            System.out.println(player.printHand());
            System.out.println(Card.ANSI_WHITE + "Deck Size: " + deck.getCardsLeft());
            System.out.println(player.getPoints());
            System.out.println("What do you want to do?");
            // Processes the player's input
            String choice = s.nextLine();
            // If they choose draw, makes sure they can actually draw and then does the action
            if (choice.equals("draw"))
            {
                if (deck.isEmpty())
                {
                    // Exits the game, as they've lost
                    System.out.println("Haha you lost");
                    System.out.println(player.getPoints());
                    return;
                }
                drawFromDeck();
            }
            // At this point choice can only be an index, or it's invalid
            else
            {
                // If index is parsable from choice (it's an integer that exists in the string)
                // Check that it's a valid index and then attempt to place it in the middle
                // Makes sure it matches
                try
                {
                    int index = Integer.parseInt(choice);
                    if (index < 0 || index >= player.getHandSize())
                    {
                        System.out.println("Invalid Index");
                        wait(3000);
                    }
                    else if (!placeCard(index))
                    {
                        System.out.println("Card Doesn't Match");
                        wait(3000);
                    }
                }
                // If no integers exist in choice it has to be an invalid input, so prompts the user
                catch(Exception e)
                {
                    System.out.println("Invalid Input");
                    wait(3000);
                }
            }
            // Clears space for the next turn to print
            clearSpace();
        }
        // If the code makes it here, the user has won
        System.out.println("YOU WON!!!!!");
        System.out.println(player.getPoints());
    }
}

