
package Locadora;

public class Locacao {
    private Veiculo veiculo;
    private Cliente cliente;
    private boolean ativa;
    private int quantidadeDias;
    private double valorTotal;
    
    public Locacao(Cliente cliente, Veiculo veiculo, int quantidadeDias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = calcularTotal();
        this.ativa = true;
    }
        //gets
    public Cliente getCliente() {
        return this.cliente;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public int getQuantidadeDias() {
        return this.quantidadeDias;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public boolean isAtiva() {
        return this.ativa;
    }
    //valor total da locacao atual do veiculo com cliente
    public double calcularTotal() {
        return this.veiculo.getvalorDiaria() * this.quantidadeDias;
    }
    
    // finaliza a locacao
    public void finalizarLocacao() {
        this.ativa = false;
    }
}
