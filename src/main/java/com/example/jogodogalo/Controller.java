package com.example.jogodogalo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text welcomeText;
    ArrayList<Button> Botoes;
    private int playerTurn = 0;
    @FXML
    private Button Button1;
    @FXML
    private Button Button2;
    @FXML
    private Button Button3;
    @FXML
    private Button Button4;
    @FXML
    private Button Button5;
    @FXML
    private Button Button6;
    @FXML
    private Button Button7;
    @FXML
    private Button Button8;
    @FXML
    private Button Button9;
    private int count = 0;

    private String x = "X Ganhou!";
    private String y = "O Ganhou!";
    private String z = "Recomece o Jogo";
    private String w = "Empate!";

    public Controller() {
    }

    public void resetButton() {

        this.Botoes = new ArrayList(Arrays.asList(this.Button1, this.Button2, this.Button3, this.Button4, this.Button5, this.Button6, this.Button7, this.Button8, this.Button9));

        for (Button Button : this.Botoes) {
            Button.setDisable(false);
            Button.setText("");
        }

        this.welcomeText.setText("Jogo do Galo");
        this.playerTurn = 0;
    }

    public void setupButton(ActionEvent e) {


        if (this.welcomeText.getText() != this.x && this.welcomeText.getText() != this.y && this.welcomeText.getText() != this.z && this.welcomeText.getText() != this.w) {
            Button Button = (Button)e.getSource();
            Button.setOnMouseClicked((mouseEvent) -> {
                this.setPlayerSymbol(Button);
                Button.setDisable(true);
                this.checkForWinner();
                ++this.count;
            });
        } else {
            this.welcomeText.setText("Recomece o Jogo");
        }

    }

    public void setPlayerSymbol(Button Button) {
        if (this.playerTurn % 2 == 0) {
            Button.setText("X");
            this.playerTurn = 1;
        } else {
            Button.setText("O");
            this.playerTurn = 0;
        }

    }

    public void checkForWinner() {

        for (int a = 0; a < 8; a++) {
            String linha = switch (a) {
                case 0 -> Button1.getText() + Button2.getText() + Button3.getText();
                case 1 -> Button4.getText() + Button5.getText() + Button6.getText();
                case 2 -> Button7.getText() + Button8.getText() + Button9.getText();
                case 3 -> Button1.getText() + Button5.getText() + Button9.getText();
                case 4 -> Button3.getText() + Button5.getText() + Button7.getText();
                case 5 -> Button1.getText() + Button4.getText() + Button7.getText();
                case 6 -> Button2.getText() + Button5.getText() + Button8.getText();
                case 7 -> Button3.getText() + Button6.getText() + Button9.getText();
                default -> null;
            };

            if (linha.equals("XXX")) {
                this.welcomeText.setText("X Ganhou!");
                this.count = 0;
            } else if (linha.equals("OOO")) {
                this.welcomeText.setText("O Ganhou!");
                this.count = 0;
            } else if (this.count == 9) {
                this.welcomeText.setText("Empate!");
                this.count = 0;
            }
        }

    }
}