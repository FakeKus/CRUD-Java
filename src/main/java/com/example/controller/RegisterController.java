package com.example.controller;

import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import com.example.dao.SubjectDAO;
import com.example.forms.Subject;
import com.example.helper.CheckCPF;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegisterController {

    private Subject subject = new Subject();
    private List<Subject> listSubjects;

    private Calendar calendar = Calendar.getInstance();

    private boolean editing;

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
    private ChoiceBox<Integer> choiceDateDay;

    @FXML
    private ChoiceBox<String> choiceDateMonth;

    @FXML
    private ChoiceBox<Integer> choiceDateYear;

    @FXML
    private ChoiceBox<String> choiceGender;

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

    private ObservableList<Subject> subjects;
    private TableColumn<Subject, String> columnName = new TableColumn<>("Nome");
    private TableColumn<Subject, Integer> columnCpf = new TableColumn<>("CPF");
    @FXML
    private TableView<Subject> tableData;

    @FXML
    private TextField textCPF;

    @FXML
    private TextField textName;

    @FXML
    private TextField textRG;

    @FXML
    void btnAddEvent(ActionEvent event) {
        btnDel.setVisible(false);
        btnEdit.setVisible(false);
        btnAdd.setVisible(false);
        btnSave.setVisible(true);
        iconBack.setVisible(true);
        anchorList.setVisible(false);
        anchorRegister.setVisible(true);

        editing = false;

        textName.setText("");
        textCPF.setText("");
        textRG.setText("");
        choiceGender.setValue("Masculino");
        choiceDateDay.setValue(1);
        choiceDateMonth.setValue("Janeiro");
        choiceDateYear.setValue(calendar.get(Calendar.YEAR));
    }

    @FXML
    void btnDelEvent(ActionEvent event) {
        Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType btnSim = new ButtonType("Sim");
        ButtonType btnNao = new ButtonType("Não");

        dialogoExe.setTitle("ATENÇÃO");
        dialogoExe.setHeaderText("Confirme que deseja excluir o registro");
        dialogoExe.setContentText("Nome: " + subject.getName() + ", CPF: " + subject.getCpf());
        dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
        dialogoExe.showAndWait().ifPresent(choice -> {
            if (choice == btnSim) {
                new SubjectDAO().deleteData(subject.getCpf());
                listSubjects = new SubjectDAO().getData();
                subjects.clear();
                subjects.addAll(listSubjects);
                tableData.setItems(subjects);
                subject = null;
                btnDel.setDisable(true);
                btnEdit.setDisable(true);
            } else if (choice == btnNao) {
                this.iconBackEvent(null);
            }
        });
    }

    @FXML
    void btnEditEvent(ActionEvent event) {
        btnDel.setVisible(false);
        btnEdit.setVisible(false);
        btnAdd.setVisible(false);
        btnSave.setVisible(true);
        iconBack.setVisible(true);
        anchorList.setVisible(false);
        anchorRegister.setVisible(true);
        textCPF.setDisable(true);

        editing = true;

        textName.setText(subject.getName());
        textCPF.setText(String.valueOf(subject.getCpf()));
        textRG.setText(String.valueOf(subject.getRg()));
        if (subject.getGender() == 'M') {choiceGender.setValue("Masculino");} else {choiceGender.setValue("Feminino");}
        Date date = subject.getBirthDate();
        int day = date.toLocalDate().getDayOfMonth();
        String month = String.valueOf(date.toLocalDate().getMonth());
        switch (month) {
            case "JANUARY":
                month = "Janeiro";
                break;
            case "FEBRUARY":
                month = "Fevereiro";
                break;
            case "MARCH":
                month = "Março";
                break;
            case "APRIL":
                month = "Abril";
                break;
            case "MAY":
                month = "Maio";
                break;
            case "JUNE": 
                month = "Junho";
                break;
            case "JULY":
                month = "Julho";
                break;
            case "AUGUST":
                month = "Agosto";
                break;
            case "SEPTEMBER":
                month = "Setembro";
                break;
            case "OCTOBER":
                month = "Outubro";
                break;
            case "NOVEMBER":
                month = "Novembro";
                break;
            case "DECEMBER":
                month = "Dezembro";
                break;
            default:
                break;
        }
        int year = date.toLocalDate().getYear();
        choiceDateDay.setValue(day);
        choiceDateMonth.setValue(month);
        choiceDateYear.setValue(year);
    }

    @FXML
    void btnSaveEvent(ActionEvent event) {
        if (editing) {
            if (textName.getText().equals("") || textCPF.getText().equals("") || textRG.getText().equals("")) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Preencha todos os campos");
                dialogoInfo.showAndWait();
            } else {
                Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType btnSim = new ButtonType("Sim");
                ButtonType btnNao = new ButtonType("Não");

                dialogoExe.setTitle("ATENÇÃO");
                dialogoExe.setHeaderText("Confirme que deseja alterar o registro");
                dialogoExe.setContentText("Nome de: " + subject.getName() + ", para: " + textName.getText() + "\n"
                    + "RG de: " + subject.getRg() + ", para: " + textRG.getText() + "\n"
                    + "Gênero de: " + subject.getGender() + ", para: " + choiceGender.getValue().charAt(0) + "\n"
                    + "Data de Nascimento de: " + subject.getBirthDate() + ", para: " + choiceDateYear.getValue() + "-" 
                        + (choiceDateMonth.getSelectionModel().getSelectedIndex() + 1) + "-" + choiceDateDay.getValue());
                dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                dialogoExe.showAndWait().ifPresent(choice -> {
                    if (choice == btnSim) {
                        Subject subject = new Subject.Builder()
                            .setName(textName.getText())
                            .setCpf(Long.parseLong(textCPF.getText()))
                            .setRg(Integer.parseInt(textRG.getText()))
                            .setGender(choiceGender.getValue().charAt(0))
                            .setBirthDate(Date.valueOf(choiceDateYear.getValue() + "-" + (choiceDateMonth.getSelectionModel().getSelectedIndex() + 1) + "-" + choiceDateDay.getValue()))
                            .build();
                        new SubjectDAO().updateData(subject);
                        listSubjects = new SubjectDAO().getData();
                        subjects.clear();
                        subjects.addAll(listSubjects);
                        tableData.setItems(subjects);
                        this.iconBackEvent(null);
                    } else if (choice == btnNao) {
                        this.iconBackEvent(null);
                    }
                });
            }
        } else {
            if (textName.getText().equals("") || textCPF.getText().equals("") || textRG.getText().equals("")) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Preencha todos os campos");
                dialogoInfo.showAndWait();
            } else {
                if (!CheckCPF.isCPF(textCPF.getText())) {
                    Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                    dialogoInfo.setTitle("ATENÇÃO");
                    dialogoInfo.setHeaderText("CPF inválido");
                    dialogoInfo.showAndWait();
                    return;
                } else {
                    Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
                    ButtonType btnSim = new ButtonType("Sim");
                    ButtonType btnNao = new ButtonType("Não");

                    dialogoExe.setTitle("ATENÇÃO");
                    dialogoExe.setHeaderText("Confirme que deseja salvar o registro");
                    dialogoExe.setContentText("Nome: " + textName.getText() + ", CPF: " + textCPF.getText());
                    dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
                    dialogoExe.showAndWait().ifPresent(choice -> {
                        if (choice == btnSim) {
                            Subject subject = new Subject.Builder()
                                .setName(textName.getText())
                                .setCpf(Long.parseLong(textCPF.getText()))
                                .setRg(Integer.parseInt(textRG.getText()))
                                .setGender(choiceGender.getValue().charAt(0))
                                .setBirthDate(Date.valueOf(choiceDateYear.getValue() + "-" + (choiceDateMonth.getSelectionModel().getSelectedIndex() + 1) + "-" + choiceDateDay.getValue()))
                                .build();
                            new SubjectDAO().insertData(subject);
                            listSubjects = new SubjectDAO().getData();
                            subjects.clear();
                            subjects.addAll(listSubjects);
                            tableData.setItems(subjects);
                            this.iconBackEvent(null);
                        } else if (choice == btnNao) {
                            this.iconBackEvent(null);
                        }
                    });
                }
            }
        }
    }

    @FXML
    void iconBackEvent(MouseEvent event) {
        btnDel.setVisible(true);
        btnEdit.setVisible(true);
        btnAdd.setVisible(true);
        btnSave.setVisible(false);
        iconBack.setVisible(false);
        anchorList.setVisible(true);
        anchorRegister.setVisible(false);
    }

    @FXML
    void tableDataEvent(MouseEvent event) {
        if (tableData.getSelectionModel().getSelectedItem() != null) {
            //System.out.println(tableData.getSelectionModel().getSelectedItem().getName());
            subject = tableData.getSelectionModel().getSelectedItem();
            btnDel.setDisable(false);
            btnEdit.setDisable(false);
        } else {
            subject = null;
            btnDel.setDisable(true);
            btnEdit.setDisable(true);
        }
    }

    @FXML
    void textRGEvent(KeyEvent event) {

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
        assert tableData != null : "fx:id=\"tableData\" was not injected: check your FXML file 'Register.fxml'.";
        assert textCPF != null : "fx:id=\"textCPF\" was not injected: check your FXML file 'Register.fxml'.";
        assert textName != null : "fx:id=\"textName\" was not injected: check your FXML file 'Register.fxml'.";
        assert textRG != null : "fx:id=\"textRG\" was not injected: check your FXML file 'Register.fxml'.";

        //Carregando as imagens
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

        //Iniciando a Tabela
        listSubjects = new SubjectDAO().getData();
        subjects = FXCollections.observableArrayList();
        subjects.addAll(listSubjects);
        columnName.setCellValueFactory(new PropertyValueFactory<Subject, String>("name"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<Subject, Integer>("cpf"));
        columnName.setPrefWidth(190);
        columnName.setMinWidth(190);
        columnName.setResizable(false);
        columnCpf.setPrefWidth(190);
        columnCpf.setMinWidth(190);
        columnCpf.setResizable(false);
        tableData.getColumns().add(columnName);
        tableData.getColumns().add(columnCpf); 
        tableData.setItems(subjects);

        //Iniciando os ChoiceBox
        choiceGender.getItems().addAll("Masculino", "Feminino");
        for (int day = 1; day <= 31; day = day + 1) {choiceDateDay.getItems().add(day);}
        choiceDateMonth.getItems().addAll("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", 
            "Outubro", "Novembro", "Dezembro");
        for (int year = (calendar.get(Calendar.YEAR) - 121); year <= calendar.get(Calendar.YEAR); year = year + 1) {choiceDateYear.getItems().add(year);}
    }

}
