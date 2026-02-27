package vistas;

class Fecha {
    public Fecha (int año, int mes, int dia){};
    public Fecha (){};
    public Fecha (Fecha fecha){};

    public void mostrar(){};
    public void editarFecha(int año, int mes, int dia){};
    public Fecha realizarOperacionArtimeticaConUnaFecha(Fecha fecha, String operacion){ return new Fecha();};    
    public boolean fechaEsMayor(Fecha fecha){return true;};
    public int numeroSemana(){return 0;};

}