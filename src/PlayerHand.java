public class PlayerHand {
    private ArrayList playerCards = new ArrayList(5);
    private String name;

    public PlayerHand(String name) {
        this.name = name;
    }

    public void addPlayerCards(Card card){
        playerCards.addCard(card);
    }
    public String getName(){
        return this.name;
    }

    public int getPlayerTotalCards(){
        return playerCards.getSize();
    }

    public String checkCards(){
        if (playerCards.getSize() == 0){
            return this.name + " has no cards";
        }
        return this.name + " has a total of " + this.playerCards.getSize();
    }

}
