import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	Nodo primeiro, selecionado = null;
	public static void main(String[] args) {
		
		Main m = new Main();
		boolean exit = false;
		do {
			System.out.println("1- Inserir elemento");
			System.out.println("2- Exibir elemento");
			System.out.println("3- Contar elemento");
			System.out.println("4- Excluir elemento");
			System.out.println("0- Sair");
			int opt = m.sc.nextInt();
			switch(opt) {
				case 1:
					m.inserir();
					break;
				case 2:
					m.exibir();
					break;
				case 3:
					m.contar();
					break;
				case 4:
					m.excluir();
					break;
				case 0:
					System.out.println("saindo...");
					exit = true;
					break;
				default:
					System.err.println("INVALIDO");
					break;
			}
		}while(exit==false);
	}
	private void inserir() {
		System.out.println("valor: ");
		Nodo novo = new Nodo();
		novo.valor = sc.nextInt();
		if(primeiro == null) {
			primeiro = novo;
			encadear(primeiro, primeiro, primeiro);
		}else {
			encadear(primeiro.pegarAnterior(), novo, primeiro);
		}
	}
	private void encadear(Nodo anterior, Nodo atual, Nodo proximo) {
		atual.inserirAnterior(anterior);
		atual.inserirProximo(proximo);
		atual.pegarProximo().inserirAnterior(atual);
		atual.pegarAnterior().inserirProximo(atual);
	}
	private void exibir() {
		int opt = 0;
		do {
			if(selecionado == null) {
				selecionado = primeiro;
			}
			if(selecionado != null) {
				selecionado.exibir();
				System.out.println("1-Prox1\n2-Ant\n0-Sair");
				opt = sc.nextInt();
				switch(opt) {
					case 1:
						selecionado = selecionado.pegarAnterior();
						break;
					case 2:
						selecionado = selecionado.pegarProximo();
						break;
					case 0:
						return;
					default:
						System.err.println("INVALIDO");
						break;
				}
			}
		}while(opt > 0);
	}
	private void contar() {
		Nodo marca = primeiro;
		int cont = 0;
		if(marca != null) {
			do {
				cont++;
				marca = marca.pegarProximo();
			}while(marca != primeiro);
		}
		System.out.println("existem " + cont + " nodos");
	}
	private void excluir() {
		if(selecionado == null) {
			selecionado = primeiro;
		}	
		if(selecionado != null) {
			int opt=0;
			System.out.println("certeza que deseja excluir "+selecionado.valor);
			System.out.println("1-Sim\n2-Nao");
			opt = sc.nextInt();
			switch(opt) {
			case 1:
				selecionado.pegarProximo().inserirAnterior(selecionado.pegarAnterior());
				selecionado.pegarAnterior().inserirProximo(selecionado.pegarProximo());
				if(selecionado != selecionado.pegarProximo()) {
					selecionado = selecionado.pegarProximo();
				}else {
					primeiro = selecionado = null;
				}
				break;
			case 2:
				return;
			default:
				System.err.println("INVALIDO");
				break;
			}
		}else {
			System.err.println("INVALIDO");
		}
	}

}
