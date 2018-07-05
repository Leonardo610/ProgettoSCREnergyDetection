package scr.model;

public class SequenzeDetection {
	private Sequenza sequenza;
	
	public SequenzeDetection(Sequenza sequenza) {
		this.sequenza = sequenza;
	}
	
	public Sequenza[] dividiSequenza() {
		Campione[] campioni = sequenza.getCampioni();
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
