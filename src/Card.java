public class Card
{
    // Instance variables for a card's number, color, and point value
    private String rank;
    private String suit;
    private String colorCode;
    private int points;

    // Special characters to write in color to the terminal
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Creates a wild card by default
    public Card()
    {
        rank = "Wild";
        suit = "White";
        colorCode = ANSI_WHITE;
        points = 10;
    }

    // Creates a card with the specified information
    public Card(String rank, String suit)
    {
        this.rank = rank;
        this.suit = suit;
        if (suit.equals("Green"))
        {
            colorCode = ANSI_GREEN;
        }
        else if (suit.equals("Red"))
        {
            colorCode = ANSI_RED;
        }
        else if (suit.equals("Yellow"))
        {
            colorCode = ANSI_YELLOW;
        }
        else if (suit.equals("Blue"))
        {
            colorCode = ANSI_BLUE;
        }
        points = Integer.parseInt(rank);
    }

    // Getters and Setters for rank, suit, and points
    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public String getSuit()
    {
        return suit;
    }

    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Checks if a card matches another card in suit or rank, or if one of them is a wild card
    public boolean matches(Card other)
    {
        return this.rank.equals(other.rank) || this.suit.equals(other.suit) || this.rank.equals("Wild") || other.rank.equals("Wild");
    }

    // Prints the card number in its color
    @Override
    public String toString()
    {
        return colorCode + rank + colorCode;
    }

    // Prints the card using terminal art
    public String printLarge()
    {
        String result = colorCode +
                "______________\n" +
                "|            |\n" +
                "|            |\n";

        if (rank.equals("Wild"))
        {
            result += "|    " + rank + "    |\n";
        }
        else
        {
            result += "|     " + rank + "      |\n";
        }

        result +=
                "|            |\n" +
                "|            |\n" +
                "--------------\n" +
                colorCode;
        return result;
    }
}
