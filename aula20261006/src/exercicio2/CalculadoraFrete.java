package exercicio2;

public class CalculadoraFrete {

    private double taxaBase;
    private double pesoMaximoPermitido;

    public CalculadoraFrete(double taxaBase, double pesoMaximoPermitido) {
        this.taxaBase = taxaBase;
        this.pesoMaximoPermitido = pesoMaximoPermitido;
    }

    public double getTaxaBase() {
        return this.taxaBase;
    }

    public void setTaxaBase(double taxaBase) {
        if (taxaBase > 0) {
            this.taxaBase = taxaBase;
        }
    }

    public double calcular(double pesoKg) {
        double valor = pesoKg * this.taxaBase;
        if (pesoKg > this.pesoMaximoPermitido) {
            valor += 100;
        }
        return valor;
    }

    public double calcular(double pesoKg, boolean expressa) {
        double valor = this.calcular(pesoKg);

        if (expressa) {
            valor += 30;
        }

        return valor;
    }

    public double calcular(double pesoKg, String cupomDesconto) {
        double valor = this.calcular(pesoKg);

        if (cupomDesconto.equals("VIP10")) {
            valor -= valor * 0.1;
        }
        return valor;
    }

}
