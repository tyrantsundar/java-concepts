package lld.parkinglot;

import java.util.Date;

class Ticket {
    Vehicle vehicle;
    Date entryTime;
    Gate entryGate;
    ParkingSlot slot;

    Ticket(Vehicle vehicle, Gate entryGate, ParkingSlot slot) {
        this.vehicle = vehicle;
        this.entryGate = entryGate;
        this.slot = slot;
        this.entryTime = new Date();
    }
}
