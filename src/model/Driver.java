package model;

public class Driver {
    private String driverName;
    private String noNIC;
    private String drivingLicenseNo;
    private String address;
    private String contact;

    public Driver(String driverName, String noNIC, String drivingLicenseNo, String address, String contact) {
        this.setDriverName(driverName);
        this.setNoNIC(noNIC);
        this.setDrivingLicenseNo(drivingLicenseNo);
        this.setAddress(address);
        this.setContact(contact);
    }

    public Driver() {
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNoNIC() {
        return noNIC;
    }

    public void setNoNIC(String noNIC) {
        this.noNIC = noNIC;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", noNIC='" + noNIC + '\'' +
                ", drivingLicenseNo='" + drivingLicenseNo + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
