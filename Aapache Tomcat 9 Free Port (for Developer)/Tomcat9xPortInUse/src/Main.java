import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class Main extends Application {
	
	// == Fields ==
	// == cmd Command ==
	// start cmd before any other cmd command
	private static final String startCmdCommand = "cmd /c";
	// cmd command to find Listening port and kill port
	private static final String findPortCommand = "netstat -o -n -a | findstr 0.0:";
	private static final String killPortCommand = "taskkill /F /PID ";
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage arg0) throws Exception {
		startBox();
	}
	
	private void startBox() {
		TextInputDialog dialog = new TextInputDialog("8080");
		dialog.setTitle("Choose Server Port");
		dialog.setHeaderText("Please Enter the Server Port Number in your Tomcat Setup (the default is 8080)");
		dialog.setContentText("Port Number:");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(TomcatPort -> executeCmd(TomcatPort));
		
	}
	
	private void executeCmd(String TomcatPort) {
		// == fields ==
		Process process;
		BufferedReader reader;
		Runtime runtime;
		String listeningPort;
		try {
			runtime = Runtime.getRuntime();
			// Execute cmd command which is netstat -o -n -a | findstr 0.0:8080
			process = runtime.exec(startCmdCommand + " " + findPortCommand + TomcatPort); 
			
			// Reader the data from the command to find LISTENING port using 8080
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String[] reply = reader.readLine().split(" ");
			listeningPort = reply[reply.length - 1];
			killBox(TomcatPort,  listeningPort);
			
		}catch(IOException e) {
			System.out.println("can not execute cmd command ");
			e.printStackTrace();
		}
	}
	
	private void killBox(String TomcatPort, String listeningPort) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Listening Port confirmation");
		// listening port info
		alert.setHeaderText("LISTENING port for " + TomcatPort + " is " + listeningPort);
		// Confirm with user to kill this listening port
		alert.setContentText("Do you want to kill this " + listeningPort + " ListeningPort ? You will be able to free your Tomcat Server Port ("
							 + TomcatPort + ")");
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.OK) {
			// Forward to execute kill command methods
			killPortExecute(listeningPort);
		}else {}
	}
	
	private void killPortExecute(String listeningPort) {
		// == Fields
		Runtime runtime;
		Process process;
		BufferedReader reader;
		try {
			runtime = Runtime.getRuntime();
			process = runtime.exec(startCmdCommand + killPortCommand + listeningPort);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String confirmation = reader.readLine();
			// confirmationBox after the kill
			confirmationBox(confirmation, listeningPort);
		}catch(IOException e) {
			System.out.println("Error in killing port " + listeningPort);
			e.printStackTrace();
		}
	}
	
	private void confirmationBox(String confirmation, String listeningPort) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Done");
		alert.setHeaderText(null);
		alert.setContentText("killed " + listeningPort + ". You can start to Tomcat Server on Eclipse again");
		alert.showAndWait();
	}

}
