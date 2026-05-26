package ServiceCentre.config;

import ServiceCentre.config.Service.BillingService;
import ServiceCentre.config.Service.CustomerServices;
import ServiceCentre.config.Service.VehicleServices;
import ServiceCentre.config.entity.Customer;
import ServiceCentre.config.entity.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BillingService service = new BillingService();
        VehicleServices vehicleServices = new VehicleServices();
        CustomerServices customerServices = new CustomerServices();
        while (true) {
            System.out.println("1.Add Customer & Vehicle Details");
            System.out.println("2.Generate Invoice");
            System.out.println("3.Show Invoice");
            System.out.println("4.Show List of Invoice");
            System.out.println("5.Exit: ");
            System.out.print("5.Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Customer Name: ");
                    String Name = sc.nextLine();

                    System.out.println("Enter Contact Number");
                    String contact = sc.nextLine();

                    //generated customer ID
                    int customerId=customerServices.addCustomer(new Customer(0, Name, contact));

                    System.out.println("Enter Vehicle Number Plate: ");
                    String plate = sc.nextLine();

                    //sc.nextLine();

                    System.out.println("Enter Vehicle Model: ");
                    String model = sc.nextLine();
                    VehicleServices.addVehicle (new Vehicle(0, customerId, plate, model));

                    System.out.println("Vehicle And Customer Details Added Succesfully!!");
                    break;


                case 2:
                    System.out.println("-----Here is the Customers Data:-----");
                    System.out.println(service.customerServices.getAllCustomer() + "\n");
                    System.out.println(vehicleServices.getAllVehicle());
                    System.out.println("Enter Customer Id: ");
                    int CustomerId = sc.nextInt();
                    System.out.println("Enter Vehicle id: ");
                    int vehicleId = sc.nextInt();
                    System.out.println("Enter no of services: ");
                    int n = sc.nextInt();
                    List<Integer> serviceIds = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter the Service Id: ");
                        serviceIds.add(sc.nextInt());
                    }
                    service.createInvoice(CustomerId, vehicleId, serviceIds);
                    break;


                case 3:
                    System.out.print("Enter Customer Id: ");
                    int cId = sc.nextInt();

                    System.out.print("Enter Vehicle Id: ");
                    int vId = sc.nextInt();

                    service.invoiceServices.showInvoiceWithAmount(cId, vId);
                    break;

                case 4:
                    service.showAllInvoices();
                    break;


                case 5:
                    System.exit(0);



                default:
                    System.out.println("Not a valid choice");
            }
        }
    }
}
