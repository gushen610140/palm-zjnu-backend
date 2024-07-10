package icu.sunway.palmzjnubackend.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("banners")
public class Banner {
    @TableId
    private String url;
}
