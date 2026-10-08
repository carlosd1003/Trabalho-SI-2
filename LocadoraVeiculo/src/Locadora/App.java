package Locadora;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
     
        Scanner scan = new Scanner(System.in);
        Locadora locadora = new Locadora("Nome da Locadora", "12.345.678/0001-90", "Endereço da Locadora", "(11) 1234-5678");
        //ArrayList<Cliente> clientes = new ArrayList<>(); //Cria uma lista para adicionar os clientes cadastrados 
        ArrayList<Veiculo> veiculo = new ArrayList<>(); 
        int escolha;        
        do{
            System.out.println("Qual opcao voce deseja? ");
            System.out.println("1 - Cadastrar um Cliente ");
            System.out.println("2 - Cadastrar um Veiculo");
            
            System.out.print("Número da opção: ");
            escolha = scan.nextInt();
            
            
            switch (escolha){
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
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Cpf: " + cliente.getCpf());
                    System.out.println("Cnh: " + cliente.getCnh());
                    System.out.println("Idade: " + cliente.getIdade());
                        break;
                }
                case 2:{
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
                    veiculo.add(carro);

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
         
            }
            
        } while (escolha != 0);
        
    }
}
