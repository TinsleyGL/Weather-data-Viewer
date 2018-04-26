import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DetailedTable {
	public static VBox buildTable() {
		VBox gridBox = new VBox();
		gridBox.getStyleClass().add("tableStyle");
		gridBox.setAlignment(Pos.CENTER);
		gridBox.setPadding(new Insets(60,10,10,20));
		
		GridPane tableGrid = new GridPane();
		tableGrid.setPadding(new Insets(0,15,15,0));
		tableGrid.setHgap(5);
		tableGrid.setVgap(10);

	    Label blank = new Label("");
	    tableGrid.add(blank, 0, 0);
	    Label january = new Label("Jan");
	    january.setStyle("-fx-text-fill: white");
	    tableGrid.add(january, 1, 0);
	    GridPane.setHalignment(january,HPos.CENTER);
	    Label February = new Label("Feb");
	    tableGrid.add(February, 2, 0);
	    GridPane.setHalignment(February,HPos.CENTER);
	    Label March = new Label("Mar");
	    tableGrid.add(March, 3, 0);
	    GridPane.setHalignment(March,HPos.CENTER);
	    Label April = new Label("Apr");
	    tableGrid.add(April, 4, 0);
	    GridPane.setHalignment(April,HPos.CENTER);
	    Label May = new Label("May");
	    tableGrid.add(May, 5, 0);
	    GridPane.setHalignment(May,HPos.CENTER);
	    Label June = new Label("Jun");
	    tableGrid.add(June, 6, 0);
	    GridPane.setHalignment(June,HPos.CENTER);
	    Label July = new Label("Jul");
	    tableGrid.add(July, 7, 0);
	    GridPane.setHalignment(July,HPos.CENTER);
	    Label August = new Label("Aug");
	    tableGrid.add(August, 8, 0);
	    GridPane.setHalignment(August,HPos.CENTER);
	    Label September = new Label("Sept");
	    tableGrid.add(September, 9, 0);
	    GridPane.setHalignment(September,HPos.CENTER);
	    Label October = new Label("Oct");
	    tableGrid.add(October, 10, 0);
	    GridPane.setHalignment(October,HPos.CENTER);
	    Label November = new Label("Nov");
	    tableGrid.add(November, 11, 0);
	    GridPane.setHalignment(November,HPos.CENTER);
	    Label December = new Label("Dec");
	    tableGrid.add(December, 12, 0);
	    GridPane.setHalignment(December,HPos.CENTER);

	    Label highMean = new Label("Monthly mean maximum temperature (tmax)");
	    highMean.setWrapText(true);
	    tableGrid.add(highMean, 0, 1);
	    Label lowMean = new Label("Monthly mean minimum temperature (tmin)");
	    lowMean.setWrapText(true);
	    tableGrid.add(lowMean, 0, 2);
	    Label totalAir = new Label("Air frost days");
	    totalAir.setWrapText(true);
	    tableGrid.add(totalAir, 0, 3);
	    Label totalRainfall = new Label("Rainfall");
	    totalRainfall.setWrapText(true);
	    tableGrid.add(totalRainfall, 0, 4);
	    
	    ColumnConstraints col1 = new ColumnConstraints();
	    col1.setPrefWidth(200);
	    tableGrid.getColumnConstraints().add(col1);
	        
	    for (int x = 0; x < 12; x++ ) {
	        ColumnConstraints col = new ColumnConstraints();
	        col.setPrefWidth(80);
	        tableGrid.getColumnConstraints().add(col);
	    }
	    
	    for(int x = 1, b = 1; x < 13; x++, b++) {		// build data for high mean
	        Label lab = new Label(Double.toString(WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelector.getValue(),b)) + "\u2103");
	        tableGrid.add(lab, x, 1);
	        GridPane.setHalignment(lab,HPos.CENTER);
	     }
	    	    
	    for(int x = 1, b = 1; x < 13; x++, b++) {		// build data for low mean
	        Label lab = new Label(Double.toString(WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelector.getValue(),b)) + "\u2103");
	        tableGrid.add(lab, x, 2);
	        GridPane.setHalignment(lab,HPos.CENTER);
	     }
	    
	    for(int x = 1, b = 1; x < 13; x++, b++) {		//build data for total air frost days
	        Label lab = new Label(Integer.toString(WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
		        			main.yearSelector.getValue(),b)));
	        tableGrid.add(lab, x, 3);
	        GridPane.setHalignment(lab,HPos.CENTER);
	     }
	    
	    for(int x = 1, b = 1; x < 13; x++, b++) {		// build data for total rainfall
	        Label lab = new Label(Double.toString(WeatherPOJO.getTotalRainfallForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
        			main.yearSelector.getValue(),b)));
	        tableGrid.add(lab, x, 4);
	        GridPane.setHalignment(lab,HPos.CENTER);
	     }
	    
	    gridBox.getChildren().add(tableGrid);
	    return gridBox;
	}
}
