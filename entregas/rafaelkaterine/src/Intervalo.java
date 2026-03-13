import java.util.Scanner;

class Intervalo{
     private double puntoMedio;
     private double longitud;


    private double getInferior() {
        return puntoMedio - longitud / 2;
    }
    private double getSuperior() {
        return puntoMedio + longitud / 2;
    }


    public Intervalo (double inferior, double superior) {
        assert inferior <= superior;
        this.longitud = superior - inferior;
        this.puntoMedio = inferior + this.longitud / 2;
    }
    public Intervalo (double superior) {
        this(0, superior);
    }
    public Intervalo () {
        this(0, 0);
    }  
    public Intervalo (Intervalo intervalo) {
        this.puntoMedio = intervalo.puntoMedio;
        this.longitud = intervalo.longitud;
    }


    public boolean incluye(double punto) {
        return this.getInferior() <= punto && this.getSuperior() >= punto;
    }
    public boolean incluye(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.getInferior()) && this.incluye(intervalo.getSuperior());
    }
    public boolean equals(Intervalo intervalo) {
        return this.puntoMedio == intervalo.puntoMedio && this.longitud == intervalo.longitud;
    }
    public void mostrar() {
        System.out.println("[" + this.getInferior() + ", " + this.getSuperior() + "]");
    }
    public void oponer() {
        this.puntoMedio = -this.puntoMedio;
    }
    public void doblar() {
        this.longitud *= 2;
    }
    public void desplazar(double desplazamiento) {
        this.puntoMedio = this.puntoMedio + desplazamiento;
    }
    public Intervalo desplazado(double desplazamiento) {
        Intervalo intervalo = this.clone();
        intervalo.desplazar(desplazamiento);
        return intervalo;
    }
    public Intervalo clone() {
        return new Intervalo(this);
    }
    public double longitud() {
        return this.longitud;
    }
    public double puntoMedio() {
        return this.puntoMedio;
    }
    public Intervalo[] trocear(int numeroTrozos) {
        Intervalo[] trozos = new Intervalo[numeroTrozos];
        double nuevaLongitud = this.longitud / numeroTrozos;
        double inicio = this.puntoMedio - this.longitud / 2;
        for (int i = 0; i < numeroTrozos; i++) {
            trozos[i] = new Intervalo(inicio + i * nuevaLongitud, inicio + (i + 1) * nuevaLongitud);
        }
        return trozos;

    }
    public Intervalo union(Intervalo intervalo) {
        assert intervalo != null;
        double nuevoInferior = Math.min(this.getInferior(), intervalo.getInferior());
        double nuevoSuperior = Math.max(this.getSuperior(), intervalo.getSuperior());
        return new Intervalo(nuevoInferior, nuevoSuperior);
    }
    public boolean intersecta(Intervalo intervalo) {
        assert intervalo != null;
        return this.getSuperior() >= intervalo.getInferior() && 
            intervalo.getSuperior() >= this.getInferior();
    }
    public Intervalo interseccion(Intervalo intervalo) {
        assert intervalo != null;
        
        if (!this.intersecta(intervalo)) {
            return null; 
        }
        double inferior = Math.max(this.getInferior(), intervalo.getInferior());
        double superior = Math.min(this.getSuperior(), intervalo.getSuperior());

        return new Intervalo(inferior, superior);
    }

    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE INTERVALOS CON PERSONAJES ---");

    
        Intervalo maria = new Intervalo(10, 30);
        Intervalo pepe = new Intervalo(15, 25);
        Intervalo pepito = new Intervalo(5); 
        Intervalo katerine = maria.clone();

        System.out.print("Intervalo Maria: "); maria.mostrar();
        System.out.print("Intervalo Pepe: "); pepe.mostrar();
        System.out.print("Intervalo Pepito: "); pepito.mostrar();
        System.out.print("Intervalo Katerine (clon de Maria): "); katerine.mostrar();

        System.out.println("\n--- PRUEBAS DE INCLUSIÓN Y POSICIÓN ---");
        
        System.out.println("¿Maria incluye a Pepe?: " + maria.incluye(pepe));
        System.out.println("¿Pepito intersecta con Maria?: " + pepito.intersecta(maria));

        System.out.println("\n--- TRANSFORMACIONES ---");

        System.out.print("Pepe original: "); pepe.mostrar();
        pepe.desplazar(10);
        System.out.print("Pepe tras desplazarse 10 unidades: "); pepe.mostrar();

        System.out.print("Maria original (longitud " + maria.longitud() + "): "); maria.mostrar();
        maria.doblar();
        System.out.print("Maria tras doblar su tamaño: "); maria.mostrar();

        System.out.println("\n--- OPERACIONES GRUPALES ---");

        Intervalo familiaUnida = pepe.union(pepito);
        System.out.print("Unión de Pepe y Pepito: "); familiaUnida.mostrar();

        Intervalo zonaComun = maria.interseccion(pepe);
        if (zonaComun != null) {
            System.out.print("Zona común entre Maria y Pepe: "); zonaComun.mostrar();
        } else {
            System.out.println("Maria y Pepe ya no tienen nada en común.");
        }

        System.out.println("¿Maria es igual a Katerine?: " + maria.equals(katerine));

        System.out.println("\n--- TROCEANDO A PEPITO ---");
        
        Intervalo[] hijosDePepito = pepito.trocear(2);
        for (int i = 0; i < hijosDePepito.length; i++) {
            System.out.print("Pepito Jr " + (i + 1) + ": ");
            hijosDePepito[i].mostrar();
        }
    }


}