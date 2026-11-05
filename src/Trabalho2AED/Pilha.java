package Trabalho2AED;

public class Pilha<T> {
	private Celula<T> topo;
	private int tam;
	
	public Pilha() {
		topo = null;
		tam = 0;
	}
	
	public void push(T item) {  // empilhar : adiciona um novo elemento no topo da pilha 
		if(item == null) {
			throw new NullPointerException("Não é permitido empilhar item nulo");
		}
		else {
			Celula <T> novo = new Celula<>(item);
			novo.prox = topo;
			topo = novo;
			tam++;
		}
	}
	
	public T pop () throws RuntimeException { //desempilhar : Remove o último elemento inserido
		if(topo == null)
			throw new RuntimeException ("Erro: A pilha está vazia");
		else {
			T item = topo.item;
			topo = topo.prox;
			tam--;
			return item;
		}
	}
	
	public T peek() throws RuntimeException { //Serve para vizualizar o elemento do topo da pilha
		if(topo == null)
			throw new RuntimeException ("Erro: A pilha está vazia");
		else {
			return topo.item;
		}
	}
	
	public boolean isVazia() {
		return topo == null;
	}
}
