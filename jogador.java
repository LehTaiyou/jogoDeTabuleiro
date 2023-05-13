package jogoDeTabuleiro;
import java.util.Random;


public class jogador extends todosOsJogadores {
  String cor;
  String tipoDeJogador;
  int posiçao;
  int rodadas;
  boolean podeJogar;
  
  public jogador(int posiçao, String cor, String tipoDeJogador) {
	  this.posiçao = 0;
	  this.cor = cor;
	  this.tipoDeJogador = tipoDeJogador;
	  this.rodadas = 0;
	  this.podeJogar = true;
	  
}

public void jogarDados() {
	if(podeJogar == false) {
		this.podeJogar = true;
		return;
	}
	int valorDados;
	Random random = new Random();
    int dado1 = random.nextInt(5);
	int dado2 = random.nextInt(5);
	dado1 += 1;
	dado2 += 1;
	
	
	valorDados = dado1 + dado2;
	if(tipoDeJogador == "Sortudo" && valorDados < 7) {
		jogarDados();
		return;
	}
	if(tipoDeJogador == "Azarado" && valorDados > 7) {
		jogarDados();
		return;
	}
	this.posiçao += valorDados;
	
	switch (this.posiçao) {
	case 10, 25, 38:
		this.podeJogar = false;
		System.out.println(" Você caiu numa casa especial: " + this.posiçao + " \nJogador não pode jogar a próxima rodada: " + this.cor);
		break;
	case 13:
		System.out.println(" Você caiu numa casa especial: " + this.posiçao + " \nJogador terá seu tipo de jogador mudado ");
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
	    break;
	case 5, 15, 30:
		System.out.println(" Você caiu numa casa especial e andará 3 casas ");
		if(this.tipoDeJogador != "Azarado") {
			this.posiçao += 3;
		}
		else {
			System.out.println(" Você é Azarado e não poderá andar ");
		}
		break;
	}
	System.out.println(" Valor dos dados " + valorDados);
	
	
	if(dado1 == dado2) {
		System.out.println (" Dados iguais, jogue novamente ");
	     dado1 = random.nextInt(5);
		 dado2 = random.nextInt(5);
		 dado1 += 1;
		 dado2 += 1;
		
		valorDados = dado1 + dado2;
		this.posiçao += valorDados;
	}
	
	rodadas++;
}
  
public String getCor() {
	return cor;
}


public void setCor(String cor) {
	this.cor = cor;
}


public String getTipoDeJogador() {
	return tipoDeJogador;
}


public void setTipoDeJogador(String tipoDeJogador) {
	this.tipoDeJogador = tipoDeJogador;
}


public int getPosiçao() {
	return posiçao;
}


public void setPosiçao(int posiçao) {
	this.posiçao = posiçao;
}
public int getRodadas() {
	return rodadas;
}
}