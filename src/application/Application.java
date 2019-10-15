package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Application {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Enter number room: ");
			int roomNumber = sc.nextInt();
			System.out.println("Check in date: dd/mm/yyyy");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check Out date: dd/mm/yyyy");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			//update dates the reservation
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check in date: dd/mm/yyyy");
			Date checkInUpdate = sdf.parse(sc.next());
			System.out.println("Check Out date: dd/mm/yyyy");
			Date checkOutUpdate = sdf.parse(sc.next());
			//VERIFICAR AS INCONSISTENCIAS DAS DATAS

			reservation.updateDates(checkInUpdate, checkOutUpdate);
			System.out.println("Reservations updates: " +  reservation);
				
			sc.close();
		}
		catch(ParseException e) {
			System.out.println("Invalid date format: ");
		}
		catch(IllegalArgumentException e) {
			//IllegalArgumentException esse é padrão do java que está na classe Reservation
			System.out.println(e.getMessage());
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}

	}
}
