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

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuitColor() {
        return suitColor;
    }

    public void setSuitColor(String suitColor) {
        this.suitColor = suitColor;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }
}
