/**
 * Chang Ye
 * 08/10/2020
 */
abstract class Price {
    abstract int getPricedCode();

    abstract double getCharge(int rentedDays);

    int getTotalFrequentRenterPoints(int rentedDays) {
        return 1;
    }
}

class ChildrenPrice extends Price {

    @Override
    int getPricedCode() {
        return Movie.CHILDREN;
    }

    @Override
    double getCharge(int rentedDays) {
        double price = 1.5;
        if (rentedDays > 3)
            price += (rentedDays - 3) * 1.5;
        return price;
    }
}

class NewReleasePrice extends Price {

    @Override
    int getPricedCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int rentedDays) {
        return rentedDays * 3;
    }

    @Override
    int getTotalFrequentRenterPoints(int rentedDays) {
        int frequentRenterPoints = 1;

        if (rentedDays > 1) frequentRenterPoints++;

        return frequentRenterPoints;
    }
}

class RegularPrice extends Price {

    @Override
    int getPricedCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int rentedDays) {
        double price = 2;
        if (rentedDays > 2)
            price += (rentedDays - 2) * 1.5;
        return price;
    }
}

