package lld.parkinglot;

import java.util.Date;

public interface FeeCalculator {
    double calculateFee(Ticket ticket, Date exitTime);
}