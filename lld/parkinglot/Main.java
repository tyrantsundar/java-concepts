package lld.parkinglot;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Setup
        Operator op = new Operator("John");
        Gate entry = new Gate("G1", GateType.ENTRY, op);
        Gate exit = new Gate("G2", GateType.EXIT, op);

        List<ParkingSlot> slots = Arrays.asList(
                new ParkingSlot("S1", Set.of(VehicleType.CAR)),
                new ParkingSlot("S2", Set.of(VehicleType.BIKE))
        );
        ParkingFloor floor = new ParkingFloor("F1", slots);

        ParkingLot lot = new ParkingLot("Lot1",
                Arrays.asList(floor),
                Arrays.asList(VehicleType.CAR, VehicleType.BIKE),
                Arrays.asList(entry),
                Arrays.asList(exit),
                new RandomAllotment(),
                new TimeBasedFeeCalculator()
        );

        ParkingService service = new ParkingService(lot);

        // Simulate CLI flow
        Vehicle car = new Vehicle("TN01AB1234", VehicleType.CAR);
        Ticket t1 = service.enter(car, entry);

        try { Thread.sleep(2000); } catch(Exception e) {} // simulate time

        Bill b1 = service.exit(car.regNo, exit);
        b1.addPayment(new Payment(PaymentMode.UPI, b1.billAmount, PaymentStatus.SUCCESS));

        System.out.println("Payment Done: " + b1.billAmount + " via " + b1.payments.get(0).mode);
    }
}

