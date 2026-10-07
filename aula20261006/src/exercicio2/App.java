package exercicio2;

public class App {
    public static void main(String[] args) {
        CalculadoraFrete c = new CalculadoraFrete(2, 500);
        
        System.out.println(c.calcular(500));
        System.out.println(c.calcular(501));
        System.out.println("---");
        
        System.out.println(c.calcular(500, true));
        System.out.println(c.calcular(500, false));
        System.out.println(c.calcular(501, true));
        System.out.println(c.calcular(501, false));
        System.out.println("---");
        
        System.out.println(c.calcular(500, "VIP15"));
        System.out.println(c.calcular(500, "VIP10"));
        System.out.println(c.calcular(501, "VIP15"));
        System.out.println(c.calcular(501, "VIP10"));
    }
}
