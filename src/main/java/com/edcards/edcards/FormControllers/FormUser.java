package com.edcards.edcards.FormControllers;

import com.edcards.edcards.ClassControllers.GlobalVAR;
import com.edcards.edcards.Programa.Classes.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FormUser {
    @FXML
    Image imageUser;
    @FXML
    Button btnPos;
    @FXML
    Button btnHorario;
    @FXML
    Button btnHistComp;
    @FXML
    Button btnMarcRef;
    @FXML
    Button btnRefMarc;
    @FXML
    String labelNome;
    @FXML
    String labelSaldo;
    @FXML
    String labelTipo;

    @FXML
    public void initialize(){

        Pessoa pessoa = GlobalVAR.Dados.getPessoaAtual();
        imageUser = pessoa.getFoto();
        labelNome = pessoa.getNome();
        labelSaldo = String.valueOf(pessoa.getSaldo());
        labelTipo = String.valueOf(pessoa.getTipo());

    }
}
