package ServiceCentre.config.Service;

import ServiceCentre.config.DbConfig;
import ServiceCentre.config.entity.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleServices {
    public static void addVehicle(Vehicle vehicle) throws Exception{
        Connection conn= DbConfig.getConnection();
        PreparedStatement psrt=conn.prepareStatement("INSERT INTO vehicle(Customer_id,number_plate,model)values (?,?,?)");
        psrt.setInt(1,vehicle.getCustomer_id());
        psrt.setString(2,vehicle.getNumberplate());
        psrt.setString(3, vehicle.getModelno());
        psrt.executeUpdate();
        psrt.close();
        conn.close();
    }
    public List<Vehicle>getAllVehicle() throws Exception{
        List<Vehicle>list=new ArrayList<>();
        Connection conn=DbConfig.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("SELECT * from vehicle");
        while(rs.next()){
            list.add(new Vehicle(
                    rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getString("number_plate"),
                    rs.getString("model")));
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

}
