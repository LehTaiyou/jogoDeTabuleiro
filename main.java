package jogoDeTabuleiro;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		
		
		System.out.println(" Quantos jogadores vão jogar? ");
		Scanner input = new Scanner(System.in);
		String jogadores = input.nextLine();
		int num = Integer.valueOf(jogadores);
		if (num > 6) {
			System.out.println(" Erro Numero de jogadores máximo é 6 ");
			input.close();
			return;
		}
		ArrayList<jogador> listaDeJogadores = new ArrayList<jogador>(5);
		
		for(int i = 1; i <= num; i++) {
			String cor = null;
			String tipoDeJogador = null; 
			switch (i) {
			  case 1:
			    cor = "Amarelo";
			    break;
			  case 2:
			    cor = "Azul";
			    break;
			  case 3:
			    cor = "Vermelho";
			    break;
			  case 4:
			    cor = "Preto";
			    break;
			  case 5:
			    cor = "Branco";
			    break;
			  case 6:
			    cor = "Verde";
			    break;
			}
			
			Random random = new Random();
		    int numeroAleatorio = random.nextInt(2);
			switch (numeroAleatorio) {
			  case 0:
				  tipoDeJogador = "Azarado";
			    break;
			  case 1:
				  tipoDeJogador = "Sortudo";
			    break;
			  case 2:
				  tipoDeJogador = "Normal";
			    break;
			}
			jogador j = new jogador(0, cor, tipoDeJogador);
			listaDeJogadores.add(j);
			
		}
		String guardarJogador = listaDeJogadores.get(0).tipoDeJogador;
		for (jogador j : listaDeJogadores) {
			if(guardarJogador != j.getTipoDeJogador()) {
				break;
			}
			switch (guardarJogador) {
			case "Azarado":
				j.setTipoDeJogador("Sortudo");
				break;
			case "Sortudo":
				j.setTipoDeJogador("Normal");
				break;
			case "Normal":
				j.setTipoDeJogador("Azarado");
				
			}
		}
		String vencedorCor = null;
		int vencedorRodadas = 0;
		boolean jogoFinalizado = true;
		while(jogoFinalizado) {
			
			for (jogador j : listaDeJogadores) {
				System.out.println(" Rodada do jogador: " + j.getCor());
				System.out.println (" Posição atual: " + j.getPosiçao());
				System.out.println (" Aperte qualquer tecla para jogar os dados ");
				Scanner botao = new Scanner(System.in);
				String querJogarDados = botao.nextLine();
				j.jogarDados();
				switch(j.getPosiçao()) {
			    case 17, 27:
			    System.out.println(" Você caiu numa casa especial: " + j.getPosiçao());
				System.out.println(" Escolha um jogador para voltar para o início ");
				String jogadorInicio = input.nextLine();
				for (jogador p : listaDeJogadores) {
					if(p.getCor() == jogadorInicio) {
						p.setPosiçao(0);
					}	
				}
				break;
			    case 20, 35:
			    int posiçaoAtual = 40;
			    String jogadorMenorPosiçao = null;
			    System.out.println(" Você caiu numa casa especial: " + j.getPosiçao() + " Jogador: " + j.getCor() + " Trocará de casa com o jogador mais atrás");
			    for (jogador g : listaDeJogadores) {
			    	if(g.getPosiçao() < posiçaoAtual) {
			    		jogadorMenorPosiçao = g.getCor();
			    		posiçaoAtual = g.getPosiçao();
			    	}
			    }
			    for (jogador g : listaDeJogadores) {
			    	if(g.getCor() == jogadorMenorPosiçao) {
			    		g.setPosiçao(j.getPosiçao());
				    	j.setPosiçao(posiçaoAtual);
			    	}
			    }
			
				}
				
				if(j.getPosiçao() > 40) {
				jogoFinalizado = false;
				vencedorCor = j.getCor();
				vencedorRodadas = j.getRodadas();
				}
			}
		}
		System.out.println(" Jogador Vencedor: " + vencedorCor + " \nNúmero de rodadas " + vencedorRodadas);
		
		for (jogador j : listaDeJogadores) {
			System.out.println(" Rodada do Jogador: " + j.getCor() + " \nNúmero de Rodadas: " + j.getRodadas() + " Posição do jogador: " + j.getPosiçao());
		}	
		input.close();
	}

}
