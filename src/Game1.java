import java.util.Scanner;

public class Game1 {
    static CardDeck deck = new CardDeck();
    static Scanner scanner;
    static PlayerHand playerOne,playerTwo;
    static String streak = "\t \t STREAK";
    static String newLine = "\n\r";

    static String onePlayer = "Click 1: Single Player Game";
    static String twoPlayers = "Click 2: Single Player Game";
    static String streak2 = "----------------------";

    public static void main(String[] args) {
        System.out.println(streak);
        System.out.println(streak2);
        System.out.println(onePlayer);
        System.out.println(twoPlayers);

        scanner = new Scanner(System.in);

        if (scanner.nextLine().equals("1")){
            singlePlayerGame();
        }else{
            twoPlayerGame(playerOne, playerTwo);
        }


    }

    public static PlayerHand createPlayer(){
        System.out.println("Enter your name to play the game");
        String name = scanner.nextLine();

        System.out.println("Enter the number of cards to have(5 - 10)");
        int capacity = Integer.parseInt(scanner.nextLine());

        PlayerHand player = new PlayerHand(name, capacity);
        for (int i = 0; i < deck.getCardDeckSize(); i++) {
            deck.getDeckCards().shuffleCards();
            if(player.getPlayerTotalCards() < capacity){
                Card newCard = deck.getDeckCards().getCard(i);
                player.addPlayerCards(newCard);
                deck.getDeckCards().removeCard(i);
            }

        }
        player.sortCards();

        return player;
    }

    public static void dropCard(PlayerHand player){
        System.out.println("Type the name of the card to drop e.g ace - type ace, two - type two");
        String cardToDrop = scanner.nextLine();
        player.dropCard(cardToDrop);
    }

    public static void pickCard(PlayerHand player){
        deck.getDeckCards().shuffleCards();
        Card pickedCard = deck.getDeckCards().getCard(deck.getCardDeckSize());
        deck.getDeckCards().removeCard(deck.getCardDeckSize());
        player.addPlayerCards(pickedCard);
        player.sortCards();
        System.out.println(player.displayPlayerCards());
        System.out.println("Yo have a Streak of: " + player.getScore());
    }

    public static void endGame(PlayerHand player){
        System.out.println(newLine + newLine + "-----GAME OVER ---------"+ newLine);
        System.out.println("Your score is: "+player.getScore());
        System.out.println("-----GAME OVER ------------");
    }

    public static void endGAme(PlayerHand player1, PlayerHand player2){

        if (player1.getScore() > player2.getScore()){
            System.out.println(newLine + newLine + "-----GAME OVER ---------"+ newLine);
            System.out.println(player1.getName() + " Score is");
            System.out.println(newLine + player1.getScore());
            System.out.println("SORRY " + player2.getName() + newLine + player1.getName() + " WINS");
        } else if (player1.getScore() == player2.getScore()) {

            System.out.println("You have a tied score.");
        } else{
            System.out.println("-----GAME OVER ------------" + newLine + newLine);
            System.out.println(player2.getName() + " Score is");
            System.out.println(newLine + player2.getScore());
            System.out.println("SORRY " + player1.getName() + newLine + player2.getName() + " WINS");
            System.out.println("-----GAME OVER ------------" + newLine + newLine);
        }
    }

    public static void singlePlayerGame(){
            playerOne = createPlayer();
            System.out.println(playerOne.displayPlayerCards());
            System.out.println("You have a Streak score of: " + playerOne.getScore());
            System.out.println("Click D to drop a card or any key to end Game \n NOTE: " + playerOne.getDroppedTimes() + " times remaining"+ newLine);

            if (scanner.nextLine().equalsIgnoreCase("d")){

                dropCard(playerOne);
                //Player picking another card
                System.out.println("You must have a maximum of " + playerOne.getCapacity() +" , Click p to pick a card or q to quit" + newLine);

                while(scanner.nextLine().equalsIgnoreCase("p") && playerOne.getDroppedTimes() != 0 ){
                    pickCard(playerOne);
                    System.out.println("Click D to drop a card or any key to end Game \n NOTE: " + playerOne.getDroppedTimes() + " times remaining"+ newLine);
                    if (scanner.nextLine().equalsIgnoreCase("d")){
                        dropCard(playerOne);
                    }else{
                        endGame(playerOne);
                        break;
                    }
                    System.out.println("You must have a maximum " + playerOne.getCapacity() + " cards" + " , Click p to pick a card or any key to quit" + newLine);
                }

                endGame(playerOne);
            }else{
                endGame(playerOne);
            }
    }

    public static void twoPlayerGame(PlayerHand playerOne, PlayerHand playerTwo){

        System.out.println("First player turn");
        playerOne = createPlayer();
        System.out.println(playerOne.displayPlayerCards());
        System.out.println("You have a Streak score of: " + playerOne.getScore());
        String playerOnesTurn = playerOne.getName() + " turn to play" + newLine;
        System.out.println("Second player turn");
        playerTwo = createPlayer();
        System.out.println(playerTwo.displayPlayerCards());
        System.out.println("You have a Streak score of: " + playerTwo.getScore());
        String playerTwosTurn = playerTwo.getName() + " turn to play" + newLine;


        do {
            System.out.println(playerOnesTurn);
            System.out.println("Click D to drop a card or any key to end Game \n NOTE: " + playerOne.getDroppedTimes() + " times remaining"+ newLine);

            if (scanner.nextLine().equalsIgnoreCase("d")){
                System.out.println(playerOne.displayPlayerCards());
                dropCard(playerOne);
            }else{
                endGAme(playerOne, playerTwo);
                break;
            }
            System.out.println("You must have a maximum " + playerOne.getCapacity() + " cards" + " , Click p to pick a card or any key to quit" + newLine);
            if (scanner.nextLine().equalsIgnoreCase("p")){
                pickCard(playerOne);
            }else{
                endGAme(playerOne, playerTwo);
                break;
            }
            System.out.println(playerTwosTurn);
            System.out.println("Click D to drop a card or any key to end Game \n NOTE: " + playerTwo.getDroppedTimes() + " times remaining"+ newLine);

            if (scanner.nextLine().equalsIgnoreCase("d")){
                System.out.println(playerTwo.displayPlayerCards());
                dropCard(playerTwo);
            }else{
                endGAme(playerOne, playerTwo);
                break;
            }
            System.out.println("You must have a maximum " + playerTwo.getCapacity() + " cards" + " , Click p to pick a card or any key to quit" + newLine);
            if (scanner.nextLine().equalsIgnoreCase("p")){
                pickCard(playerTwo);
            }else{
                endGAme(playerOne, playerTwo);
                break;
            }

            System.out.println(playerOnesTurn);
            System.out.println(playerOne.displayPlayerCards());
            System.out.println("You have a Streak score of: " + playerOne.getScore());
            System.out.println("Click D to drop a card or any key to end Game \n NOTE: " + playerOne.getDroppedTimes() + " times remaining"+ newLine);

        } while (scanner.nextLine().equalsIgnoreCase("d") && playerTwo.getDroppedTimes() != 0);

        System.out.println("The number of times of dropping a card is over");
        endGAme(playerOne, playerTwo);
    }

}
