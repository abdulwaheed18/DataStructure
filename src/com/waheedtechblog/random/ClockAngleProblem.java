package com.waheedtechblog.random;

/**
 * Class to calculate angle between hour and minute hand. Check
 * https://en.wikipedia.org/wiki/Clock_angle_problem for more details.
 * 
 * @author abdulwaheed18@gmail.com
 * 
 *
 */
public class ClockAngleProblem {

	public static void main(String[] args) {
		ClockAngleProblem problem = new ClockAngleProblem();
		problem.angle(12, 30);
		problem.angle(7, 55);
		problem.angle(12, 40);
	}

	/*
	 * Minute: Complete 360 degree in 60 mins = 360/60 = 6 degree / minute. Hour
	 * : 6/12 = 0.5 degree
	 * 
	 * 
	 * 
	 */
	private void angle(int hour, int minutes) {
		System.out.print("Time: " + hour + ":" +minutes);

		// check validation
		if (hour > 12 || hour < 0 || minutes > 60 || minutes < 0) {
			System.err.println("Invalid Input");
			return;
		}

		// Count it as 0 to calculate correct angle
		if (hour == 12)
			hour = 0;
		if (minutes == 60)
			minutes = 0;

		int hour_angle = (int) (0.5 * (hour * 60 + minutes));
		int minute_angle = 6 * minutes;

		int angle = Math.abs(hour_angle - minute_angle);

		System.out.println(", Angle: " + angle);

	}

}
