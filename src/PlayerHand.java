import java.util.Arrays;


public class PlayerHand {
    private ArrayList playerCards;
    private String name;
    private int droppedTimes;
    private int capacity;

    public PlayerHand(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.playerCards = new ArrayList(capacity);
        this.droppedTimes = capacity;
    }
    public PlayerHand(){}
    public void addPlayerCards(Card card){
        playerCards.addCard(card);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void dropCard(String name){
        for (int i = 0; i < this.playerCards.getSize(); i++) {
            if (this.playerCards.getCard(i).getRank().equalsIgnoreCase(name)){
                this.playerCards.removeCard(i);
                this.droppedTimes--;
            }
        }
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
                str += playerCards.getCard(i).getCardValue() +" -" + playerCards.getCard(i).getRank() + ": of " + playerCards.getCard(i).getSuit().getName() + " COLOR: " + playerCards.getCard(i).getSuit().getColor();
                str += "\n";
            }
            return str;
        }

    }

    public void sortCards(){
        CardDeck playerDeck;
        int[] cardValues = new int[this.playerCards.getSize()];
        int[] ranksToBeSorted = new int[this.playerCards.getSize()];
        String[] sortedRanks = new String[this.playerCards.getSize()];
        Suit[] cardSuitsToBeSorted = new Suit[this.playerCards.getSize()];



        for (int i = 0; i < cardValues.length; i++) {
            cardValues[i] = this.playerCards.getCard(i).getCardValue();

        }
        Arrays.sort(cardValues);


        for (int j = 0; j < ranksToBeSorted.length; j++) {
            ranksToBeSorted[j] = CardDeck.getDefaultCardValues(this.playerCards.getCard(j).getRank());

        }

        Arrays.sort(ranksToBeSorted);

        for (int i = 0; i < sortedRanks.length; i++) {
            sortedRanks[i] = CardDeck.getDefaultCardRanks(ranksToBeSorted[i]) ;

        }

        for (int i = 0; i < cardSuitsToBeSorted.length; i++) {
            cardSuitsToBeSorted[i] = this.playerCards.getCard(i).getSuit();
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

        if(playerCards.getSize() == 5) {
            if ((playerCards.getCard(0).getCardValue() == playerCards.getCard(1).getCardValue() - 1)) {
                newScore = 2;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() + "\n";

                if (playerCards.getCard(0).getSuit().getName().equalsIgnoreCase(playerCards.getCard(1).getSuit().getName())) {
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(0).getSuit().getName() + "\n";

                }

                if (playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(0).getSuit().getColor();


                }


            }
            else if ((playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1)) {
                newScore = 2;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(1).toString() + ",\n" + playerCards.getCard(2).toString() + "\n";

                if (playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) {
                    newScore += 2;
                    score = newScore;
                    message += " with same suits: " + playerCards.getCard(1).getSuit().getName() + "\n";

                }

                if (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(1).getSuit().getColor();


                }


            }
            else if ((playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1)) {
                newScore = 2;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(2).toString() + ",\n" + playerCards.getCard(3).toString() + "\n";


                if (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) {
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(1).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(2).getSuit().getColor();


                }

            }
            //A three streak
            if (((playerCards.getCard(0).getCardValue() == playerCards.getCard(1).getCardValue() - 1) &&
                    (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(1).getCardValue() + 1))) {

                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n" + playerCards.getCard(2).toString();

                if ((playerCards.getCard(0).getSuit().getName().equalsIgnoreCase(playerCards.getCard(1).getSuit().getName())) ||
                        (playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName()))) {
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


            }
            else if (((playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(2).getCardValue() + 1))) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" + playerCards.getCard(1).toString() +
                        "\n" + playerCards.getCard(2).toString() + "\n" + playerCards.getCard(3).toString();

                if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                        (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))) {
                    newScore += 2;
                    score = newScore;


                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (((playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(3).getCardValue() + 1))) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n" + playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))) {
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            //four streak
            if (((playerCards.getCard(0).getCardValue() == playerCards.getCard(1).getCardValue() - 1) &&
                    (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1)) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(2).getCardValue() + 1)) {

                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n" + playerCards.getCard(2).toString() + "\n" + playerCards.getCard(3).toString() + "\n";

                if ((playerCards.getCard(0).getSuit().getName().equalsIgnoreCase(playerCards.getCard(1).getSuit().getName())) ||
                        (playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                        (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))) {
                    newScore += 2;
                    score = newScore;

                    //message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;


                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                    //message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);

            }
            else if (((playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1)) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(3).getCardValue() + 1)) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n" + playerCards.getCard(2).toString() + "\n" + playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                        (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))) {
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

            }
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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }

            //five streak

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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }

            return score;
        } else if (playerCards.getSize() == 6) {
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



            }
            else if (  (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) ) {
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


            }
            else if (  (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) ) {
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



            }
            else if (  (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) {
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

            }
            else if (  (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(4).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


                if ( playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }

            //three card streak
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


            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            //four card streak

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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                    //message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);

            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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
                    return score;

                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) )&&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }

            //five card streak
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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1)  &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                        (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }

        } else if (playerCards.getSize() == 7) {
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



            }
            else if (  (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) ) {
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


            }
            else if (  (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) ) {
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



            }
            else if (  (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) {
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

            }
            else if (  (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(4).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


                if ( playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(5).toString() + ",\n" + playerCards.getCard(6).toString() + "\n";


                if ( playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }


            //three card streak
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


            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n" + playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))) {
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }

            //four card streak

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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                    //message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);

            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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
                    return score;

                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) )&&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) )&&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }

            //five card streak
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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1)  &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                        (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1)  &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }

        } else if (playerCards.getSize() == 8) {
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



            }
            else if (  (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) ) {
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


            }
            else if (  (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) ) {
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



            }
            else if (  (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) {
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

            }
            else if (  (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(4).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


                if ( playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(5).toString() + ",\n" + playerCards.getCard(6).toString() + "\n";


                if ( playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(6).toString() + ",\n" + playerCards.getCard(6).toString() + "\n";


                if ( playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }

            //three card streak
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


            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n" + playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))) {
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName())) ||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }

            //four card streak
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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                    //message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);

            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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
                    return score;

                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) )&&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) )&&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) )&&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }

            //five card streak
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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1)  &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                        (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1)  &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) ) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1)  &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
        } else if (playerCards.getSize() == 9) {

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



            }
            else if (  (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) ) {
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


            }
            else if (  (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) ) {
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



            }
            else if (  (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) {
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

            }
            else if (  (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(4).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


                if ( playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(5).toString() + ",\n" + playerCards.getCard(6).toString() + "\n";


                if ( playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(6).toString() + ",\n" + playerCards.getCard(6).toString() + "\n";


                if ( playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(3).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


                if ( playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();

                }

            }

            //three card streak
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


            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n" + playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))) {
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName())) ||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) &&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(7).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName())) ||
                        (playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor())) ||
                        (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;


                }



            }

            //four card streak
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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                    //message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);

            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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
                    return score;

                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) )&&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) )&&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) )&&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) )&&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(7).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName())) ||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))||
                        (playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor())) ||
                        (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }

            //five card streak

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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1)  &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                        (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1)  &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) ) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1)  &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) ) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1)  &&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(7).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))||
                        (playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))||
                        (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
        }else {
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



            }
            else if (  (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) ) {
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


            }
            else if (  (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) ) {
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



            }
            else if (  (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) {
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

            }
            else if (  (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(4).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


                if ( playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(5).toString() + ",\n" + playerCards.getCard(6).toString() + "\n";


                if ( playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(6).toString() + ",\n" + playerCards.getCard(6).toString() + "\n";


                if ( playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

            }
            else if (  (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(3).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


                if ( playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();

                }

            }
            else if (  (playerCards.getCard(8).getCardValue() == playerCards.getCard(9).getCardValue() - 1) ) {
                newScore = 2;
                score = newScore ;

                message = this.name.toUpperCase() + " contains a streak of 2 cards \n"
                        + playerCards.getCard(3).toString() + ",\n" + playerCards.getCard(4).toString() + "\n";


                if ( playerCards.getCard(8).getSuit().getName().equalsIgnoreCase(playerCards.getCard(9).getSuit().getName()) ){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";


                }

                if (playerCards.getCard(8).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(9).getSuit().getColor())) {
                    newScore += 1;
                    score = newScore;

                    message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();



                }

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


            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
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

            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n" + playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))) {
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName())) ||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                }

            }
            else if (( (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) &&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(7).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName())) ||
                        (playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor())) ||
                        (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;


                }



            }
            else if (( (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) &&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(9).getCardValue() - 1) &&
                    (playerCards.getCard(9).getCardValue() == playerCards.getCard(8).getCardValue() + 1) )) {
                newScore = 3;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 3 cards \n" +
                        playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName())) ||
                        (playerCards.getCard(8).getSuit().getName().equalsIgnoreCase(playerCards.getCard(9).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                }

                if ((playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor())) ||
                        (playerCards.getCard(8).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(9).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;
                    return score;

                }

                return score;
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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

                    //message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);

            }
            else if (( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
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
                    return score;

                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) )&&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) )&&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) )&&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) )&&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(7).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName())) ||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))||
                        (playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor())) ||
                        (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
            }
            else if (( (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) &&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(9).getCardValue() - 1) )&&
                    (playerCards.getCard(9).getCardValue() == playerCards.getCard(8).getCardValue() + 1) ) {
                newScore = 4;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 4 cards \n"
                        + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName())) ||
                        (playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()))||
                        (playerCards.getCard(8).getSuit().getName().equalsIgnoreCase(playerCards.getCard(9).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;
                    return score;

                }

                if ((playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor())) ||
                        (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor())) ||
                        (playerCards.getCard(8).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(9).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;


                }

//            System.out.println(message);
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
                    return score;



                }

                if ((playerCards.getCard(0).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(1).getSuit().getColor())) ||
                        (playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor()))||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(1).getCardValue() == playerCards.getCard(2).getCardValue() - 1) &&
                    (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) ) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1)  &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(4).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(1).getSuit().getName().equalsIgnoreCase(playerCards.getCard(2).getSuit().getName())) ||
                        (playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName()))||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(1).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(2).getSuit().getColor())) ||
                        (playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor()))||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(2).getCardValue() == playerCards.getCard(3).getCardValue() - 1) &&
                    (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) ) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1)  &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(5).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(2).getSuit().getName().equalsIgnoreCase(playerCards.getCard(3).getSuit().getName())) ||
                        (playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName()))||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(2).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(3).getSuit().getColor())) ||
                        (playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor()))||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(3).getCardValue() == playerCards.getCard(4).getCardValue() - 1) &&
                    (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) ) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1)  &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(6).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(3).getSuit().getName().equalsIgnoreCase(playerCards.getCard(4).getSuit().getName())) ||
                        (playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName()))||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(3).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(4).getSuit().getColor())) ||
                        (playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor()))||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(4).getCardValue() == playerCards.getCard(5).getCardValue() - 1) &&
                    (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) ) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1)  &&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(7).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(4).getSuit().getName().equalsIgnoreCase(playerCards.getCard(5).getSuit().getName())) ||
                        (playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName()))||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))||
                        (playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(4).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(5).getSuit().getColor())) ||
                        (playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor()))||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))||
                        (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }
            else if ( ( (playerCards.getCard(5).getCardValue() == playerCards.getCard(6).getCardValue() - 1) &&
                    (playerCards.getCard(6).getCardValue() == playerCards.getCard(7).getCardValue() - 1) &&
                    (playerCards.getCard(7).getCardValue() == playerCards.getCard(8).getCardValue() - 1) ) &&
                    (playerCards.getCard(8).getCardValue() == playerCards.getCard(9).getCardValue() - 1)  &&
                    (playerCards.getCard(9).getCardValue() == playerCards.getCard(8).getCardValue() + 1) ){

                newScore = 5;
                score = newScore;

                message = this.name.toUpperCase() + " contains a streak of 5 cards \n"
                        + playerCards.getCard(0).toString() + ",\n" + playerCards.getCard(1).toString() +
                        "\n"+ playerCards.getCard(2).toString() + "\n"+ playerCards.getCard(3).toString() + "\n"
                        + playerCards.getCard(4).toString() + "\n";

                if ((playerCards.getCard(5).getSuit().getName().equalsIgnoreCase(playerCards.getCard(6).getSuit().getName())) ||
                        (playerCards.getCard(6).getSuit().getName().equalsIgnoreCase(playerCards.getCard(7).getSuit().getName()))||
                        (playerCards.getCard(7).getSuit().getName().equalsIgnoreCase(playerCards.getCard(8).getSuit().getName()))||
                        (playerCards.getCard(8).getSuit().getName().equalsIgnoreCase(playerCards.getCard(9).getSuit().getName()))){
                    newScore += 2;
                    score = newScore;

                    message += " with same suits: " + playerCards.getCard(3).getSuit().getName() + "\n";
                    return score;



                }

                if ((playerCards.getCard(5).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(6).getSuit().getColor())) ||
                        (playerCards.getCard(6).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(7).getSuit().getColor()))||
                        (playerCards.getCard(7).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(8).getSuit().getColor()))||
                        (playerCards.getCard(8).getSuit().getColor().equalsIgnoreCase(playerCards.getCard(9).getSuit().getColor()))) {
                    newScore += 1;
                    score = newScore;

//                message += " same suit color: " + playerCards.getCard(3).getSuit().getColor();
                    return score;

                }

//            System.out.println(message);
            }





            return score;
        }
        return score;
    }
}
