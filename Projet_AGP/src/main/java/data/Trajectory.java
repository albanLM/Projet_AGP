package data;

public class Trajectory extends Event {

	private TransportMethod transportMethod;
	
	public Trajectory(float time, float price, TransportMethod transportMethod) {
		super(time, price);
		this.transportMethod = transportMethod;
	}

	public TransportMethod getTransportMethod() {
		return transportMethod;
	}

	public void setTransportMethod(TransportMethod transportMethod) {
		this.transportMethod = transportMethod;
	}
	
}
