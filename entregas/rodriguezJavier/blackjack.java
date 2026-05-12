import java.util.Scanner;

public class Blackjack {
    private Baraja baraja;
    private Mano mano;
    private boolean partidaActiva;
    private Scanner scanner;
    
    public Blackjack() {
        this.baraja = new Baraja();
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        boolean jugando = true;
        
        while (jugando) {
            this.nuevaPartida();
            
            while (this.partidaActiva) {
                this.mostrarEstado();
                
                if (this.mano.calcularPuntaje() >= 21) {
                    this.partidaActiva = false;
                    break;
                }
                
                int opcion = this.mostrarMenu();
                
                if (opcion == 1) {
                    this.pedirCarta();
                } else if (opcion == 2) {
                    this.partidaActiva = false;
                } else if (opcion == 3) {
                    jugando = false;
                    this.partidaActiva = false;
                }
            }
            
            this.mostrarResultadoFinal();
        }
        
        System.out.println("Gracias por jugar!");
        this.scanner.close();
    }
    
    private void nuevaPartida() {
        this.baraja.reiniciar();
        this.mano = new Mano();
        this.partidaActiva = true;
        
        this.mano.agregarCarta(this.baraja.repartirCarta());
        this.mano.agregarCarta(this.baraja.repartirCarta());
    }
    
    private void pedirCarta() {
        Carta nueva = this.baraja.repartirCarta();
        if (nueva != null) {
            this.mano.agregarCarta(nueva);
        }
    }
    
    private void mostrarEstado() {
        System.out.println("--------------------");
        System.out.print("Mano: ");
        this.mano.mostrar();
        System.out.print(" - Puntaje: " + this.mano.calcularPuntaje());
        
        if (this.mano.calcularPuntaje() > 21) {
            System.out.print(" ==> Perdió");
        } else if (this.mano.calcularPuntaje() == 21) {
            System.out.print(" ==> Ganó");
        } else {
            System.out.print(" ==> Sigue jugando");
        }
        System.out.println();
    }
    
    private int mostrarMenu() {
        System.out.println("--------------------");
        System.out.println("1. Pedir");
        System.out.println("2. Empezar de nuevo");
        System.out.println("3. Salir");
        System.out.println("--------------------");
        
        int opcion = this.scanner.nextInt();
        return opcion;
    }
    
    private void mostrarResultadoFinal() {
        int puntaje = this.mano.calcularPuntaje();
        
        System.out.println("--------------------");
        System.out.print("Mano: ");
        this.mano.mostrar();
        System.out.print(" - Puntaje: " + puntaje);
        
        if (puntaje > 21) {
            System.out.println(" ==> Perdió");
        } else if (puntaje == 21) {
            System.out.println(" ==> Ganó");
        } else {
            System.out.println(" ==> Se plantó con " + puntaje);
        }
    }
}