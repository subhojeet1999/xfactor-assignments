// Src for tax chart : https://www.iciciprulife.com/insurance-guide/financial-planning-tools-calculators/income-tax-calculator.html
import java.io.*;

public class TaxCalc{
	public static double taxCal(double amt){
		if (amt <= 250000)
			return 0;
		if (amt > 250000 && amt <= 500000)
			return 0.05 * amt;
		if (amt > 500000 && amt <= 1000000)
			return 12500 + (amt - 500000) * 0.2;
		return 112500 + (amt - 1000000) * 0.3;
	}
	public static void main(String args[])throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double amt;
		System.out.print("Enter the amount: ");
		amt = Double.parseDouble(in.readLine());
		double tax = taxCal(amt);
		System.out.println("TDS: " + tax + "\nFinal Amt: " + (amt - tax));
	}
}
