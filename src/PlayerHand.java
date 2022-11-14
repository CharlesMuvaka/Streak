public class PlayerHand {
    private ArrayList playerCards = new ArrayList(5);
    private String name;

    public PlayerHand(String name) {
        this.name = name;
    }

    public void addPlayerCards(Card card){
        playerCards.addCard(card);
    }

}
