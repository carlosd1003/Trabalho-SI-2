
package Locadora;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
     
        Scanner scan = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>(); //Cria uma lista para adicionar os clientes cadastrados
        int escolha;
        
        do{
            System.out.println("Qual opcao voce deseja? ");
            System.out.println("1 - Cadastrar um Cliente ");
            
            
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
                    clientes.add(cliente);//Pega o cliente cadastrado e guarda na lista criada
                    
                    System.out.println("Cliente cadastrado com sucesso!");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Cpf: " + cliente.getCpf());
                    System.out.println("Cnh: " + cliente.getCnh());
                    System.out.println("Idade: " + cliente.getIdade());
                        
                }
                case 2:
              
                    default:
                        break;
                
                
            }
            
        } while (escolha != 0);
        
    }
}
