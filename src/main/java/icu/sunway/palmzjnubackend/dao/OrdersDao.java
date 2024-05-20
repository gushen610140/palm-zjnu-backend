package icu.sunway.palmzjnubackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.sunway.palmzjnubackend.pojo.OrdersPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersDao extends BaseMapper<OrdersPojo> {
}
