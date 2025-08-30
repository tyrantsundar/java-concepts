package lld.parkinglot;

import java.util.*;

class Bill {
    Ticket ticket;
    Date exitTime;
    Gate exitGate;
    double billAmount;
    List<Payment> payments = new ArrayList<>();

    Bill(Ticket ticket, Gate exitGate, double billAmount) {
        this.ticket = ticket;
        this.exitGate = exitGate;
        this.billAmount = billAmount;
        this.exitTime = new Date();
    }

    void addPayment(Payment p) { payments.add(p); }
}

