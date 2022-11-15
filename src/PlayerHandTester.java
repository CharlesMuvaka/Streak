public class PlayerHandTester {
    static CardDeck deck = new CardDeck();

    //method to test initialization of the card deck of 52 cards
    public static CardDeck testCardDeck(){
        return deck;
    }

    //method to check shuffle method of the customArrayList
    public static CardDeck shuffleCardDeck(){
        deck.getDeckCards().shuffleCards();
        return deck;
    }

    public static PlayerHand createAHand(){
        PlayerHand playerOne = new PlayerHand("Tester");

            //shuffling the deck
            deck.getDeckCards().shuffleCards();
            for (int i = 0; i < deck.getCardDeckSize() ; i++) {

                //Giving the player Five cards to initiate the game
                Card newCard = deck.getDeckCards().getCard(i);
                if(playerOne.getPlayerCards().getSize() < 5){

                playerOne.addPlayerCards(newCard);
                }
            }

        return playerOne;
    }



}
