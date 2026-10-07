package exercicio1;

public class App {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Fulano", 2000);
        Funcionario f2 = new Funcionario("Ciclano", 3000);
        Funcionario f3 = new Funcionario("Teste", 1800);
        
        Departamento d = new Departamento("Laboratório");
        
        d.adicionarFuncionario(f1);
        d.adicionarFuncionario(f3);
        
        d.listarFuncionarios();
        System.out.println(d.calcularFolhaPagamento());
                
        d.adicionarFuncionario(f2);
        d.listarFuncionarios();
        System.out.println(d.calcularFolhaPagamento());
    }
}
