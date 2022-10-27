package app;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-In date (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
            System.out.print("Check-Out date (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dtf);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-In date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            System.out.print("Check-Out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), dtf);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }

        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
    }
}

