package it.unibo.oop.lab.exception1;

/*Used IllegalStateException due to similarity to PositionOutOfBoundException*/
public class NotEnoughBatteryException extends IllegalStateException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

    private final double battery;

    public NotEnoughBatteryException(double battery) {
	super();
	this.battery = battery;
    }

    @Override
    public String toString() {
	return "Not enough battery, actual: " + battery + "%";
    }

    @Override
    public String getMessage() {
	return this.toString();
    }
}