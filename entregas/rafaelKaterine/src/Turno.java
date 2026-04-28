public class Turno {

    public void ejecutar(Caballo[] caballos, Pista pista) {
        for (Caballo caballo : caballos) {
            caballo.avanzar(pista.limite());
        }
    }
}