import java.util.Scanner;
class jogo_nim {
	public static int computador_escolhe_jogada(int n, int m) {
		if (n<=m) return n;
		else if (n%(m+1)>0) return n%(m+1);
		else return m;
	}
	public static int usuario_escolhe_jogada(int n, int m) {
		System.out.print("Quantas peças você vai tirar? ");
		Scanner s = new Scanner(System.in);
		int valor = s.nextInt();
		while (valor>m || valor<=0 || valor>n) {
			System.out.print("Oops! Jogada inválida! Tente de novo.\nQuantas peças você vai tirar? ");
			s = new Scanner(System.in);
			valor = s.nextInt();
		}
		return valor;
	}
	public static void partida() {
		int valor, jogada;
		System.out.print("Quantas peças? ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n<1) {
			System.out.print("Número de peças inválido\nQuantas peças? ");
			s = new Scanner(System.in);
			n = s.nextInt();
		}
		System.out.print("Limite de peças por jogada? ");
		s = new Scanner(System.in);
		int m = s.nextInt();
		while (m<1) {
			System.out.print("Número de peças inválido\nQuantas peças? ");
			s = new Scanner(System.in);
			m = s.nextInt();
		}
		if (n%(m+1)==0) {
			System.out.print("\nVocê começa!\n");
			jogada=1;
			while (n>0) {
				if (jogada==1) {
					valor=usuario_escolhe_jogada(n,m);
					n=n-valor;
					System.out.print("\nVocê tirou "+valor+" peça(s).\nAgora restam "+n+" peças no tabuleiro.\n\n");
					jogada=2;
				}
				else {
					valor=computador_escolhe_jogada(n,m);
					n=n-valor;
					System.out.print("\nO computador tirou "+valor+" peça(s)\nAgora restam "+n+" peças no tabuleiro.\n\n");
					jogada=1;
				}
			}
			System.out.print("Fim do jogo! O computador ganhou!\n");
		}
		else {
			System.out.print("\nComputador começa!\n");
			jogada=2;
			while (n>0) {
				if (jogada==2) {
					valor=computador_escolhe_jogada(n,m);
					n=n-valor;
					System.out.print("\nO computador tirou "+valor+" peça(s)\nAgora restam "+n+" peças no tabuleiro.\n\n");
					jogada=1;
				}
				else {
					valor=usuario_escolhe_jogada(n,m);
					n=n-valor;
					System.out.print("\nVocê tirou "+valor+" peça(s).\nAgora restam "+n+" peças no tabuleiro.\n\n");
					jogada=2;
				}
			}
			System.out.print("Fim do jogo! O computador ganhou!\n");
			}
		}
	public static void campeonato() {
		int quantidade_partida=1;
		while (quantidade_partida<4) {
			System.out.print("\n**** Rodada "+quantidade_partida+" ****\n");
			partida();
			quantidade_partida++;
		}
		System.out.print("**** Final do campeonato! ****\n\nPlacar: Você 0 X 3 Computador\n");
	}
	public static void main(String[] args) {
		System.out.print("Bem-vindo ao jogo do NIM!\n1 - para jogar uma partida isolada\n2 - para jogar um campeonato\nEscolha: ");
		Scanner s = new Scanner(System.in);
		int escolha = s.nextInt();
		while (escolha!=1 && escolha!=2) {
			System.out.print("Escolha uma opção válida!\nEscolha: ");
			s = new Scanner(System.in);
			escolha = s.nextInt();
		}
		if (escolha==1) {
			System.out.print("\nVocê escolheu uma partida isolada!\n");
			partida();
		}
		else {
			System.out.print("\nVocê escolheu um campeonato!\n");
			campeonato();
		}
	}
}
