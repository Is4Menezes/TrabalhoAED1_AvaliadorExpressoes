package Trabalho2AED;

public class ConversorPosFixa {
	public Fila<Character> converterInfixa(String expressao) { // converte expressão infixa para posfixa
		ValidadorExpressao ve = new ValidadorExpressao();

		Pilha<Character> pilha = new Pilha<Character>();
		Fila<Character> fila = new Fila<Character>();

		if (expressao != null && ve.validarExpressao(expressao)) {
			for (int i = 0; i < expressao.length(); i++) {
				char car = expressao.charAt(i); // car de caractere
				if (car == '(') {
					pilha.push(car);
				} else if (car >= '0' && car <= '9') { // se o caractere for um dígito, já enfileira
					fila.enfileirar(car);
				} else if (verificarOperador(car)) {
					while (!pilha.isVazia() && pilha.peek() != '('
							&& verificarPrecedencia(pilha.peek()) >= verificarPrecedencia(car) && car != '^') {
						fila.enfileirar(pilha.pop()); // desempilha todos os operadores até a pilha ficar vazia ou
														// encontrar um operador com ordem de precedência menor que
														// a do car
					}
					pilha.push(car);
				} else if (car == ')') {
					while (pilha.peek() != '(') {
						fila.enfileirar(pilha.pop()); // desempilha todos os operadores até encontrar o '('
					}
					pilha.pop();
				}
			}
			while (!pilha.isVazia()) {
				fila.enfileirar(pilha.pop()); // esvazia a pilha
			}
			return fila;
		}
		throw new IllegalArgumentException("Expressão inválida!");
	}

	public int verificarPrecedencia(Character operador) { // retorna a ordem de precedência dos operadores
		if (operador != null) {
			if (operador == '+' || operador == '-') {
				return 1;
			} else if (operador == '*' || operador == '/') {
				return 2;
			} else if (operador == '^') {
				return 3;
			}
		}
		throw new IllegalArgumentException("Operador inválido");
	}

	public boolean verificarOperador(Character car) { // verifica se o caractere é um operador
		if (car == '+' || car == '-' || car == '*' || car == '/' || car == '^')
			return true;
		return false;
	}
}
