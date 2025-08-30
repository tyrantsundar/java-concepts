package lld.parkinglot;

import java.util.List;

class ParkingFloor {
    String name;
    List<ParkingSlot> slots;
    ParkingFloorStatus status = ParkingFloorStatus.OPEN;

    ParkingFloor(String name, List<ParkingSlot> slots) {
        this.name = name;
        this.slots = slots;
    }
}

