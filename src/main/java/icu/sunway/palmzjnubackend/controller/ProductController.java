package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.ProductPojo;
import icu.sunway.palmzjnubackend.service.ProductService;
import icu.sunway.palmzjnubackend.type.PostedProduct;
import icu.sunway.palmzjnubackend.type.Status;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "api/products", method = RequestMethod.GET)
    public List<ProductPojo> getAllUsers() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "api/product", method = RequestMethod.POST)
    public Status addUser(@RequestBody PostedProduct product) {
        return productService.addProduct(product.getName(), product.getPrice(), product.getStock(), product.getDescription(), product.getCategoryId());
    }
}
