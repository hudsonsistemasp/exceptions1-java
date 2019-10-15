package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Application {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter number room: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check in date: dd/mm/yyyy");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check Out date: dd/mm/yyyy");
		Date checkOut = sdf.parse(sc.next());
		
		//Regra de negócio :verificar se a data de checkIn não é maior que a de checkOut
		if (checkIn.after(checkOut)) {
			System.out.println("Error in resevartion: Check-out date must be after Check-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			//update dates the reservation
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check in date: dd/mm/yyyy");
			Date checkInUpdate = sdf.parse(sc.next());
			System.out.println("Check Out date: dd/mm/yyyy");
			Date checkOutUpdate = sdf.parse(sc.next());
			//VERIFICAR AS INCONSISTENCIAS DAS DATAS
			Date now = new Date();
			if (checkInUpdate.before(now) || checkOutUpdate.before(now) ) {
				System.out.println("Error in reservation: Reservation dates for update must be futures date");
			}
			else if(checkInUpdate.before(checkOutUpdate)) {
				System.out.println("Error in resevartion: Check-out date must be after Check-in date");
			}
			else {
				reservation.updateDates(checkInUpdate, checkOutUpdate);
				System.out.println("Reservations updates: " +  reservation);
			}

		}
		
		

		
		sc.close();
	}

}
