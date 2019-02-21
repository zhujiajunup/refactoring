package org.zhujiajunup.refactoring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhujiajunup@163.com
 * 19-2-20
 */
@Getter
@Setter
@AllArgsConstructor
public class Rental {
    private Movie movie;

    private int dayRented;

    public int getFrequentRenterPoints() {

        return this.movie.getFrequentRenterPoints(dayRented);
    }

    public double getCharge() {
        return movie.getCharge(this.dayRented);
    }
}
