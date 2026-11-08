package Trabalho2AED;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ConversorPosFixa cp = new ConversorPosFixa();
		
		System.out.print("Digite a expressão infixa: ");
		String expressao = scan.nextLine();
		System.out.println("Expressão convertida para pósfixa: " + cp.converterInfixa(expressao));

		Fila<Character> f = cp.converterInfixa(expressao);
		System.out.println(f);
		System.out.println(f);
	}

}
