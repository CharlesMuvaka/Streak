import java.util.Random;

public class ArrayList {
    private Card[] cards;
    private int capacity, size;

    public ArrayList(int capacity) {
        this.cards = new Card[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
    //create a method that adds a card to the ArrayList
    public void addCard(Card card){
        cards[size] = card; //the card's index in the array will be equal to the array size
        size++;
    }

    //create a method to remove an item from the arraylist
    public void removeCard(int index){
        for(int i = index; i < cards.length -1; i++){
            cards[i] = cards[i + 1]; //the card to be removed will be assigned details of the next card
        }
        this.size--;
    }

    //create a method to get the size of the arrayList
    public int getSize(){
        return this.size;
    }

    //create a method to shuffle the arrayList
    public void shuffleCards(){
        Random randomNumber = new Random();
        for (int i = 0; i < cards.length; i++){
            int secondCard = randomNumber.nextInt(cards.length); //generates a random number based from the length of the cards
            Card newCard = cards[i];
            cards[i] = cards[secondCard];
            cards[secondCard] = newCard;
        }
    }

    //create a method that gets a card from the arraylist based on its index
    public Card getCard(int index){
        return this.cards[index];
    }

    @Override
    public String toString(){
        if (cards.length == 0){
            return  "You has no cards";
        }else{
            String str = new String("You has the following cards \n");
            for (int i = 0; i < cards.length; i++) {
                str += cards[i].toString();
                str += "\n";
            }
            return str;
        }

    }


}
