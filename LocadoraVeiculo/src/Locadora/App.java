package Locadora;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scan = new Scanner(System.in);

        // Cria um objeto Locadora
        Locadora locadora = new Locadora("Nome da Locadora", "12.345.678/0001-90", "Endereço da Locadora", "(11) 1234-5678");
        int escolha;

        // Loop para exibir o menu
        do {

            // Menu de opções
            System.out.println("==============================================");
            System.out.println("Qual opção você deseja? ");
            System.out.println("1 - Cadastrar um Cliente ");
            System.out.println("2 - Cadastrar um Veiculo");
            System.out.println("3 - Fazer uma Locação");
            System.out.println("4 - Listar Cliente");
            System.out.println("5 - Listar Veículo");
            System.out.println("6 - Listar Locação");
            System.out.println("7 - Devolver Veículo");
            System.out.println("8 - Remover um Cliente do Sistema");
            System.out.println("9 - Remover um Carro do Sistema");
            System.out.println("10 - Remover uma Locação");
            System.out.println("11 - Buscar Veículo por Placa");
            System.out.println("12 - Buscar Cliente por CPF");
            System.out.println("0 - Para Sair");
            System.out.println("==============================================");

            // Pede para o usuário digitar a opção desejada
            System.out.print("Número da opção: ");
            escolha = scan.nextInt();

            // Verifica se a opção digitada é válida
            switch (escolha) {
                // Cadastra um cliente
                case 1: {
                    // Pede para o usuário digitar o nome do cliente                 
                    System.out.print("Nome do Cliente: ");
                    String nome = scan.next();

                    System.out.print("Cpf do Cliente: ");
                    String cpf = scan.next();

                    // Verifica se o cpf do cliente ja está cadastrado
                    if (locadora.verificarCpf(cpf)) {
                        System.out.println("Este CPF já está criado!");
                        break;
                    }

                    // Pede para o usuário digitar a CNH do cliente
                    System.out.print("Cnh do Cliente: ");
                    String cnh = scan.next();

                    // Verifica se a cnh do cliente ja está cadastrada
                    if (locadora.verificarCnh(cnh)) {
                        System.out.println("Esta CNH já está criada!");
                        break;
                    }

                    // Pede para o usuário digitar a idade do cliente
                    System.out.print("Idade do Cliente: ");
                    int idade = scan.nextInt();

                    // Pega os dados digitados e cria um cliente
                    Cliente cliente = new Cliente(nome, cpf, cnh, idade);

                    // Pega o cliente cadastrado e guarda na lista criada na classe locadora
                    locadora.cadastrarCliente(cliente);

                    // Mostra uma mensagem de sucesso e os dados do cliente cadastrado
                    System.out.println("==============================================");
                    System.out.println("Cliente cadastrado com sucesso!");
                    System.out.println("Informações do cliente abaixo");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Cpf: " + cliente.getCpf());
                    System.out.println("Cnh: " + cliente.getCnh());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("==============================================");
                    break;
                }
                // Cadastra um veículo
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

                    // Verifica se a placa do veiculo ja está cadastrada
                    if (locadora.verificarPlaca(placa)) {
                        System.out.println("Esta placa já está criado!");

                        // Encerra o case 2 e volta para o menu
                        break;
                    }

                    // Pede o ano de fabricação do veículo
                    System.out.print("Ano do veiculo: ");
                    int ano = scan.nextInt();

                    // Pede o valor que será cobrado por dia de aluguel
                    System.out.print("Valor da diária: R$");
                    double valorDiaria = scan.nextDouble();

                    // Todo veículo cadastrado começa disponível para aluguel
                    boolean disponivel = true;

                    // Cria um objeto Veiculo com os dados digitados
                    Veiculo carro = new Veiculo(modelo, marca, placa, ano, valorDiaria, disponivel);

                    // Adiciona o veículo cadastrado na lista de veículos
                    locadora.cadastrarVeiculo(carro);

                    // Mostra uma mensagem confirmando o cadastro
                    System.out.println("Veículo cadastrado com sucesso!");

                    // Mostra os dados do veículo usando os métodos getters
                    System.out.println("==============================================");
                    System.out.println("Modelo: " + carro.getmodelo());
                    System.out.println("Marca: " + carro.getmarca());
                    System.out.println("Placa: " + carro.getplaca());
                    System.out.println("Ano: " + carro.getano());
                    System.out.println("Valor da diaria: R$" + carro.getvalorDiaria());
                    System.out.println("Disponível: " + carro.getdisponivel());
                    System.out.println("==============================================");

                    // Encerra o case 2 e volta para o menu
                    break;
                }
                // Fazer uma locação
                case 3: {
                    Cliente cliente;
                    Veiculo veiculo = null;

                    // Procurar cliente até encontrar
                    do {
                        System.out.print("Qual o CPF do cliente: ");
                        String cpf = scan.next();

                        cliente = locadora.buscarCliente(cpf);

                        // Verifica se o cliente foi encontrado, caso não, mostra uma mensagem de erro e pede para digitar novamente
                        if (cliente == null) {
                            System.out.println("Cliente não encontrado! Tente novamente.");
                        }

                    } while (cliente == null);

                    boolean cancelou = false;

                    do {
                        System.out.print("Qual a placa do veículo (0 para cancelar): ");
                        String placa = scan.next();

                        if (placa.equals("0")) {
                            cancelou = true;
                            break;
                        }

                        veiculo = locadora.buscarVeiculo(placa);

                        if (veiculo == null) {
                            System.out.println("Veículo não existe! Tente novamente.");
                        } else if (!veiculo.getdisponivel()) {
                            System.out.println("Veículo indisponível! Escolha outro.");
                        }

                    } while (veiculo == null || !veiculo.getdisponivel());

                    if (cancelou) {
                        System.out.println("Locação cancelada!");
                        break;
                    }

                    // Se o usuário cancelou, volta ao menu
                    if (veiculo == null || !veiculo.getdisponivel()) {
                        break;
                    }

                    // Verificar quantidade de dias
                    int dias;

                    do {
                        System.out.print("Quantidade de dias: ");
                        dias = scan.nextInt();

                        if (dias <= 0) {
                            System.out.println("Quantidade de dias inválida!");
                        }

                    } while (dias <= 0);

                    // Criar locacao
                    Locacao locacao = new Locacao(cliente, veiculo, dias);

                    locadora.cadastrarLocacao(locacao);
                    System.out.println("==============================================");
                    System.out.println("Locação cadastrada!");
                    System.out.println("Cliente: " + locacao.getCliente().getNome());
                    System.out.println("Veiculo: " + locacao.getVeiculo().getmodelo());
                    System.out.println("Valor total: R$ " + locacao.getValorTotal());
                    System.out.println("==============================================");

                    // Encerra o case 3 e volta para o menu
                    break;
                }
                // Listar clientes
                case 4: {
                    // Verifica se há clientes cadastrados
                    if (locadora.listarClientes().isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado!");
                        break;
                    }
                    // Mostra as informações de cada cliente cadastrado
                    for (int i = 0; i < locadora.listarClientes().size(); i++) {
                        Cliente cliente = locadora.listarClientes().get(i);
                        System.out.println("==============================================");
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("CPF: " + cliente.getCpf());
                        System.out.println("==============================================");
                    }

                    // Encerra o case 4 e volta para o menu
                    break;
                }
                // Listar veículos
                case 5: {
                    // Verifica se há veículos cadastrados
                    if (locadora.listarVeiculos().isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado!");
                        break;
                    }
                    // Mostra as informações de cada veículo cadastrado
                    for (int i = 0; i < locadora.listarVeiculos().size(); i++) {
                        Veiculo veiculo = locadora.listarVeiculos().get(i);
                        System.out.println("==============================================");
                        System.out.println("Modelo: " + veiculo.getmodelo());
                        System.out.println("Placa: " + veiculo.getplaca());
                        System.out.println("==============================================");
                    }

                    // Encerra o case 5 e volta para o menu
                    break;
                }
                // Listar locações
                case 6: {
                    // Verifica se há locações cadastradas
                    if (locadora.listarLocacoes().isEmpty()) {
                        System.out.println("Nenhuma locação cadastrada!");
                        break;
                    }
                    // Mostra as informações de cada locação cadastrada
                    for (int i = 0; i < locadora.listarLocacoes().size(); i++) {
                        Locacao locacao = locadora.listarLocacoes().get(i);

                        System.out.println("Locacao numero: " + (i + 1));
                        System.out.println("==============================================");
                        System.out.println("Cliente: " + locacao.getCliente().getNome());
                        System.out.println("CPF: " + locacao.getCliente().getCpf());
                        System.out.println("Veiculo: " + locacao.getVeiculo().getmodelo());
                        System.out.println("Placa: " + locacao.getVeiculo().getplaca());
                        System.out.println("Quantidade de dias: " + locacao.getQuantidadeDias());
                        System.out.println("Valor total: R$ " + locacao.getValorTotal());
                        System.out.println("Ativa: " + locacao.seAtiva());
                        System.out.println("==============================================");
                    }

                    // Encerra o case 6 e volta para o menu
                    break;
                }
                // Devolver veiculo

                case 7: {
                    System.out.print("Digite a placa do veiculo: ");
                    String placa = scan.next();

                    System.out.print("Digite a quantidade de dias que o veiculo ficou com o cliente: ");
                    int diasReais = scan.nextInt();

                    boolean devolvido = locadora.devolverVeiculo(placa, diasReais);

                    if (devolvido) {
                        System.out.println("Veiculo devolvido com sucesso!");

                        double multa = locadora.getUltimaMulta();

                        if (multa > 0) {
                            System.out.println("Multa por atraso: R$ " + multa);
                        } else {
                            System.out.println("Sem multa por atraso.");
                        }

                        System.out.println("Veiculo disponivel para aluguel!");
                    } else {
                        System.out.println("Nenhuma locacao ativa encontrada para essa placa!");
                    }

                    break;
                }

                case 8: {
                    System.out.println("Digite o CPF do Cliente que deseja remover do Sistema: ");
                    String cpf = scan.next();

                    boolean remover = locadora.removerCliente(cpf);

                    if (remover) {
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente nao encontrado");
                    }
                    break;
                }
                case 9: {
                    System.out.print("Digite a placa do veículo que deseja remover: ");
                    String placa = scan.next();

                    boolean remover = locadora.removerCarro(placa);

                    if (remover) {
                        System.out.println("Veículo removido com sucesso!");
                    } else {
                        System.out.println("Não foi possível remover!");
                        System.out.println("O veículo não existe ou está alugado.");
                    }

                    break;
                }
                case 10: {
                    System.out.print("Digite a placa do veículo da locação que deseja remover: ");
                    String placa = scan.next();

                    boolean remover = locadora.removerLocacao(placa);

                    if (remover) {
                        System.out.println("Locação removida com sucesso!");
                    } else {
                        System.out.println("Não foi possível remover a locação!");
                        System.out.println("Verifique se a locação existe ou se o veículo ainda está alugado.");
                    }

                    break;
                }
                case 11: {
                    System.out.print("Digite a placa do veículo que deseja buscar: ");
                    String placa = scan.next();

                    Veiculo veiculo = locadora.buscarVeiculo(placa);

                    if (veiculo != null) {
                        System.out.println("==============================================");
                        System.out.println("Veículo encontrado!");
                        System.out.println("Modelo: " + veiculo.getmodelo());
                        System.out.println("Placa: " + veiculo.getplaca());
                        System.out.println("Valor da diária: R$ " + veiculo.getvalorDiaria());
                        System.out.println("Disponível: " + veiculo.getdisponivel());
                        System.out.println("==============================================");
                    } else {
                        System.out.println("Veículo não encontrado!");
                    }

                    break;
                }
                case 12: {
                    System.out.print("Digite o CPF do cliente que deseja buscar: ");
                    String cpf = scan.next();

                    Cliente cliente = locadora.buscarCliente(cpf);

                    if (cliente != null) {
                        System.out.println("Cliente encontrado!");
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("CPF: " + cliente.getCpf());
                        System.out.println("CNH: " + cliente.getCnh());
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }

                    break;
                }

                case 0: {
                    System.out.println("Saindo do Menu!");
                    break;
                }
                default: {
                    System.out.println("Número Inválido! Tente Novamente.");
                    break;
                }

            }
            // Encerra o loop do menu e fecha o scanner
        } while (escolha != 0);
        scan.close();
    }
}
