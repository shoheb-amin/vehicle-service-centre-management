package ServiceCentre.config.entity;

public class Vehicle {
    private int id;
    private int customer_id;
    private String numberplate;
    private String modelno;

    public Vehicle(int id,int customer_id, String numberplate, String modelno) {
        this.id = id;
        this.customer_id = customer_id;
        this.numberplate = numberplate;
        this.modelno = modelno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    @Override
    public String toString() {
        return "Vehicle[" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", numberplate='" + numberplate + '\'' +
                ", modelno='" + modelno + '\'' +
                ']';
    }
}
