import java.util.Scanner;

public class Edlin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] lineas = new String[10];
        int lineaActiva = 1;
        
        System.out.println("Editor EDLIN - Iniciando...");
        System.out.println("Tengo " + lineas.length + " lineas disponibles.");
        System.out.println("Linea activa: " + lineaActiva);
        
        sc.close();
    }
}