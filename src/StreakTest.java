public class StreakTest {
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

    public static int checkPlayerScore(){
        PlayerHand playerTwo = new PlayerHand("Charles");
        int score = 0;

        Card card = new Card("one", new Suit("cubs", "black"), 1);
        Card card1 = new Card("two", new Suit("cubs", "black"), 2);
        Card card2 = new Card("three", new Suit("spades", "black"), 3);
        Card card3 = new Card("four", new Suit("hearts", "red"), 4);
        Card card4 = new Card("five", new Suit("cubs", "black"), 5);

        playerTwo.addPlayerCards(card);
        playerTwo.addPlayerCards(card1);
        playerTwo.addPlayerCards(card2);
        playerTwo.addPlayerCards(card3);
        playerTwo.addPlayerCards(card4);

        //sorting players card
        playerTwo.sortCards();
        System.out.println(playerTwo.displayPlayerCards()); //displaying the cards to see if sorted.
        score = playerTwo.getScore();
        return score;
    }



    public static void main(String[] args) {

        //Displaying the deck of cards
        //System.out.println(PlayerHandTester.testCardDeck());

        //displaying a shuffled deck
        //System.out.println(PlayerHandTester.shuffleCardDeck().toString());

        //checking whether a player as been assigned cards
        //System.out.println(PlayerHandTester.createAHand().displayPlayerCards());

        //checking score with the shortest streak - 2
        System.out.println(StreakTest.checkPlayerScore());
    }


}
