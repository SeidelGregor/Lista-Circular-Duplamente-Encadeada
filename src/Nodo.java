
public class Nodo {
	public int valor;
	public Nodo anterior = null;
	public Nodo proximo = null;
	public void inserirProximo(Nodo proximo) {
		this.proximo = proximo;
	}
	
	public void inserirAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	
	public void exibir() {
		System.out.println(proximo.valor + "|" + valor + "|" + anterior.valor);
	}
	public Nodo pegarProximo() {
		return proximo;
	}
	public Nodo pegarAnterior() {
		return anterior;
	}
}
