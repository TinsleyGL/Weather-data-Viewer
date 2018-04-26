import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javafx.scene.control.Label;

public class WeatherPOJO {
	
	String stationName = "";
	int year = 0;
	int month = 0;
	double tempMax = 0.;
	double tempMin = 0.;
	int airFrost = 0;
	double rainfall = 0.;
	
	
	public WeatherPOJO() {					// Constructor
	}
	
	public String getStationName() {			// returns weather station name
		return stationName;
	}

	public void setStationName(String stationName) {			//sets weather station name
		this.stationName = stationName;
	}

	public int getYear() {			// returns year
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}
	
	public String getMonthString() {
		String monthString;
        switch (this.month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }           
		return monthString;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public int getAirFrost() {
		return airFrost;
	}

	public void setAirFrost(int airFrost) {
		this.airFrost = airFrost;
	}

	public double getRainfall() {
		return rainfall;
	}

	public void setRainfall(double rainfall) {
		this.rainfall = rainfall;
	}
	
	public static double getHighestMeanTempPerMonth(List<WeatherPOJO> weatherPOJOs, int month, String name) {
		double max = 0.;
		
		for(WeatherPOJO curr : weatherPOJOs) {			// loops through all objects, finds match with name
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase()))	// finds name match
			{
				if(curr.getMonth() == month) {		// finds the month entered
					if(curr.getTempMax() > max)		// if value is higher than zero, set that value as the return
					{								// Loops through all objects that match above and finally
						max = curr.getTempMax();		// ends with the highest overall value
					}
				}
			}
		}
		return max;
	}
	
	public static String getOverallHighestTemp(List<WeatherPOJO> weatherPOJOs, String name) {
		double max = 0.;
		Label a = new Label();
		for(WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase())) {
				if(curr.getTempMax() > max) {
					max = curr.getTempMax();
					a.setText(Double.toString(max) +"\u2103" + " on "
						+ curr.getMonthString() + " " + curr.getYear());
				}
			}
		}
		return a.getText();
	}
	
	public static double getHighMeanTempForYearAndMonth(List<WeatherPOJO> weatherPOJOs, String name, int year, int month) {
		double ret = 0.;
		for (WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase())) {
				if(curr.getYear() == year) {
					if(curr.getMonth() == month) {
						ret = curr.getTempMax();
					}
				}
			}
		}
		return ret;	
	}
	
	public static double getLowestMeanTempPerMonth(List<WeatherPOJO> weatherPOJOs, int month, String name) {
		double min = 999999;
		
		for(WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase()))
			{
				if(curr.getMonth() == month) {
					if(curr.getTempMin() < min)
					{
						min = curr.getTempMin();
					}
				}
			}
		}
		return min;
	}
	
	public static String getOverallLowestTemp(List<WeatherPOJO> weatherPOJOs, String name) {
		double min = 999999;
		Label a = new Label();
		for(WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase())) {
				if(curr.getTempMin() < min) {
					min = curr.getTempMin();
					a.setText(Double.toString(min) +"\u2103" + " on "
						+ curr.getMonthString() + " " + curr.getYear());
				}
			}
		}
		return a.getText();
	}
	
	public static double getLowMeanTempForYearAndMonth(List<WeatherPOJO> weatherPOJOs, String name, int year, int month) {
		double ret = 0.;
		for (WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase())) {
				if(curr.getYear() == year) {
					if(curr.getMonth() == month) {
						ret = curr.getTempMin();
					}
				}
			}
		}
		return ret;	
	}
	
	public static double getTotalRainfall(List<WeatherPOJO> weatherPOJOs, int month, String name) {
		double ret = 0;

		for(WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase()))
			{
				if(curr.getMonth() == month) {
					ret += curr.getRainfall();
				}
			}
		}
		double newRet = Math.round(ret*100.0)/100.0;
		return newRet;
	}
	
	public static Double getRainfallOverallAverage(List<WeatherPOJO> weatherPOJOs, String name, Set<Integer> yearSet) {
		double ret = 0.;
		for(WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase())) {
				ret += curr.getRainfall();
			}
		}
		ret = ret/yearSet.size();
		double newRet = Math.round(ret*100.0)/100.0;
		return newRet;
	}
	
	public static double getTotalRainfallForYearAndMonth(List<WeatherPOJO> weatherPOJOs, String name, int year, int month) {
		double ret = 0.;
		for (WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase())) {
				if(curr.getYear() == year) {
					if(curr.getMonth() == month) {
						ret = curr.getRainfall();
					}
				}
			}
		}
		double newRet = Math.round(ret*100.0)/100.0;
		return newRet;	
	}
	
	public static int getTotalAirFrostDays(List<WeatherPOJO> weatherPOJOs, int month, String name) {
		int ret = 0;
		
		for(WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase()))
			{
				if(curr.getMonth() == month) {
					ret += curr.getAirFrost();
				}
			}
		}	
		return ret;
	}
	
	public static int getAirFrostOverallAverage(List<WeatherPOJO> weatherPOJOs, String name, Set<Integer> yearSet) {
		int ret = 0;
		for(WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase())) {
				ret += curr.getAirFrost();
			}
		}
		ret = ret/yearSet.size();
		return ret;
	}
	
	public static int getTotalAirfrostDaysForYearAndMonth(List<WeatherPOJO> weatherPOJOs, String name, int year, int month) {
		int ret = 0;
		for (WeatherPOJO curr : weatherPOJOs) {
			if(curr.getStationName().toLowerCase().equals(name.toLowerCase())) {
				if(curr.getYear() == year) {
					if(curr.getMonth() == month) {
						ret = curr.getAirFrost();
					}
				}
			}
		}
		return ret;	
	}
	
	public static List<WeatherPOJO> getListPerYear(List<WeatherPOJO> weatherPOJOs, int year) {
		List<WeatherPOJO> ret = new ArrayList<WeatherPOJO>();
		
		for(WeatherPOJO curr : weatherPOJOs) {
			if(curr.getYear() == year) {
				ret.add(curr);
			}
		}
		return ret;	
	}
	
	public static void getSetOfYears(List<WeatherPOJO> weatherPOJOs, Set a) {
		for(WeatherPOJO curr : weatherPOJOs) {
			a.add(curr.getYear());			
		}
	}
}
