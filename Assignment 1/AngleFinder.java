import java.io.*;

public class AngleFinder{
	public double findAngle(int hour, int min){
		if(hour < 0 || min < 0 || hour > 12 || min > 60)
			return -1;
		if (hour == 12)
			hour = 0;
		if (min == 60){
			min = 0;
			hour++;
			hour = (hour > 12)?(hour-12):hour;
		}
		double hrangle, mnangle, angle;
		hrangle = (hour * 60 + min) * 0.5;
		mnangle = min * 6;
		angle = Math.abs(hrangle - mnangle);
		return Math.min(angle, 360-angle);
	}

	public static void main(String args[])throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int hour, min;
		System.out.print("Enter hours(12hr format) : ");
		hour = Integer.parseInt(in.readLine());
		System.out.print("Enter minutes : ");
		min = Integer.parseInt(in.readLine());
		AngleFinder ob = new AngleFinder();
		double angle = ob.findAngle(hour, min);
		if(angle == -1)
			System.out.println("Invalid Input");
		else
			System.out.println("Angle b/w hands of clock: " + angle);
	} 
}