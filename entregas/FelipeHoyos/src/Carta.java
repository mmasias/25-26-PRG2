class Carta {

    private int palo;
    private int numero;

    public Carta(int palo, int numero) {
        assert palo >= 0 && palo <= 3;
        assert numero >= 1 && numero <= 13;

        this.palo = palo;
        this.numero = numero;
    }
    
    public int valorBlackJack() {
        if (numero > 10) {
        return 10;
     } 

        return numero;

    }


    public String toString() {
        return "[" +
                this.numeroComoTexto() +
                " " +
                this.paloComoTexto() +
                "]"
    }


    private string numeroComoTexto() {
        switch (numero) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            
        }

        return "" + numero;

    }

    


}
