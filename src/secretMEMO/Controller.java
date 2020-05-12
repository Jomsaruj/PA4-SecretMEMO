package secretMEMO;


import encryptdecrypt.FileHandler;
import encryptdecrypt.ReadFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.File;
import encryptdecrypt.WriteFile;

/**
 * Controller for the Secret MEMO application
 * @author Saruj Sattayanurak
 */
public class Controller {
    @FXML
    private AnchorPane scene;// "scene" is the ID of AnchorPane in Decrypt.fxml and Encrypt.fxml

    // elements in Encrypt.fxml
    @FXML
    private TextField destination;// TextField for destination to save .txt file
    @FXML
    private TextField encKey;// TextField for key of encryption
    @FXML
    private TextField encText;// TextField for our memo
    @FXML
    private TextField encName;// TextField for name of .txt file
    @FXML
    private MenuItem e1; //AlphabetShiftCipher
    @FXML
    private MenuItem e2; //UnicodeCipher
    @FXML
    private MenuItem e3; //KeyWordCipher
    @FXML
    private MenuItem e4; //AESCipher

    // element in Decrypt.fxml
    @FXML
    private TextField source;// TextField for name of .txt file
    @FXML
    private TextField decKey;// TextField for name of .txt file
    @FXML
    private TextField decText;// TextField for destination to save .txt file
    @FXML
    private MenuItem d1; //AlphabetShiftCipher
    @FXML
    private MenuItem d2; //UnicodeCipher
    @FXML
    private MenuItem d3; //KeyWordCipher
    @FXML
    private MenuItem d4; //AESCipher

    /**
     * perform switch scene activity.
     * @param event is refer to action event of user.
     * @param destinationPage is name of the .fxml file to switch to.
     */
    private void initComponent(ActionEvent event, Parent destinationPage) {
        Scene destinationScene = new Scene(destinationPage);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(destinationScene);
        window.show();
    }

    /**
     * Activate when user want to creat a new text file.
     * @param event is refer to action event of user.
     */
    public void toEncrypt(ActionEvent event)throws IOException{
        Parent destinationPage = FXMLLoader.load(getClass().getResource("Encrypt.fxml"));
        initComponent(event, destinationPage);
    }

    /**
     * Activate when user want to decrypt a text file.
     * @param event is refer to action event of user.
     */
    public void toDecrypt(ActionEvent event) throws IOException{
        Parent decryptPage = FXMLLoader.load(getClass().getResource("Decrypt.fxml"));
        initComponent(event, decryptPage);
    }

    /**
     * Activate when user want to return to main menu.
     * @param event is refer to action event of user.
     */
    public void toMainMenu(ActionEvent event) throws IOException{
        Parent mainPage = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        initComponent(event, mainPage);
    }

    /**
     * Show a browse dialog scene use for browse directory.
     * @param event is refer to action event of user.
     */
    public void browseDirectory(){
        final DirectoryChooser chooser = new DirectoryChooser();
        Stage stage = (Stage)scene.getScene().getWindow();
        File file = chooser.showDialog(stage);
        if(file != null){destination.setText(file.getAbsolutePath());}
    }

    /**
     * Show a browse dialog scene use for browse source of file.
     * @param event is refer to action event of user.
     */
    public void browseFile(){
        final FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("txt files", "*.txt");
        chooser.getExtensionFilters().add(filter);
        Stage stage = (Stage)scene.getScene().getWindow();
        File file = chooser.showOpenDialog(stage);
        if(file != null){source.setText(file.getAbsolutePath());}
    }

    /**
     * create a .txt file that contain cipher text
     * @param event is refer to action event of user.
     */
    public void saveFile() throws Exception {
        boolean success = false;
        WriteFile ref = new WriteFile();
        if(!destination.getText().isBlank() && !encName.getText().isBlank() && !encKey.getText().isBlank() && !encText.getText().isBlank()){
            // always create .txt file
            String fileName = String.format("%s.txt",encName.getText());
            String dest = String.format("%s/%s",destination.getText(),fileName);
            success = ref.writeFile(encText.getText(), dest, encKey.getText(), getCurrentStrategy());
            if(success){ref.showDialog(String.format("Create  %s  successful",fileName));}
        }
        else {ref.showDialog("Please fill in all the blank");}
    }

    /**
     * read and decrypt .txt file that contain cipher text
     * @param event is refer to action event of user.
     */
    public void decryptFile() throws Exception {
        ReadFile ref = new ReadFile();
        if(!source.getText().isBlank() && !decKey.getText().isBlank()){
            String filename = source.getText();
            String key = decKey.getText();
            decText.setText(ref.readFile(filename, key, getCurrentStrategy()));
        }
        else ref.showDialog("Please fill in all the blank");
    }

    /**
     * clear all textfield for Encrypt.fxml
     * @param event is refer to action event of user.
     */
    public void clearEnc(){
        destination.clear();
        encKey.clear();
        encText.clear();
        encName.clear();
    }

    /**
     * clear all textfield for Decrypt.fxml
     * @param event is refer to action event of user.
     */
    public void clearDec(){
        source.clear();
        decKey.clear();
        decText.clear();
    }

    /**
     * terminate programs
     */
    public void doExit(){
        System.exit(0);
    }

    String currentStrategy = "s1";
    /**
     * set current Strategy
     */
    public void setCurrentStrategy(String currentStrategy){
        this.currentStrategy = currentStrategy;
    }

    /**
     * get Current Strategy
     */
    public String getCurrentStrategy(){return this.currentStrategy;}

    /**
     * get action to set current Strategy
     */
    public void getStrategy(ActionEvent event){
        FileHandler dialog = new FileHandler();
        if(event.getSource() == e1 || event.getSource() == d1){setCurrentStrategy( "s1" );
            dialog.showDialog("Current strategy is Alphabet Shift");
        }
        if(event.getSource() == e2 || event.getSource() == d2){setCurrentStrategy( "s2" );
            dialog.showDialog("Current strategy is Unicode");
        }
        if(event.getSource() == e3 || event.getSource() == d3){setCurrentStrategy( "s3" );
            dialog.showDialog("Current strategy is Keyword");
        }
        if(event.getSource() == e4 || event.getSource() == d4){setCurrentStrategy( "s4" );
            dialog.showDialog("Current strategy is AES");
        }
    }

    /**
     * Show current strategy detail
     */
    public void about(){
        FileHandler ref = new FileHandler();
        if(getCurrentStrategy().equals("s1")) ref.showDialog("current strategy : alphabet shift \n key : number");
        if(getCurrentStrategy().equals("s2")) ref.showDialog("current strategy : unicode \n key : number");
        if(getCurrentStrategy().equals("s3")) ref.showDialog("current strategy : keyword \n key : word");
        if(getCurrentStrategy().equals("s4")) ref.showDialog("current strategy : AES \n key : word");
    }
}
