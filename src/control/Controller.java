package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Coder;
import model.Decoder;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private TextField inputText;
    @FXML
    private Button codeBtn;
    @FXML
    private Button decodeBtn;
    @FXML
    private Label outputText;


    private Coder coder = new Coder();
    private Decoder decoder = new Decoder();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        codeBtn.setOnAction(this::translateToMorse);
        decodeBtn.setOnAction(this::translateToPolish);
    }

    private void translateToMorse(ActionEvent event)
    {
        String output = coder.code(inputText.getText());
        this.outputText.setText("Wynik translacji: " + output);
    }

    private void translateToPolish(ActionEvent event)
    {
        String output = decoder.decode(inputText.getText());
        this.outputText.setText("Wynik translacji: " + output);
    }
}

