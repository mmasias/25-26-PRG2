package entregas.sanmiguelHector.reto002;

public class EditorFicheros {
    public static void main(String[] args) {
        MostrarMenu();
    }

    static void MostrarMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("0: | Bienvenidos al editor EDLIN");
        System.out.println("1:*| Utilice el menu inferior para editar el texto");
        System.out.println("2: | ------");
        System.out.println("3: | [L] permite definir la linea activa");
        System.out.println("4: | [E] permite editar la linea activa");
        System.out.println("5: | [I] permite intercambiar dos lineas");
        System.out.println("6: | [B] borra el contenido de la linea activa");
        System.out.println("7: | [S] sale del programa");
        System.out.println("8: | ");
        System.out.println("9: | ");
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }
}
