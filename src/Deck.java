import java.util.ArrayList;

public class Deck
{
    // Instance variables for the deck and the amount of cards left
    private ArrayList<Card> cards;
    private int cardsLeft;

    // Arrays holding the different colors and numbers a card can have
    public static final String[] COLORS = {"Red", "Green", "Blue", "Yellow"};
    public static final String[] TYPES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    // Creates the deck and adds the correct cards
    public Deck() {
        cards = new ArrayList<Card>();
        cardsLeft = 84;
        for (int i = 0; i < 2; i++) {
            for (String suit : COLORS) {
                for (String rank : TYPES) {
                    cards.add(new Card(rank, suit));
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            cards.add(new Card());
        }

        shuffle();
    }

    // Returns a boolean based on whether the deck is empty
    public boolean isEmpty()
    {
        return cardsLeft == 0;
    }

    // Returns how many cards are left
    public int getCardsLeft()
    {
        return cardsLeft;
    }

    // Removes a card from the deck and returns it
    public Card draw()
    {
        cardsLeft--;
        return cards.remove(0);
    }

    // Swaps the position of 2 cards
    public void swap(int i, int j)
    {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    // Shuffles the deck
    public void shuffle()
    {
        for (int i = 0; i < 84; i++)
        {
            int j = (int)(Math.random() * 84);
            swap(i, j);
        }
    }

    // Returns a string of all cards in the deck
    @Override
    public String toString() {
        String result = "";
        for (Card card : cards) {
            result += card;
            result += " ";
        }
        return result + Card.ANSI_WHITE;
    }
}