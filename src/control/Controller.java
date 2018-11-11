package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Coder;
import model.Decoder;
import model.DictionaryException;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Piotr Musioł
 * @version 1.0
 */

public class Controller implements Initializable
{
    /**
     * input text field
     */
    @FXML
    private TextField inputText;
    @FXML
    /**
     * button used for coding message into Morse code
     */
    private Button codeBtn;
    /**
     * button used for decoding message into Polish
     */
    @FXML
    private Button decodeBtn;
    /**
     * output text field
     */
    @FXML
    private Label outputText;

    /**
     * Instance of Coder Class
     */
    private Coder coder = new Coder();
    /**
     * Instance of Decoder Class
     */
    private Decoder decoder = new Decoder();

    /**
     * Referencing buttons to the handler method
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)  //
    {
        codeBtn.setOnAction(this::translateToMorse);
        decodeBtn.setOnAction(this::translateToPolish);
    }

    /**
     * Coding button handler
     * @param event
     */
    private void translateToMorse(ActionEvent event)
    {
        String output;
        try
        {
            output = coder.code(inputText.getText());
        } catch (DictionaryException e)
        {
            output = e.getMessage();
        }
        this.outputText.setText("Wynik translacji: " + output);
    }

    /**
     *Decoding button handler
     * @param event
     */
    private void translateToPolish(ActionEvent event)
    {
        String output;
        try
        {
            output = decoder.decode(inputText.getText());
        } catch (DictionaryException e)
        {
            output = e.getMessage();
        }
        this.outputText.setText("Wynik translacji: " + output);
    }
}

