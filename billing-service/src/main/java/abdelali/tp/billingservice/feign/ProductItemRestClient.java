package abdelali.tp.billingservice.feign;

import abdelali.tp.billingservice.model.Product;
import jakarta.ws.rs.QueryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping("/products")
    PagedModel<Product> pageProducts(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "size") int size
    );

    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);
}
