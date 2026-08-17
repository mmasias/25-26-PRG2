class Carrera {
     public static void main(String[] args) {
       
    }

    
    private int caballo1 = 0;
    private int caballo2 = 0;
    private int meta = 40;

     public void jugar() {
        int turno = 1;

        while (caballo1 < meta && caballo2 < meta) {
            System.out.println("TURNO NÚMERO: " + turno);

            avanzarCaballos();
            mostrarPista();

            turno++;
            pausa(); 
        }

        mostrarResultado();
    }

     private void avanzarCaballos() {
        caballo1 += (int) (Math.random() * 3); 
        caballo2 += (int) (Math.random() * 3);
    }
      private void mostrarPista() {
        System.out.println("----------------------------------------------");
        dibujarCarril(caballo1);
        dibujarCarril(caballo2);
        System.out.println("----------------------------------------------\n");
    }
     private void dibujarCarril(int posicion) {
        for (int i = 0; i < posicion; i++) {
            System.out.print(" ");
        }
        System.out.println(";-;'");
    }
     private void pausa() {// Esto me salio con la ia cuando me estanque  no se muy bien como funciona 
        try {
            Thread.sleep(300); 
        } catch (InterruptedException e) {
           
        }
    }
     private void mostrarResultado() {
        if (caballo1 >= meta && caballo2 >= meta) {
            System.out.println("¡Es un EMPATE!");
        } else if (caballo1 >= meta) {
            System.out.println("Ganó el CABALLO 1");
        } else {
            System.out.println("Ganó el CABALLO 2");
        }
    }
    

    
    
}
