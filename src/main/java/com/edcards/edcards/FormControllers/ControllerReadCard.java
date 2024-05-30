package com.edcards.edcards.FormControllers;

import com.edcards.edcards.ApplicationMain;
import com.edcards.edcards.ClassControllers.GlobalVAR;
import com.edcards.edcards.Programa.Classes.Admin;
import com.edcards.edcards.Programa.Classes.Aluno;
import com.edcards.edcards.Programa.Classes.Funcionario;
import com.edcards.edcards.Programa.Controllers.LerCartao;
import com.edcards.edcards.Programa.DataTable.CartaoBLL;
import com.edcards.edcards.Programa.DataTable.UsersBLL;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.smartcardio.CardException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class ControllerReadCard implements Initializable {


//   Aluno aluno = new Aluno("5B09593B","leo",0.0,null,true,"adada",2007,"0/0/0000",219892,true,91,true,new Turma(1,1,null,null));
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            LerCartao lerCartao = new LerCartao();
            String idCartao = "";
            try {
                idCartao = lerCartao.lerIDCartao();
            } catch (CardException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(idCartao);
//            int x = CartaoBLL.getIdUserByNFC(idCartao);
//            if (x == 0) {
//                return;
//            }
//            var pessoa = UsersBLL.getUser(x);
//            if (pessoa == null) {
//                return;
//            }
//            if (pessoa instanceof Aluno) {
//                GlobalVAR.Dados.setAlunoAtual((Aluno) pessoa);
//            } else if (pessoa instanceof Funcionario) {
//                GlobalVAR.Dados.setFuncionarioAtual((Funcionario) pessoa);
//            } else if (pessoa instanceof Admin) {
//                GlobalVAR.Dados.setAdminAtual((Admin) pessoa);
//            }

            Platform.runLater(() -> {
                try {
                    Change();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    };





    public void Change() throws IOException {

        Parent root = FXMLLoader.load(ApplicationMain.class.getResource("PIN.fxml"));
        Scene scene = new Scene(root);
        GlobalVAR.Dados.currentStage.setScene(scene);
        GlobalVAR.Dados.currentStage.show();

    }

    private void onLoad() {
        timer.scheduleAtFixedRate(timerTask, 0, 3000);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       onLoad();
   }
    public void switchScene(String fxmlFile)
    {



    }
}
