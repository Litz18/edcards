package com.edcards.edcards.Programa.Controllers;

import javax.smartcardio.*;
import java.util.Scanner;

public class LerCartao {
    public String returnIDCartao() throws CardException, InterruptedException {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String idCartao = readCardId(scanner);

                if (idCartao == null) {
                    System.out.println("Não foi possível ler o ID do cartão NFC. Tente novamente.");
                } else {
                    return idCartao;
                }

                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static String lerIDCartao() throws CardException, InterruptedException {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                Thread.sleep(2000);
                String idCartao = readCardId(scanner);
                return idCartao;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readCardId(Scanner scanner) throws InterruptedException {
        try {
            TerminalFactory factory = TerminalFactory.getDefault();
            CardTerminal terminal = factory.terminals().list().get(0);

            while (true) {
                if (terminal.isCardPresent()) {

                    Card card = terminal.connect("*");
                    CardChannel channel = card.getBasicChannel();

                    CommandAPDU commandAPDU = new CommandAPDU(new byte[]{(byte) 0xFF, (byte) 0xCA, 0x00, 0x00, 0x00});
                    ResponseAPDU responseAPDU = channel.transmit(commandAPDU);

                    byte[] responseData = responseAPDU.getBytes();
                    if (responseAPDU.getSW() != 0x9000) {
                        System.out.println("Não foi possível ler o ID do cartão. Tente novamente.");
                        break;
                    }

                    byte[] uid = new byte[responseAPDU.getData().length];
                    System.arraycopy(responseData, 0, uid, 0, uid.length);

                    String idCartao = byteArrayToHexString(uid);

                    card.disconnect(false);
                    //break; // Saia do loop depois de processar o cartão
                    return idCartao;
                }
            }
        } catch (CardException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }
}