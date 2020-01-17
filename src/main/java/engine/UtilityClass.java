package engine;

import data.Coordinates;
import data.Place;
import data.TransportMethod;

public class UtilityClass {

	public static String determineTransportMethod(Place placeA, Place placeB) {
		return "car";
		//return "boat";
	}
	
	public static int calculateDistance(Coordinates coordA, Coordinates coordB) {
		int gapX = coordB.getX()-coordA.getX();
		int gapY = coordB.getY()-coordA.getY();
		return (int)Math.sqrt(Math.pow(gapX,2) + Math.pow(gapY,2));
	}
	
	public static float calculateTrajectoryTime(int distance, TransportMethod vehicule) {
		return 0;
	}
	public static float calculateTrajectoryPrice(int distance, TransportMethod vehicule) {
		return 0;
	}
}
