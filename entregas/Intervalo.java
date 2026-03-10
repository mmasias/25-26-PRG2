public class Intervalo {

    public Intervalo (double puntoMedio, double longitud)
    public Intervalo (double longitud)
    public Intervalo ()
    public Intervalo (Intervalo intervalo)

    public Intervalo clone()

    public double longitud()

    public double puntoMedio()

    public void desplazar (double desplazamiento)

    public Intervalo desplazado(double desplazamiento)

    public boolean incluye(double punto)

    public boolean incluye(Intervalo intervalo)

    public boolean equals(Intervalo intervalo)

    public Intervalo interseccion(Intervalo intervalo)

    public boolean intersecta(Intervalo intervalo)

    public void oponer()

    public void doblar()

    public void mostrar()

    public void recoger()

}