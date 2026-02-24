class Intervalo {
    double inicioIntervalo;
    double finIntervalo;
    double[] intervalo;

    public Intervalo (double inicio, double fin)
    {
        this.inicioIntervalo = inicio;
        this.finIntervalo = fin;
        this.construirIntervalo(inicio, fin);
    };

    public Intervalo (double fin){
        this.finIntervalo = fin;
        this.inicioIntervalo = 0.0;
        this.construirIntervalo(inicioIntervalo, fin);
    };

    private void construirIntervalo(double inicio, double fin)
    {
        for(int i = 0; i == fin; i++ ){
            this.intervalo[i] = inicio + i;
        }
    }
}