import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeatherDataCreator {
    private static final String COMMA_DELIMITER = ",";
	static ObservableList<String> data = FXCollections.observableArrayList();
	static File file = new File("src/Stations");			// Location to store weather station data
	static File[] files = file.listFiles();				// Used to create list of files in Stations folder

	public static List<WeatherPOJO> createDataForStations() {
		List<WeatherPOJO> weatherPOJOs = new ArrayList<WeatherPOJO>();
		
		/* Loops through file list, for each file, creates a weatherPOJO, parses the data into 
		 * the objects variables, then adds object to array list weatherPOJOs to b used in program */
		for (File i : files) {			
			File currentFile = i;
			String nameOfStation = new String(currentFile.getName().replaceFirst("[.][^.]+$", ""));
		    data.add(nameOfStation);
				try {
		            BufferedReader br = new BufferedReader(new FileReader(currentFile));
		            String line = " ";
		            while ((line = br.readLine()) != null) {
		            		String[] dataString = line.split(COMMA_DELIMITER);
		            		if(dataString.length > 0) {
		            			WeatherPOJO weatherPOJO = new WeatherPOJO();
		            			weatherPOJO.setStationName(nameOfStation);
		            			weatherPOJO.setYear(Integer.parseInt(dataString[0]));
		            			weatherPOJO.setMonth(Integer.parseInt(dataString[1]));
		            			weatherPOJO.setTempMax(Double.parseDouble(dataString[2]));
		            			weatherPOJO.setTempMin(Double.parseDouble(dataString[3]));
		            			weatherPOJO.setAirFrost(Integer.parseInt(dataString[4]));
		            			weatherPOJO.setRainfall(Double.parseDouble(dataString[5]));
		            			weatherPOJOs.add(weatherPOJO);
		            		}
		            }
				} catch (Exception ee) {
					ee.printStackTrace();
				} 
		}
		return weatherPOJOs;
	}
	
	/* Used to create new weatherPOJO on demand, takes a file and performs same code as above,
	 * adds new weatherPOJO to whatever weatherPOJO list is included in parameters */
	public static String createSinglePOJO(File newFile, List<WeatherPOJO> weatherPOJOs) {
		String nameOfStation = new String(newFile.getName().replaceFirst("[.][^.]+$", ""));
			try {
				BufferedReader br = new BufferedReader(new FileReader(newFile));
				String line = " ";
				while ((line = br.readLine()) != null) {
					String[] dataString = line.split(COMMA_DELIMITER);
					if(dataString.length > 0) {
			    			WeatherPOJO weatherPOJO = new WeatherPOJO();
			    			weatherPOJO.setStationName(nameOfStation);
			    			weatherPOJO.setYear(Integer.parseInt(dataString[0]));
			    			weatherPOJO.setMonth(Integer.parseInt(dataString[1]));
			    			weatherPOJO.setTempMax(Double.parseDouble(dataString[2]));
			    			weatherPOJO.setTempMin(Double.parseDouble(dataString[3]));
			    			weatherPOJO.setAirFrost(Integer.parseInt(dataString[4]));
			    			weatherPOJO.setRainfall(Double.parseDouble(dataString[5]));
			    			weatherPOJOs.add(weatherPOJO);
			    		}
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		files = file.listFiles();
		return nameOfStation;
	}
}

