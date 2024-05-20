package icu.sunway.palmzjnubackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.sunway.palmzjnubackend.pojo.ProductPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<ProductPojo> {
}
