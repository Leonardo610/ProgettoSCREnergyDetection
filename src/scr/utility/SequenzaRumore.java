package scr.utility;

import java.util.Random;

import scr.model.Campione;
import scr.model.Sequenza;

public class SequenzaRumore {
	private Sequenza sequenza;
	
	public SequenzaRumore(double snr) {
		this.sequenza = this.crea(snr);
	}
	
	public void setSequenza(Sequenza sequenza) {
		this.sequenza = sequenza;
	}
	
	public Sequenza getSequenza() {
		return this.sequenza;
	}

	private Sequenza crea(double snrDb){
		Sequenza sequenza;
		double pot_rumore = 1/(Math.pow(10, snrDb/10));
		double deviazioneStandard = Math.sqrt(pot_rumore/2);
		Random r= new Random();
		sequenza = new Sequenza(1000);
		int i;
		for (i=0; i<1000; i++){
			sequenza.getCampioni()[i] = new Campione(r.nextGaussian()*deviazioneStandard, r.nextGaussian()*deviazioneStandard);
		}
		sequenza.calcolaPotenze();
		return sequenza;
	}
	
	public double getPotenza() {
		return this.sequenza.getPotenza();
	}
}
