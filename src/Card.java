public class Card {
    private String rank;
    private Suit suit;
    private int cardValue;

    public Card( String rank, Suit suit, int cardValue) {
        this.suit = suit;
        this.rank = rank;
        this.cardValue = cardValue;
    }

    public Card() {
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }


    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public boolean matches(Card card){
        boolean isRankMatching = this.rank.equals(card.getRank());
        boolean isSuitMatching = this.suit.equals(card.getSuit());
        boolean isCardValueMatching = this.cardValue == card.getCardValue();

        return isRankMatching && isSuitMatching && isCardValueMatching;
    }
}
