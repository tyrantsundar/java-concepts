package lld.parkinglot;

import java.util.List;

class ParkingLot {
    String name;
    List<ParkingFloor> floors;
    List<VehicleType> allowedVehicles;
    List<Gate> entryGates;
    List<Gate> exitGates;
    SlotAllotment allotmentStrategy;
    FeeCalculator feeCalculator;
    ParkingLotStatus status = ParkingLotStatus.OPEN;

    ParkingLot(String name, List<ParkingFloor> floors,
               List<VehicleType> allowedVehicles, List<Gate> entryGates,
               List<Gate> exitGates, SlotAllotment allotmentStrategy,
               FeeCalculator feeCalculator) {
        this.name = name;
        this.floors = floors;
        this.allowedVehicles = allowedVehicles;
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        this.allotmentStrategy = allotmentStrategy;
        this.feeCalculator = feeCalculator;
    }
}
