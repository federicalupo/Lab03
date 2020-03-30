package it.polito.tdp.spellchecker.model;

import java.util.*;
import java.io.*;

public class Dictionary {

	// private Set<String> dizionario; // LinkedHashSet ma non mi interessa
	// ordinamento
	private List<String> dizionario;

	private int conta;
	private double tempo;

	public Dictionary() {
		super();
		//this.dizionario = new HashSet<>();
		this.dizionario = new LinkedList<>();
		//this.dizionario= new ArrayList<>();
		conta = 0;

	}

	public void loadDictionary(String language) {

		if (language.equals("English")) {
			try {
				FileReader fr = new FileReader("src/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);

				String word;
				while ((word = br.readLine()) != null) {

					this.dizionario.add(word); 

				}

				br.close();

			} catch (IOException ioe) {
				System.out.println("Errore nella lettura del file");
			}

		} else if (language.equals("Italian")) {

			try {
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
				BufferedReader br = new BufferedReader(fr);

				String word;
				while ((word = br.readLine()) != null) {

					this.dizionario.add(word);

				}

				br.close();

			} catch (IOException ioe) {
				System.out.println("Errore nella lettura del file");
			}

		}

	}

	public List<RichWord> spellCheckTextLinear(List<String> inputTextList) {

		List<RichWord> errate = new LinkedList<>();

		this.conta = 0;

		double start = System.nanoTime();

		for (String s : inputTextList) {

			RichWord temp = new RichWord(s);

			for (String d : this.dizionario) {
				if (s.equals(d)) {
					temp.setCorretta(true);
					// devo scandire tutto prima - uso flag, perche se metto if !equals, se magari è
					// in terza posizione per le prime due posizioni entra nell'if, invece così
					// scandisce tutto per trovarla,
					// se alla fine non la trova aggiunge alle errate

				}
			}
			if (!temp.isCorretta()) {
				this.conta++;

				errate.add(temp);

			}

		}

		double finish = System.nanoTime();
		this.tempo = finish - start;

		return errate;

	}

	public List<RichWord> spellCheckTextDichotomic(List<String> inputTextList) {

		List<RichWord> errate = new LinkedList<>();
		this.dizionario.sort(null); 
		this.conta = 0;

		int dim = this.dizionario.size();
		int meta= dim/2;

		double start = System.nanoTime();

		for (String s : inputTextList) {

			RichWord temp = new RichWord(s);

			if (!this.dizionario.get(meta).equals(s)) {
				if (this.dizionario.get(meta).compareTo(s) > 0) {

					for (int i = 0; i < meta; i++) {

						if (this.dizionario.get(i).equals(s)) {
							temp.setCorretta(true);
							
						}

					}
					if (!temp.isCorretta()) {
						this.conta++;
						errate.add(temp);
					}

				} else if (this.dizionario.get(meta).compareTo(s) < 0) {

					for (int i = meta; i < dim; i++) {

						if (this.dizionario.get(i).equals(s)) {
							temp.setCorretta(true);
							
						}

					}
					if (!temp.isCorretta()) {
						this.conta++;
						errate.add(temp);
					}

				}
			} else {
				temp.setCorretta(true);
			}

		}

		double finish = System.nanoTime();
		this.tempo = finish - start;

		return errate;

	}

	public int getConta() {
		return conta;
	}

	public double getTempo() {

		return tempo / 1e9; // diviso 10 alla 9
	}

}
