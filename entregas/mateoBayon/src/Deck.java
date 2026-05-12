public class Deck {
    private Card[] cards;
    private int nextCardIndex = 0;

    public Deck() {
        String [] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String [] suits = {"♥", "♦", "♣", "♠"};
        this.cards = new Card[52];

        int index = 0;
        for(int r = 0; r < ranks.length; r++){
            for(int s = 0; s < suits.length; s++){
                this.cards[index] = new Card(ranks[r], suits[s]);
                index++;
            }
        }
    }

    public void shuffleCards() {
        for(int i = 0; i < cards.length; i++){
            int randomIndex = (int) (Math.random()) * 52;
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    public Card dealCard() {
        if(nextCardIndex < cards.length){
            Card card = this.cards[nextCardIndex];
            nextCardIndex++;
            return card;
        } else {
            return null;
        }
    }
}
