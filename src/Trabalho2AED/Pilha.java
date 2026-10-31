package Trabalho2AED;

public class Pilha<T> {
	private class Celula {
		T item;
		Celula prox;
	}
	
	private Celula topo;
	private int tam;
	
	public Pilha() {
		topo = null;
		tam = 0;
	}
	
	public void push(T item) {
		if(item == null) {
			throw new NullPointerException();
		}
		else {
			Celula novo = new Celula();
			novo.item = item;
			novo.prox = topo;
			topo = novo;
			tam++;
		}
	}
}
