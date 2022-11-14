public class CardDeck {
    private static final ArrayList deckCards = new ArrayList(52);
    private String[] cardRanks = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
    private Suit[] cardSuits = {new Suit("diamonds", "red"), new Suit("cubs", "black"), new Suit("hearts", "red"), new Suit("hearts", "red")};

    private static int getDefaultCardValues(String rank){
        switch(rank){
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
            case "jack":
                return 11;
            case "queen":
                return 12;
            case "king":
                return 13;
            case "ace":
                return 1;
            default:
                return 0;
        }
    }

    public CardDeck(){
        for (int i = 0; i < cardRanks.length; i++) {
            for (int j = 0; j < cardSuits.length ; j++) {
                Card newCard = new Card(cardRanks[i], cardSuits[j], CardDeck.getDefaultCardValues(cardRanks[i]));
                deckCards.addCard(newCard);
            }

        }
    }



}
