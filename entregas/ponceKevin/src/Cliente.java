public class Cliente {
    private public static void main(String[] args) {
        boolean jugando = true;
        Mano mano = new Mano();
        baraja baraja = new baraja();
        mano.agregarCarta(baraja.sacarCarta());
        mano.agregarCarta(baraja.sacarCarta());
        do {
            mano.mostrarMano();
            menu();
            procesarFinal();
        } while (jugando);
    }

    private static void menu() {
        System.out.println("1.pedir carta");
        System.out.println("2.Reiniciar juego");
        System.out.println("3. Salir");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> mano.agregarCarta(baraja.sacarCarta());
            case 2 -> reiniciarPartida();
            case 3 -> jugando = false;
        }
    }

    private static void reiniciarPartida() {
        mano = new Mano();
        baraja = new baraja();
        mano.agregarCarta(baraja.sacarCarta());
        mano.agregarCarta(baraja.sacarCarta());
    }

}