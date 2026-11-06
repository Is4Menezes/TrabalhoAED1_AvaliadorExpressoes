package Trabalho2AED;

public class ValidadorExpressao {
	public boolean validarExpressao(String expressao) { // recebe a expressão infixa e verifica se é uma expressão válida
		int contParentese = 0; // conta os parênteses abertos
		boolean esperandoOperando = true; // começa no estado 1 (espera receber um operando ou '(')
		for (int i = 0; i < expressao.length(); i++) {
			char car = expressao.charAt(i); // car de caractere
			if (car == ' ') { // se o caractere for um espaço, só ignora
				continue;
			} else if (esperandoOperando) {
				if (car == '(') {
					contParentese++;
				} else if (car >= '0' && car <= '9') {
					esperandoOperando = false; // vai para o estado 2 (espera receber um operador ou ')' )
				} else {
					return false;
				}
			} else {
				if (car == ')' && contParentese > 0) {
					contParentese--;
				} else if (car == ')') {
					return false;
				} else if (car == '+' || car == '-' || car == '/' || car == '*' || car == '^') {
					esperandoOperando = true;
				} else {
					return false;
				}
			}
		}
		if (esperandoOperando == false && contParentese == 0)
			return true;
		else
			return false;
	}
}
