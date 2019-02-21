package org.zhujiajunup.refactoring;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author zhujiajunup@163.com
 * 19-2-20 - 下午2:05
 */
@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
    @NonNull
    private String name;

    private List<Rental> rentals = new ArrayList<>();


    public String statement() {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ").append(getName()).append("\n");
        for (Rental rental : rentals) {
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(String.valueOf(rental.getCharge())).append("\n");
        }
        result.append("Amount owed is ").append(getTotalCharge()).append("\n")
                .append("You earned ").append(String.valueOf(getTotalFrequentRenterPoints())).append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder();
        result.append("<h1>Rental Record for <EM>").append(getName()).append("</EM></h1><p>\n");
        for (Rental rental : rentals) {
            result.append(rental.getMovie().getTitle()).append(":").append(String.valueOf(rental.getCharge())).append("<br>\n");
        }
        result.append("<p>Amount owed is ").append(getTotalCharge()).append("</p>\n")
                .append("You earned ").append(String.valueOf(getTotalFrequentRenterPoints())).append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        return rentals.stream().map(Rental::getCharge).reduce((a, b) -> a + b).orElse(0D);

    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().map(Rental::getFrequentRenterPoints).reduce((a, b) -> a + b).orElse(0);
    }

}
