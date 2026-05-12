public class Carta{
    private char palo;
    private intq valor;

private carta(){
    this.palo = ' ';
    this.valor = 0;
}
public carta(char nuevoPalo,int nuevoValor){
if(nuevoValor < 1 || nuevoValor > 13){
    throw new IllegalArgumentException("Valor de carta no válido. Debe estar entre 1 y 13.");
}else{
    this.valor = nuevoValor;
}
if(nuevoPalo != 'C' && nuevoPalo != 'D' && nuevoPalo != 'T' && nuevoPalo != 'P'){
    throw new IllegalArgumentException("Palo de carta no válido. Debe ser 'C', 'D', 'T' o 'P'.");
}else{
    this.palo = nuevoPalo;
}
}
public String toString(){
    return NombrePalo() + " " + this.valor;
}
public String NombrePalo(){
    switch(this.palo){
        case 'C':
            return "Corazones";
        case 'D':
            return "Diamantes";
        case 'T':
            return "Tréboles";
        case 'P':
            return "Picas";
        default:
            return "Palo desconocido";
    }

}
public char identificarPalo(){
    return this.palo;
}
public String obtenerNombreValor(){
    String nombre = "Desconocido";

		if (this.valor == 1) {
			nombre = "As";
		}
		else if (this.valor == 2) {
			nombre = "Dos";
		}
		else if (this.valor == 3) {
			nombre = "Tres";
		}
		else if (this.valor == 4) {
			nombre = "Cuatro";
		}
		else if (this.valor == 5) {
			nombre = "Cinco";
		}
		else if (this.valor == 6) {
			nombre = "Seis";
		}
		else if (this.valor == 7) {
			nombre = "Siete";
		}
		else if (this.valor == 8) {
			nombre = "Ocho";
		}
		else if (this.valor == 9) {
			nombre = "Nueve";
		}
		else if (this.valor == 10) {
			nombre = "Diez";
		}
		else if (this.valor == 11) {
			nombre = "Jota";
		}
		else if (this.valor == 12) {
			nombre = "Reina";
		}
		else if (this.valor == 13) {
			nombre = "Rey";
		}

		return nombre;
	}
public int obtenerValorNumerico(){
    return this.valor;
}
public boolena compararPalo(Carta carta){
    return this.palo == carta.identificarPalo();
}
public boolena compararValor(Carta carta){
    return this.valor == carta.obtenerValorNumerico();
}
public boleana compararCarta(Carta carta){
    return this.compararPalo(carta) && this.compararValor(carta);
}
}