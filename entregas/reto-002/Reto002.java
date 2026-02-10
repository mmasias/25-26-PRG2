import java.util.Scanner;

public class Reto002 {
   final int MAX_LINEAS = 10;
   String[] fichero = new String[10];
   int lineaActiva = 0;
   Scanner scanner;

   public Reto002() {
      this.scanner = new Scanner(System.in);

      for(int var1 = 0; var1 < 10; ++var1) {
         this.fichero[var1] = "";
      }

   }

   public static void main(String[] var0) {
      Reto002 var1 = new Reto002();
      var1.ejecutar();
   }

   public void ejecutar() {
      boolean var1 = false;

      while(!var1) {
         this.mostrarInterfaz();
         System.out.print("Comando: ");
         switch (this.scanner.nextLine().toUpperCase()) {
            case "L":
               this.definirLineaActiva();
               break;
            case "E":
               this.editarLineaActiva();
               break;
            case "I":
               this.intercambiarLineas();
               break;
            case "B":
               this.borrarLineaActiva();
               break;
            case "S":
               var1 = true;
               break;
            default:
               System.out.println("Comando no válido. Intente de nuevo.");
         }
      }

      System.out.println("Saliendo del editor...");
      this.scanner.close();
   }

   private void mostrarInterfaz() {
      System.out.println("\n" + "------------------------------------------------------------");
      System.out.println("0: | Bienvenido al editor EDLIN");
      System.out.println("1:*| Utilice el menu inferior para editar el texto");
      System.out.println("2: |");
      System.out.println("3: | [L] permite definir la línea activa");
      System.out.println("4: | [E] permite editar la línea activa");
      System.out.println("5: | [I] permite intercambiar dos líneas");
      System.out.println("6: | [B] borra el contenido de la línea activa");
      System.out.println("7: | [S] sale del programa");
      System.out.println("8: |");
      System.out.println("9: |");
      System.out.println("------------------------------------------------------------");
      System.out.println("\nFichero actual (línea activa: " + this.lineaActiva + "):");
      this.mostrarFichero();
      System.out.println("\nComandos: [L]ínea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
   }

   public void mostrarFichero() {
      for(int var1 = 0; var1 < 10; ++var1) {
         String var2 = var1 == this.lineaActiva ? ">>> " : "    ";
         System.out.printf("%s%d: %s\n", var2, var1, this.fichero[var1]);
      }

   }

   public void definirLineaActiva() {
      System.out.print("Ingrese el número de línea (0-9): ");

      try {
         int var1 = Integer.parseInt(this.scanner.nextLine());
         if (var1 >= 0 && var1 < 10) {
            this.lineaActiva = var1;
            System.out.println("Línea activa establecida a: " + this.lineaActiva);
         } else {
            System.out.println("Número de línea inválido.");
         }
      } catch (NumberFormatException var2) {
         System.out.println("Ingrese un número válido.");
      }

   }

   public void editarLineaActiva() {
      System.out.print("Ingrese el contenido para la línea " + this.lineaActiva + ": ");
      this.fichero[this.lineaActiva] = this.scanner.nextLine();
      System.out.println("Línea actualizada.");
   }

   public void intercambiarLineas() {
      System.out.print("Ingrese el número de línea a intercambiar con la línea " + this.lineaActiva + " (0-9): ");

      try {
         int var1 = Integer.parseInt(this.scanner.nextLine());
         if (var1 >= 0 && var1 < 10) {
            String var2 = this.fichero[this.lineaActiva];
            this.fichero[this.lineaActiva] = this.fichero[var1];
            this.fichero[var1] = var2;
            System.out.println("Líneas intercambiadas.");
         } else {
            System.out.println("Número de línea inválido.");
         }
      } catch (NumberFormatException var3) {
         System.out.println("Ingrese un número válido.");
      }

   }

   public void borrarLineaActiva() {
      this.fichero[this.lineaActiva] = "";
      System.out.println("Contenido de la línea " + this.lineaActiva + " borrado.");
   }
}
