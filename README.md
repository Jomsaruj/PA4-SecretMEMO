# PA4 - Secret MEMO Application

Secret MEMO is an application that implements knowledge of Cryptography to perform Encryption and Decryption. Which can help to keep you MEMO safe.

## Video 
Explanation video uploaded on Youtube

https://youtu.be/bZstCo34ywM

## Run

There are 2 (recommended) ways to run my SecretMEMO Application
* Run converter application by IDE (recommended Intellij IDEA)
* Run converter application by command (Terminal)

`Run SecretMEMO application by Intellij`

User can run Converter application by run converter.ConverterApp.java by Intellij IDEA.(For java 11)

* Add javaFX11 to module
    - File -> Project Structure -> Global Libraries -> javaFX11 -> add to modules. -> apply

    ![](README_Image/addtoModule.png)

* Add VM option
    - Run -> edit configurations -> VM options
    - --module-path /path/to/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml

    ![](README_Image/VmOption.png)



`Run SecretMEMO application by terminal`

```bash
java --module-path /Path to/javafx-sdk-11.0.2/lib/ --add-modules javafx.controls,javafx.fxml  -jar SecretMEMO.jar
```












