package entregas.riveraOscar;
import java.util.Scanner;

public class Blackjack {
    private Baraja baraja;
    private Mano manoJugador;
    private Scanner entrada;
    
    public Blackjack(){
        this.entrada = new Scanner(System.in);
    }

    public void jugar(){
        boolean continuar = true;

        while (continuar) {
            this.baraja = new Baraja();
            this.baraja.barajar();
            this.manoJugador = new Mano();

            this.manoJugador.recibirCarta(baraja.darCarta());
            this.manoJugador.recibirCarta(baraja.darCarta());

            boolean turno = true;
            while (turno) {
                System.out.println("--------------------");
                this.manoJugador.mostrarMano();
                int puntos = this.manoJugador.calcularPuntaje();

                if (puntos > 21) {
                    System.out.println("==> Perdió");
                    turno = false;
                } else if (puntos == 21) {
                    System.out.println("==> ¡Ganó!");
                    turno = false;
                } else {
                    System.out.println("==> Sigue jugando");
                }

                if (turno) {
                    System.out.println("--------------------");
                    System.out.println("1. Pedir\n2. Empezar de nuevo\n3. Salir");
                    System.out.println("--------------------");
                    
                    int opcion = entrada.nextInt();

                    switch (opcion) {
                        case 1:
                            this.manoJugador.recibirCarta(baraja.darCarta());
                            break;
                        case 2:
                            turno = false;
                            break;
                        case 3:
                            turno = false;
                            continuar = false;
                        default:
                            break;
                    }
                } else {
                    System.out.println("1. Jugar otra vez\n2. Salir");
                    int finalOpcion = entrada.nextInt();
                    if (finalOpcion == 2) {
                        continuar = false;
                    }
                    turno = false;
                }
            }
        }
    }
}