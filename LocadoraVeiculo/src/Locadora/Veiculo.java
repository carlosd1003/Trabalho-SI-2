
package Locadora;

public class Veiculo {
    private String modelo;
    private String marca;
    private String placa;
    private int ano;
    private double valorDiaria;
    private boolean disponivel;


    public Veiculo (String modelo, String marca, String placa,int ano,double valorDiaria,boolean disponivel){
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }
    
    public String getmodelo(){
        return this.modelo;
    }
    
    public String getmarca(){
        return this.marca;
    
    }
    
    public String getplaca(){
        return this.placa;
    
    }
    
    public int getano(){
        return this.ano;
        
    }
    
    public double getvalorDiaria(){
        return this.valorDiaria;
        
    }
    
    public boolean getdisponivel(){
        return this.disponivel;
    
    
    }
    
 
    
}