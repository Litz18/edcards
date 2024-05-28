package com.edcards.edcards.Programa.Controllers;

import javafx.scene.image.Image;

import java.io.*;

public class ImageController {
    public static byte[] convertImgToByteArr(File file) throws IOException { //new
        byte[] foto;
        try (InputStream fis = new FileInputStream(file)) {
            foto = fis.readAllBytes();
        }
        return foto;
    }

    public static Image convertByteToImage(byte[] foto){   //new
        return new Image(new ByteArrayInputStream(foto));
    }
}
