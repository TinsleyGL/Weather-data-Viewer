import java.util.Arrays;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ChartBuilder {
	
	public static BarChart buildTMaxBarChart() {
		//Defining the x axis               
		CategoryAxis xAxis = new CategoryAxis();   
		        
		xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Month"))); 
		xAxis.setLabel("");  

		//Defining the y axis 
		NumberAxis yAxis = new NumberAxis(); 
		yAxis.setLabel("TMax (\u2103)");
		
		//Creating the Bar chart 
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);  
		barChart.setTitle("Mean maximum temperature per month (TMax) for " + main.yearSelectorTempMax.getValue());
		
		XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
		series1.setName("Jan"); 
		series1.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),1)));
		XYChart.Series<String, Number> series2 = new XYChart.Series<>(); 
		series2.setName("Feb"); 
		series2.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),2)));
		XYChart.Series<String, Number> series3 = new XYChart.Series<>(); 
		series3.setName("Mar"); 
		series3.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),3)));
		XYChart.Series<String, Number> series4 = new XYChart.Series<>(); 
		series4.setName("Apr"); 
		series4.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),4)));
		XYChart.Series<String, Number> series5 = new XYChart.Series<>(); 
		series5.setName("May"); 
		series5.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),5)));
		XYChart.Series<String, Number> series6 = new XYChart.Series<>(); 
		series6.setName("Jun"); 
		series6.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),6)));
		XYChart.Series<String, Number> series7 = new XYChart.Series<>(); 
		series7.setName("Jul"); 
		series7.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),7)));
		XYChart.Series<String, Number> series8 = new XYChart.Series<>(); 
		series8.setName("Aug"); 
		series8.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),8)));
		XYChart.Series<String, Number> series9 = new XYChart.Series<>(); 
		series9.setName("Sept"); 
		series9.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),9)));
		XYChart.Series<String, Number> series10 = new XYChart.Series<>(); 
		series10.setName("Oct"); 
		series10.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),10)));
		XYChart.Series<String, Number> series11 = new XYChart.Series<>(); 
		series11.setName("Nov"); 
		series11.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),11)));
		XYChart.Series<String, Number> series12 = new XYChart.Series<>(); 
		series12.setName("Dec"); 
		series12.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getHighMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMax.getValue(),12)));
		
		barChart.getData().addAll(series1, series2, series3,series4,series5,series6,
				series7,series8,series9,series10,series11,series12);
		
		barChart.setPrefWidth(800);
		
		return barChart;	
	}
	
	public static BarChart buildTMinBarChart() {
		//Defining the x axis               
		CategoryAxis xAxis = new CategoryAxis();   
		        
		xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Month"))); 
		xAxis.setLabel("");  

		//Defining the y axis 
		NumberAxis yAxis = new NumberAxis(); 
		yAxis.setLabel("TMin (\u2103)");
		
		//Creating the Bar chart 
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);  
		barChart.setTitle("Mean minimum temperature per month (TMin) for " + main.yearSelectorTempMin.getValue());
		
		XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
		series1.setName("Jan"); 
		series1.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),1)));
		XYChart.Series<String, Number> series2 = new XYChart.Series<>(); 
		series2.setName("Feb"); 
		series2.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),2)));
		XYChart.Series<String, Number> series3 = new XYChart.Series<>(); 
		series3.setName("Mar"); 
		series3.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),3)));
		XYChart.Series<String, Number> series4 = new XYChart.Series<>(); 
		series4.setName("Apr"); 
		series4.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),4)));
		XYChart.Series<String, Number> series5 = new XYChart.Series<>(); 
		series5.setName("May"); 
		series5.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),5)));
		XYChart.Series<String, Number> series6 = new XYChart.Series<>(); 
		series6.setName("Jun"); 
		series6.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),6)));
		XYChart.Series<String, Number> series7 = new XYChart.Series<>(); 
		series7.setName("Jul"); 
		series7.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),7)));
		XYChart.Series<String, Number> series8 = new XYChart.Series<>(); 
		series8.setName("Aug"); 
		series8.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),8)));
		XYChart.Series<String, Number> series9 = new XYChart.Series<>(); 
		series9.setName("Sept"); 
		series9.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),9)));
		XYChart.Series<String, Number> series10 = new XYChart.Series<>(); 
		series10.setName("Oct"); 
		series10.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),10)));
		XYChart.Series<String, Number> series11 = new XYChart.Series<>(); 
		series11.setName("Nov"); 
		series11.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),11)));
		XYChart.Series<String, Number> series12 = new XYChart.Series<>(); 
		series12.setName("Dec"); 
		series12.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getLowMeanTempForYearAndMonth
	        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorTempMin.getValue(),12)));
		
		barChart.getData().addAll(series1, series2, series3,series4,series5,series6,
				series7,series8,series9,series10,series11,series12);
		
		barChart.setPrefWidth(800);

		return barChart;	
	}
	
	public static BarChart buildTotalAirfrostBarChart() {
		//Defining the x axis               
		CategoryAxis xAxis = new CategoryAxis();   
		        
		xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Month"))); 
		xAxis.setLabel("");  

		//Defining the y axis 
		NumberAxis yAxis = new NumberAxis(); 
		yAxis.setLabel("Airfrost days");
		
		//Creating the Bar chart 
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);  
		barChart.setTitle("Total number of airfrost days per month for " + main.yearSelectorAirfrost.getValue());
		
		XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
		series1.setName("Jan"); 
		series1.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),1)));
		XYChart.Series<String, Number> series2 = new XYChart.Series<>(); 
		series2.setName("Feb"); 
		series2.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),2)));
		XYChart.Series<String, Number> series3 = new XYChart.Series<>(); 
		series3.setName("Mar"); 
		series3.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),3)));
		XYChart.Series<String, Number> series4 = new XYChart.Series<>(); 
		series4.setName("Apr"); 
		series4.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),4)));
		XYChart.Series<String, Number> series5 = new XYChart.Series<>(); 
		series5.setName("May"); 
		series5.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),5)));
		XYChart.Series<String, Number> series6 = new XYChart.Series<>(); 
		series6.setName("Jun"); 
		series6.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),6)));
		XYChart.Series<String, Number> series7 = new XYChart.Series<>(); 
		series7.setName("Jul"); 
		series7.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),7)));
		XYChart.Series<String, Number> series8 = new XYChart.Series<>(); 
		series8.setName("Aug"); 
		series8.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),8)));
		XYChart.Series<String, Number> series9 = new XYChart.Series<>(); 
		series9.setName("Sept"); 
		series9.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),9)));
		XYChart.Series<String, Number> series10 = new XYChart.Series<>(); 
		series10.setName("Oct"); 
		series10.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),10)));
		XYChart.Series<String, Number> series11 = new XYChart.Series<>(); 
		series11.setName("Nov"); 
		series11.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),11)));
		XYChart.Series<String, Number> series12 = new XYChart.Series<>(); 
		series12.setName("Dec"); 
		series12.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalAirfrostDaysForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorAirfrost.getValue(),12)));
		
		barChart.getData().addAll(series1, series2, series3,series4,series5,series6,
				series7,series8,series9,series10,series11,series12);
		
		barChart.setPrefWidth(800);
		
		return barChart;	
	}
	
	public static BarChart buildTotalRainfallBarChart() {
		//Defining the x axis               
		CategoryAxis xAxis = new CategoryAxis();   
		        
		xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Month"))); 
		xAxis.setLabel("");  

		//Defining the y axis 
		NumberAxis yAxis = new NumberAxis(); 
		yAxis.setLabel("Rainfall (mm)");
		
		//Creating the Bar chart 
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);  
		barChart.setTitle("Total rainfall per month for " + main.yearSelectorRainfall.getValue());
		
		XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
		series1.setName("Jan"); 
		series1.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),1)));
		XYChart.Series<String, Number> series2 = new XYChart.Series<>(); 
		series2.setName("Feb"); 
		series2.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),2)));
		XYChart.Series<String, Number> series3 = new XYChart.Series<>(); 
		series3.setName("Mar"); 
		series3.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),3)));
		XYChart.Series<String, Number> series4 = new XYChart.Series<>(); 
		series4.setName("Apr"); 
		series4.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),4)));
		XYChart.Series<String, Number> series5 = new XYChart.Series<>(); 
		series5.setName("May"); 
		series5.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),5)));
		XYChart.Series<String, Number> series6 = new XYChart.Series<>(); 
		series6.setName("Jun"); 
		series6.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),6)));
		XYChart.Series<String, Number> series7 = new XYChart.Series<>(); 
		series7.setName("Jul"); 
		series7.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),7)));
		XYChart.Series<String, Number> series8 = new XYChart.Series<>(); 
		series8.setName("Aug"); 
		series8.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),8)));
		XYChart.Series<String, Number> series9 = new XYChart.Series<>(); 
		series9.setName("Sept"); 
		series9.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),9)));
		XYChart.Series<String, Number> series10 = new XYChart.Series<>(); 
		series10.setName("Oct"); 
		series10.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),10)));
		XYChart.Series<String, Number> series11 = new XYChart.Series<>(); 
		series11.setName("Nov"); 
		series11.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),11)));
		XYChart.Series<String, Number> series12 = new XYChart.Series<>(); 
		series12.setName("Dec"); 
		series12.getData().add(new XYChart.Data<>("Month", WeatherPOJO.getTotalRainfallForYearAndMonth
        		(main.weatherPOJOs, main.stationNameLabelList[0].getText(), 
	        			main.yearSelectorRainfall.getValue(),12)));
		
		barChart.getData().addAll(series1, series2, series3,series4,series5,series6,
				series7,series8,series9,series10,series11,series12);
		
		barChart.setPrefWidth(800);

		return barChart;	
	}

}
