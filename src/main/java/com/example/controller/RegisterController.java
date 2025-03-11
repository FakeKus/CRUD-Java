package com.example.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorBtn;

    @FXML
    private AnchorPane anchorList;

    @FXML
    private AnchorPane anchorLogo;

    @FXML
    private AnchorPane anchorRegister;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private ChoiceBox<?> choiceDateDay;

    @FXML
    private ChoiceBox<?> choiceDateMonth;

    @FXML
    private ChoiceBox<?> choiceDateYear;

    @FXML
    private ChoiceBox<?> choiceGender;

    @FXML
    private ImageView iconAdd;

    @FXML
    private ImageView iconBack;

    @FXML
    private ImageView iconDel;

    @FXML
    private ImageView iconEdit;

    @FXML
    private ImageView iconSave;

    @FXML
    private ImageView imgLogo;

    @FXML
    private ListView<?> listData;

    @FXML
    private TextField textCPF;

    @FXML
    private TextField textName;

    @FXML
    private TextField textRG;

    @FXML
    void btnAddEvent(ActionEvent event) {

    }

    @FXML
    void btnDelEvent(ActionEvent event) {

    }

    @FXML
    void btnEditEvent(ActionEvent event) {

    }

    @FXML
    void btnSaveEvent(ActionEvent event) {

    }

    @FXML
    void iconBackEvent(MouseEvent event) {

    }

    @FXML
    void textCPFEvent(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert anchorBtn != null : "fx:id=\"anchorBtn\" was not injected: check your FXML file 'Register.fxml'.";
        assert anchorList != null : "fx:id=\"anchorList\" was not injected: check your FXML file 'Register.fxml'.";
        assert anchorLogo != null : "fx:id=\"anchorLogo\" was not injected: check your FXML file 'Register.fxml'.";
        assert anchorRegister != null : "fx:id=\"anchorRegister\" was not injected: check your FXML file 'Register.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'Register.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'Register.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'Register.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'Register.fxml'.";
        assert choiceDateDay != null : "fx:id=\"choiceDateDay\" was not injected: check your FXML file 'Register.fxml'.";
        assert choiceDateMonth != null : "fx:id=\"choiceDateMonth\" was not injected: check your FXML file 'Register.fxml'.";
        assert choiceDateYear != null : "fx:id=\"choiceDateYear\" was not injected: check your FXML file 'Register.fxml'.";
        assert choiceGender != null : "fx:id=\"choiceGender\" was not injected: check your FXML file 'Register.fxml'.";
        assert iconAdd != null : "fx:id=\"iconAdd\" was not injected: check your FXML file 'Register.fxml'.";
        assert iconBack != null : "fx:id=\"iconBack\" was not injected: check your FXML file 'Register.fxml'.";
        assert iconDel != null : "fx:id=\"iconDel\" was not injected: check your FXML file 'Register.fxml'.";
        assert iconEdit != null : "fx:id=\"iconEdit\" was not injected: check your FXML file 'Register.fxml'.";
        assert iconSave != null : "fx:id=\"iconSave\" was not injected: check your FXML file 'Register.fxml'.";
        assert imgLogo != null : "fx:id=\"imgLogo\" was not injected: check your FXML file 'Register.fxml'.";
        assert listData != null : "fx:id=\"listData\" was not injected: check your FXML file 'Register.fxml'.";
        assert textCPF != null : "fx:id=\"textCPF\" was not injected: check your FXML file 'Register.fxml'.";
        assert textName != null : "fx:id=\"textName\" was not injected: check your FXML file 'Register.fxml'.";
        assert textRG != null : "fx:id=\"textRG\" was not injected: check your FXML file 'Register.fxml'.";

        imgLogo.setImage(new Image(getClass()
            .getResourceAsStream("/com/example/icons/MainLogo.png")));
        iconBack.setImage(new Image(getClass()
            .getResourceAsStream("/com/example/icons/Back.png")));
        iconAdd.setImage(new Image(getClass()
            .getResourceAsStream("/com/example/icons/Add.png")));
        iconDel.setImage(new Image(getClass()
            .getResourceAsStream("/com/example/icons/Del.png")));        
        iconEdit.setImage(new Image(getClass()  
            .getResourceAsStream("/com/example/icons/Edit.png")));
        iconSave.setImage(new Image(getClass()
            .getResourceAsStream("/com/example/icons/Save.png")));
        
    }

}
