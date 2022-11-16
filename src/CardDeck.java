public class CardDeck {
    private final ArrayList deckCards;

    public CardDeck(int[] values, String[] cardRanks,Suit[] suits){
        deckCards = new ArrayList(5);
        for (int i = 0; i < cardRanks.length; i++) {
                Card newCard = new Card(cardRanks[i], suits[i], values[i] );
                deckCards.addCard(newCard);
        }
    }
    public CardDeck(){
         deckCards = new ArrayList(52);
        String[] cardRanks = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
        for (int i = 0; i < cardRanks.length; i++) {
            Suit[] cardSuits = {new Suit("diamonds", "red"), new Suit("cubs", "black"), new Suit("hearts", "red"), new Suit("hearts", "red")};
            for (int j = 0; j < cardSuits.length ; j++) {
                Card newCard = new Card(cardRanks[i], cardSuits[j], CardDeck.getDefaultCardValues(cardRanks[i]));
                deckCards.addCard(newCard);
            }

        }
    }



    public static int getDefaultCardValues(String rank){
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

    public static String getDefaultCardRanks(int value){
        switch(value){
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "jack";
            case 12:
                return "queen";
            case 13:
                return "king";
            case 1:
                return "ace";
            default:
                return "0";
        }
    }


    public int getCardDeckSize(){
        return deckCards.getSize();
    }

    public ArrayList getDeckCards(){
        return deckCards;
    }

    @Override
    public String toString(){
        String str = String.format("You deck consists of %d cards \n", deckCards.getSize());
        for (int i = 0; i < deckCards.getSize(); i++) {
            str += deckCards.getCard(i).toString();
            str += "\n";
        }
        return str;
    }

}
