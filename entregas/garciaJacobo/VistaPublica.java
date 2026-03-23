class Fecha {

    public Fecha();

    public Fecha(int dia, int mes, int anio);

    public Fecha(int dia, int mes);

    public Fecha(int anio);

    public Fecha(String fechaTexto);

    public boolean estasEnAñoBisiesto();

    public int diasDelMes();

    public boolean fechaValida();

    public void sumarDias(int dias);

    public void restarDias(int dias);

    public int compararCon(Fecha otraFecha);

    public int diasEntre(Fecha otraFecha);

    public boolean esAnteriorA(Fecha otraFecha);

    public boolean esPosteriorA(Fecha otraFecha);

    public void mostrarFecha();

    public void nuevaFecha();

    public void editarFecha(int dias, int meses, int anio);

}

