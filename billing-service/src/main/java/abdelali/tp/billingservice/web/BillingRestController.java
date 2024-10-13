package abdelali.tp.billingservice.web;

import abdelali.tp.billingservice.entities.Bill;
import abdelali.tp.billingservice.feign.CustomerRestClient;
import abdelali.tp.billingservice.feign.ProductItemRestClient;
import abdelali.tp.billingservice.model.Customer;
import abdelali.tp.billingservice.model.Product;
import abdelali.tp.billingservice.repository.BillRepository;
import abdelali.tp.billingservice.repository.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id) {
       Bill bill = billRepository.findById(id).get();
       Customer customer = customerRestClient.getCustomerById(bill.getCustomerId());
       bill.setCustomer(customer);
       bill.getProductItems().forEach(pi->{
           Product product = productItemRestClient.getProductById(pi.getProductId());
           pi.setProduct(product);
       });
       return bill;
    }
}
