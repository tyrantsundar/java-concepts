package lld.parkinglot;

import java.util.List;

class RandomAllotment implements SlotAllotment {
    @Override
    public ParkingSlot assignSlot(List<ParkingFloor> floors, VehicleType type) {
        for (ParkingFloor f : floors) {
            for (ParkingSlot s : f.slots) {
                if (s.status == ParkingSlotStatus.FREE && s.allowedTypes.contains(type)) {
                    s.status = ParkingSlotStatus.OCCUPIED;
                    return s;
                }
            }
        }
        return null;
    }
}