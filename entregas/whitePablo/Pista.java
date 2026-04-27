class Pista {
    private int longitud;
    private String[] pista;
    private Caballo[] caballoPorPosicion;

    public Pista(int longitud) {
        this.longitud = longitud;
        this.pista = new String[longitud];
        this.caballoPorPosicion = new Caballo[longitud];
        inicializarPista();
    }

    private void inicializarPista() {
        for (int i = 0; i < longitud; i++) {
            pista[i] = " ";
            caballoPorPosicion[i] = null;
        }
    }

    public void colocarCaballo(Caballo c, int posicion) {
        if (posicion >= 0 && posicion < longitud) {
            caballoPorPosicion[posicion] = c;
            pista[posicion] = c.dibujar();
        }
    }

    public void limpiar() {
        for (int i = 0; i < longitud; i++) {
            if (caballoPorPosicion[i] != null) {
                pista[i] = " ";
                caballoPorPosicion[i] = null;
            }
        }
    }

    public void actualizar(Caballo c) {
        for (int i = 0; i < longitud; i++) {
            if (caballoPorPosicion[i] == c) {
                pista[i] = " ";
                caballoPorPosicion[i] = null;
                break;
            }
        }
        int nuevaPos = c.getPosicion();
        if (nuevaPos < longitud) {
            caballoPorPosicion[nuevaPos] = c;
            pista[nuevaPos] = c.dibujar();
        }
    }

    public void mostrar() {
        for (int i = 0; i < longitud; i++) {
            System.out.print("-");
        }
        System.out.println();
        
        StringBuilder linea = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            if (pista[i] != " ") {
                linea.append(pista[i]);
            } else {
                linea.append(" ");
            }
        }
        System.out.println(linea.toString());
        
        for (int i = 0; i < longitud; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}