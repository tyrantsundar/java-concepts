package lld.parkinglot;

import java.util.List;

public interface SlotAllotment {
    ParkingSlot assignSlot(List<ParkingFloor> floors, VehicleType type);
}
