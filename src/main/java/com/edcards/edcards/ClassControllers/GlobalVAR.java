package com.edcards.edcards.ClassControllers;

import com.edcards.edcards.Programa.Classes.Admin;
import com.edcards.edcards.Programa.Classes.Aluno;
import com.edcards.edcards.Programa.Classes.Funcionario;
import com.edcards.edcards.Programa.Classes.Pessoa;
import com.edcards.edcards.Programa.Controllers.LerCartao;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
public class GlobalVAR {
    public static class Dados {

        private static Admin adminAtual;
        private static Funcionario funcionarioAtual;
        private static Aluno alunoAtual;
        private static Pessoa pessoaAtual;

        public static Stage getCurrentStage() {
            return currentStage;
        }

        public static void setCurrentStage(Stage currentStage) {
            Dados.currentStage = currentStage;
        }

        public static Stage currentStage;

        public static Funcionario getFuncionarioAtual() {
            return funcionarioAtual;
        }

        public static void setFuncionarioAtual(Funcionario funcionarioAtual) {
            Dados.funcionarioAtual = funcionarioAtual;
        }

        public static Aluno getAlunoAtual() {
            return alunoAtual;
        }

        public static void setAlunoAtual(Aluno alunoAtual) {
            Dados.alunoAtual = alunoAtual;
        }

        public static Admin getAdminAtual() {
            return adminAtual;
        }

        public static void setAdminAtual(Admin adminAtual) {
            Dados.adminAtual = adminAtual;
        }

        public static void setPessoaAtual(Pessoa pessoa) {
            pessoaAtual = pessoa;
        }
        public static Pessoa getPessoaAtual() {
            return pessoaAtual;
        }

        public static void setCartaoAtual(String cartao) {
        }

    }


    public static class ImageController {
        public static BufferedImage byteArrayToImage(byte[] byteArray) throws IOException {
            ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
            return ImageIO.read(bais);
        }

        public static byte[] imageToByteArray(BufferedImage image, String format) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, format, baos);
            return baos.toByteArray();
        }

    }



}
