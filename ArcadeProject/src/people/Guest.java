package people;

public class Guest extends User{ // FIXME: do we even need this?
	public Guest() {
		name = "Guest";
		setIsGuest(true);
	}
}
