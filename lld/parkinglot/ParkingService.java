package lld.parkinglot;

import java.util.*;

class ParkingService {
    ParkingLot lot;
    Map<String, Ticket> activeTickets = new HashMap<>();

    ParkingService(ParkingLot lot) { this.lot = lot; }

    Ticket enter(Vehicle vehicle, Gate entryGate) {
        ParkingSlot slot = lot.allotmentStrategy.assignSlot(lot.floors, vehicle.type);
        if (slot == null) {
            System.out.println("No available slot for vehicle " + vehicle.regNo);
            return null;
        }
        Ticket ticket = new Ticket(vehicle, entryGate, slot);
        activeTickets.put(vehicle.regNo, ticket);
        System.out.println("Ticket generated: " + vehicle.regNo + " Slot: " + slot.name);
        return ticket;
    }

    Bill exit(String regNo, Gate exitGate) {
        Ticket ticket = activeTickets.remove(regNo);
        if (ticket == null) {
            System.out.println("No active ticket found!");
            return null;
        }
        double fee = lot.feeCalculator.calculateFee(ticket, new Date());
        ticket.slot.status = ParkingSlotStatus.FREE; // release slot
        Bill bill = new Bill(ticket, exitGate, fee);
        System.out.println("Bill generated for " + regNo + " Amount: " + fee);
        return bill;
    }
}

