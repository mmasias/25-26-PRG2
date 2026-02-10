import java.util.Scanner;

public class PyEdlin {

    static String[] lineas = new String[10];
    static int lineaActiva = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            lineas[i] = "";
        }

        while(true){
            mostrarEditor();
            System.out.print("Comando: ");
            String comando = sc.nextLine().toUpperCase();

            if(comando.equals("L")){
                System.out.print("Numero de linea (0-9): ");
                int nueva = Integer.parseInt(sc.nextLine());
                if(nueva >= 0 && nueva <= 9){
                    lineaActiva = nueva;
                }
            }
            else if(comando.equals("E")){
                System.out.print("Nuevo texto: ");
                String texto = sc.nextLine();
                lineas[lineaActiva] = texto;
            }
            else if(comando.equals("B")){
                lineas[lineaActiva] = "";
            }
            else if(comando.equals("I")){
                System.out.print("Primera linea: ");
                int l1 = Integer.parseInt(sc.nextLine());
                System.out.print("Segunda linea: ");
                int l2 = Integer.parseInt(sc.nextLine());

                if(l1 >= 0 && l1 <= 9 && l2 >= 0 && l2 <= 9){
                    String temp = lineas[l1];
                    lineas[l1] = lineas[l2];
                    lineas[l2] = temp;
                }
            }
            else if(comando.equals("S")){
                break;
            }
        }

        sc.close();
    }

    public static void mostrarEditor(){
        System.out.println("----------------------------------");
        for(int i = 0; i < 10; i++){
            if(i == lineaActiva)
                System.out.println(i + ":*| " + lineas[i]);
            else
                System.out.println(i + ": | " + lineas[i]);
        }
        System.out.println("----------------------------------");
    }
}
