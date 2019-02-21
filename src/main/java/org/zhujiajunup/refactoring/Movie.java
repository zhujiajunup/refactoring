package org.zhujiajunup.refactoring;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NET_RELEASE = 1;

    private String title;

    private int priceCode;

    public int getFrequentRenterPoints(int daysRented) {

        if (this.getPriceCode() == Movie.NET_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    public double getCharge(int daysRented) {
        double result = 0;
        switch (this.getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NET_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }


}
