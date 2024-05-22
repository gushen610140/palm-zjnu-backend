package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.dao.ProductDao;
import icu.sunway.palmzjnubackend.pojo.ProductPojo;
import icu.sunway.palmzjnubackend.type.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<ProductPojo> getAllProducts() {
        return productDao.selectList(null);
    }

    public Status addProduct(String name, double price, int stock, String description, int categoryId) {
        ProductPojo product = new ProductPojo(null, name, price, stock, description, categoryId);
        if (productDao.insert(product) > 0) {
            return Status.SUCCESS;
        } else {
            return Status.ERROR;
        }
    }
}
