import java.util.Scanner;
import java.util.Stack;

public class Edlin {

    static final int MAX = 10;

    public static void mostrar(String[] buffer, int activa) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < buffer.length; i++) {
            String marca = (i == activa) ? "*" : " ";
            System.out.println(i + ":" + marca + "| " + buffer[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: L linea | E editar | I intercambiar | B borrar | D deshacer | S salir");
    }

    public static String[] copiar(String[] original) {
        String[] copia = new String[original.length];
        for(int i=0;i<original.length;i++)
            copia[i] = original[i];
        return copia;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] buffer = new String[MAX];
        for(int i=0;i<MAX;i++)
            buffer[i] = "";

        int activa = 0;
        Stack<String[]> historial = new Stack<>();

        boolean salir = false;

        while(!salir) {

            mostrar(buffer, activa);
            System.out.print("Comando: ");
            String cmd = sc.nextLine().toUpperCase().trim();

            switch(cmd) {

                case "L":
                    System.out.print("Linea activa: ");
                    int l = Integer.parseInt(sc.nextLine());
                    if(l>=0 && l<MAX)
                        activa = l;
                    break;

                case "E":
                    historial.push(copiar(buffer));
                    System.out.print("Nuevo texto: ");
                    buffer[activa] = sc.nextLine();
                    break;

                case "B":
                    historial.push(copiar(buffer));
                    buffer[activa] = "";
                    break;

                case "I":
                    System.out.print("Linea 1: ");
                    int a = Integer.parseInt(sc.nextLine());
                    System.out.print("Linea 2: ");
                    int b = Integer.parseInt(sc.nextLine());
                    if(a>=0 && a<MAX && b>=0 && b<MAX){
                        historial.push(copiar(buffer));
                        String temp = buffer[a];
                        buffer[a] = buffer[b];
                        buffer[b] = temp;
                    }
                    break;

                case "D":
                    if(!historial.isEmpty())
                        buffer = historial.pop();
                    else
                        System.out.println("Nada que deshacer");
                    break;

                case "S":
                    salir = true;
                    break;

                default:
                    System.out.println("Comando invalido");
            }
        }
        sc.close();
    }
}