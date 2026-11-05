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
	
	public void Enfileirar(T item){
		if(item == null)
			throw new NullPointerException("Não é permitido empilhar item nulo");
		else {
			fim.prox = new Celula<>(item);
			fim = fim.prox;
			tam++;
		}
	}
	
	public T desenfileirar() throws Exception {
		if (inicio == fim)
			 throw new Exception("Erro: Fila vazia!");
		else
			return null;
	}
}
