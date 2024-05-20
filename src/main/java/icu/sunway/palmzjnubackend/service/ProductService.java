package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.dao.ProductDao;
import icu.sunway.palmzjnubackend.pojo.ProductPojo;
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
}
