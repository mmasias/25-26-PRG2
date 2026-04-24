public class Carrera {
  public void jugar() {
      Console console = new Console();
      Caballos caballo1 = new Caballos(console);
      Caballos caballo2 = new Caballos(console);
      Pista pista = new Pista();
    
      do {
        pista.mostrar();
        caballo1.movimientoCaballo();
        caballo2.movimientoCaballo();
        console.pause(1);
        console.cleanScreen();

      } while (!caballo1.haTerminado() && !caballo2.haTerminado());


    
  }



}
