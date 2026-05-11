public class Deck {
    private Cards[] cards;

    public Deck() {
        String [] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String [] suits = {"♥", "♦", "♣", "♠"};
        this.cards = new Cards[52];

        int index = 0;
        for(int r = 0; r < ranks.length; r++){
            for(int s = 0; s < suits.length; s++){
                this.cards[index] = new Cards(ranks[r], suits[s]);
                index++;
            }
        }
    }

    public void shuffleCards() {
        for(int i = 0; i < cards.length; i++){
            int randomIndex = (int) (Math.random()) * 52;
            Cards temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }
}
