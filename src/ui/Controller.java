package ui;

import algorithm.Des;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField textFieldBlock;
    @FXML
    private TextField textFieldKey;
    @FXML
    private TextField textFieldResult;

    @FXML
    private void onButtonEncryptClicked() {
        runOperation(Des.Operation.ENCRYPT);
    }

    @FXML
    private void onButtonDecryptClicked() {
        runOperation(Des.Operation.DECRYPT);
    }

    private void runOperation(Des.Operation operation) {
        try {
            Des des = new Des();
            long block = Long.parseUnsignedLong(textFieldBlock.getText(), 16);
            long key = Long.parseUnsignedLong(textFieldKey.getText(), 16);
            long result;

            switch (operation) {
                case ENCRYPT:
                    result = des.encrypt(block, key);
                    break;
                case DECRYPT:
                    result = des.decrypt(block, key);
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            textFieldResult.setText(String.format("%016X", result));

        } catch (Throwable error) {
            textFieldResult.setText(error.getClass().getSimpleName());
        }
    }
}
