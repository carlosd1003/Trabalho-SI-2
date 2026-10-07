
package Locadora;

public class App {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Carlos", "111.222.333-44", "123456789-00", 18);
        
        System.out.println(c1.getNome());
        System.out.println(c1.getCnh());
        System.out.println(c1.getCpf());
        System.out.println(c1.getIdade());
        
    }
}
