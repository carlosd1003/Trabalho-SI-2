package Locadora;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Locadora locadora = new Locadora("Nome da Locadora", "12.345.678/0001-90", "Endereço da Locadora", "(11) 1234-5678");
        int escolha;
        do {
            System.out.println("Qual opcao voce deseja? ");
            System.out.println("1 - Cadastrar um Cliente ");
            System.out.println("2 - Cadastrar um Veiculo");
            System.out.println("3 - Fazer uma Locacao");
            System.out.println("4 - Listar Cliente");
            System.out.println("5 - Listar Veiculo");
            System.out.println("6 - Listar Locacao");
            System.out.println("7 - Devolver Veiculo");
            System.out.println("0 - Para Sair");

            System.out.print("Número da opção: ");
            escolha = scan.nextInt();

            switch (escolha) {
                case 1: {
                    System.out.print("Nome do Cliente: ");
                    String nome = scan.next();

                    System.out.print("Cpf do Cliente: ");
                    String cpf = scan.next();

                    System.out.print("Cnh do Cliente: ");
                    String cnh = scan.next();

                    System.out.print("Idade do Cliente: ");
                    int idade = scan.nextInt();

                    Cliente cliente = new Cliente(nome, cpf, cnh, idade);//Pega os dados digitados e cria um cliente
                    locadora.cadastrarCliente(cliente); //Pega o cliente cadastrado e guarda na lista criada

                    System.out.println("Cliente cadastrado com sucesso!");
                    System.out.println("Informacoes do cliente abaixo");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Cpf: " + cliente.getCpf());
                    System.out.println("Cnh: " + cliente.getCnh());
                    System.out.println("Idade: " + cliente.getIdade());
                    break;
                }
                case 2: {
                    // Pede para o usuário digitar o modelo do veículo
                    System.out.print("Nome do modelo: ");
                    String modelo = scan.next();

                    // Pede a marca do veículo
                    System.out.print("Nome da marca: ");
                    String marca = scan.next();

                    // Pede a placa do veículo
                    System.out.print("Número da placa: ");
                    String placa = scan.next();

                    // Pede o ano de fabricação do veículo
                    System.out.print("Ano do veiculo: ");
                    int ano = scan.nextInt();

                    // Pede o valor que será cobrado por dia de aluguel
                    System.out.print("Valor da diaria: ");
                    double valorDiaria = scan.nextDouble();

                    // Todo veículo cadastrado começa disponível para aluguel
                    boolean disponivel = true;

                    // Cria um objeto Veiculo com os dados digitados
                    Veiculo carro = new Veiculo(modelo, marca, placa, ano, valorDiaria, disponivel);

                    // Adiciona o veículo cadastrado na lista de veículos
                    locadora.cadastrarVeiculo(carro);

                    // Mostra uma mensagem confirmando o cadastro
                    System.out.println("Veiculo cadastrado com sucesso!");

                    // Mostra os dados do veículo usando os métodos getters
                    System.out.println("Modelo: " + carro.getmodelo());
                    System.out.println("Marca: " + carro.getmarca());
                    System.out.println("Placa: " + carro.getplaca());
                    System.out.println("Ano: " + carro.getano());
                    System.out.println("Valor da diaria: R$ " + carro.getvalorDiaria());
                    System.out.println("Disponivel: " + carro.getdisponivel());

                    // Encerra o case 2 e volta para o menu
                    break;
                }
                case 3: {
                    Cliente cliente;
                    Veiculo veiculo;

                    // procurar cliente até encontrar
                    do {
                        System.out.print("Qual o CPF do cliente: ");
                        String cpf = scan.next();

                        cliente = locadora.buscarCliente(cpf);

                        if (cliente == null) {
                            System.out.println("Cliente nao encontrado! Tente novamente.");
                        }

                    } while (cliente == null);

                    // procurar veiculo até encontrar
                    do {
                        System.out.print("Qual a placa do veiculo: ");
                        String placa = scan.next();

                        veiculo = locadora.buscarVeiculo(placa);

                        if (veiculo == null) {
                            System.out.println("Veiculo nao existe! Tente novamente.");
                        } else if (!veiculo.getdisponivel()) {
                            System.out.println("Veiculo indisponivel! Escolha outro.");
                        }

                    } while (veiculo == null || !veiculo.getdisponivel());

                    // verificar quantidade de dias
                    int dias;

                    do {
                        System.out.print("Quantidade de dias: ");
                        dias = scan.nextInt();

                        if (dias <= 0) {
                            System.out.println("Quantidade de dias invalida!");
                        }

                    } while (dias <= 0);

                    // criar locacao
                    Locacao locacao = new Locacao(cliente, veiculo, dias);

                    locadora.cadastrarLocacao(locacao);

                    System.out.println("Locacao cadastrada!");
                    System.out.println("Cliente: " + locacao.getCliente().getNome());
                    System.out.println("Veiculo: " + locacao.getVeiculo().getmodelo());
                    System.out.println("Valor total: R$ " + locacao.getValorTotal());

                    break;
                }

                case 4: {
                    for (int i = 0; i < locadora.listarClientes().size(); i++) {
                        Cliente cliente = locadora.listarClientes().get(i);
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("CPF: " + cliente.getCpf());
                        System.out.println("------------------");
                    }
                    break;
                }

                case 5: {
                    for (int i = 0; i < locadora.listarVeiculos().size(); i++) {
                        Veiculo veiculo = locadora.listarVeiculos().get(i);
                        System.out.println("Modelo: " + veiculo.getmodelo());
                        System.out.println("Placa: " + veiculo.getplaca());
                        System.out.println("------------------");
                    }
                    break;
                }
                case 6: {
                    if (locadora.listarLocacoes().isEmpty()) {
                        System.out.println("Nenhuma locacao cadastrada!");
                        break;
                    }

                    for (int i = 0; i < locadora.listarLocacoes().size(); i++) {
                        Locacao locacao = locadora.listarLocacoes().get(i);

                        System.out.println("Locacao numero: " + (i + 1));
                        System.out.println("Cliente: " + locacao.getCliente().getNome());
                        System.out.println("CPF: " + locacao.getCliente().getCpf());
                        System.out.println("Veiculo: " + locacao.getVeiculo().getmodelo());
                        System.out.println("Placa: " + locacao.getVeiculo().getplaca());
                        System.out.println("Quantidade de dias: " + locacao.getQuantidadeDias());
                        System.out.println("Valor total: R$ " + locacao.getValorTotal());
                        System.out.println("Ativa: " + locacao.isAtiva());
                        System.out.println("------------------");
                    }

                    break;
                }
                case 7: {
                    System.out.print("Digite a placa do veiculo: ");
                    String placa = scan.next();

                    boolean devolvido = locadora.devolverVeiculo(placa);

                    if (devolvido) {
                        System.out.println("Veiculo devolvido com sucesso!");
                        System.out.println("Veiculo disponivel para aluguel!");
                    } else {
                        System.out.println("Nenhuma locacao ativa encontrada para essa placa!");
                    }

                    break;
                }

            }

        } while (escolha != 0);
        scan.close();
    }
}
