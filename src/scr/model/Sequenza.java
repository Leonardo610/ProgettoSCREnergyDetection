package scr.model;

public class Sequenza {

	private Campione[] campioni;
	private double[] potenze;
	
	public Sequenza() {}

	public Sequenza(int lunghezza){
		this.campioni = new Campione[lunghezza];
	}

	public Campione[] getCampioni(){
		return this.campioni;
	}
	
	public void setCampioni(Campione[] campioni) {
		this.campioni = campioni;
	}

	public double[] getPotenze(){
		return this.potenze;
	}

	public void setPotenze(double[] potenze){
		this.potenze=potenze;
	}



	public double[] calcolaPotenze(){
		double[] potenze = new double[campioni.length];
		int i;
		for(i=0;i<campioni.length;i++)
			potenze[i]=this.getCampioni()[i].getPotenza();
		this.setPotenze(potenze);
		return potenze;
	}

	public double getPotenza(){
		int i;
		double potenza = 0;
		for(i=0;i<this.getPotenze().length;i++)
			potenza += this.getPotenze()[i];
		potenza = potenza/this.getPotenze().length;
		return potenza;
	}
	
	public Sequenza[] dividiSequenza() {
		Campione[] campioni = this.getCampioni();
		Sequenza[] blocchiSequenza = new Sequenza[100];
		int i, j, n;
		n = 0;
		for (j=0; j<100; j++) {
			Campione[] temp = new Campione[1000];
			for (i=0; i<1000; i++) {
				temp[i] = campioni[n];
				n++;
			}
			blocchiSequenza[j] = new Sequenza(1000);
			blocchiSequenza[j].setCampioni(temp);
		}
		return blocchiSequenza;
	}

	public double[] potenzeBlocchi(Sequenza[] blocchi) {
		double[] potenze = new double[100];
		int i;
		for (i=0; i<blocchi.length; i++)
			potenze[i] = blocchi[i].getPotenza();
		return potenze;
	}
}
