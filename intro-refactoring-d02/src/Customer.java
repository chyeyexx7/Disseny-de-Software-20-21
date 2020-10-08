
import java.util.*;

public class Customer {
    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental : this.rentals) {

            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(getAmountFor(rental)).append("\n");
        }

        result.append("You owed ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points\n");

        return result.toString();
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this.rentals) {
            frequentRenterPoints += rental.calculatePoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental rental : this.rentals) {
            totalAmount += getAmountFor(rental);
        }
        return totalAmount;
    }

    private double getAmountFor(Rental rental) {
        return rental.getRentalPrice();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n");
        for (Rental rental : this.rentals) {

            result.append(rental.getMovie().getTitle()).append(": ").append(getAmountFor(rental)).append("<BR>\n");
        }

        result.append("<P>You owe <EM>").append(getTotalCharge()).append("</EM><P>\n");
        result.append("On this rental you earned <EM>").append(getTotalFrequentRenterPoints()).append("</EM> frequent renter points<P>");

        return result.toString();
    }

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
}