public class Caballos {
    
    private String caballo = ";-;'";
    private String fichasMovimiento = " ";
    private int posiciónCaballo = 0;
    private String avance = "";
    private Console console;

    public Caballos(Console console) {
        this.console = console;
    }

    public void movimientoCaballo() {
        int movimiento = (int) (Math.random() * 3);
        if (movimiento == 0) {

        } else if (movimiento == 1) {
            avance = fichasMovimiento + avance;
            posiciónCaballo = posiciónCaballo + 1;

        } else if (movimiento == 2) {
            avance = fichasMovimiento + fichasMovimiento + avance;
            posiciónCaballo = posiciónCaballo + 2;
        }

    }

}
