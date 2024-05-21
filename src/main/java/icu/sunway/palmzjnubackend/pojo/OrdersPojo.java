package icu.sunway.palmzjnubackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "orders")
public class OrdersPojo {

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "order_time")
    private String orderTime;

    @TableField(value = "total_price")
    private double totalPrice;

    @TableField(value = "status")
    private String status;

}
