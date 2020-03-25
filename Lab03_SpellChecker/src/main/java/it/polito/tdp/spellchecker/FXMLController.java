package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Dictionary model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> bxSeleziona;

	@FXML
	private TextArea txtInserisci;

	@FXML
	private Button btnControlla;

	@FXML
	private TextArea txtErrori;

	@FXML
	private Label txtContaErrori;

	@FXML
	private Button btnPulisci;

	@FXML
	private Label txtTempo;

	@FXML
	void doClearText(ActionEvent event) {

	}

	@FXML
	void doSpellCheck(ActionEvent event) {
		model.loadDictionary(bxSeleziona.getValue());
		
		
		String inputTesto = txtInserisci.getText().toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");

		String array[] = inputTesto.split(" ");

		List<String> input = new LinkedList<>(Arrays.asList(array));
		
		List<RichWord> sbagliate= model.spellCheckText(input);
		
		for(RichWord r: sbagliate)
		{
			txtErrori.appendText(r.toString()+"\n");
			
		}

	}

	@FXML
	void initialize() {
		assert bxSeleziona != null : "fx:id=\"bxSeleziona\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnControlla != null : "fx:id=\"btnControlla\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtContaErrori != null : "fx:id=\"txtContaErrori\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnPulisci != null : "fx:id=\"btnPulisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setModel(Dictionary model) {
		this.bxSeleziona.getItems().addAll("English", "Italian"); // Popolo comboBox in setModel

		this.model = model;
	}
}
