package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola) {
		super();
		this.parola= parola;
		this.corretta=false; //nell'es 2 parte da false
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	
	
	public boolean isCorretta() {
		return corretta;
	}

	@Override
	public String toString() {
		
		return parola;
	}

	
		
		
		
		
}
