package icu.sunway.palmzjnubackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.sunway.palmzjnubackend.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
