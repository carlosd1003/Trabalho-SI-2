
package Locadora;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private String cnh;
    private int idade;
    
    
    
    
    public Cliente(String nome, String cpf, String cnh, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.idade = idade;            
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public String getCnh(){
        return this.cnh;
    }
    public int getIdade(){
        return this.idade;
    }
    
}
