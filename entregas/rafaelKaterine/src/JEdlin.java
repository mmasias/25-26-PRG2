import java.util.Scanner;
import java.util.Arrays;

public class JEdlin {
    private String[] linea;
    private int lineaSeleccionada;
    private Scanner scanner;

    public JEdlin() {
        linea = new String[10];
        Arrays.fill(linea,"");
        linea[0] = "Bienvenidos al editor EDLIN";
        linea[1]= "Utilice el menu inferior para editar el texto";
        linea[2]= "---------------------------------------------";
        lineaSeleccionada = 0;
        scanner = new Scanner(System.in)
    }

    private void limpiarPantalla(){
        System.out.print("/////////");
        System.out.flush();
        for (int i = 0; i < 50; i++) System.out.println();
    }

    public void interfaz(){
        limpiarPantalla();
        for (int i = 0; i < linea.length; i++){
            String marker = (i == lineaSeleccionada) ? "*": "";
            System.out.printf("%d: %s| %s%n", i, marker, linea[i]);
        }
    }

    private void setActivateLine(){
        
    }

}


