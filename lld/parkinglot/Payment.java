package lld.parkinglot;

class Payment {
    PaymentMode mode;
    double amount;
    PaymentStatus status;

    Payment(PaymentMode mode, double amount, PaymentStatus status) {
        this.mode = mode;
        this.amount = amount;
        this.status = status;
    }
}

