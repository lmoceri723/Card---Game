import java.util.ArrayList;

public class Player
{
    // Instance variables for the player's name, hand, and score
    private ArrayList<Card> hand;
    private String name;
    private int points;

    // Creates a player with a specified name
    public Player(String name)
    {
        this.hand = new ArrayList<Card>();
        this.name = name;
        this.points = 0;
    }

    // Creates a player with a specified name and hand
    public Player(String name, ArrayList<Card> hand)
    {
        this.hand = new ArrayList<Card>();
        for (Card card : hand)
        {
            this.hand.add(card);
        }
        this.name = name;
        this.points = 0;
    }

    // Getters for instance variables
    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public String getName()
    {
        return name;
    }

    public String getPoints()
    {
        return "Points: " + points;
    }

    // Returns the size of the player's hand
    public int getHandSize()
    {
        return hand.size();
    }

    // Returns whether the hand is empty
    public boolean handIsEmpty()
    {
        return hand.size() == 0;
    }

    // Functions for adding and removing a card
    public void addCard(Card card)
    {
        hand.add(card);
    }

    public Card rmCard(int index)
    {
        return hand.remove(index);
    }

    // Increments the player's score
    public void addPoints(int points)
    {
        this.points += points;
    }

    // Prints the player's hand
    public String printHand()
    {
        String result = "";
        for (Card card : hand) {
            result += card;
            result += " ";
        }

        return result;
    }

    // Prints the player's name as well as their score
    @Override
    public String toString()
    {
        return name + " has " + points + " points\n" + name + "'s cards: " + printHand();
    }
}
