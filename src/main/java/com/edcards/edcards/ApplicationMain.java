package com.edcards.edcards;

import com.edcards.edcards.Programa.Classes.Pessoa;
import com.edcards.edcards.Programa.Controllers.LerCartao;
import com.edcards.edcards.Programa.DataTable.CartaoBLL;
import com.edcards.edcards.Programa.DataTable.UsersBLL;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.edcards.edcards.ClassControllers.GlobalVAR;

import javax.smartcardio.CardException;

public class ApplicationMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("ReadCard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Aplicação");
        stage.setScene(scene);
        stage.show();
        GlobalVAR.Dados.setCurrentStage(stage);

        Platform.runLater(() -> {
            while (true) {
                Pessoa pessoa = cartaoLido();
                if (pessoa != null) {
                    try {
                        FXMLLoader pinLoader = new FXMLLoader(getClass().getResource("PinInput.fxml"));
                        Parent pinRoot = pinLoader.load();
                        Scene pinScene = new Scene(pinRoot);
                        stage.setScene(pinScene);
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Nenhum usuário encontrado. Aguardando cartão...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public Pessoa cartaoLido(){
        String cartao;
        try {
            cartao = LerCartao.lerIDCartao();
        } catch (CardException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        var userByNFC = CartaoBLL.getUserByNFC(cartao);
        if (userByNFC != null) {
            Pessoa pessoa = UsersBLL.getUser(userByNFC.getIduser());
            System.out.println("ID: " + pessoa.getIduser());
            System.out.println("Número do Cartão: " + pessoa.getNumCartao());
            GlobalVAR.Dados.setPessoaAtual(pessoa);
            return pessoa;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
