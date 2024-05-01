package cofrinho;

public class Euro extends Moeda {

	public Euro(double valor) {
		super(valor, TipoMoeda.EURO);
	}

	@Override
	void info() {
		System.out.printf("Moeda %d - €%.2f\n",id, valor);
	}

	@Override
	double converter() {
		return valor * Cofrinho.getCotacaoEuro();
	}

}
