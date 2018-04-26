import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TextFileCreator {
    
	public static void createTXT(List<WeatherPOJO> weatherPOJOs) throws IOException {
		File file = new File("Report.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("*********************************");
		pw.println("");
		pw.println("  CMT205 - Weather data report");
		pw.println("");
		pw.println("*********************************");
		pw.println("");

		int a = 1;
		
		for(File files: WeatherDataCreator.files) {
			pw.println("Number: " + Integer.toString(a));
			String nameOfStation = new String(files.getName().replaceFirst("[.][^.]+$", ""));
			pw.println("Station: " + nameOfStation);
			pw.println("Highest Mean Temp: " + WeatherPOJO.getOverallHighestTemp(main.weatherPOJOs, nameOfStation));
			pw.println("Lowest Mean Temp: " + WeatherPOJO.getOverallLowestTemp(main.weatherPOJOs, nameOfStation));
			pw.println("Average Annual Airfrost: " + WeatherPOJO.getAirFrostOverallAverage
					(main.weatherPOJOs, nameOfStation, main.yearSet) + " days per year");
			pw.println("Average Annual Rainfall: " + WeatherPOJO.getRainfallOverallAverage
					(main.weatherPOJOs, nameOfStation, main.yearSet) + "mm per year");
			pw.println("");
			a++;
		}
				
		pw.close();
	}
	
	public static void createTXTAtLocation(List<WeatherPOJO> weatherPOJOs, File fileName) throws IOException {
		FileWriter fw = new FileWriter(new File(fileName.getAbsolutePath()) + ".txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("*********************************");
		pw.println("");
		pw.println("  CMT205 - Weather data report");
		pw.println("");
		pw.println("*********************************");
		pw.println("");

		int a = 1;
		
		for(File files: WeatherDataCreator.files) {
			pw.println("Number: " + Integer.toString(a));
			String nameOfStation = new String(files.getName().replaceFirst("[.][^.]+$", ""));
			pw.println("Station: " + nameOfStation);
			pw.println("Highest Mean Temp: " + WeatherPOJO.getOverallHighestTemp(main.weatherPOJOs, nameOfStation));
			pw.println("Lowest Mean Temp: " + WeatherPOJO.getOverallLowestTemp(main.weatherPOJOs, nameOfStation));
			pw.println("Average Annual Airfrost: " + WeatherPOJO.getAirFrostOverallAverage
					(main.weatherPOJOs, nameOfStation, main.yearSet) + " days per year");
			pw.println("Average Annual Rainfall: " + WeatherPOJO.getRainfallOverallAverage
					(main.weatherPOJOs, nameOfStation, main.yearSet) + "mm per year");
			pw.println("");
			a++;
		}
				
		pw.close();
	}
	
	public static ScrollPane showTXTFile() {
		int currentLine = 1;
		ScrollPane s1 = new ScrollPane();
		s1.setPadding(new Insets(10,10,10,20));
		s1.setPrefSize(500, 500);
		s1.setMaxWidth(900);
		VBox vbox = new VBox();
		s1.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("Report.txt")))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
		        	if(currentLine > 5) {		// Starting point for text
		        		if(line.contains("Number")) {
			        		Text text = new Text();
			        		text.setStyle("-fx-font-size:19");
			        		text.setFill(Color.WHITE);
			        		text.setText(line);
			        		HBox hbox = new HBox();
			        		hbox.getChildren().add(text);
			        		vbox.getChildren().add(hbox);
		        		} else {
			        		Text text = new Text();
			        		text.setFill(Color.WHITE);
			        		text.setText(line);
			        		vbox.getChildren().add(text); 	
		        		}
		        	} else {
		        	}
		    currentLine++;
	        }   		
		} catch (IOException e) {
	        e.printStackTrace();
	    }		
		
		s1.setContent(vbox);
		return s1;
	}
}
