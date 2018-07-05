package scr.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

import scr.model.Campione;
import scr.model.Sequenza;

public class StreamDati {
	private LineNumberReader reader;

	public StreamDati(String nomeFile) throws FileNotFoundException {
		try {
			this.reader = new LineNumberReader(new FileReader(nomeFile));
		}
		catch (FileNotFoundException e) {
			System.out.println(nomeFile + " non trovato");
		}
	}

	public Sequenza leggiSegnaleDaFile() throws FileNotFoundException, IOException {
		Sequenza sequenza = new Sequenza(100000);
		BufferedReader br = new BufferedReader(this.reader);
		int i = 0;
		String line = br.readLine();
		while (line!=null) {
			sequenza.getCampioni()[i] = this.leggiECreaCampione(line);
			i++;
			line = br.readLine();
		}
		br.close();
		return sequenza;
	}

	/*Prende i parametri di un oggetto Campione dalla List e crea una nuova istanza Campione*/
	private Campione leggiECreaCampione(String valoriCampione) throws IOException{
		Campione campione = new Campione();
		double[] valori = this.separaStringhe(valoriCampione);
		if (valoriCampione!=null) {
			campione.setParteReale(valori[0]);
			campione.setParteImmaginaria(valori[1]);;
		}
		return campione;
	}

	/*Legge da file una riga composta da due double separati da spazio e li inserisce in una List*/
	private double[] separaStringhe(String string) {
		double[] result = new double[2];
		if (string!=null) {
			Scanner scanner = new Scanner(string);
			result[0] = Double.parseDouble(scanner.next());
			result[1] = Double.parseDouble(scanner.next());
			scanner.close();
		}
		return result;
	}
}
