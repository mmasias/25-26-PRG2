class Main {
    public static void main(String[] args) {
        Fraccion fraccion = new Fraccion(1,2);
        Fraccion fraccionOtra = new Fraccion(4,7);
        fraccion.sumar(fraccionOtra);
        fraccion.mostrar();
        fraccion.equals(fraccionOtra);
        fraccion.dividir(fraccionOtra);
        fraccion.mostrar();
        System.out.println(fraccion.aDecimal());
        fraccion.restar(fraccionOtra);
        fraccion.mostrar();
    }
}
