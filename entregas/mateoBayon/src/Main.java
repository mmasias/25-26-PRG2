import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        Deck deck = new Deck();
        Hand playerHand = new Hand();

        while(!playerHand.playerWon()){
            System.out.println("Do you want to get a card? (Y/N)");
            String answer = playerInput.nextLine();
            if(answer == "Y"){
                playerHand.getCard(deck.dealCard());
            } else {
                System.out.println("You have " + playerHand.totalPoints() + " points.");
            }
            playerHand.playerWon();
        }
    }
}
