package encryptdecrypt;


import javafx.scene.control.Alert;

/**
 * Parent class of WriteFile and ReadFile
 * @author Saruj Sattayanurak
 */
public class FileHandler {
    /**
     * Give user some advise or some warning on the dialog box
     * @param message to show on the dialog box.
     */
    public void showDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText( message );
        // wait for user to dismiss dialog
        alert.showAndWait();

    }
    /**
     * Display a help message
     */
    public void usage() {
        String name = WriteFile.class.getName();
        String message = String.format("Usage: java %s destinationFile\n", name);
        showDialog(message);
    }

    /**
     * display an error message.
     * @param message the error text to display
     */
    public void error(String message) { showDialog(message); }

    /**
     * check if key is valid
     * @param key to check if key is valid or not.
     * @return true if key is valid, false if not.
     */
    public boolean isValid(String key, String strategy){
        if(strategy.equals("s1") || strategy.equals("s2") ){
            try{ int index = Integer.parseInt(key); }
            catch (NumberFormatException nfe){ error("Invalid key type : key must be a number"); return false; }
        }
        return true;
    }

}
