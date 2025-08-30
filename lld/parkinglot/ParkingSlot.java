package lld.parkinglot;


import java.util.Set;

class ParkingSlot {
    String name;
    Set<VehicleType> allowedTypes;
    ParkingSlotStatus status = ParkingSlotStatus.FREE;

    ParkingSlot(String name, Set<VehicleType> allowedTypes) {
        this.name = name;
        this.allowedTypes = allowedTypes;
    }
}

