package icu.sunway.palmzjnubackend.service.impl;

import icu.sunway.palmzjnubackend.entity.Product;
import icu.sunway.palmzjnubackend.mapper.ProductMapper;
import icu.sunway.palmzjnubackend.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gushen
 * @since 2024-05-19
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
