package abdelali.tp.billingservice;

import abdelali.tp.billingservice.entities.Bill;
import abdelali.tp.billingservice.entities.ProductItem;
import abdelali.tp.billingservice.feign.CustomerRestClient;
import abdelali.tp.billingservice.feign.ProductItemRestClient;
import abdelali.tp.billingservice.model.Customer;
import abdelali.tp.billingservice.model.Product;
import abdelali.tp.billingservice.repository.BillRepository;
import abdelali.tp.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClient customerRestClient,
            ProductItemRestClient productItemRestClient) {
        return args -> {
            Customer customer = customerRestClient.getCustomerById(1L);
            Bill bill1 = billRepository.save(new Bill(null,new Date(),null,customer.getId(),null));
            PagedModel<Product> productPagedModel = productItemRestClient.pageProducts(1,1);
            productPagedModel.forEach(p->{
                ProductItem productItem = new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setBill(bill1);
                productItem.setProductId(p.getId());
                productItemRepository.save(productItem);
            });
        };
    }

}
