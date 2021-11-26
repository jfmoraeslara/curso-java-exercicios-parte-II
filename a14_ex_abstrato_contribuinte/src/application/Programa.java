package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Contribuinte> list = new ArrayList<>();

		System.out.print("Entre com os números de contribuintes: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do contribuinte #" + i + " :");
			System.out.print("Pessoa Física ou Jurídica (f/j): ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Rendimento anual: ");
			Double rendaAnual = sc.nextDouble();

			if (ch == 'f') {
				System.out.print("Gastos com saúde: ");
				Double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, gastosSaude, rendaAnual));
			} else {
				System.out.print("Numeros de funcionarios: ");
				Integer numeroFuncionario = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionario));
			}
		}

		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		for (Contribuinte contribuinte : list) {
			System.out.println(contribuinte.getNome() + ": " + String.format("$%.2f ", contribuinte.totalImposto()));
		}

		double soma = 0.0;
		for (Contribuinte contribuinte : list) {
			soma += contribuinte.totalImposto();
		}
		System.out.println();
		System.out.printf("TOTAL IMPOSTO: " + String.format("$%.2f ", soma));

		sc.close();
	}
}
