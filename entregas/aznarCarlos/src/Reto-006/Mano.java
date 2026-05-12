public class Mano {
    private Carta[] mano = new Carta[12];
    private int numCartas = 0;
    public int calcularTotal(){
int total = 0;
       boolean hayAs = false;
        for (int i = 0; i < numCartas; i++) {
            total += mano[i].getValor();
            if (mano[i].getValor() == 1) {
                hayAs = true;
            }
        }
        if (hayAs && total <= 11) {
            total += 10;
        }
        return total;
    }
    public String toString(){
        return this.toString(false,false);
    }
    public String toString(boolean esCrupier,boolean ocultarCartaOculta){
        String texto = "";
        int total = 0;
        boolean hayAs = false;
        string textoAs = "";
        for(int i=0;i<numCartas;i++){
            if(esCrupier && ocultarCartaOculta && i==0){
                texto = "mostrando";
            }else{
                int valor = mano[i].getValor();
                String nombreValor;
                if (valor >10){
                    nombreValor = mano[i].getNombreValor().substring(0,1);
                }else if (valor == 1){
                    nombreValor = "A";
            }else{
                nombreValor = Integer.toString(valor);
            }
        texto += nombreValor + " de " + mano[i].getPalo() + "\n";
        if (valor > 10){
            valor += 10;
    }else if (valor == 1){
        hayAs = true;
       
    }
        total += valor;
    }
        }
        if (hayA && total +10<=21){
            textoAS= "o"+ (total+10);
        }
        if (ocultarCartaOculta){
           retiurn texto;
        }else{
            return texto + "Total: " + total + textoAs;
        }
    }
    public void agregarCarta(Carta carta){
        mano[numCartas] = carta;
    }
    public void limpiarMano(){
        numCartas = 0;
    }
    public boolean revisarCartaCrupier(){
        int valor= mano[1].getValor();
        return valor == 1 || valor >= 10;
    }
}
