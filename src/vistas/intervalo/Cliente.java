package vistas.intervalo;

public class Cliente {
    public static void main(String[] args) {
        Console console = new Console();

        console.writeln("> Constructores");
        Intervalo intervalo = new Intervalo(5, 10);
        intervalo.mostrar();
        new Intervalo(7).mostrar();
        new Intervalo().mostrar();
        new Intervalo(intervalo).mostrar();
        intervalo.clone().mostrar();

        console.writeln("> Longitud / puntoMedio");
        console.writeln("longitud [5,10] = " + intervalo.longitud());
        console.writeln("puntoMedio [5,10] = " + intervalo.puntoMedio());
        Intervalo degenerado = new Intervalo(3, 3);
        console.writeln("longitud [3,3] = " + degenerado.longitud());
        console.writeln("puntoMedio [3,3] = " + degenerado.puntoMedio());

        console.writeln("> Desplazar");
        Intervalo desplazable = new Intervalo(5, 10);
        desplazable.desplazar(3);
        desplazable.mostrar();
        console.writeln("longitud tras desplazar = " + desplazable.longitud());

        desplazable.desplazar(-20);
        desplazable.mostrar();
        console.writeln("longitud tras desplazar negativo = " + desplazable.longitud());

        Intervalo original = new Intervalo(0, 4);
        Intervalo copia = original.desplazado(10);
        original.mostrar();
        copia.mostrar();

        console.writeln("> Oponer");
        Intervalo oponible = new Intervalo(2, 8);
        oponible.oponer();
        oponible.mostrar();
        console.writeln("longitud tras oponer = " + oponible.longitud());

        Intervalo negativo = new Intervalo(-5, -1);
        negativo.oponer();
        negativo.mostrar();

        Intervalo simetrico = new Intervalo(-3, 3);
        simetrico.oponer();
        simetrico.mostrar();

        console.writeln("> Doblar");
        Intervalo doblable = new Intervalo(4, 6);
        doblable.doblar();
        doblable.mostrar();
        console.writeln("longitud tras doblar = " + doblable.longitud());
        console.writeln("puntoMedio tras doblar = " + doblable.puntoMedio());

        console.writeln("> Incluye punto");
        Intervalo base = new Intervalo(0, 10);
        console.writeln("[0,10] incluye 5: " + base.incluye(5));
        console.writeln("[0,10] incluye 0: " + base.incluye(0));
        console.writeln("[0,10] incluye 10: " + base.incluye(10));
        console.writeln("[0,10] incluye -1: " + base.incluye(-1));
        console.writeln("[0,10] incluye 10.01: " + base.incluye(10.01));

        console.writeln("> Incluye intervalo");
        console.writeln("[0,10] incluye [2,8]: " + base.incluye(new Intervalo(2, 8)));
        console.writeln("[0,10] incluye [0,10]: " + base.incluye(new Intervalo(0, 10)));
        console.writeln("[0,10] incluye [5,15]: " + base.incluye(new Intervalo(5, 15)));

        console.writeln("> Equals");
        console.writeln("[0,10] equals [0,10]: " + base.equals(new Intervalo(0, 10)));
        console.writeln("[0,10] equals [0,9]: " + base.equals(new Intervalo(0, 9)));

        console.writeln("> Intersecta / Interseccion");
        Intervalo a = new Intervalo(0, 10);
        Intervalo b = new Intervalo(5, 15);
        Intervalo c = new Intervalo(3, 7);
        Intervalo d = new Intervalo(20, 25);

        console.writeln("[0,10] intersecta [5,15]: " + a.intersecta(b));
        console.writeln("[0,10] intersecta [3,7]: " + a.intersecta(c));
        console.writeln("[0,10] intersecta [20,25]: " + a.intersecta(d));

        console.write("[0,10] ∩ [5,15] = ");
        a.interseccion(b).mostrar();

        console.write("[0,10] ∩ [3,7] = ");
        a.interseccion(c).mostrar();

        console.write("[5,15] ∩ [0,10] = ");
        b.interseccion(a).mostrar();

        console.writeln("> Union");
        console.write("[0,10] ∪ [5,15] = ");
        a.union(b).mostrar();

        console.write("[5,15] ∪ [0,10] = ");
        b.union(a).mostrar();

        console.write("[0,10] ∪ [3,7] = ");
        a.union(c).mostrar();

        console.write("[3,7] ∪ [0,10] = ");
        c.union(a).mostrar();

        Intervalo e = new Intervalo(8, 12);
        console.write("[5,15] ∪ [8,12] = ");
        b.union(e).mostrar();

        console.writeln("> Trocear");
        Intervalo troceado = new Intervalo(0, 12);
        Intervalo[] trozos = troceado.trocear(3);
        for (int i = 0; i < trozos.length; i++) {
            console.write("  trozo " + i + ": ");
            trozos[i].mostrar();
        }

        trozos = troceado.trocear(4);
        for (int i = 0; i < trozos.length; i++) {
            console.write("  trozo " + i + ": ");
            trozos[i].mostrar();
        }

        console.writeln("> Combinaciones");
        Intervalo combo = new Intervalo(0, 10);
        combo.doblar();
        combo.mostrar();
        combo.oponer();
        combo.mostrar();
        combo.desplazar(15);
        combo.mostrar();
        console.writeln("longitud final = " + combo.longitud());

        console.writeln("> Recoger");
        Intervalo recogido = new Intervalo();
        recogido.recoger();
        recogido.mostrar();
        console.writeln("longitud = " + recogido.longitud());
        console.writeln("puntoMedio = " + recogido.puntoMedio());
    }
}