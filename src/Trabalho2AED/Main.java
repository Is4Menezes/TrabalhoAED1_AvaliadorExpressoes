package Trabalho2AED;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ConversorPosFixa cp = new ConversorPosFixa();
		AvaliadorPosFixa ap = new AvaliadorPosFixa();

		int op = 0;
		do {
			System.out.println("Deseja: ");
			System.out.println("1 - Avaliar uma expressão infixa");
			System.out.println("2 - Sair do programa");
			op = scan.nextInt();

			switch (op) {
			case 1: {
				try {
					scan.nextLine();
					System.out.print("Digite a expressão infixa: ");
					String expressao = scan.nextLine();
					Fila<Character> expressaoP = cp.converterInfixa(expressao);

					System.out.print("Expressão convertida para pósfixa: " + expressaoP);
					System.out.printf(" = %.2f", ap.avaliar(expressaoP));

				} catch (RuntimeException e) {
					System.err.print("\n" + e.getMessage());
				}
				break;
			}
			case 2: {
				System.out.println("Programa encerrado!");
				break;
			}
			default: {
				System.err.print("Opção inválida");
				break;
			}
			}
			System.out.println("\n");
		} while (op != 2);
		scan.close();
	}

}
