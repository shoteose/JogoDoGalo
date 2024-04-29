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

    private final String x = "X Ganhou!";
    private final String y = "O Ganhou!";
    private final String z = "Recomece o Jogo";
    private final String w = "Empate!";

    private boolean podeJogar = true;
    public Controller() {
    }

    public void resetButton() {
        this.playerTurn = 0;
        this.Botoes = new ArrayList(Arrays.asList(this.Button1, this.Button2, this.Button3, this.Button4, this.Button5, this.Button6, this.Button7, this.Button8, this.Button9));

        for (Button Button : this.Botoes) {
            Button.setDisable(false);
            Button.setText("");
        }

        this.welcomeText.setText("Jogo do Galo");
        this.podeJogar = true;

    }

    public void setupButton(ActionEvent e) {

        if (!podeJogar) {
            this.welcomeText.setText(this.z);
            return;
        }

        Button Button = (Button)e.getSource();
        this.setPlayerSymbol(Button);
        Button.setDisable(true);
        checkForWinner();
        this.count++;

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

        if (this.count == 9) {
            this.welcomeText.setText(this.w);
            this.podeJogar = false;
            this.count = 0;
        }

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
                this.welcomeText.setText(this.x);
                this.podeJogar = false;
                this.count = 0;
            } else if (linha.equals("OOO")) {
                this.welcomeText.setText(this.y);
                this.podeJogar = false;
                this.count = 0;
            }
        }

    }
}