package cofrinho;

public class Dollar extends Moeda {

	public Dollar(double valor) {
		super(valor, TipoMoeda.DOLLAR);
	}

	@Override
	void info() {
		System.out.printf("Moeda %d - $%.2f\n", id, valor);
	}

	@Override
	double converter() {
		return valor * Cofrinho.getCotacaoDollar();
	}

}
