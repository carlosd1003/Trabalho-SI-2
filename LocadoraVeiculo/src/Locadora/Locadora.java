package Locadora;

import java.util.ArrayList;

public class Locadora {

    // atributos
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private ArrayList<Cliente> clientes;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Locacao> locacoes;
    private double ultimaMulta;

    // construtor
    public Locadora(String nome, String cnpj, String endereco, String telefone) {

        // construtor
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.clientes = new ArrayList<Cliente>();
        this.veiculos = new ArrayList<Veiculo>();
        this.locacoes = new ArrayList<Locacao>();
    }

    // getters
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

    // cadastra cliente
    public void cadastrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    // Verifica se o CPF tem exatamente 11 números
    public boolean verificarTamanhoCpf(String cpf) {
        return cpf.matches("[0-9]{11}");
    }
    
    // verifica se o cpf do cliente ja está cadastrado
    public boolean verificarCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    // verifica se a cnh do cliente ja está cadastrada
    public boolean verificarCnh(String cnh) {
        for (Cliente cliente : clientes) {
            if (cliente.getCnh().equals(cnh)) {
                return true;
            }
        }
        return false;
    }

    // lista clientes
    public ArrayList<Cliente> listarClientes() {
        return this.clientes;
    }

    // cadastra carro
    public void cadastrarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    // lista carros
    public ArrayList<Veiculo> listarVeiculos() {
        return this.veiculos;
    }

    // lista locacoes
    public ArrayList<Locacao> listarLocacoes() {
        return this.locacoes;
    }

    // cadastra locacoes
    public void cadastrarLocacao(Locacao locacao) {
        if (locacao.getVeiculo().getdisponivel()) {
            this.locacoes.add(locacao);

            locacao.getVeiculo().setDisponivel(false);
        }
    }

    // busca de cliente por cpf
    public Cliente buscarCliente(String cpf) {

        for (int i = 0; i < this.clientes.size(); i++) {

            Cliente cliente = this.clientes.get(i);

            if (cliente.getCpf().equals(cpf)) { //compara o cpf digitado com o da lista
                return cliente;
            }
        }

        return null;
    }

    // busca de veiculo pela placa
    public Veiculo buscarVeiculo(String placa) {
        for (int i = 0; i < this.veiculos.size(); i++) {
            Veiculo veiculo = this.veiculos.get(i);

            if (veiculo.getplaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    // permite devolver o veiculo para ficar disponivel novamente
    public boolean devolverVeiculo(String placa, int diasReais) {

        for (int i = 0; i < this.locacoes.size(); i++) {

            Locacao locacao = this.locacoes.get(i);

            if (locacao.getVeiculo().getplaca().equalsIgnoreCase(placa)
                    && locacao.seAtiva()) {

                ultimaMulta = calcularMulta(locacao, diasReais);

                locacao.finalizarLocacao();
                locacao.getVeiculo().setDisponivel(true);

                return true;
            }
        }

        return false;
    }

    public double getUltimaMulta() {
        return ultimaMulta;
    }

    // verifica se a placa do veiculo ja está cadastrada
    public boolean verificarPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getplaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    // calcula uma multa de 20% caso o cliente devolva o veiculo atrasado
    public double calcularMulta(Locacao locacao, int diasReais) {
        int diasAtraso = diasReais - locacao.getQuantidadeDias();
        if (diasAtraso > 0) {
            //cobra os dias de atraso multiplicados por 20%
            return diasAtraso * (locacao.getVeiculo().getvalorDiaria() * 1.2);
        }
        return 0;
    }

    public boolean removerCliente(String cpf) {

        for (int i = 0; i < this.clientes.size(); i++) {

            Cliente cliente = this.clientes.get(i);

            if (cliente.getCpf().equals(cpf)) { //compara o cpf digitado com o da lista
                this.clientes.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean removerCarro(String placa) {

        for (int i = 0; i < this.veiculos.size(); i++) {

            Veiculo veiculo = this.veiculos.get(i);

            if (veiculo.getplaca().equalsIgnoreCase(placa)) {

                // Verifica se o veículo está disponível
                if (!veiculo.getdisponivel()) {
                    return false;
                }

                this.veiculos.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean removerLocacao(String placa) {

        for (int i = 0; i < this.locacoes.size(); i++) {

            Locacao locacao = this.locacoes.get(i);

            if (locacao.getVeiculo().getplaca().equalsIgnoreCase(placa)) {

                // Verifica se a locação está ativa
                if (locacao.seAtiva()) {
                    
                    return false;
                }

                // Remove somente se a locação estiver finalizada
                this.locacoes.remove(i);
                return true;
            }
        }

        System.out.println("Locação não encontrada!");
        return false;
    }

}
