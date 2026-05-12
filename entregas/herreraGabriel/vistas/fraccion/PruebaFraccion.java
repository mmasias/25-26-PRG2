package vistas.fraccion;

public class PruebaFraccion {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion();
        f1.recoger();
        
        System.out.print("Tu fracción es: ");
        f1.mostrar();
        
        System.out.println("En decimal es: " + f1.aDecimal());
    }
}