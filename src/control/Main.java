package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Morse Translator
 * @author Piotr Musioł
 * @version 1.0
 */

public class Main extends Application
{
    /**
     * Setting up application
     * @param primaryStage Stage class is the top level JavaFX container.
     * @throws Exception various exceptions that can be thrown by class stage objects
     */

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/view/View.fxml"));
        primaryStage.setTitle("Morse Translator");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * @param args command line arguments that are not used because it's not a console program
     */

    public static void main(String[] args)
    {
        launch(args);
    }
}
