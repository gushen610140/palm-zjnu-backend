package icu.sunway.palmzjnubackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.sunway.palmzjnubackend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
