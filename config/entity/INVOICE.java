package ServiceCentre.config.entity;

public class INVOICE {
    private int ID;
    private int customer_id;
    private int vehicle_id;
    private int service_id;

    public INVOICE(int ID, int customer_id, int vehicle_id, int service_id) {
        this.ID = ID;
        this.customer_id = customer_id;
        this.vehicle_id = vehicle_id;
        this.service_id = service_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    @Override
    public String toString() {
        return "INVOICE [ " +
                " ID:" + ID +
                ", customerId: " + customer_id +
                ", vehicleId: " + vehicle_id +
                ", serviceId: " + service_id+" ]";
    }
}
