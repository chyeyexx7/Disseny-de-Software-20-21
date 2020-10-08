

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private Price price;

    private final String title;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    private void setPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.CHILDREN:
                price = new ChildrenPrice();
                break;
            default:
                throw new IllegalStateException("Unexpected Value: " +
                    priceCode);
        }
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getPriceCode() {
        return price.getPricedCode();
    }

    public String getTitle() {
        return title;
    }

    int getFrequentRenterPoints(int daysRented) {
        return price.getTotalFrequentRenterPoints(daysRented);
    }



}