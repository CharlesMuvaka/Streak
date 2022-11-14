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
}
