package exercicio1;

public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        }
    }
}
