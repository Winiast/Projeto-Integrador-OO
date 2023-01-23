package ifpr.pgua.eic.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Utils {
    public static Alert exibeAlert(AlertType tipo, String mensagem) {
        Alert alert = new Alert(tipo, mensagem);
        return alert;
    }
}
