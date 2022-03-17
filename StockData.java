import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StockData {
	
	public static double average(ArrayList<Double> a) {
		double total = 0;
		for (int i=0; i<a.size(); i++) {
			total= total + a.get(i);
		}
		if (a.size()>0) {
			return total/a.size();
		}
		else {
			return 0;
		}
	}		
	
	public static double StandardDev(ArrayList<Double> a, double average) {
		double StandardDeviation = 0;
		for (int i = 0; i<a.size(); i++) {
			double top = (a.get(i) - average(a));
			double finaltop= top*top;
			StandardDeviation = Math.sqrt(finaltop/(a.size() - 1));
		}
		return StandardDeviation;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	Scanner userInput = new Scanner(System.in);	
	System.out.println("Please Enter The Stock Symbol To Anaylze");
	String symbol =userInput.next();
	
	File myFile = new File (symbol+ ".txt"); //aapl.txt
	Scanner file = new Scanner (myFile);
	
	ArrayList <Double> Prices= new ArrayList<Double>();
	
	file.nextLine(); //skip the header in the files
	
	while (file.hasNext()) {
		file.next();
		file.next();
		file.next();
		file.next();
		double price= file.nextDouble();
		Prices.add(price);
	} //Go through a line of data
	
	Double max= Collections.max(Prices);
	Double min= Collections.min(Prices);
	
	
	file.close();
	
	System.out.println("Number of Prices Input:" + Prices.size());
	System.out.println("Average Price: " + average(Prices));
	System.out.println("Max Price: " + max);
	System.out.println("Min Price: " + min);
	System.out.println("Stanardard Deviation: " + StandardDev(Prices, average(Prices)));
	

	
	}
}
