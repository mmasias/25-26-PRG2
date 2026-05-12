public class Hand {
    private Card[] myCards;
    private int numCards;

    public Hand() {
        this.myCards = new Card[10];
        this.numCards = 0;
    }

    public void getCard(Card card) {
        for(int i = 0; i < myCards.length; i++){
            this.myCards[numCards] = card;
            this.numCards++;
        }
    }

    public int totalPoints() {
        int total = 0;
        for(int i = 0; i < myCards.length; i++) {
            total += myCards[i].getValueRank();
        }
        return total;
    }

    public boolean playerWon() {
        if(totalPoints() == 21){
            return true;
        }
        return false;
    }
}
