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
            Pessoa pessoa = cartaoLido();
            try {
                if (pessoa != null) {
                    FXMLLoader pinLoader = new FXMLLoader(getClass().getResource("PinInput.fxml"));
                    Parent pinRoot = pinLoader.load();
                    Scene pinScene = new Scene(pinRoot);
                    stage.setScene(pinScene);
                } else {
                    System.err.println("Nenhum user encontrado");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
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
            return pessoa;
        } else {
            System.err.println("User Não Encontrado");
            return null;
        }
    }


    public static void main(String[] args) {
        launch();
    }
}