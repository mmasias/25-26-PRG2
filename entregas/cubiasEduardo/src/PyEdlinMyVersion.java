import java.util.Scanner;

public class PyEdlinMyVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] textoIngresadoPorElUsuario = new String[10];
        int lineaSeleccionadaDelTextoIngresado = 0;
        
        menuDeBienvenida();
        crearTextoIngresadoPorElUsuario(sc, textoIngresadoPorElUsuario);
        mostrarTextoIngresadoPorElUsuario(textoIngresadoPorElUsuario);
    }

    static void menuDeBienvenida() {
        String menu = """
                --------------------------------------------------
                0: | Bienvenidos al editor EDLIN
                1:*| Utilice el menu inferior para editar el texto
                2: | ------
                3: | [L] permite definir la linea activa
                4: | [E] permite editar la linea activa
                5: | [I] permite intercambiar dos lineas
                6: | [B] borra el contenido de la linea activa
                7: | [S] sale del programa
                8: |
                9: |
                --------------------------------------------------
                Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir
                """;

        System.out.println(menu);
    }

    static void crearTextoIngresadoPorElUsuario(Scanner sc, String[] textoIngresadoPorElUsuario) {
        System.out.println("Ingrese el texto que desea editar. Para finalizar, ingrese [S].");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < textoIngresadoPorElUsuario.length; i++) {
            System.out.print("Ingrese la linea " + (i + 1) + ": ");
            String lineaIngresada = sc.nextLine();
            if(lineaIngresada.equals("[S]")) {
                break;
            }
            textoIngresadoPorElUsuario[i] = lineaIngresada;
        }
        System.out.println("--------------------------------------------------");
    }

    static void mostrarTextoIngresadoPorElUsuario(String[] textoIngresadoPorElUsuario) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < textoIngresadoPorElUsuario.length; i++) {
            System.out.println((i + 1) + ": " + ((textoIngresadoPorElUsuario[i] != null) ? textoIngresadoPorElUsuario[i] : ""));
        }
        System.out.println("--------------------------------------------------");
    }
}
