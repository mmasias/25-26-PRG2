public class Cards {
    private String rank;
    private String suit;

    public Cards(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getValueRank() {
        switch(this.rank){
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(this.rank);
        }
    }

    public String getSuit() {
        return suit;
    }
}
