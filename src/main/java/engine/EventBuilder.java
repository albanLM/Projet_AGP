package engine;

import data.Event;
import data.Excursion;
import data.Hotel;
import data.Place;
import data.Trajectory;
import data.TransportMethod;
import data.Visit;

public class EventBuilder {
	
	private final TransportMethod car = new TransportMethod("car", 80, 1.0f);
	private final TransportMethod boat = new TransportMethod("boat", 50, 2.0f);

	public Excursion buildEvent(Event event, Excursion excursion, float maxTimePerDay, float maxPricePerDay, Hotel hotel){
		int lastIndexOfEvents = excursion.getEvents().size();
		Place startPlace = ((Visit)excursion.getEvents().get(lastIndexOfEvents)).getPlace();
		Place endPlace = ((Visit)event).getPlace();
//		String transportName = UtilityClass.determineTransportMethod(startPlace, endPlace);
		
//		if(transportName.equals("car"))
//		{
//			float timeToGoToEvent = UtilityClass.calculateTrajectoryTime(startPlace.getCoord(), endPlace.getCoord(), car);
//		}
//		else
//		{
//			float timeToGoToEvent = UtilityClass.calculateTrajectoryTime(startPlace.getCoord(), endPlace.getCoord(), boat);
//		}
		int distanceToGoToEvent = UtilityClass.calculateDistance(startPlace.getCoord(), endPlace.getCoord());
		float timeToGoToEvent = UtilityClass.calculateTrajectoryTime(distanceToGoToEvent, car);
		float priceToGoToEvent = UtilityClass.calculateTrajectoryPrice(distanceToGoToEvent, car);
		
//		if(transportName.equals("car"))
//		{
//			float timeToGetBackToHotel = UtilityClass.calculateTrajectoryTime(endPlace.getCoord(), hotel.getCoord(), car);
//		}
//		else
//		{
//			float timeToGetBackToHotel = UtilityClass.calculateTrajectoryTime(endPlace.getCoord(), hotel.getCoord(), boat);
//		}
		int distanceToGoBackToHotel = UtilityClass.calculateDistance(endPlace.getCoord(), hotel.getCoord());
		float timeToGoBackToHotel = UtilityClass.calculateTrajectoryTime(distanceToGoBackToHotel, car);
		float priceToGoBackToHotel = UtilityClass.calculateTrajectoryPrice(distanceToGoBackToHotel, car);
		
		float totalTime = 0.0f;
		for(Event e : excursion.getEvents()) {
			totalTime += e.getTime();
		}
		
		if(totalTime + timeToGoToEvent + event.getTime() + timeToGoBackToHotel <= maxTimePerDay){
			if(excursion.getPrice() + priceToGoToEvent + event.getPrice() + priceToGoBackToHotel <= maxPricePerDay) {
				excursion.setPrice(excursion.getPrice() + priceToGoToEvent + event.getPrice());
				excursion.getEvents().add(new Trajectory(timeToGoToEvent, priceToGoToEvent, car));
				excursion.getEvents().add(event);
			}
		}
		
		return excursion;
	}
	
	public Excursion buildBackToHotel(Excursion excursion, Hotel hotel) {
		int lastIndexOfEvents = excursion.getEvents().size();
		Place lastPlace = ((Visit)excursion.getEvents().get(lastIndexOfEvents)).getPlace();
		
		int distanceToGoBackToHotel = UtilityClass.calculateDistance(lastPlace.getCoord(), hotel.getCoord());
		
//		String transportName = UtilityClass.determineTransportMethod(startPlace, endPlace);
		
		float timeToGoBackToHotel = UtilityClass.calculateTrajectoryTime(distanceToGoBackToHotel, car);
		float priceToGoBackToHotel = UtilityClass.calculateTrajectoryPrice(distanceToGoBackToHotel, car);
		
		excursion.setPrice(excursion.getPrice() + priceToGoBackToHotel);
		excursion.getEvents().add(new Trajectory(timeToGoBackToHotel, priceToGoBackToHotel, car));
		
		return excursion;
	}
}
