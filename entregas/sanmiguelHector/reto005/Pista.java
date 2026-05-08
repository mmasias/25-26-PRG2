class Pista {

    int[][] pista;
    private int numeroJugadores;
    private int tamañoPista;

    public Pista(int numeroJugadores, int tamañoPista) {
        this.numeroJugadores = numeroJugadores;
        this.tamañoPista = tamañoPista;

        pista = new int[numeroJugadores][tamañoPista];
        
        for (int i = 0; i < numeroJugadores; i++) {
            for (int j = 0; j < tamañoPista; j++) {
                pista[i][j] = -1;
            }
        }
    }
    
    public void mostrar() {
        for(int i = 0; i < numeroJugadores; i++){
            System.out.print("Caballo " + i + ": ");
            for(int j = 0; j < tamañoPista; j++){
                if (pista[i][j] != -1) {
                    System.out.print("[" + pista[i][j] + "]");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();

        } System.out.println();
    }

    public void meter(Caballo caballo) {
        pista[caballo.getDorsal()][0] = caballo.getDorsal();
    }

    public void mover(Caballo caballo) {
        int dorsal = caballo.getDorsal();
        int posicionActual = -1;

        for (int j = 0; j < tamañoPista; j++) {
            if (pista[dorsal][j] == dorsal) {
                posicionActual = j;
                break;
            }
        }

        double probabilidad = Math.random() * 100;
        int avance;
        if (probabilidad < 50) {
            avance = 1;
        } else if (probabilidad < 80) {
            avance = 2;
        } else {
            avance = 4;
        }

        int nuevaPosicion = posicionActual + avance;
        if (nuevaPosicion >= tamañoPista) {
            nuevaPosicion = tamañoPista - 1;
        }

        pista[dorsal][posicionActual] = -1;
        pista[dorsal][nuevaPosicion] = dorsal;
    }

    public boolean hayGanadores() {
        for (int i = 0; i < numeroJugadores; i++) {
            if (pista[i][tamañoPista - 1] != -1) {
                return true;
            }
        }
        return false;
    }

    public void mostrarEstadoFinal() {
        System.out.println("\n--- RESULTADO DE LA CARRERA ---");
        for (int i = 0; i < numeroJugadores; i++) {
            if (pista[i][tamañoPista - 1] != -1) {
                System.out.println("El Caballo " + i + " ha ganado la carrera!");
            }
        }
    }
} 