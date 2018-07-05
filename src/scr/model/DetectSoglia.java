package scr.model;

import java.util.Arrays;

import scr.utility.SequenzaRumore;

public class DetectSoglia {
	private double[] potenze;
	
	public DetectSoglia(double snr) {
		this.potenze = new double[10000];
		for (int i=0; i<potenze.length; i++) {
			SequenzaRumore rumore = new SequenzaRumore(snr);
			potenze[i] = rumore.getPotenza();
		}
		Arrays.sort(potenze);
	}
	
	public double getSoglia() {
		return this.potenze[9989];
	}
}

