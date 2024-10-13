package abdelali.tp.customerservice;

import abdelali.tp.customerservice.entities.Customer;
import abdelali.tp.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguraion) {
        restConfiguraion.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null,"abdelali", "abdelali@gmail.com"));
            customerRepository.save(new Customer(null,"etoo", "etoo@gmail.com"));
            customerRepository.save(new Customer(null,"abia", "abia@gmail.com"));
            customerRepository.save(new Customer(null,"ayman", "ayman@gmail.com"));
            customerRepository.findAll().forEach(c->
                    System.out.println(c.toString()));
        };
    }

}
