package calculadoraImposto;

public class CalculadoraImposto {
    private double rendaAnualSalario;
    private double rendaAnualServicos;
    private double rendaAnualGanhoCapital;
    private double gastosMedicos;
    private double gastosEducacionais;

    public CalculadoraImposto(double rendaAnualSalario, double rendaAnualServicos, double rendaAnualGanhoCapital,
                               double gastosMedicos, double gastosEducacionais) {
        this.rendaAnualSalario = rendaAnualSalario;
        this.rendaAnualServicos = rendaAnualServicos;
        this.rendaAnualGanhoCapital = rendaAnualGanhoCapital;
        this.gastosMedicos = gastosMedicos;
        this.gastosEducacionais = gastosEducacionais;
    }

    public double calcularImpostoSalario() {
        double salarioMensal = rendaAnualSalario / 12;
        if (salarioMensal < 3000) {
            return 0.0;
        } else if (salarioMensal < 5000) {
            return rendaAnualSalario * 0.10;
        } else {
            return rendaAnualSalario * 0.20;
        }
    }

    public double calcularImpostoServicos() {
        return rendaAnualServicos * 0.15;
    }

    public double calcularImpostoGanhoCapital() {
        return rendaAnualGanhoCapital * 0.20;
    }

    public double calcularImpostoBrutoTotal() {
        return calcularImpostoSalario() + calcularImpostoServicos() + calcularImpostoGanhoCapital();
    }

    public double calcularMaximoDedutivel() {
        return calcularImpostoBrutoTotal() * 0.30;
    }

    public double calcularAbatimento() {
        double maximoDedutivel = calcularMaximoDedutivel();
        double gastosTotais = gastosMedicos + gastosEducacionais;
        return Math.min(maximoDedutivel, gastosTotais);
    }

    public double calcularImpostoDevido() {
        return calcularImpostoBrutoTotal() - calcularAbatimento();
    }

    // Getters para gastos médicos e educacionais
    public double getGastosMedicos() {
        return gastosMedicos;
    }

    public double getGastosEducacionais() {
        return gastosEducacionais;
    }
}
