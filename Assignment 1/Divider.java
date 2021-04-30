import java.io.*;

public class Divider{
	public static int divide(int num, int den){
		int sign = ((num < 0) ^ (den < 0))?-1:1; 
		// XOR for sign -> opp 1, else 0 -> -1 or 1
		num = Math.abs(num); den = Math.abs(den);
		int ans = 0;
		while(num >= den){
			num -= den;
			ans++;
		}
		ans *= sign;
		return ans;
	}

	public static void main(String args[])throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num, den;
		System.out.print("Enter numerator: ");
		num = Integer.parseInt(in.readLine());
		System.out.print("Enter denominator : ");
		den = Integer.parseInt(in.readLine());
		System.out.println("Result: " + divide(num, den));
	}
}