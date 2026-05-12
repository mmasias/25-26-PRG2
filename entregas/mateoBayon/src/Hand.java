public class Hand {
    private Card[] myCards;
    public int numCards = 0;

    public Hand() {
        this.myCards = new Card[2];
        this.numCards = 0;
    }

    public int totalPoints() {
        for(int i = 0; i < myCards.length; i++) {
            numCards += myCards[i].getValueRank();
        }
        return numCards;
    }

    public boolean playerWon() {
        if(totalPoints() == 21){
            return true;
        }
        return false;
    }
}
