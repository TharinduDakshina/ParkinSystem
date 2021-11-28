package model;

public class DataStore {

        private String vehicleNumber;
        private String vehicleType;
        private String parkingSlot;
        private String driverName;
        private String parkedTime;
        private String leftTime;
            // park on action
    public DataStore(String vehicleNumber, String vehicleType, String parkingSlot, String driverName, String parkedTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.driverName = driverName;
        this.parkedTime = parkedTime;
    }
            //deliver on action
    public DataStore(String vehicleNumber, String vehicleType, String driverName, String leftTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.leftTime = leftTime;
    }

    public DataStore() {
        }

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getParkingSlot() {
            return parkingSlot;
        }

        public void setParkingSlot(String parkingSlot) {
            this.parkingSlot = parkingSlot;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getParkedTime() {
            return parkedTime;
        }

        public void setParkedTime(String parkedTime) {
            this.parkedTime = parkedTime;
        }

        public String getLeftTime() {
            return leftTime;
        }

        public void setLeftTime(String leftTime) {
            this.leftTime = leftTime;
        }

    @Override
    public String toString() {
        return "DataStore{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", parkingSlot='" + parkingSlot + '\'' +
                ", driverName='" + driverName + '\'' +
                ", parkedTime='" + parkedTime + '\'' +
                ", leftTime='" + leftTime + '\'' +
                '}';
    }
}
