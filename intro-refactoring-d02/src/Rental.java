
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }


    double getRentalPrice() {
        return movie.getCharge(daysRented);
    }

    double calculatePoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}