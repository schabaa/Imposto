package calculadoraImposto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        double rendaAnualSalario = sc.nextDouble();

        System.out.print("Renda anual com prestação de serviço: ");
        double rendaAnualServicos = sc.nextDouble();

        System.out.print("Renda anual com ganho de capital: ");
        double rendaAnualGanhoCapital = sc.nextDouble();

        System.out.print("Gastos médicos: ");
        double gastosMedicos = sc.nextDouble();

        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = sc.nextDouble();

        CalculadoraImposto calculadora = new CalculadoraImposto(
            rendaAnualSalario,
            rendaAnualServicos,
            rendaAnualGanhoCapital,
            gastosMedicos,
            gastosEducacionais
        );

        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f%n", calculadora.calcularImpostoSalario());
        System.out.printf("Imposto sobre serviços: %.2f%n", calculadora.calcularImpostoServicos());
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", calculadora.calcularImpostoGanhoCapital());

        System.out.println("\n* DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f%n", calculadora.calcularMaximoDedutivel());
        System.out.printf("Gastos dedutíveis: %.2f%n", calculadora.getGastosMedicos() + calculadora.getGastosEducacionais());

        System.out.println("\n* RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", calculadora.calcularImpostoBrutoTotal());
        System.out.printf("Abatimento: %.2f%n", calculadora.calcularAbatimento());
        System.out.printf("Imposto devido: %.2f%n", calculadora.calcularImpostoDevido());

        sc.close();
    }
}
