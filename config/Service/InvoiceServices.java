package ServiceCentre.config.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import ServiceCentre.config.DbConfig;
import ServiceCentre.config.entity.INVOICE;

import java.sql.Connection;

public class InvoiceServices {
    public void addInvoice(INVOICE invoice) throws Exception {
        Connection conn = DbConfig.getConnection();
        PreparedStatement psrt = conn.prepareStatement("INSERT INTO invoices(Customer_iD,vehicle_id,service_id)values (?,?,?)");
        psrt.setInt(1, invoice.getCustomer_id());
        psrt.setInt(2, invoice.getVehicle_id());
        psrt.setInt(3, invoice.getService_id());
        psrt.executeUpdate();
        psrt.close();
        conn.close();
    }
        //This method fetches all invoices from the database and returns them as a List<Customer>.
        public List<INVOICE> getAllInvoices()throws Exception{
            //Creates an empty list to store customers
            List<INVOICE> list = new ArrayList<>();
            //CREATE database connection
            Connection conn = DbConfig.getConnection();

            //Creates a Statement object
            //Used when no parameters are required in SQL
            Statement st = conn.createStatement();

            //Executes SELECT query
            //ResultSet stores returned rows from database
            ResultSet rs = st.executeQuery("Select * from invoices");

            //Loops through each row in the result set
            while (rs.next()) {
                list.add(new INVOICE(rs.getInt("id"),
                        rs.getInt("Customer_id"),
                        rs.getInt("Vehicle_id"),
                        rs.getInt("Service_id")));
            }
            return list;


        }
    public void showInvoiceWithAmount(int customerId, int vehicleId) throws Exception {

        Connection conn = DbConfig.getConnection();

        String sql = """
        SELECT c.user_name, c.contact,
               v.number_plate, v.model,
               s.description, s.cost, i.date
        FROM invoices i
        JOIN customer c ON i.customer_id = c.id
        JOIN vehicle v ON i.vehicle_id = v.id
        JOIN services s ON i.service_id = s.id
        WHERE i.customer_id = ? AND i.vehicle_id = ?
    """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, customerId);
        ps.setInt(2, vehicleId);

        ResultSet rs = ps.executeQuery();

        double total = 0;
        int count = 1;
        boolean headerPrinted = false;

        System.out.println("\n================= GARAGE INVOICE =================");

        while (rs.next()) {

            if (!headerPrinted) {
                System.out.println("Invoice Date : " + rs.getTimestamp("date"));
                System.out.println("\nCustomer Name : " + rs.getString("user_name"));
                System.out.println("Contact       : " + rs.getString("contact"));

                System.out.println("\nVehicle No    : " + rs.getString("number_plate"));
                System.out.println("Vehicle Model : " + rs.getString("model"));

                System.out.println("\n--------------------------------------------------");
                System.out.println("Services Done");
                System.out.println("--------------------------------------------------");

                headerPrinted = true;
            }

            double cost = rs.getDouble("cost");
            total += cost;

            System.out.printf(
                    "%d. %-20s ₹%.2f%n",
                    count++,
                    rs.getString("description"),
                    cost
            );
        }

        System.out.println("\n--------------------------------------------------");
        System.out.printf("TOTAL AMOUNT             ₹%.2f%n", total);
        System.out.println("==================================================");

        rs.close();
        ps.close();
        conn.close();
    }

}
