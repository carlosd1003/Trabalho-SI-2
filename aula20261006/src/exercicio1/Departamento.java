package exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nomeSetor;
    private List<Funcionario> funcionarios;

    public Departamento(String nomeSetor) {
        this.nomeSetor = nomeSetor;
        this.funcionarios = new ArrayList<>();
    }
    
    public void adicionarFuncionario(Funcionario f) {
        this.funcionarios.add(f);
    }
    
    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
    }
    
    public double calcularFolhaPagamento() {
        double total = 0;
        // percorrer a lista de funcionario, somando todos os salarios
        for (Funcionario f : this.funcionarios) {
            total += f.getSalario();
        }
        return total;
    }
}
