package scr.utility;

import java.io.FileNotFoundException;
import java.io.IOException;

import scr.model.Sequenza;
import scr.model.DetectSoglia;

public class Main {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String[] nomiFile = new String[]{"seq_1_SNR_-10dB.dat", "seq_1_SNR_0dB.dat", "seq_1_SNR_10dB.dat",
										"seq_2_SNR_-10dB.dat", "seq_1_SNR_0dB.dat", "seq_1_SNR_10dB.dat"};
		int[] snr = new int[]{-10, 0, 10, -10, 0 , 10};
		for (int j=0; j<nomiFile.length; j++) {
			DetectSoglia trovaSoglia = new DetectSoglia(snr[j]);
			double soglia = trovaSoglia.getSoglia();
			StreamDati sd = new StreamDati(nomiFile[j]);
			System.out.println("\n\nNome file: " + nomiFile[j] + "; SNR: " + snr[j] + ";");
			Sequenza[] sequenze = sd.leggiSegnaleDaFile().dividiSequenza();
			int hit = 0;
			int i;
			System.out.println("La soglia e': " + soglia);
			for (i=0; i<sequenze.length; i++) {
				sequenze[i].calcolaPotenze();
				if (sequenze[i].getPotenza()>=soglia)
					hit++;
			}
			System.out.println("Percentuale di detection: " + hit + " %");
			
		}
	}
}
