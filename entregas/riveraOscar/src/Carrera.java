public class Carrera {
    private Caballo[] caballos;
    Pista pista;
    Turno turno;

    public Carrera(){
        this.caballos = new Caballo[2];
        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo(i + 1);
        }
        this.pista = new Pista();
        this.turno = new Turno(caballos.length);
    }

    public void jugar() {
        while (!pista.existeGanador(caballos)) {
            pista.mostrarPista(caballos);
            
            int caballoActual = turno.toca();
            caballos[caballoActual].avanzar();
            turno.cambiar();

        }
        pista.mostrarPista(caballos);
        if (pista.existeEmpate(caballos)) {
            System.out.println("¡Es un empate!");
        } else {
            for (Caballo caballo : caballos) {
                if (caballo.obtenerPosicion() >= 40) {
                    System.out.println("¡El caballo " + caballo.obtenerNumero() + " ha ganado!");
                    break;
                }
            }
        }
    }
}