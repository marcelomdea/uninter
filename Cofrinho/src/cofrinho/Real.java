package cofrinho;

public class Real extends Moeda {

	public Real(double valor) {
		super(valor, TipoMoeda.REAL);
	}

	@Override
	void info() {
		System.out.printf("Moeda %d - R$%.2f\n", id, valor);
	}

	@Override
	double converter() {
		return valor;
	}

}
