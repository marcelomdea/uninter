package cofrinho;

import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opt = 1;
		Cofrinho cofrinho = new Cofrinho();
		
		//Loop Principal
		while(opt > 0) {
			System.out.println("\n\n\n*********MENU PRINCIPAL*********");
			System.out.println("1 - Adicionar Moeda");
			System.out.println("2 - Remover Moeda");
			System.out.println("3 - Listar Moedas");
			System.out.println("4 - Calcular total convertido para Real");
			System.out.println("5 - Mudar Cotação DOLLAR/EURO");
			System.out.println("0 - Encerar");
			
			System.out.println("\n\nCOTAÇÃO:");
			System.out.printf("---DOLLAR: $%.2f\n---EURO: €%.2f\n\n", Cofrinho.getCotacaoDollar(), Cofrinho.getCotacaoEuro());
			
			opt = Main.getOpcao();
					
			switch(opt) {
			case 1 :
				cofrinho.adcionarMoeda();
				break;
			case 2 :
				cofrinho.removerMoeda();
				break;
			case 3 :
				cofrinho.listarMoedas();
				break;
			case 4 :
				cofrinho.totalConvertido();
				break;
			case 5 :
				System.out.println("Digite a nova cotação para o Dollar:");
				Cofrinho.setCotacaoDollar(Main.getOpcao());
				System.out.println("Digite a nova cotação para o Euro:");
				Cofrinho.setCotacaoEuro(Main.getOpcao());
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Opção inválida.");
			}
		}
	}
	
	static public int getOpcao() {
		String  input  = scanner.next();
		try {
	        return Integer.parseInt(input);
	    } catch (NumberFormatException nfe) {
	        return 0;
	    } catch (Exception ex) {
	        return 0;
	    }
	}

}
