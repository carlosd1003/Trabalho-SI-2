package Locadora;

import java.util.Scanner;
import java.util.ArrayList;

public class Locadora {

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private ArrayList<Cliente> clientes;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Locacao> locacoes;

    public Locadora(String nome, String cnpj, String endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.clientes = new ArrayList<Cliente>();
        this.veiculos = new ArrayList<Veiculo>();
        this.locacoes = new ArrayList<Locacao>();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    //cadastra cliente
    public void cadastrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    //listar clientes
    public ArrayList<Cliente> listarClientes() {
        return this.clientes;
    }

    //cadastra carro
    public void cadastrarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    // listar carros
    public ArrayList<Veiculo> listarVeiculos() {
        return this.veiculos;
    }

    // listar locacoes
    public ArrayList<Locacao> listarLocacoes() {
        return this.locacoes;
    }

    //cadastra locacoes
    public void cadastrarLocacao(Locacao locacao) {
        if (locacao.getVeiculo().getdisponivel()) {
            this.locacoes.add(locacao);

            locacao.getVeiculo().setDisponivel(false);
        }
    }

    //busca de cliente por cpf
    public Cliente buscarCliente(String cpf) {

        for (int i = 0; i < this.clientes.size(); i++) {

            Cliente cliente = this.clientes.get(i);

            if (cliente.getCpf().equals(cpf)) { //compara o cpf digitado com o da lista
                return cliente;
            }
        }

        return null;
    }

    //busca veiculo pela placa
    public Veiculo buscarVeiculo(String placa) {
        for (int i = 0; i < this.veiculos.size(); i++) {
            Veiculo veiculo = this.veiculos.get(i);

            if (veiculo.getplaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public boolean devolverVeiculo(String placa) {

        for (int i = 0; i < this.locacoes.size(); i++) {

            Locacao locacao = this.locacoes.get(i);

            if (locacao.getVeiculo().getplaca().equalsIgnoreCase(placa)
                    && locacao.isAtiva()) {

                locacao.finalizarLocacao();

                locacao.getVeiculo().setDisponivel(true);

                return true;
            }
        }

        return false;
    }
}
