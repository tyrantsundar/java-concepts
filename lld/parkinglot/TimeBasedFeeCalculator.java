package lld.parkinglot;

import java.util.Date;

class TimeBasedFeeCalculator implements FeeCalculator {

    @Override
    public double calculateFee(Ticket ticket, Date exitTime) {
        long diffMs = exitTime.getTime() - ticket.entryTime.getTime();
        long hours = (diffMs / (1000 * 60 * 60)) + 1; // round up
        return hours * 50; // 50 per hour
    }
}