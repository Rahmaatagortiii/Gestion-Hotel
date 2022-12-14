/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.picampers.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.picampers.Services.HebergementService;
import com.picampers.entities.Hebergement;
import com.picampers.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.PopOver;
import com.picampers.IServices.IHebergementService;
import com.picampers.Services.HebergementService;
import com.picampers.entities.Hebergement;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Arij
 */
public class HebergementController implements Initializable {
    
int nombre=0;
private PopOver popOver;
private Stage stage;
private static int idusr;
private int selectedcom;    
private static int idcom;
String comusername;    
String texte; 
private String imageFile;

@FXML private TextField valeur;
private TextField descfield;
private Button btn;
private Button annulmodif;
@FXML private Button supprimer;
@FXML private Label lblid;
@FXML private Label lbliduser;
@FXML private Label labelstars;
@FXML private Label labelrooms;
@FXML private Label labeladdress;
@FXML private Label labelname;
@FXML private Label labeldescription;
private Label lbldesc;
@FXML private Label lbldate;  
@FXML private Button retour;
@FXML private Button modifier;
private Button suppcomm;
private Button modifcomm;
private Button modibtn;
@FXML private ImageView img;
@FXML private Label lbluser;
private TextField modifield;      
private ObservableList<ObservableList> data;
private Connection conn; 
private String question;
private String choix1;
private String choix2;
private String choix3;
private String choix4;
private String choix5;
private static int val;

    public static int getIdusr() {
        return idusr;
    }

    public static void setIdusr(int idusr) {
        HebergementController.idusr = idusr;
    }

private static String usr;

    public static String getUsr() {
        return usr;
    }

    public static void setUsr(String usr) {
        HebergementController.usr = usr;
    }
    
    public static int getIdcom() {
        return idcom;
    }

    public static void setIdcom(int idcom) {
        HebergementController.idcom = idcom;
    }

   public static void setVal(int val) {
       HebergementController.val = val;
    }

    public static int getVal() {
        return val;
    }
    @FXML
    private Label lblname;
    @FXML
    private Label lblnbstars;
    @FXML
    private Label lblnbrooms;
    @FXML
    private Label lbladdress;
    @FXML
    private Label lbldescription;
    @FXML
    private Button modifier1;
    @FXML
    private Button supprimer1;
    private Label labelid;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label lblnbr;
    @FXML
    private Label lbldes;
        
 

@FXML
private void handleSupprimerAction(ActionEvent event) throws IOException {
int id=Integer.parseInt(labelid.getText());            
 IHebergementService iHebergementService=new HebergementService();  
 iHebergementService.delete(id);
 Notifications notificationsBuilder = Notifications.create()
                .title("Picampers")
                .text("Sujet Supprim??")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BASELINE_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
                @Override
               public void handle(ActionEvent event) {
                   System.out.println("Cliquer sur la notification");
               }
           });
        notificationsBuilder.darkStyle();
        notificationsBuilder.showError();
 
        Stage stage;
        Parent root;
        stage=(Stage) supprimer.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ListeHebergements.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
 }


@FXML
    private void handleretourAction(ActionEvent event) throws IOException {
    
       Stage stage; 
       Parent root;
       stage=(Stage) retour.getScene().getWindow();
       root = FXMLLoader.load(getClass().getResource("ListeHebergements.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }    

    
    
    private void handlemodibtnAction(ActionEvent event) throws IOException {
   
        try {                   
            Statement stmt = null;
            stmt = conn.createStatement();
            String sql="UPDATE commentaire SET description='"+modifield.getText()+"' where id="+selectedcom+"";
            //  String sql4 = "UPDATE sujet SET titre= 'change' where id="+id+"";
            stmt.executeUpdate(sql);
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheHebergement.fxml"));
        HebergementController controller = loader.getController();
        controller.setVal(val);
        
        Stage stage;
        Parent root;
        stage=(Stage) suppcomm.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("AfficheHebergement.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        } catch (SQLException ex) {
            Logger.getLogger(HebergementController.class.getName()).log(Level.SEVERE, null, ex);
        }}

    
    
  public int getId(String nom){
      int idusr=0;
        try {
 Statement stmt = null;
 conn = DataSource.getMyInstance().getMyConnexion();

          stmt = conn.createStatement();
          String sql2 = "SELECT * FROM utilisateur where username='"+nom+"'";
          ResultSet rs = stmt.executeQuery(sql2);
          while(rs.next()){
               idusr = rs.getInt("id");  
          } } catch (SQLException ex) {    
          Logger.getLogger(Hebergement.class.getName()).log(Level.SEVERE, null, ex);
      }
    return idusr;
}  

   
   @FXML
    private void handlemodifieraction(ActionEvent event) throws IOException {
        
       IHebergementService iHebergementService=new HebergementService();  
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierHebergement.fxml"));
       ModifierHebergementController controller = loader.getController();
       controller.setVal(val);
       controller.setUsr(usr);
       
       
       Stage stage; 
       Parent root;
       stage=(Stage) modifier.getScene().getWindow();
       root = FXMLLoader.load(getClass().getResource("ModifierHebergement.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }    

   @FXML
    private void handlesupprimeraction(ActionEvent event) throws IOException {
 IHebergementService iHebergementService=new HebergementService();  
 iHebergementService.delete(val);
                    handleretourAction(event);

        /*Stage stage; 
       Parent root;
       stage=(Stage) modifier.getScene().getWindow();
       root = FXMLLoader.load(getClass().getResource("AfficheHebergement.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show(); */
        
        
    }    
    
    
     
    
@FXML
    private void handlemodifierAction(ActionEvent event) throws IOException {
       
       IHebergementService iHebergementService=new HebergementService();  
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierHebergement.fxml"));
       ModifierHebergementController controller = loader.getController();
       controller.setVal(val);
       controller.setUsr(usr);
       Stage stage; 
       Parent root;
       stage=(Stage) modifier.getScene().getWindow();
       root = FXMLLoader.load(getClass().getResource("ModifierHebergement.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }   
  
    
    
    private void handleannulmodifAction(ActionEvent event) throws IOException {
       
        descfield.setVisible(true);
        btn.setVisible(true);  
        modifcomm.setVisible(true);
        modifield.setVisible(false);
        modibtn.setVisible(false);
        annulmodif.setVisible(false);     
    }    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
  
  IHebergementService iHebergementService=new HebergementService(); 
  lblid.setText(String.valueOf(val));
//  labelid.setText(String.valueOf(iHebergementService.afficher(val).get(0).getId()));
  
  labelname.setText(iHebergementService.afficher(val).get(0).getName());
  labelstars.setText(String.valueOf(iHebergementService.afficher(val).get(0).getNbStars()));
  labelrooms.setText(String.valueOf(iHebergementService.afficher(val).get(0).getNbRooms()));
  labeladdress.setText(String.valueOf(iHebergementService.afficher(val).get(0).getAddress()));
  labeldescription.setText(iHebergementService.afficher(val).get(0).getDescription());  
  lbldate.setText(String.valueOf(iHebergementService.afficher(val).get(0).getType())); 
    
    
//Image image1 = new Image(getClass().getResourceAsStream(String.valueOf(iSujetService.afficher(val).get(0).getImage())));
//img.setImage(image1);
  
  



  imageFile = iHebergementService.afficher(val).get(0).getImage();
  if(imageFile.equals("")){
  Image imgch=new Image("file:/C:/wamp/www/images/noIMG.PNG");    
  img.setImage(imgch);    
      
  }
  else
  {
  //System.out.println(imageFile);
  Image image1=new Image(imageFile);
  img.setImage(image1);
  }
  
 

  idusr=getId(usr);      
    
    }
}
