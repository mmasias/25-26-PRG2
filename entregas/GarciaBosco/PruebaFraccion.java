public class PruebaFraccion {
public static void main(String[] args) {
    Fraccion f1=new Fraccion();
    Fraccion f2=new Fraccion(1,2);
   // Fraccion f3=new Fraccion(1,0);
    Fraccion f4=new Fraccion(7);
    Fraccion f5=new Fraccion(-2,7);
    Fraccion f6=new Fraccion(2,3);
    Fraccion f7=new Fraccion(4,3);
    Fraccion f8=new Fraccion(2,4);
    Fraccion f9=new Fraccion(6,8);
    

    System.out.println(f1.toString());
    System.out.println(f2.toString());
   // System.out.println(f3.toString());
   System.out.println(f4.toString());
   System.out.println(f5.toString());

   System.out.println(f5.opuesta());
   System.out.println(f5.inversa());
   System.out.println(f2.sumar(f5));
   System.out.println(f6.sumar(f7));
   System.out.println(f8.sumar(f9));
   System.out.println(f9.restar(f8));
   System.out.println(f7.restar(f8));

    
    Fraccion f10=f2.clone();
    System.out.println(f10.toString());
   
    System.out.println(f2.multiplicar(f6));
    System.out.println(f2.dividir(f6));
    System.out.println(f5.decimal());
}
}
