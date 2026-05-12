public class BlackJackGame {
    
    private Scanner entrada = new Scanner(System.in);
    private int usuarios;
    private Jugador[] jugadores;
    private Baraja baraja;
    private Dealer crupier = new Dealer();

    public void inicializarJuego(){
        String nombres;

        System.out.println("Bienvenido al juego de BlackJack");
        System.out.println("");
        System.out.println(" REGLAS DEL JUEGO ");
        System.out.println("1. El objetivo del juego es acercarse lo más posible a 21 puntos sin pasarse.");
        System.out.println("2. Cada jugador recibe dos cartas al inicio del juego.");
        System.out.println("3. Los jugadores pueden elegir 'Pedir' para recibir otra carta o 'Plantarse' para mantener su mano actual.");
        System.out.println("4. El crupier juega después de que todos los jugadores hayan terminado sus turnos.");
        System.out.println("5. El jugador que tenga la mano más cercana a 21 sin pasarse gana la partida.");
        System.out.println("");

        do {
            System.out.print("Ingrese el número de jugadores (1-4): ");
            usuarios = entrada.nextInt();

        } while (usuarios < 1 || usuarios > 4);

        jugadores = new Jugador[usuarios];
        baraja = new Baraja();

        for(int i=0; i<usuarios; i++){
            System.out.print("Ingrese el nombre del jugador " + (i+1) + ": ");
            nombres = entrada.next();
            jugadores[i] = new Jugador(nombres);
            jugadore[i].establecerNombre(nombres);
        }
    }

    public void barajarCartas(){
        baraja.barajar();

    }
    public void obtenerApuestas(){
int ValorApuesta;

for(int i=0; i<usuarios; i++){
    if(jugadores[i].getSaldo() > 0) {
        do {
            System.out.print(jugadores[i].getNombre() + ", ingrese su apuesta (saldo disponible: " + jugadores[i].getSaldo() + "): ");
            ValorApuesta = entrada.nextInt();
            jugadores[i].establecerApuesta(ValorApuesta);
        } while (!(ValorApuesta > 0 && ValorApuesta <= jugadores[i].getSaldo()));
  
System.out.println("")

    }
       
}   
    }
public void repartirCartas(){
    for(int j =o; j<2; j++){
        for(int i=0; i<usuarios; i++){
            if(jugadores[i].getSaldo() > 0) {
                jugadores[i].añadirCarta(baraja.siguienteCarta());
            }
        }
         crupier.añadirCarta(baraja.siguienteCarta());
    }
   
}
public void comprobarBlackjack(){
    if (crupier.tieneBlackjack()) {
        system.out.println("El crupier tiene Blackjack. Todos los jugadores pierden.");
        for (int i = 0 ; i< usuarios; i++) {
            if(jugadores[i].getTotal() == 21) {
                system.out.println(jugadores[i].getNombre() + " tiene Blackjack. Empate con el crupier.");
jugadores[i].push();
}else {
    System.out.println(jugadores[i].getNombre() + " pierde contra el crupier.");
jugadores[i].perder();
        }
    }
}else {
    if (crupier.revisa()){
        Sistem.out.println("El crupier revisa y no tiene el blacjack");

    }
    for(int i = 0;i<usuarios ; i++){
        if (jugadores[i].getTotal() == 21) {
            System.out.println(jugadores[i].getNombre() + " tiene Blackjack. Gana contra el crupier.");
            jugadores[i]blackjack();
       
        }
    }
}
public void pedirCartaOPlantarse(){
    string comando;
    char c;

    for(int i = 0; i<usuarios; i++){
        if(jugadores[i].getSaldo() > 0) {
            System.out.println();
            System.out.println(jugadores[i].getname() + ", tu mano actual es: " + jugadores[i].mostrarMano());
            
            do{
                do{
                    System.out.print("¿Deseas 'Pedir' una carta o 'Plantarte'? (P/Pedir, S/Plantarse): ");
                    comando = entrada.next();
                    c = comando.toUpperCase().charAt(0);

                }while (!(c == 'P' || c == 'S'));
                if (c == 'P') {
                    jugadores[i].añadirCarta(baraja.siguienteCarta());
                    System.out.println("Tu mano actual es: " + jugadores[i].mostrarMano());
                }
            }while (c == 'P' && jugadores[i].calcularValorMano() < 21);
}
}
}
public void juegaCrupier(){
    boolean algunJugadorSigueEnJuego = false;

    for (int i = 0;i < usuarios && !algunJugadorSigueEnJuego; i++) {
        if (jugadores[i].getSaldo() > 0 && jugadores[i].calcularValorMano() <= 21) {
            algunJugadorSigueEnJuego = true;
        }
    }
    if(algunJugadorSigueEnJuego){
        crupier.dealerJuega(baraja);
    }
}
public void liquidarApuesta(){

    Sustem.out.println();

    for(int i = 0; i< usuarios;i++){
        if(jugadores[i].getSaldo()>0){
            if (jugadores[i].getTotal() > 21) {
                System.out.println(jugadores[i].getNombre() + " se ha pasado de 21. Pierde su apuesta.");
                jugadores[i].perder();
            } else if (crupier.getTotal() > 21) {
                System.out.println("El crupier se ha pasado de 21. " + jugadores[i].getNombre() + " gana su apuesta.");
                jugadores[i].ganar();
            } else if (jugadores[i].getTotal() > crupier.getTotal()) {
                System.out.println(jugadores[i].getNombre() + " tiene una mano mejor que el crupier. Gana su apuesta.");
                jugadores[i].ganar();
            } else if (jugadores[i].getTotal() == crupier.getTotal()) {
                System.out.println(jugadores[i].getNombre() + " empata con el crupier. Recupera su apuesta.");
                jugadores[i].push();
            } else {
                System.out.println(jugadores[i].getNombre() + " tiene una mano peor que el crupier. Pierde su apuesta.");
                jugadores[i].perder();
        }
    }
}
}
public void imprimirEstado() {
    for (int i = 0; i < usuarios;i++){
        if(jugadores[i].getSaldo()>0){
            System.out.println(jugadores[i].getNombre()+ ", saldo actual: " + jugadores[i].mostrarMano());
        }
    }
    System.out.println("Crupier, mano actual: " + crupier.mostrarMano());
}
public void imprimirDinero(){
    for(int i = 0; i<usuarios; i++){
        if(jugadores[i].getSaldo()>0){
            System.out.println(jugadores[i].getnombre()+ ", saldo final: " + jugadores[i].getSaldo()); 
        }
        if(jugadores[i].getSaldo() == 0){
            System.out.println(jugadores[i].getNombre() + ", te has quedado sin saldo. Gracias por jugar.");
        jugadores[i].salirDelJuego();
        }
    }
}
public void limpiarManos(){
    for(int i=0 ; i< usuarios; i++){
        jugadores[i].limpiarMano();
    }
    crupier.limpiarMano();
}
public boolean jugarDeNuevo(){
    String comando;
    char c;
    boolean estadoJuego= true;

    if(forzamosFin()){
        estadoJuego = false;
    }else{
        do{
            System.out.println("¿Desean jugar otra ronda? (S/N): ");
            comando = entrada.next();
            c = comando.toUpperCase().charAt(0);
        }while (!(c == 'S' || c == 'N'));
        if (c == 'N') {
            estadoJuego = false;
        }
    }
    return estadoJuego;
}
public boolean forzamosFin(){
    boolean fin=false;
    int contadorFin = 0;

    for(int i=0;i<usuarios;i++){
        if(jugadores[i].getSaldo() == -1){
            contadorFin++;
        }
    }
    if(contadorFin == usuarios){
        fin = true;
    }
    if(fin){
        System.out.println("Todos los jugadores se han quedado sin saldo. El juego ha terminado.");
    }
return fin;
}
public void finalizarJuego(){

    int cantidadFinal;
    String estadoFinal = "sin cambios";

    System.out.println("");
    for (int i = 0; i< usuarios; i++){
        if(jugadores[i].getSaldo()==-1){
            jugadores[i].reicibirSaldo();
        }
        cantidadFinal = jugadores[i].getSaldo() - 100;
        if(cantidadFinal > 0){
            estadoFinal = "ganancia de";
            
    }else if(cantidadFinal < 0){
        estadoFinal = "pérdida de"; 
}
System.out.println(jugadores[i].getNombre()+ "termino el juego con"+ jugadores[1].getSaldo()+".");
if(estadoFInal != "sin cambios"){
    System.out.println("Esto representa una " + estadoFinal + " " + Math.abs(cantidadFinal) + " fichas.");
}
SYstem.out.println("");
}
System.out.println("Gracias por jugar al BlackJack. ¡Hasta la próxima!");
}
}
}