package model;

public class Vehicle {
    private String vehicleNumber;
    private String maxWait;
    private String noOfPassengers;
    private String vehicleType;
    private String vehicleStatus;

    public Vehicle(String vehicleNumber, String maxWait, String noOfPassengers, String vehicleType) {
        this.setVehicleNumber(vehicleNumber);
        this.setMaxWait(maxWait);
        this.setNoOfPassengers(noOfPassengers);
        this.setVehicleType(vehicleType);

    }

    public Vehicle(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Vehicle() {
    }




    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(String maxWait) {
        this.maxWait = maxWait;
    }

    public String getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(String noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + getVehicleNumber() + '\'' +
                ", maxWait='" + getMaxWait() + '\'' +
                ", noOfPassengers='" + getNoOfPassengers() + '\'' +
                ", vehicleType='" + getVehicleType() + '\'' +
                '}';
    }
}
