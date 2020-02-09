package javafx_gui2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Familia Ortega
 */


public class MainMenuController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private Button country;
    @FXML
    private TextField text_sal;
    @FXML
    private TextField text_lleg;
    @FXML
    private Button nextScene;
    @FXML
    private TextField TextUsuario;
    @FXML
    private TextField TextPassw;
    @FXML
    private Button InicioSesion;

    /**
     * Método de creación 
     * popup login
     * @param stage
     * @throws java.io.IOException
     */
      
    public void popup(final Stage stage) throws IOException {         
    final Popup popup = new Popup(); 
  
    Button show = new Button("Show");
    show.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        popup.show(stage);
      }
    });

    Button hide = new Button("Hide");
    hide.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        popup.hide();
      }
    });

        Parent root = FXMLLoader.load(getClass().getResource("Login_Window.fxml"));         
            
        Scene scene = new Scene (root);      
        
        stage.setScene(scene);
        stage.show();
  }

    
    
    /**
     * Método para llamar popup
     * al presionar el login
     * @param event
     * @throws java.io.IOException
     */
    public void loginButtonPushed(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));         
            
        Scene scene = new Scene (root);      
        
        Stage stage= new Stage();
        stage.setScene(scene);

        popup(stage);
    }
    
    /**
     * Método para cambiar a la escena
     * usuario una vez hecho el login
     * @param event
     */
    public void inicioSesionButtonPushed(ActionEvent inicio) throws IOException{
        System.out.println("holi");
        /*Parent inicioSesionParent = FXMLLoader.load(getClass().getResource("Main_Menu.fxml"));
        Scene inicioSesionScene = new Scene (inicioSesionParent);
        
        Stage window = new Stage();
        window .setScene(inicioSesionScene);
        window.show();*/
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }    
    
}
