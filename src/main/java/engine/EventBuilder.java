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
		
		float timeToGoToEvent = 0.0f;
		float priceToGoToEvent = 0.0f;
		float timeToGoBackToHotel = 0.0f;
		float priceToGoBackToHotel = 0.0f;
		
		int distanceToGoToEvent = UtilityClass.calculateDistance(startPlace.getCoord(), endPlace.getCoord());
		String transportNameToGoToEvent = UtilityClass.determineTransportMethod(startPlace, endPlace);
		if(transportNameToGoToEvent.equals("car"))
		{
			timeToGoToEvent = UtilityClass.calculateTrajectoryTime(distanceToGoToEvent, car);
			priceToGoToEvent = UtilityClass.calculateTrajectoryPrice(distanceToGoToEvent, car);
		}
		else
		{
			timeToGoToEvent = UtilityClass.calculateTrajectoryTime(distanceToGoToEvent, boat);
			priceToGoToEvent = UtilityClass.calculateTrajectoryPrice(distanceToGoToEvent, boat);
		}
		
		int distanceToGoBackToHotel = UtilityClass.calculateDistance(endPlace.getCoord(), hotel.getCoord());
		String transportNameToGoToHotel = UtilityClass.determineTransportMethod(endPlace, hotel);
		if(transportNameToGoToHotel.equals("car"))
		{
			timeToGoBackToHotel = UtilityClass.calculateTrajectoryTime(distanceToGoBackToHotel, car);
			priceToGoBackToHotel = UtilityClass.calculateTrajectoryPrice(distanceToGoBackToHotel, car);
		}
		else
		{
			timeToGoBackToHotel = UtilityClass.calculateTrajectoryTime(distanceToGoBackToHotel, boat);
			priceToGoBackToHotel = UtilityClass.calculateTrajectoryPrice(distanceToGoBackToHotel, boat);
		}
		float totalTime = 0.0f;
		for(Event e : excursion.getEvents()) {
			totalTime += e.getTime();
		}
		
		if(totalTime + timeToGoToEvent + event.getTime() + timeToGoBackToHotel <= maxTimePerDay){
			if(excursion.getPrice() + priceToGoToEvent + event.getPrice() + priceToGoBackToHotel <= maxPricePerDay) {
				excursion.setPrice(excursion.getPrice() + priceToGoToEvent + event.getPrice());
				
				if(transportNameToGoToEvent.equals("car"))
				{
					excursion.getEvents().add(new Trajectory(timeToGoToEvent, priceToGoToEvent, car));
				}
				else
				{
					excursion.getEvents().add(new Trajectory(timeToGoToEvent, priceToGoToEvent, boat));
				}
				
				excursion.getEvents().add(event);
			}
		}
		
		return excursion;
	}
	
	public Excursion buildBackToHotel(Excursion excursion, Hotel hotel) {
		int lastIndexOfEvents = excursion.getEvents().size();
		Place lastPlace = ((Visit)excursion.getEvents().get(lastIndexOfEvents)).getPlace();
		
		int distanceToGoBackToHotel = UtilityClass.calculateDistance(lastPlace.getCoord(), hotel.getCoord());
		
		float timeToGoBackToHotel = 0.0f;
		float priceToGoBackToHotel = 0.0f;
		
		String transportNameToGoToHotel = UtilityClass.determineTransportMethod(lastPlace, hotel);
		if(transportNameToGoToHotel.equals("car"))
		{
			timeToGoBackToHotel = UtilityClass.calculateTrajectoryTime(distanceToGoBackToHotel, car);
			priceToGoBackToHotel = UtilityClass.calculateTrajectoryPrice(distanceToGoBackToHotel, car);
		}
		else
		{
			timeToGoBackToHotel = UtilityClass.calculateTrajectoryTime(distanceToGoBackToHotel, boat);
			priceToGoBackToHotel = UtilityClass.calculateTrajectoryPrice(distanceToGoBackToHotel, boat);
		}
		
		excursion.setPrice(excursion.getPrice() + priceToGoBackToHotel);
		
		if(transportNameToGoToHotel.equals("car"))
		{
			excursion.getEvents().add(new Trajectory(timeToGoBackToHotel, priceToGoBackToHotel, car));
		}
		else
		{
			excursion.getEvents().add(new Trajectory(timeToGoBackToHotel, priceToGoBackToHotel, boat));
		}
		
		
		return excursion;
	}
}
