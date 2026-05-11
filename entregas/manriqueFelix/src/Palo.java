public enum Palo {
    CORAZONES("♥"), DIAMANTES("♦"), TREBOLES("♣"), PICAS("♠");
    
    public final String simbolo;
    
    Palo(String simbolo) { 
        this.simbolo = simbolo; 
    }
}