public class Deck {
    private Cards[] cards;

    public Deck() {
        String [] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String [] suits = {"♥", "♦", "♣", "♠"};
        this.cards = new Cards[52];

        int index = 0;
    }
}
