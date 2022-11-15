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




}
