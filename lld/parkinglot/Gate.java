package lld.parkinglot;

class Gate {
    String gateNo;
    GateType type;
    Operator operator;

    Gate(String gateNo, GateType type, Operator operator) {
        this.gateNo = gateNo;
        this.type = type;
        this.operator = operator;
    }
}
