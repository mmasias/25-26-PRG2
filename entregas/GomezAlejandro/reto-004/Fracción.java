package gomezAlejandro;

public class Fraccion {

    private int num;
    private int den;

    private int mcd(int a, int b) {
        while (b != 0) {
            int aux = b;
            b = a % b;
            a = aux;
        }
        return a;
    }

    public Fraccion(int n, int d) {
        assert d != 0;
        this.num = n;
        this.den = d;
        reducir();
    }

    public Fraccion(int n) {
        this(n, 1);
    }

    public Fraccion(Fraccion f) {
        this(f.num, f.den);
    }

    public Fraccion copia() {
        return new Fraccion(this);
    }

    public void sumar(Fraccion f) {
        num = num * f.den + f.num * den;
        den = den * f.den;
        reducir();
    }

    public void restar(Fraccion f) {
        num = num * f.den - f.num * den;
        den = den * f.den;
        reducir();
    }

    public void multiplicar(Fraccion f) {
        num *= f.num;
        den *= f.den;
        reducir();
    }

    public void dividir(Fraccion f) {
        assert f.num != 0;
        num *= f.den;
        den *= f.num;
        reducir();
    }

    public boolean esMayor(Fraccion f) {
        return num * f.den > f.num * den;
    }

    public boolean esMenor(Fraccion f) {
        return num * f.den < f.num * den;
    }

    public boolean esIgual(Fraccion f) {
        return num * f.den == den * f.num;
    }

    public void mostrar() {
        if (den == 1) {
            System.out.println(num);
        } else {
            System.out.println(num + "/" + den);
        }
    }

    public void invertir() {
        assert num != 0;
        int aux = num;
        num = den;
        den = aux;
    }

    public void cambiarSigno() {
        num = -num;
    }

    public void reducir() {
        int divisor = mcd(Math.abs(num), Math.abs(den));
        num /= divisor;
        den /= divisor;

        if (den < 0) {
            num *= -1;
            den *= -1;
        }
    }
}
