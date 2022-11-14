public class Card {
    private String suit, rank, suitColor;
    private int cardValue;

    public Card(String suit, String rank, String suitColor, int cardValue) {
        this.suit = suit;
        this.rank = rank;
        this.suitColor = suitColor;
        this.cardValue = cardValue;
    }

    public Card() {
    }
}
