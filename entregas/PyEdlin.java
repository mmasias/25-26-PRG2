import java.util.Scanner;

public class PyEdlin {

    static String[] lineas = new String[10];
    static int lineaActiva = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            lineas[i] = "";
        }

        mostrarEditor();

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
