package cofrinho;

import java.util.ArrayList;

public class Cofrinho {
	private static double cotacaoDollar = 5;
	private static double cotacaoEuro = 6;
	public static final ArrayList<Moeda> moedas = new ArrayList<Moeda>();
	
	public void adcionarMoeda() {
		System.out.println("\n*********ADICIONAR MOEDA*********");
		System.out.println("1 - Real");
		System.out.println("2 - Dollar");
		System.out.println("3 - Euro");
		int tipo = Main.getOpcao();
		if(tipo < 1 || tipo > 3) {
			System.out.println("Tipo de moeda invalido.");
			return;
		}
		
		System.out.println("Digite o Valor:");
		int valor = Main.getOpcao();
		
		switch(tipo) {
		case 1:
			moedas.add(new Real(valor));
			break;
		case 2:
			moedas.add(new Dollar(valor));
			break;
		case 3:
			moedas.add(new Euro(valor));
			break;
		}
		
	}
	
	public void removerMoeda() {
		System.out.println("\n*********REMOVER MOEDA*********");
		System.out.println("Digite o número da moeda:");
		int opt = Main.getOpcao();
		Moeda moeda = getMoedaPorId(opt);
		if(moeda == null) {
			System.out.printf("Moeda %i não encontrada.", opt);
		}else {
			moedas.remove(moeda);
		}
		
	}
	
	public void listarMoedas() {
		System.out.println("\n*********LISTAR MOEDAS*********");
		for(Moeda moeda : moedas) {
			moeda.info();
		}
		System.out.println("--------------------------------");
		System.out.printf("Total de Moedas - %d\n", moedas.size());
		System.out.printf("Total em ReaL - R$%.2f\n", getTotalMoedasPorTipo(TipoMoeda.REAL));
		System.out.printf("Total em Dollar - $%.2f\n", getTotalMoedasPorTipo(TipoMoeda.DOLLAR));
		System.out.printf("Total em Euro - €%.2f\n", getTotalMoedasPorTipo(TipoMoeda.EURO));
	}
	
	public void totalConvertido() {
		System.out.println("\n*********TOTAL CONVERTIDO*********");
		double total = 0;
		for(Moeda moeda : moedas) {
			total += moeda.converter();
		}
		
		System.out.printf("Total convertido para Real: %.2f", total);
	}

	//Métodos de classe
	static public double getCotacaoDollar() {
		return cotacaoDollar;
	}

	static public void setCotacaoDollar(double cotacaoDollar) {
		Cofrinho.cotacaoDollar = cotacaoDollar;
	}

	static public double getCotacaoEuro() {
		return cotacaoEuro;
	}

	static public void setCotacaoEuro(double cotacaoEuro) {
		Cofrinho.cotacaoEuro = cotacaoEuro;
	}
	
	//Métodos privados
	private double getTotalMoedasPorTipo(TipoMoeda tipo) {
		double total = 0;
		for(Moeda moeda : moedas) {
			if(moeda.tipo == tipo) {
				total += moeda.valor;
			}
		}
		return total;
	}
	
	private Moeda getMoedaPorId(int id) {
		for(Moeda moeda : moedas) {
			if(moeda.id == id) return moeda;
		}
		return null;
	}
}
