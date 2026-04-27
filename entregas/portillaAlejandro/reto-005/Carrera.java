public class Carrera {

    private Caballo caballo1;
    private Caballo caballo2;
    private Pista pista;

    public Carrera() {
        caballo1 = new Caballo(1);
        caballo2 = new Caballo(2);
        pista = new Pista(40);
    }

    public void jugar() {

        boolean fin = false;

        while (!fin) {

            int turno = (int)(Math.random() * 2);

            if (turno == 0) {
                caballo1.mover();
            } else {
                caballo2.mover();
            }

            pista.mostrar(caballo1, caballo2);

            if (caballo1.getPosicion() >= pista.getLongitud() &&
                caballo2.getPosicion() >= pista.getLongitud()) {

                System.out.println("Empate!");
                fin = true;

            } else if (caballo1.getPosicion() >= pista.getLongitud()) {

                System.out.println("Ganó el caballo 1");
                fin = true;

            } else if (caballo2.getPosicion() >= pista.getLongitud()) {

                System.out.println("Ganó el caballo 2");
                fin = true;
            }
        }
    }
}