package org.zhujiajunup.refactoring;

/**
 * @author zhujiajunup@163.com
 * 19-2-21 - 上午10:23
 */
public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented) {


        return 1;
    }
}

class ChildrensPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 0;
        result += 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}

class NewReleasePrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.NET_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 0;
        result += 3;
        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}

class RegularPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 0;
        result += 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}


