package it.polito.tdp.spellchecker.model;

import java.util.*;
import java.io.*;

public class Dictionary {

	private Set<String> dizionario; // LinkedHashSet ma non mi interessa ordinamento
	private int conta;
	private double tempo;
	
	public Dictionary() {
		super();
		this.dizionario = new HashSet<>();
		conta=0;
		

	}

	public void loadDictionary(String language) {

		if (language.equals("English")) {
			try {
				FileReader fr = new FileReader("src/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);

				String word;
				while ((word = br.readLine()) != null) {

					this.dizionario.add(word); //minuscolo???

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
	
	
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord> errate = new LinkedList<>();
		this.conta=0;
		
		double start= System.nanoTime();
		
		for(String s: inputTextList)
		{
	
			
			if(!this.dizionario.contains(s)) 
			{
				RichWord temp= new RichWord(s); 
				temp.setCorretta(false);
				conta++;
				
				errate.add(temp);
				
				
			}
		}
			
		double finish= System.nanoTime();
		this.tempo= finish-start;
		
		return errate;
		
	}

	public int getConta() {
		return conta;
	}
	
	

	public double getTempo() {
		
		return tempo/1e9; // diviso 10 alla 9
	}
	
	

	
}
