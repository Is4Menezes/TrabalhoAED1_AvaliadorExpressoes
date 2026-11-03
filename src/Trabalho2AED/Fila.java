package Trabalho2AED;

public class Fila <T> {
	private Celula<T> inicio;
	private Celula<T> fim;
	private int tam;
	
	public Fila() {
		inicio = new Celula<T>(null);
		fim = inicio;
		tam = 0;
	}
	
}
