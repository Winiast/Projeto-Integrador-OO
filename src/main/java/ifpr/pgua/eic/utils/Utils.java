package ifpr.pgua.eic.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Utils {
    public static Alert exibeAlert(AlertType tipo, String mensagem) {
        Alert alert = new Alert(tipo, mensagem);
        return alert;
    }

    public static String gerarSenha(int tamanho) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&";
 
        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
 
        for (int i = 0; i < tamanho; i++) {
            int randomIndex = random.nextInt(chars.length());
            stringBuilder.append(chars.charAt(randomIndex));
        }
 
        return stringBuilder.toString();
    }

    public static String gerarHash(String senha) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-1");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }

            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
