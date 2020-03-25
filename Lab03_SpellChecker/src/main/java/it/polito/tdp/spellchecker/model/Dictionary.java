package it.polito.tdp.spellchecker.model;

import java.util.*;
import java.io.*;

public class Dictionary {

	Set<String> dizionario; // LinkedHashSet ma non mi interessa ordinamento

	public Dictionary() {
		super();
		this.dizionario = new HashSet<>();

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
		
		for(String s: inputTextList)
		{
	
			
			if(!this.dizionario.contains(s)) //contains dice se contiene! quindi equals???
			{
				RichWord temp= new RichWord(s); 
				temp.setCorretta(false);
				
				errate.add(temp);
				
				
			}
		}
		
		
			
			
		return errate;
		
	}

	/*
	public boolean cerca(String cercare)
	{
		for(String s: this.dizionario)
		{
			if(s.equals(cercare))
				return true;
		}
		
		
		return false;
	}*/
}
