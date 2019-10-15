package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//static para não precisar instanciar a cada objeto dessa classe
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	//Constructors
	public Reservation() {
	}
	
	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		//Programação defensiva: Verificar no construtor
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now) ) {
			// IllegalArgumentException:Padrão do Java
			//throw new IllegalArgumentException("Error in reservation: Reservation dates for update must be future date");
			throw new DomainException("Error in reservation: Reservation dates for update must be future date");
		}
	}
	
	//GETTERS and SETTERS
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	/*Como o projeto pede um update Dates, 
	  não tem necesidade de mudar essas data de forma aberta
	  e isso foi delegado ao método*/
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut(){
		return checkOut;
	}
	
	//METHODS
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {
		if(checkIn.before(checkOut)) {
			// IllegalArgumentException:Padrão do Java
			//throw new IllegalArgumentException("Error in resevartion: Check-out date must be after Check-in date");//Padrão do Java
			throw new DomainException("Error in resevartion: Check-out date must be after Check-in date");//DomainException :Minha exceção personalizada
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room: " + this.roomNumber
				+ ", " + " checkIn: " + sdf.format(this.checkIn)
				+ ", " + " checkOut: " + sdf.format(this.checkOut)
				+ ", " + this.duration() + " nights"; 
	}
}
