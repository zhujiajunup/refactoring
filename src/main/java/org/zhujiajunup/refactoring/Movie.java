package org.zhujiajunup.refactoring;

import lombok.Getter;
import lombok.Setter;


public class Movie {
    public static final int REGULAR = 0;
    public static final int NET_RELEASE = 1;
    public static final int CHILDRENS = 2;
    @Setter
    @Getter
    private String title;

    private Price price;

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPrice(Price price) {
        this.price = price;
    }


    public Movie(String title, Price price) {
        this.title = title;
        setPrice(price);
    }

    public int getFrequentRenterPoints(int daysRented) {

        return price.getFrequentRenterPoints(daysRented);
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }


}
