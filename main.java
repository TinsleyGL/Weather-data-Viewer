import java.awt.image.RenderedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.geometry.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;


public class main extends Application {
	static List<WeatherPOJO> weatherPOJOs = new ArrayList<WeatherPOJO>();	//creates array of weatherPOJOs
    static Label[] stationNameLabelList = new Label[6];
    static Label stationName = new Label();
    static HBox[] stationNameBoxList = new HBox[6];
    static ChoiceBox<Integer> yearSelector = new ChoiceBox<Integer>();
    static ChoiceBox<Integer> yearSelectorTempMax = new ChoiceBox<Integer>();
    static ChoiceBox<Integer> yearSelectorTempMin = new ChoiceBox<Integer>();
    static ChoiceBox<Integer> yearSelectorAirfrost = new ChoiceBox<Integer>();
    static ChoiceBox<Integer> yearSelectorRainfall = new ChoiceBox<Integer>();
	static Set<Integer> yearSet = new TreeSet<Integer>();

    public static void start(String[] args) {
        launch(args);
      }

    @Override
    public void start(Stage primaryStage) throws IOException {  
    	    	
    		/* Initialising the labels to be used a page titles across the application,
    		 * easier to put in last and refer to by index than different variable names */
    		stationNameLabelList[0] = new Label("Aberporth");
    	    stationNameLabelList[1] = new Label("Aberporth");
    	    stationNameLabelList[2] = new Label("Aberporth");
    	    stationNameLabelList[3] = new Label("Aberporth");
    	    stationNameLabelList[4] = new Label("Aberporth");
    	    stationNameLabelList[5] = new Label("Aberporth");
    		weatherPOJOs = WeatherDataCreator.createDataForStations();
    		
    		/* Initialising download buttons, used to download chart image to user
    		 * computer */
    	    Button[] downloadButtons = new Button[5];
    	    ImageView[] downloadImageview = new ImageView[5];
    	    Image[] downloadImage = new Image[5];
    	    
    	    downloadImage[0] = new Image("/Images/download");
    	    downloadImage[1] = new Image("/Images/download");
    	    downloadImage[2] = new Image("/Images/download");
    	    downloadImage[3] = new Image("/Images/download");
    	    downloadImage[4] = new Image("/Images/download");
    	    downloadImageview[0] = new ImageView(downloadImage[0]);
    	    downloadImageview[1] = new ImageView(downloadImage[1]);
    	    downloadImageview[2] = new ImageView(downloadImage[2]);
    	    downloadImageview[3] = new ImageView(downloadImage[3]);
    	    downloadImageview[4] = new ImageView(downloadImage[4]);
    	    downloadButtons[0] = new Button();
    	    downloadButtons[0].setGraphic(downloadImageview[0]);
    	    downloadButtons[1] = new Button();
    	    downloadButtons[1].setGraphic(downloadImageview[1]);
    	    downloadButtons[2] = new Button();
    	    downloadButtons[2].setGraphic(downloadImageview[2]);
    	    downloadButtons[3] = new Button();
    	    downloadButtons[3].setGraphic(downloadImageview[3]);
    	    downloadButtons[4] = new Button();
    	    downloadButtons[4].setGraphic(downloadImageview[4]);
    	    for(Button a: downloadButtons) {
    	    		a.getStyleClass().add("download-buttons");
    	    }

    		/*Get set of years creates set containing every year in weather data files,
    		 * used set to ensure no duplicates, set then used to populate year selector choiceboxes,
    		 * method called to populate year selectors  */
    		WeatherPOJO.getSetOfYears(weatherPOJOs, yearSet);
    		/* Creates text file report of all weather data files, used in report section */
    		TextFileCreator.createTXT(weatherPOJOs);
    		
    		/* Code to create the weather station selector and add new station button */
		ListView<String> listView = new ListView<String>(WeatherDataCreator.data);
	    listView.setItems(WeatherDataCreator.data);
	    listView.setPrefHeight(700); 
	    
	    GridPane grid = new GridPane();
	    grid.setVgap(10);
	    
	    VBox column1 = new VBox();
	    HBox iconBox = new HBox();
	   
	    Button addIcon = new Button();
	    addIcon.setTooltip(new Tooltip("add new CSV file"));
	    addIcon.setStyle("-fx-background-color: transparent;");
	   
	    /* SVG file as intention was to have icon expand and didn't want to lose image quality,
	     * however wasn't implemented  */
	    SVGPath svg1 = new SVGPath();
	    svg1.setContent("m 273.85671,183.92024 0,-5.11607 c 0,-0.89063 -0.71651,-1.60715 -1.60714,-1.60715 l -9.22767,"
	    		+ "0 0,-9.22767 c 0,-0.89063 -0.71652,-1.60715 -1.60715,-1.60715 l -5.11607,0 c -0.89063,0 -1.60715,0.71652 "
	    		+ "-1.60715,1.60715 l 0,9.22767 -9.22767,0 c -0.89063,0 -1.60715,0.71652 -1.60715,1.60715 l 0,5.11607 c "
	    		+ "0,0.89063 0.71652,1.60715 1.60715,1.60715 l 9.22767,0 0,9.22767 c 0,0.89063 0.71652,1.60714 1.60715,"
	    		+ "1.60714 l 5.11607,0 c 0.89063,0 1.60715,-0.71651 1.60715,-1.60714 l 0,-9.22767 9.22767,0 c 0.89063,"
	    		+ "0 1.60714,-0.71652 1.60714,-1.60715 z");
	    svg1.setStyle("-fx-fill: white");
	    addIcon.setGraphic(svg1);

	    Label stationListLabel = new Label("Station List");
	    iconBox.setAlignment(Pos.CENTER);
	    iconBox.setPadding(new Insets(10));
	    iconBox.getChildren().addAll(stationListLabel,createSpacer(),addIcon);

	    column1.getChildren().addAll(iconBox,listView);
	    stationListLabel.setStyle("-fx-text-fill:white; -fx-font-size:30px");
	    column1.setAlignment(Pos.CENTER);
	    column1.getStyleClass().add("column1");
	    
	    /* TabPane code, used for main navigation between section of application,
	     * set tabs to not close  */
	    TabPane tabpane = new TabPane();
	    TabPane chartTabPane = new TabPane();
	    tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
	    chartTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

	    Tab tab1 = new Tab("Overview");
	    Tab tab2 = new Tab("Historical Data");
	    Tab tab3 = new Tab("Charts");
	    Tab tab4 = new Tab("Report");
	    tabpane.getTabs().addAll(tab1,tab2,tab3,tab4);
	    
	    Tab tmaxChartTab = new Tab("TMax");
	    Tab tminChartTab = new Tab("TMin");
	    Tab airFrostChartTab = new Tab("Air Frost");
	    Tab rainfallChartTab = new Tab("Rainfall");
	    chartTabPane.getTabs().addAll(tmaxChartTab,tminChartTab,airFrostChartTab,rainfallChartTab);
	        
	    /* Separate columns for the different layouts, used below to hold different layouts */
	    VBox column2 = new VBox();
	    VBox column3 = new VBox();
	    VBox column4 = new VBox();
	    VBox column5 = new VBox();
	    VBox column6 = new VBox();
	    VBox column7 = new VBox();
	    VBox column8 = new VBox();

	    /* Overview page layout section, builds the overview page that appears on 
	     * launch of the program */
	    stationNameBoxList[0] = new HBox();
	    stationNameBoxList[0].setAlignment(Pos.CENTER);
	    stationNameBoxList[0].setPadding(new Insets(20,5,10,5));
	    stationNameBoxList[0].getChildren().add(stationNameLabelList[0]);
	    stationNameLabelList[0].getStyleClass().add("ws");
	    column2.getChildren().addAll(stationNameBoxList[0],OverviewTable.buildTable());
	    column2.getStyleClass().add("column2");
	    
	    /* Historical data page layout */
	    stationNameBoxList[1] = new HBox();
	    stationNameBoxList[1].setAlignment(Pos.CENTER);
	    stationNameBoxList[1].setPadding(new Insets(20,5,10,5));
	    stationNameBoxList[1].getChildren().add(stationNameLabelList[1]);
	    stationNameLabelList[1].getStyleClass().add("ws");
	    HBox cont1 = new HBox();
	    cont1.setAlignment(Pos.CENTER);
	    Label instructions = new Label("Select a year: ");
	    instructions.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
	    yearSelector.getItems().addAll(yearSet);
	    yearSelector.getStyleClass().add("year-selectors");
	    yearSelector.getSelectionModel().selectFirst();
	    cont1.getChildren().addAll(instructions,yearSelector);
	    column3.getChildren().addAll(stationNameBoxList[1],cont1,DetailedTable.buildTable());
	    column3.getStyleClass().add("column2");
	    
	    /* TempMax bar chart section layout, builds the chart containing tempMax
	     * details, is later added to tempMax tab */
	    HBox tmaxHbox = new HBox();
	    tmaxHbox.setAlignment(Pos.CENTER);
	    stationNameBoxList[2] = new HBox();
	    stationNameBoxList[2].setAlignment(Pos.CENTER);
	    stationNameBoxList[2].setPadding(new Insets(20,5,10,5));
	    stationNameBoxList[2].getChildren().add(stationNameLabelList[2]);
	    stationNameLabelList[2].getStyleClass().add("ws");
	    HBox cont2 = new HBox();
	    cont2.setAlignment(Pos.CENTER);
	    Label instructions2 = new Label("Select a year: ");
	    instructions2.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
	    yearSelectorTempMax.getStyleClass().add("year-selectors");
	    yearSelectorTempMax.getItems().addAll(yearSet);
	    yearSelectorTempMax.getSelectionModel().selectFirst();
	    tmaxHbox.getChildren().addAll(ChartBuilder.buildTMaxBarChart());
	    tmaxHbox.setPadding(new Insets(20));
	    HBox downButBox1 = new HBox();
	    downButBox1.setAlignment(Pos.CENTER);
	    downButBox1.getChildren().add(downloadButtons[0]);
	    cont2.getChildren().addAll(instructions2,yearSelectorTempMax);
	    column4.getChildren().addAll(stationNameBoxList[2],cont2,tmaxHbox,downButBox1);
	    column4.getStyleClass().add("column2");
	    
	    /* TempMin bar chart section layout, builds the chart containing tempMin
	     * details, is later added to tempMin tab */
	    HBox tminHbox = new HBox();
	    tminHbox.setAlignment(Pos.CENTER);
	    stationNameBoxList[3] = new HBox();
	    stationNameBoxList[3].setAlignment(Pos.CENTER);
	    stationNameBoxList[3].setPadding(new Insets(20,5,10,5));
	    stationNameBoxList[3].getChildren().add(stationNameLabelList[3]);
	    stationNameLabelList[3].getStyleClass().add("ws");
	    HBox cont3 = new HBox();
	    cont3.setAlignment(Pos.CENTER);
	    Label instructions3 = new Label("Select a year: ");
	    instructions3.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
	    yearSelectorTempMin.getStyleClass().add("year-selectors");
	    yearSelectorTempMin.getItems().addAll(yearSet);
	    yearSelectorTempMin.getSelectionModel().selectFirst();
	    cont3.getChildren().addAll(instructions3,yearSelectorTempMin);
	    tminHbox.getChildren().addAll(ChartBuilder.buildTMinBarChart());
	    tminHbox.setPadding(new Insets(20));
	    HBox downButBox2 = new HBox();
	    downButBox2.setAlignment(Pos.CENTER);
	    downButBox2.getChildren().add(downloadButtons[1]);
	    column5.getChildren().addAll(stationNameBoxList[3],cont3,tminHbox,downButBox2);
	    column5.getStyleClass().add("column2");
	    
	    /* airfrost bar chart section layout, builds the chart containing airfrost
	     * details, is later added to airfrost tab */
	    HBox airFrostHbox = new HBox();
	    airFrostHbox.setAlignment(Pos.CENTER);
	    stationNameBoxList[4] = new HBox();
	    stationNameBoxList[4].setAlignment(Pos.CENTER);
	    stationNameBoxList[4].setPadding(new Insets(20,5,10,5));
	    stationNameBoxList[4].getChildren().add(stationNameLabelList[4]);
	    stationNameLabelList[4].getStyleClass().add("ws");
	    HBox cont4 = new HBox();
	    cont4.setAlignment(Pos.CENTER);
	    Label instructions4 = new Label("Select a year: ");
	    instructions4.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
	    yearSelectorAirfrost.getStyleClass().add("year-selectors");
	    yearSelectorAirfrost.getItems().addAll(yearSet);
	    yearSelectorAirfrost.getSelectionModel().selectFirst();
	    cont4.getChildren().addAll(instructions4,yearSelectorAirfrost);
	    airFrostHbox.getChildren().addAll(ChartBuilder.buildTotalAirfrostBarChart());
	    airFrostHbox.setPadding(new Insets(20));
	    HBox downButBox3 = new HBox();
	    downButBox3.setAlignment(Pos.CENTER);
	    downButBox3.getChildren().add(downloadButtons[2]);
	    column6.getChildren().addAll(stationNameBoxList[4],cont4,airFrostHbox,downButBox3);
	    column6.getStyleClass().add("column2");
	    
	    /* rainfall bar chart section layout, builds the chart containing rainfall
	     * details, is later added to rainfall tab */
	    HBox rainfallHbox = new HBox();
	    rainfallHbox.setAlignment(Pos.CENTER);
	    stationNameBoxList[5] = new HBox();
	    stationNameBoxList[5].setAlignment(Pos.CENTER);
	    stationNameBoxList[5].setPadding(new Insets(20,5,10,5));
	    stationNameBoxList[5].getChildren().add(stationNameLabelList[5]);
	    stationNameLabelList[5].getStyleClass().add("ws");
	    HBox cont5 = new HBox();
	    cont5.setAlignment(Pos.CENTER);
	    Label instructions5 = new Label("Select a year: ");
	    instructions5.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
	    yearSelectorRainfall.getStyleClass().add("year-selectors");
	    yearSelectorRainfall.getItems().addAll(yearSet);
	    yearSelectorRainfall.getSelectionModel().selectFirst();
	    cont5.getChildren().addAll(instructions5,yearSelectorRainfall);
	    rainfallHbox.getChildren().addAll(ChartBuilder.buildTotalRainfallBarChart());
	    rainfallHbox.setPadding(new Insets(20));
	    HBox downButBox4 = new HBox();
	    downButBox4.setAlignment(Pos.CENTER);
	    downButBox4.getChildren().add(downloadButtons[3]);
	    
	    column7.getChildren().addAll(stationNameBoxList[5],cont5,rainfallHbox,downButBox4);
	    column7.getStyleClass().add("column2");
	    
	    /* Setting download button code */
	    downloadButtons[0].setOnAction(e -> {
    		downloadChartImage(primaryStage,column4);
	    });
	    downloadButtons[1].setOnAction(e -> {
    		downloadChartImage(primaryStage,column5);
	    });
	    downloadButtons[2].setOnAction(e -> {
    		downloadChartImage(primaryStage,column6);
	    });
	    downloadButtons[3].setOnAction(e -> {
	    		downloadChartImage(primaryStage,column7);
	    });
	    
	    
	    /* Report page code for layout, builds report page with a ScrollPane containing 
	     * weather data text report, and a save icon allowing user to save the report as
	     * a text file to any location */
	    HBox reportHbox = new HBox();
	    reportHbox.getStyleClass().add("ws");
	    reportHbox.setAlignment(Pos.CENTER);
	    reportHbox.setPadding(new Insets(20,5,10,5));
	    reportHbox.getChildren().add(new Label("Weather Data Report"));
	    
	    HBox scrollHbox = new HBox();
	    HBox reportScroller = new HBox();
	    reportScroller.getChildren().add(TextFileCreator.showTXTFile());
	    
	    HBox saveButtonBox = new HBox();
	    saveButtonBox.setPadding(new Insets(0,0,0,100));
	    saveButtonBox.setAlignment(Pos.CENTER);
	    Label saveInstruction = new Label("Save report");
	    saveInstruction.setStyle("-fx-text-fill: white; -fx-font-size: 18px");
	    saveInstruction.setPadding(new Insets(0,0,0,20));
	    saveButtonBox.getChildren().addAll(downloadButtons[4],saveInstruction);
	    
	    downloadButtons[4].setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save report");
			File file = fileChooser.showSaveDialog(primaryStage);
            if(file != null){
            	try {
            		TextFileCreator.createTXTAtLocation(weatherPOJOs, file);
			} catch (IOException e1) {
				e1.printStackTrace();
				}
            	}
	    	});
	    
	    BorderPane reportSave = new BorderPane();
	    reportSave.setCenter(saveButtonBox);
	    
	    scrollHbox.getChildren().addAll(reportScroller,reportSave);
	    column8.getChildren().addAll(reportHbox,scrollHbox);
	    column8.getStyleClass().add("column2");
	    
	    
	    /* Add columns to tabs for use in tabpane */
	    tab1.setContent(column2);
	    tab2.setContent(column3);
	    tab3.setContent(chartTabPane);
	    tab4.setContent(column8);
	    tmaxChartTab.setContent(column4);
	    tminChartTab.setContent(column5);
	    airFrostChartTab.setContent(column6);
	    rainfallChartTab.setContent(column7);
	    
	    
	    /* Build grid using columns, column1 is for weather station list
	     * column 2 contains tables, charts, and report */
	    grid.add(column1, 0, 0);
	    grid.add(tabpane, 1, 0);
	    ColumnConstraints col1Constraints = new ColumnConstraints();
	    col1Constraints.setPercentWidth(20);
	    ColumnConstraints col2Constraints = new ColumnConstraints();
	    col2Constraints.setPercentWidth(80);
	    grid.getColumnConstraints().addAll(col1Constraints,col2Constraints);
        Scene scene = new Scene(grid, 1300, 700);
        
	    /* When new item is selected in station list, relevant sections will be updated to reflect
	     * new station selected, removes the tables and calls their methods again with new input
	     * parameters  */
	    listView.getSelectionModel().selectedItemProperty().addListener(e ->{
				for(Label a:stationNameLabelList) {
					a.setText(listView.getSelectionModel().getSelectedItem());
				}
		    	    column2.getChildren().remove(1);		//removes previous table 
		        column2.getChildren().add(1, OverviewTable.buildTable());
		        column3.getChildren().remove(2);
		        column3.getChildren().add(2, DetailedTable.buildTable());
		        tmaxHbox.getChildren().remove(0);
		        tmaxHbox.getChildren().add(0, ChartBuilder.buildTMaxBarChart());
		        tminHbox.getChildren().remove(0);
		        tminHbox.getChildren().add(0, ChartBuilder.buildTMinBarChart());
		        airFrostHbox.getChildren().remove(0);
		        airFrostHbox.getChildren().add(0, ChartBuilder.buildTotalAirfrostBarChart());
		        rainfallHbox.getChildren().remove(0);
		        rainfallHbox.getChildren().add(0, ChartBuilder.buildTotalRainfallBarChart());
	    });       
	    
	    /* Allows user to add new csv file, also builds new report page data reflecting
	     * new file has been added to program  */
	    addIcon.setOnAction(e ->{
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Add new weather station");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showOpenDialog(primaryStage);
            if(file != null){
            	   copy(file.getAbsolutePath(), file.getName());
            	   listView.getItems().add(WeatherDataCreator.createSinglePOJO(file, weatherPOJOs));
            	}
     	    try {
				TextFileCreator.createTXT(weatherPOJOs);
		     	reportScroller.getChildren().remove(0);
		     	reportScroller.getChildren().add(TextFileCreator.showTXTFile());
     	    } catch (IOException e1) {
     	    		e1.printStackTrace();
     	   }
	    	});
       
	    /* Sets cursor to change when hovered, if not already set up to do so from CSS file */
	    listView.setOnMouseEntered(e -> {
	    		scene.setCursor(Cursor.HAND);
	    });
	    listView.setOnMouseExited(e ->{
	    		scene.setCursor(Cursor.DEFAULT);
	    });
	    addIcon.setOnMouseEntered(e -> {
			scene.setCursor(Cursor.HAND);
	    });
	    addIcon.setOnMouseExited(e ->{
			scene.setCursor(Cursor.DEFAULT);
	    });
	    
	    /* Calls method to assign correct chart building rules for each year selector
	     * see method for details */
	    selectYearChartBuilder(yearSelector,column3,tmaxHbox,tminHbox,airFrostHbox,rainfallHbox);
	    selectYearChartBuilder(yearSelectorTempMax,column3,tmaxHbox,tminHbox,airFrostHbox,rainfallHbox);
	    selectYearChartBuilder(yearSelectorTempMin,column3,tmaxHbox,tminHbox,airFrostHbox,rainfallHbox);
	    selectYearChartBuilder(yearSelectorAirfrost,column3,tmaxHbox,tminHbox,airFrostHbox,rainfallHbox);
	    selectYearChartBuilder(yearSelectorRainfall,column3,tmaxHbox,tminHbox,airFrostHbox,rainfallHbox);
	    	   
        scene.getStylesheets().add("NewFile.css");
	    primaryStage.setScene(scene);
	    
	    primaryStage.show();
	}
    
    /* Similar to station selector list, when new item is selected in year selector,
     * charts and tables will be deleted, then built again using new parameters to get
     * chosen years data */
    public static void selectYearChartBuilder(ChoiceBox<Integer> a, VBox b, HBox c, HBox d, HBox e, HBox f) {
    		a.valueProperty().addListener(new ChangeListener<Integer>() {
	        @Override public void changed(ObservableValue ov, Integer t, Integer t1) {
	        	b.getChildren().remove(2);
	        	b.getChildren().add(2, DetailedTable.buildTable());
	        c.getChildren().remove(0);
	        c.getChildren().add(0, ChartBuilder.buildTMaxBarChart());
	        d.getChildren().remove(0);
	        d.getChildren().add(0, ChartBuilder.buildTMinBarChart());
	        e.getChildren().remove(0);
	        e.getChildren().add(0, ChartBuilder.buildTotalAirfrostBarChart());
	        f.getChildren().remove(0);
	        f.getChildren().add(0, ChartBuilder.buildTotalRainfallBarChart());
	        }
	      });
    }
    
    /* creates a snapshot of the current column containing a chart, then opens a file chooser
     * to allow user to save file under a name of their choice  */
    public static void downloadChartImage(Stage a, VBox b) {
    		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save chart");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(a);
		if(file != null){
			b.setStyle("-fx-background-color: #4281A4");
			WritableImage chartImage = b.snapshot(new SnapshotParameters(), null);
			RenderedImage renderedImage = SwingFXUtils.fromFXImage(chartImage, null);
			try {
				ImageIO.write(renderedImage,"png", file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }
    
    /* Used to copy file selected from file chooser, and make a new copy in the stations folder,
     * allows user to select file from any location and copy it to the program files, essentially
     * updating weather station list */
    public void copy(String from, String to) {
        FileReader fr = null;
        FileWriter fw = null;
		String sep = System.getProperty("file.separator");	// For different file systems
        try {
            fr = new FileReader(from);
            fw = new FileWriter(new File(".").getAbsolutePath() + sep + "src" 
            		+ sep + "Stations" + sep + to ,true);
            int c = fr.read();
            while(c!=-1) {
                fw.write(c);
                c = fr.read();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            close(fr);
            close(fw);
        }
    }
    
    /* closes file reader stream */
    public static void close(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch(IOException e) {
            //...
        }
    }
    
    /* used to create an equal gap between two nodes in an HBox, for consistent layouts */
	public static Node createSpacer() {
	    final Region spacer = new Region();
	    // Make it always grow or shrink according to the available space
	    HBox.setHgrow(spacer, Priority.ALWAYS);
	    return spacer;
	}
}
