package icu.sunway.palmzjnubackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.sunway.palmzjnubackend.pojo.UsersPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersDao extends BaseMapper<UsersPojo> {
}
