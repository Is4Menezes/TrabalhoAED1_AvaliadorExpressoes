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
	
	public void enfileirar(T item){
		if(item == null)
			throw new NullPointerException("Não é permitido enfileirar item nulo");
		else {
			fim.prox = new Celula<>(item);
			fim = fim.prox;
			tam++;
		}
	}
	
	public T desenfileirar()throws RuntimeException {
		if (inicio == fim)
			 throw new RuntimeException("Erro: Fila vazia!");
		else {
			T aux = inicio.prox.item;
			inicio = inicio.prox;
			tam--;
			return aux;
		}
	}
	
	public boolean isVazia() {
		if(inicio == fim)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		while(!isVazia()) {
			sb.append(desenfileirar());
		}
		return sb.toString();
	}
}
