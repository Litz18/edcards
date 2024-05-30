package com.edcards.edcards.FormControllers;

import com.edcards.edcards.Programa.Classes.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.edcards.edcards.ClassControllers.GlobalVAR;
import javax.swing.JOptionPane;



public class ControllerPIN {
    private int valorAtual;

    @FXML
    private TextField field1, field2, field3, field4, field5, field6;

    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    private int pin;
    @FXML
    public void initialize(){
        valorAtual = 0;
        btn0.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn0.getText());
            colocarDigitos();
        });
        btn1.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn1.getText());
            colocarDigitos();
        });
        btn2.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn2.getText());
            colocarDigitos();
        });
        btn3.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn3.getText());
            colocarDigitos();
        });
        btn4.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn4.getText());
            colocarDigitos();
        });
        btn5.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn5.getText());
            colocarDigitos();
        });
        btn6.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn6.getText());
            colocarDigitos();
        });
        btn7.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn7.getText());
            colocarDigitos();
        });
        btn8.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn8.getText());
            colocarDigitos();
        });
        btn9.setOnAction(event -> {
            valorAtual = Integer.parseInt(btn9.getText());
            colocarDigitos();
        });

    }
    private void colocarDigitos() {
        if (field1.getText().isEmpty()){
            field1.setText(String.valueOf(valorAtual));
        } else if(field2.getText().isEmpty()){
            field2.setText(String.valueOf(valorAtual));
        } else if(field3.getText().isEmpty()){
            field3.setText(String.valueOf(valorAtual));
        } else if(field4.getText().isEmpty()){
            field4.setText(String.valueOf(valorAtual));
        } else if(field5.getText().isEmpty()){
            field5.setText(String.valueOf(valorAtual));
        } else if(field6.getText().isEmpty()){
            field6.setText(String.valueOf(valorAtual));
            pin = Integer.parseInt(field1.getText() + field2.getText() + field3.getText() + field4.getText() + field5.getText() + field6.getText());
            System.out.println(pin);

            Pessoa pessoaAtual = GlobalVAR.Dados.getPessoaAtual();
            if (pessoaAtual != null) {
                int pinDaPessoa = pessoaAtual.getPin();
                if (pin == pinDaPessoa) {
                    JOptionPane.showMessageDialog(null, "O PIN digitado corresponde ao cartão.", "Validação", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "O PIN digitado não corresponde ao cartão.", "Validação", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                System.err.println("Nenhuma pessoa encontrada");
            }
        }
    }
}