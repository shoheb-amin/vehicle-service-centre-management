package ServiceCentre.config.Service;

import ServiceCentre.config.entity.INVOICE;

import java.util.List;

public class BillingService {
    public CustomerServices customerServices=new CustomerServices();
    public InvoiceServices invoiceServices=new InvoiceServices();
    public void createInvoice(int customerId, int vehicleId, List<Integer>serviceIds) throws Exception{
        for(int serviceId:serviceIds){
            invoiceServices.addInvoice(new INVOICE(0,customerId,vehicleId,serviceId));
        }
        System.out.println("Invoice Generated Successfully.... ");
    }
    public void showAllInvoices() throws Exception{
        List<INVOICE>invoices=invoiceServices.getAllInvoices();
        for(INVOICE invoice:invoices) {
            System.out.println(invoice);
        }

    }
}
