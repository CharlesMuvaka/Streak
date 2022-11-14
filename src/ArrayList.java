public class ArrayList {
    private Card[] cards;
    private int capacity, size;

    public ArrayList(int capacity) {
        this.cards = new Card[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
}
