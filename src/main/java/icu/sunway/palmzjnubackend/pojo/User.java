package icu.sunway.palmzjnubackend.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "users")
public class User {

    @TableId
    private String userId;

    private String userName;

    private String userAvatar;

}
