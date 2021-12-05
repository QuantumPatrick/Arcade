package system;

import java.time.LocalDate;

public class Date {
	// attributes
	Integer day;
	int month;
	int year;
	
	public Date() {
		LocalDate currentDate = LocalDate.now();
		this.day = currentDate.getDayOfMonth();
		this.month = currentDate.getMonthValue();
		this.year = currentDate.getYear();
	}
	
	public Date(int d, int m, int y) {
		this.day = d;
		this.month = m;
		this.year = y;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String displayCakeDay() {
		return (this.year + "-" + this.month + "-" + this.day);
	}

}
