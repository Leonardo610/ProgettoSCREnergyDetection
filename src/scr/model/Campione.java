package scr.model;

public class Campione {
	private double parteReale;
	private double parteImmaginaria;
	
	public Campione() {}
	
	public Campione(double pR, double pI) {
		this.parteReale = pR;
		this.parteImmaginaria = pI;
	}

	public double getParteReale() {
		return parteReale;
	}

	public void setParteReale(double parteReale) {
		this.parteReale = parteReale;
	}

	public double getParteImmaginaria() {
		return parteImmaginaria;
	}

	public void setParteImmaginaria(double parteImmaginaria) {
		this.parteImmaginaria = parteImmaginaria;
	}
	
	public double getPotenza() {
		return Math.pow(this.parteReale, 2) + Math.pow(this.parteImmaginaria, 2);
	}
	
	@Override
	public String toString() {
		return ("Re: " + this.parteReale + ", Imm: " + this.parteImmaginaria + ";");
	}
}	


