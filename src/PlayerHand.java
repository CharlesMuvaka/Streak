import java.util.Arrays;


public class PlayerHand {
    private ArrayList playerCards = new ArrayList(5);
    private String name;
    private int droppedTimes = 5;

    public PlayerHand(String name) {
        this.name = name;
    }
    public PlayerHand(){}
    public void addPlayerCards(Card card){
        playerCards.addCard(card);
    }
    public String getName(){
        return this.name;
    }

    public int getPlayerTotalCards(){
        return playerCards.getSize();
    }

    public int getDroppedTimes() {
        return droppedTimes;
    }

    public void setDroppedTimes(int x) {

        this.droppedTimes = this.droppedTimes - x;
    }

    public String displayPlayerCards(){
        if (playerCards.getSize() == 0){
            return this.name + " has no cards";
        }else{
            String str = new String(this.name + " has the following cards \n");
            for (int i = 0; i < playerCards.getSize(); i++) {
                str += playerCards.getCard(i).toString();
                str += "\n";
            }
            return str;
        }

    }

    public void sortCards(){
        CardDeck playerDeck;
        int[] cardValues = new int[playerCards.getSize()];
        int[] ranksToBeSorted = new int[playerCards.getSize()];
        String[] sortedRanks = new String[playerCards.getSize()];
        Suit[] cardSuitsToBeSorted = new Suit[playerCards.getSize()];



        for (int i = 0; i < cardValues.length; i++) {
            cardValues[i] = playerCards.getCard(i).getCardValue();

        }
        Arrays.sort(cardValues);


        for (int j = 0; j < ranksToBeSorted.length; j++) {
            ranksToBeSorted[j] = CardDeck.getDefaultCardValues(playerCards.getCard(j).getRank());

        }

        Arrays.sort(ranksToBeSorted);

        for (int i = 0; i < sortedRanks.length; i++) {
            sortedRanks[i] = CardDeck.getDefaultCardRanks(ranksToBeSorted[i]) ;

        }

        for (int i = 0; i < cardSuitsToBeSorted.length; i++) {
            cardSuitsToBeSorted[i] = playerCards.getCard(i).getSuit();
        }

        playerDeck = new CardDeck(cardValues, sortedRanks,cardSuitsToBeSorted);

        this.playerCards = playerDeck.getDeckCards();
    }

    public ArrayList getPlayerCards() {
        return playerCards;
    }

    public int getScore(){
        String message;
        int score = 0;
        int newScore = 0;

        // a two card value streak
        if (  (playerCards.getCard(0).getCardValue() == playerCards.getCard(1).getCardValue() - 1) ) {
            newScore = 2;
            score = newScore ;

            message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                    + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() + "\n";

            if ( playerCards.getCard(0).getSuit().getName().equalsIgnoreCase(playerCards.getCard(1).getSuit().getName()) ){
                newScore += 2;
                score = newScore;

                message += " with same suits: " + playerCards.getCard(0).getSuit().getName() +  "\n";

            }

            if (playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) {
                newScore += 1;
                score = newScore;

                message += " same suit color: " + playerCards.getCard(0).getSuit().getColor();
            }

            System.out.println(message);

        } else if (  (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) ) {
            newScore = 2;
            score = newScore ;

            message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                    + playerCards.getCard(1).toString() + ",\n" + playerCards.getCard(2).toString() + "\n";

            if ( playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName()) ){
                newScore += 2;
                score = newScore;
                message += " with same suits: " + playerCards.getCard(1).getSuit().getName() + "\n";

            }

            if (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) {
                newScore += 1;
                score = newScore;

                message += " same suit color: " + playerCards.getCard(1).getSuit().getColor();

            }
            System.out.println(message);


        } else if (  (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) ) {
            newScore = 2;
            score = newScore ;

            message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                    + playerCards.getCard(2).toString() + ",\n" + playerCards.getCard(3).toString() + "\n";


            if ( playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()) ){
                newScore += 2;
                score = newScore;

                message += " with same suits: " + playerCards.getCard(1).getSuit().getName() + "\n";


            }

            if (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) {
                newScore += 1;
                score = newScore;

                message += " same suit color: " + playerCards.getCard(2).getSuit().getColor();

            }

            System.out.println(message);


        } else if (  (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) {
            newScore = 2;
            score = newScore ;

            message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                    + playerCards.getCard(3).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


            if ( playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()) ){
                newScore += 2;
                score = newScore;

                message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";

            }

            if (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) {
                newScore += 1;
                score = newScore;

                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();


            }

            System.out.println(message);
        }

        //A three streak
        if ( ( (playerCards.getCard(0).getCardValue() == playerCards.getCard(1).getCardValue() - 1) &&
                (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                (playerCards.getCard(2).getCardValue() == playerCards.getCard(1).getCardValue() + 1) ) ){

            newScore = 3;
            score = newScore;

            message = this.name.toUpperCase() + " contains a streak of 3 cards \n"
                    + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                    "\n"+ playerCards.getCard(2).toString();

            if ((playerCards.getCard(0).getSuit().getName().equalsIgnoreCase(playerCards.getCard(1).getSuit().getName())) ||
                    (playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName()))){
                newScore += 2;
                score = newScore;

                //message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


            }

            if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                    (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))) {
                newScore += 1;
                score = newScore;

                //message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();

            }

            System.out.println(message);

        } else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                 (playerCards.getCard(3).getCardValue() == playerCards.getCard(2).getCardValue() + 1) )) {
            newScore = 3;
            score = newScore;

            message = this.name.toUpperCase() + " contains a streak of 3 cards \n" + playerCards.getCard(1).toString() +
                    "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString();

            if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                    (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))){
                newScore += 2;
                score = newScore;

            }

            if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                    (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                    (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                newScore += 1;
                score = newScore;
            }
            System.out.println(message);

        }else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                (playerCards.getCard(4).getCardValue() == playerCards.getCard(3).getCardValue() + 1) )) {
            newScore = 3;
            score = newScore;

            message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                    playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                    + playerCards.getCard(4).toString() + "\n";

            if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                    (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))){
                newScore += 2;
                score = newScore;

            }

            if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                    (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                newScore += 1;
                score = newScore;
            }

            System.out.println(message);
        }

        //a four CardValues streak

        if ( ( (playerCards.getCard(0).getCardValue() == playerCards.getCard(1).getCardValue() - 1) &&
                (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) ) &&
                (playerCards.getCard(3).getCardValue() == playerCards.getCard(2).getCardValue() + 1) ){

            newScore = 4;
            score = newScore;

            message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                    + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                    "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n";

            if ((playerCards.getCard(0).getSuit().getName().equalsIgnoreCase(playerCards.getCard(1).getSuit().getName())) ||
                    (playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName()))||
                    (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))){
                newScore += 2;
                score = newScore;

                //message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


            }

            if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                    (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                    (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))) {
                newScore += 1;
                score = newScore;

                //message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();

            }

            System.out.println(message);

        } else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) )&&
                (playerCards.getCard(4).getCardValue() == playerCards.getCard(3).getCardValue() + 1) ) {
            newScore = 4;
            score = newScore;

            message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                     + playerCards.getCard(1).toString() +
                    "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                    + playerCards.getCard(4).toString() + "\n";

            if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                    (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))||
                    (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))){
                newScore += 2;
                score = newScore;

            }

            if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                    (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                    (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                newScore += 1;
                score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();

            }

            System.out.println(message);
        }

        //a Five CardValues streak

        if ( ( (playerCards.getCard(0).getCardValue() == playerCards.getCard(1).getCardValue() - 1) &&
                (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) ) &&
                (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1)  &&
                (playerCards.getCard(4).getCardValue() == playerCards.getCard(3).getCardValue() + 1) ){

            newScore = 5;
            score = newScore;

            message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                    + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                    "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                    + playerCards.getCard(4).toString() + "\n";

            if ((playerCards.getCard(0).getSuit().getName().equalsIgnoreCase(playerCards.getCard(1).getSuit().getName())) ||
                    (playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName()))||
                    (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))||
                    (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))){
                newScore += 2;
                score = newScore;

                message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


            }

            if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                    (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                    (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                    (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                newScore += 1;
                score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();

            }

            System.out.println(message);

        }

        return score;
    }
}
