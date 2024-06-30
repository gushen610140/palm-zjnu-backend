package icu.sunway.palmzjnubackend.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("banners")
public class BannerPojo {
    @TableId
    private String url;
}
