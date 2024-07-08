import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.*;

public class Main extends Application 
{ 
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    
    Label label; 
    TextField tf;
    Button button;
    VBox vbox;
    Scene scene;
    
    tf = new TextField("Text Field!");
    tf.setMaxWidth(200);

    label = new Label("Type text and click the button");
    button = new Button("Click"); 

    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        label.setText(tf.getText());
      }
    });

    vbox = new VBox(label, tf, button);
    vbox.setSpacing(20);
    vbox.setAlignment(Pos.CENTER);
    scene = new Scene(vbox, 300, 200);
    
    primaryStage.setTitle("Chino's Mod Launcher");
    primaryStage.setScene(scene);
    primaryStage.show();

    URL url = new URL("https://gamebanana.com/apiv11/Mod/Index?_nPerpage=15&_aFilters%5BGeneric_Studio%5D=36854&_nPage=1");

    // Get the input stream through URL Connection
    URLConnection con = url.openConnection();
    InputStream is = con.getInputStream();

    // Once you have the Input Stream, it's just plain old Java IO stuff.

    // For this case, since you are interested in getting plain-text web page
    // I'll use a reader and output the text content to System.out.

    // For binary content, it's better to directly read the bytes from stream and write
    // to the target file.          
    String file = "";
    try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
        String line = null;

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
           file += line + "\n";
        }
    }
    System.out.println(file);
  } 
    
  public static void main(String[] args) {
    launch(args);
  }
} 
