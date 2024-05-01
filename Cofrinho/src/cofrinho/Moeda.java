package cofrinho;

import java.util.Objects;

public abstract class Moeda { 
	int id;
	protected TipoMoeda tipo;
	protected double valor;
	
	abstract void info();
	abstract double converter();
	
	public Moeda(double valor, TipoMoeda tipo) {
		id = Cofrinho.moedas.isEmpty() ? 1 : Cofrinho.moedas.size() + 1;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moeda other = (Moeda) obj;
		return id == other.id;
	}
}
