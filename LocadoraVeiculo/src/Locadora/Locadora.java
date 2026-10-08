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

    //cadastra locacoes
    public void cadastrarLocacao(Locacao locacao) {
        this.locacoes.add(locacao);
    }
}
