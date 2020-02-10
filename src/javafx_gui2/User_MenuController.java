/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_gui2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Andrés Ortega
 */
public class User_MenuController implements Initializable {
    private Connection con=null;
    private PreparedStatement pds=null;
    private ResultSet rs=null;
    private ObservableList<RutasList>data;
    @FXML
    private Button login;
    @FXML
    private Button country;
    @FXML
    private TableView<RutasList> tableRutas;
    @FXML
    private TableColumn<?, ?> columnColumn1;
    @FXML
    private TableColumn<?, ?> columnid_ruta;
    @FXML
    private TableColumn<?, ?> columnid_avion;
    @FXML
    private TableColumn<?, ?> colimnid_origen;
    @FXML
    private TableColumn<?, ?> columnid_destino;
    @FXML
    private TableColumn<?, ?> columntiempo_salida;
    @FXML
    private TableColumn<?, ?> columnduracion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con=Coneccion.Coneccion2.pmConection();r
        data=FXCollections.observableArrayList();
        setCellTable();
        LoadFromDatabase();
    }    
    private void setCellTable(){
        columnColumn1.setCellValueFactory(new PropertyValueFactory<>("Column1"));
        columnid_ruta.setCellValueFactory(new PropertyValueFactory<>("id_ruta"));
        columnid_avion.setCellValueFactory(new PropertyValueFactory<>("id_avion"));
        colimnid_origen.setCellValueFactory(new PropertyValueFactory<>("id_origen"));
        columnid_destino.setCellValueFactory(new PropertyValueFactory<>("id_destino"));
        columntiempo_salida.setCellValueFactory(new PropertyValueFactory<>("tiempo_salida"));
        columnduracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));                
    }
    private void LoadFromDatabase(){
        try {
            pds= con.prepareStatement("select * from  Java_DB.dbo.Rutas;");
            rs= pds.executeQuery();
                    while(rs.next()){
                        data.add(new RutasList(""+rs.getFloat(1), ""+rs.getFloat(2),""+ rs.getFloat(3), ""+rs.getFloat(4), ""+rs.getFloat(5),""+rs.getFloat(6), ""+rs.getFloat(7)));
                    }
                    } catch (SQLException ex) {
            Logger.getLogger(User_MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableRutas.setItems(data);
    }
    
}
