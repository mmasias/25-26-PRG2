import java.util.Scanner;

public class PyEdlinMyVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] textoIngresadoPorElUsuario = new String[10];
        int lineaSeleccionadaDelTextoIngresado = 0;
        
        menuDeBienvenida();
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
}
