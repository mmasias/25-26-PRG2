package publica;

public class Cliente {
    public Fraccion(double numerador, double denominador);
    public Fraccion(double racional);

    public Fraccion(Fraccion fraccion);

    public Fraccion clonar();
    public Fraccion mostrar();

    public Fraccion dividir(Fraccion fraccion);
    public Fraccion multiplicar(Fraccion fraccion);
    public Fraccion multiplicar(double numero)
    public Fraccion sumar(Fraccion fraccion);
    public Fraccion restart(Fraccion fraccion);

    public void invertir();
    public void oponer();
}
