class BlackJack {
 public static void main(String[] args) {
 BlackJackGame mygame = new BlackJackGame();

 mygame.empezarJuego();
 do{
    mygame.barajear();
    mygame.ponerApuesta();
    mygame.repartirCartas();
    my.game.printStatus();
    mygame.revisarBlackJack();
    mygame.hitOrStand();
    mygame.dealerPlays();
    mygame.liquidarApuesta();
    mygame.printDinero();
    mygame.limpiarManos();
 }while(mygame.jugarOtraVez());
    }
}