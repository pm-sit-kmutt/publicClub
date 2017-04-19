package publicizehub.club.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import publicizehub.club.model.Search;
import publicizehub.club.model.ConnectionBuilder;
import java.sql.ResultSet;
import javafx.event.EventHandler;

/**
 *
 * @author Imagine
 */
public class SearchController implements Initializable {
    ConnectionBuilder cb = new ConnectionBuilder();
    JoinController jc = new JoinController();
    DetailController dc = new DetailController();
    Search s = new Search();
    Alert alert = new Alert(AlertType.WARNING);
    @FXML
    private Label label;
    @FXML
    private VBox buttonBox = new VBox();
    @FXML
    private TextField search;
    @FXML
    private Label l;
    
    int checkEvType;
    
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public int getCheckEvType() {
        return checkEvType;
    }

    public void setCheckEvType(int checkEvType) {
        this.checkEvType = checkEvType;
    }

    public TextField getSearch() {
        return search;
    }

    public void setSearch(TextField search) {
        this.search = search;
    }
    
    public void setSearch(String search) {
        try{
            this.search.setText(search);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void addEventToPane(String eventName,int eventId) {
        Pane p = new Pane();
        l= new Label(eventName);
        Button joinbtn = new Button("เข้าร่วม");
        Button detailbtn = new Button("รายละเอียด");
        joinbtn.getStyleClass().add("joinbtnSearch");
        detailbtn.getStyleClass().add("detailbtnSearch");
        joinbtn.setLayoutX(285);
        joinbtn.setLayoutY(100);
        detailbtn.setLayoutX(370);
        detailbtn.setLayoutY(100);
        p.getChildren().add(l);
        p.getChildren().add(joinbtn);
        p.getChildren().add(detailbtn);
        joinbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                jc.toJoinEvent(eventId);
            }
        });
        detailbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                dc.callDetail(eventId);
            }
        });
        buttonBox.setMargin(p,new Insets(15,25,15,30));
        p.setStyle("-fx-background-color: #" + "ffffff" + ";" +
                   "-fx-background-radius: 10px;" +
                   "-fx-effect: dropshadow(three-pass-box, #4d4d4d, 5, 0, 0, 1);");
        l.setStyle("-fx-padding: 30px 0px 0px 50px;"+
                   "-fx-font-size: 30px;"+
                   "-fx-text-fill: #000000;");
        p.setPrefSize(480,150);
        buttonBox.getChildren().add(p);
    }
    
    
    @FXML
    public void checkSearch(){
        ResultSet result;
        buttonBox.getChildren().clear();
        String temp = search.getText();
        if(temp.equals("")||search.getText()==null){
            temp = this.text;
        }
        search.setText("");
        try{
            if(temp.equals("")||temp.charAt(0)==' '){
                temp = "nullEventThatNoMeaning";
                search.setText("");
                alert.setTitle("คำเตือน");
                alert.setHeaderText("กรุณาใส่ชื่อกิจกรรมให้ถูกต้อง!");
                alert.showAndWait();
            } else {
                for (int i = 0; i < temp.length(); i++) {
                    if(temp.charAt(i)=='%'||temp.charAt(i)=='_'||temp.charAt(0)=='\''){
                        temp = "nullEventThatNoMeaning";
                        search.setText("");
                        alert.setTitle("คำเตือน");
                        alert.setHeaderText("กรุณาใส่ชื่อกิจกรรมให้ถูกต้อง!");
                        alert.setContentText("Injection Detected :)");
                        alert.showAndWait();
                    }
                }
            }
            result = s.resultSearch(temp);
            if(result.next()==false){
                temp = "nullEventThatNoMeaning";
                search.setText("");
                alert.setTitle("Warning!");
                alert.setHeaderText("ขออภัย");
                alert.setContentText("ไม่มีกิจกรรมที่คุณค้นหา..");
                alert.showAndWait();
            } else {
                addEventToPane(result.getString("evName"),result.getInt("evId"));
                while(result.next()){
                    addEventToPane(result.getString("evName"),result.getInt("evId"));
                }
            }
        } catch(Exception e){
            temp = "nullEventThatNoMeaning";
        }
        
        System.out.println(temp);

        cb.logout();
    }
    
    @FXML
    public void checkSearchEvType() throws Exception{
        System.out.println("checkSearchEvType");
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/ViewSearch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        if(this.checkEvType==0){
            s.resultEventType(0);
        }
        else if(this.checkEvType==1){
            s.resultEventType(1);
        }
        else {
            s.resultEventType(2);
        }
    }
    
    @FXML
    public ResultSet getEventToGui(String wording){
        ResultSet rs = s.resultSearch(wording);
        return rs;
    }
    
    @FXML
    public void callSearch(String text){
        Stage stage= new Stage();
        Parent root=null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddNews.fxml"));     
        try{
            root = (Parent)fxmlLoader.load(); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        SearchController controller = fxmlLoader.<SearchController>getController();
        controller.setText(text);
        controller.checkSearch();
        Scene scene = new Scene(root); 
        try{
            stage.setScene(scene);    
        }
        catch(Exception e){
            e.printStackTrace();
        }
        stage.show();
    }
}
