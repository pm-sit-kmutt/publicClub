package publicizehub.club.controller;

import java.sql.ResultSet;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import publicizehub.club.model.GenerateCode;
import publicizehub.club.model.Join;
import publicizehub.club.view.JoinClub;

/**
 *
 * @author ImagineRabbits
 */
public class ShowCodeController {
    Join j = new Join();
    Alert comfirm = new Alert(Alert.AlertType.CONFIRMATION);
    Alert success = new Alert(Alert.AlertType.INFORMATION);
    
    int eventId;
    
    @FXML
    Label codeText;
    @FXML
    Button closeButton;
    
    public Label getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText.setText(codeText);
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    
    
    
    @FXML
    public void unJoinEvent(){
        comfirm.setTitle("ยืนยันการยกเลิก");
        comfirm.setHeaderText("ยืนยันว่าจะยกเลิกจองกิจกรรมนี้");
        comfirm.setContentText("คุณยืนยันที่จะ \"ยกเลิก\" จองใช่หรือไม่");
        Optional<ButtonType> result = comfirm.showAndWait();
        if (result.get() == ButtonType.OK){
            j.deleteCode(codeText.getText(),getEventId());
            success.setHeaderText("ยกเลิกการจอง");
            success.setContentText("ยกเลิกการจอง สำเร็จแล้ว");
            success.showAndWait();
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
            
        }
    }
    
}
