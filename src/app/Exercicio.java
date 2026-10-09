package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Exercicio {
	
	void main() throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IO.print("Room number: ");
		int number = sc.nextInt();
		IO.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		IO.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			IO.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			IO.println("Reservation: " + reservation);
		
		
			IO.println();
			IO.println("Enter data do update the reservation:");
			IO.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			IO.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				IO.println("Error in reservation: " + error);
			}
			else {
				IO.println("Reservation: " + reservation);
			}
		
		}
		
		sc.close();		
		
	}

}
