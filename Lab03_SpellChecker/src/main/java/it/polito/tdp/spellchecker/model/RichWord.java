package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola) {
		super();
		this.parola= parola;
		this.corretta=true;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	@Override
	public String toString() {
		
		return parola;
	}

	
		
		
		
		
}
