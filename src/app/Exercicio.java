package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Exercicio {
	
	void main() {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			IO.print("Room number: ");
			int number = sc.nextInt();
			IO.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			IO.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			IO.println("Reservation: " + reservation);
		
		
			IO.println();
			IO.println("Enter data do update the reservation:");
			IO.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			IO.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			IO.println("Reservation: " + reservation);
		}
		catch (ParseException e){
			IO.println("Invalid date format");
		}
		catch (DomainException e) {
			IO.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			IO.println("Unexpected error");
		}
		
		sc.close();		
		
	}

}
