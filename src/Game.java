import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static CardDeck deck = new CardDeck();
    static String newLine = "\n\r";


    public static PlayerHand createPlayer(){
        System.out.println("Enter your name to play the game");
        String name = scanner.nextLine();

        PlayerHand player = new PlayerHand(name);
        for (int i = 0; i < deck.getCardDeckSize(); i++) {
            if(player.getPlayerTotalCards() < 5){
                deck.getDeckCards().shuffleCards();
                Card newCard = deck.getDeckCards().getCard(i);
                player.addPlayerCards(newCard);
                deck.getDeckCards().removeCard(i);
            }

        }

        return player;
    }

    public static void checkCards(PlayerHand player){
        if (scanner.nextLine().equalsIgnoreCase("c")){
            System.out.println(player.getName());
            player.sortCards();
            System.out.println(player.displayPlayerCards());
            System.out.println(player.getScore());
        }
    }

    public static void dropCard(PlayerHand player){
            System.out.println("Type the name of the card to drop e.g ace - type ace, two - type two");
            String cardToDrop = scanner.nextLine();
            for (int i = 0; i < player.getPlayerCards().getSize(); i++) {
                if (player.getPlayerCards().getCard(i).getRank().equalsIgnoreCase(cardToDrop)){
                    player.getPlayerCards().removeCard(i);
                    player.setDroppedTimes(1);
                }
            }
        System.out.println( player.getName() + " has " + player.getDroppedTimes() + " times remaining to drop a card" + newLine);
        System.out.println(player.displayPlayerCards());

    }

    public static void pickCard(PlayerHand player){
            Card pickedCard = deck.getDeckCards().getCard(deck.getCardDeckSize());
            deck.getDeckCards().removeCard(deck.getCardDeckSize());
            player.addPlayerCards(pickedCard);
            player.sortCards();
            System.out.println(player.displayPlayerCards());
            System.out.println(player.getScore());
    }

    public static void endGame(PlayerHand player){
        System.out.println(newLine + newLine + "-----GAME OVER ---------"+ newLine);
        System.out.println(newLine + player.getScore());
        System.out.println("-----GAME OVER ------------" + newLine + newLine);
    }

    public static void endGAme(PlayerHand player1, PlayerHand player2){

        if (player1.getScore() > player2.getScore()){
            System.out.println(newLine + newLine + "-----GAME OVER ---------"+ newLine);
            System.out.println(player1.getName() + " Score is");
            System.out.println(newLine + player1.getScore());
            System.out.println(newLine + player2.getScore());
            System.out.println("SORRY " + player2.getName() + newLine + player1.getName() + " WINS");
        } else if (player1.getScore() == player2.getScore()) {

            System.out.println("You have a tied score.");
        } else{
            System.out.println("-----GAME OVER ------------" + newLine + newLine);
            System.out.println(player2.getName() + " Score is");
            System.out.println(newLine + player2.getScore());
            System.out.println(newLine + player1.getScore());
            System.out.println("SORRY " + player1.getName() + newLine + player2.getName() + " WINS");
            System.out.println("-----GAME OVER ------------" + newLine + newLine);
        }
    }

    public static void main(String[] args) {
         PlayerHand playerOne = new PlayerHand();
         PlayerHand playerTwo = new PlayerHand();

        System.out.println("Streak can be played by a single or two players, type 1 to play alone or 2 to play with a friend");
        if (scanner.nextLine().equals("1")){
            playerOne = Game.createPlayer();
            System.out.println("Press c to see the cards you have");
            Game.checkCards(playerOne);
            System.out.println("Click D to drop a card or any key to end Game \n NOTE: You can drop a maximum of five cards" + newLine);

            if (scanner.nextLine().equalsIgnoreCase("d")){

                Game.dropCard(playerOne);
                //Player picking another card
                System.out.println("You must have a maximum of five cards, Click p to pick a card or q to quit" + newLine);

                while(scanner.nextLine().equalsIgnoreCase("p") && playerOne.getDroppedTimes() != 0 ){
                    Game.pickCard(playerOne);
                    System.out.println("Click D to drop a card or any key to end Game \n NOTE: You can drop a maximum of five cards" + newLine);
                    if (scanner.nextLine().equalsIgnoreCase("d")){
                        Game.dropCard(playerOne);
                    }else{
                        Game.endGame(playerOne);
                        break;
                    }
                    System.out.println("You must have a maximum of five cards, Click p to pick a card or any key to quit" + newLine);
                }

                Game.endGame(playerOne);
            }else{
                Game.endGame(playerOne);
            }


        }else {
            Game.twoPlayerGame(playerOne, playerTwo);
        }
    }
    public static void twoPlayerGame(PlayerHand playerOne, PlayerHand playerTwo){

        System.out.println("First player turn");
        playerOne = Game.createPlayer();
        String playerOnesTurn = playerOne.getName() + " turn to play" + newLine;
        System.out.println("Second player turn");
        playerTwo = Game.createPlayer();
        String playerTwosTurn = playerTwo.getName() + " turn to play" + newLine;

        System.out.println(playerOnesTurn);
        System.out.println("Press c to see the cards you have");
        Game.checkCards(playerOne);

        System.out.println(playerTwosTurn);
        System.out.println(" type c to see your cards");
        Game.checkCards(playerTwo);
        System.out.println(playerOne.getDroppedTimes());

        System.out.println(playerOnesTurn);
        System.out.println("Click D to drop a card or any key to end Game \n NOTE: You can drop a maximum of five cards" +newLine);
        System.out.println(playerOne.getName() + " has " + playerOne.getDroppedTimes() + " times remaining to drop card");

        do {
            Game.dropCard(playerOne);
            System.out.println("You must have a maximum of five cards, Click p to pick a card or any key to quit");
            if (scanner.nextLine().equalsIgnoreCase("p")){
                Game.pickCard(playerOne);
            }else{
                Game.endGAme(playerOne, playerTwo);
                break;
            }
            System.out.println(playerTwosTurn);
            System.out.println("Click D to drop a card or any key to end Game \n NOTE: You can drop a maximum of five cards" + newLine);

            if (scanner.nextLine().equalsIgnoreCase("d")){
                Game.dropCard(playerTwo);
            }else{
                Game.endGAme(playerOne, playerTwo);
                break;
            }

            System.out.println("You must have a maximum of five cards, Click p to pick a card or any key to quit");
            if (scanner.nextLine().equalsIgnoreCase("p")){
                Game.pickCard(playerTwo);
            }else{
                Game.endGAme(playerOne, playerTwo);
                break;
            }

            System.out.println(playerOnesTurn);
            System.out.println(playerOne.getPlayerCards().toString());
            System.out.println(playerOne.getScore());
            System.out.println("Click D to drop a card or any key to end Game \n NOTE: You can drop a maximum of five cards" + newLine);

        } while (scanner.nextLine().equalsIgnoreCase("d") && playerTwo.getDroppedTimes() != 5);

        System.out.println("The number of times of dropping a card is over");
        Game.endGAme(playerOne, playerTwo);
    }
}