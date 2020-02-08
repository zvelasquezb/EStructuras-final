
package javafx_gui2;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import java.text.*;
import java.util.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.stage.*; 
import javafx.geometry.*;

/**
 *
 * @author Andres Ortega
 */
public class JavaFX_GUI2 extends Application {
    
    Stage window;
    Scene main,menu,lista,vuelo;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene window = new Scene (root);
        
        primaryStage.setScene(window);
        primaryStage.show();
        
    }
    
    
    public static void main(String[] args) {
        launch(args);
    } 
}
