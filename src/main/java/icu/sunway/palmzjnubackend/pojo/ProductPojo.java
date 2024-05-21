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
@TableName(value = "product")
public class ProductPojo {

    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "price")
    private Double price;

    @TableField(value = "stock")
    private Integer stock;

    @TableField(value = "description")
    private String description;

    @TableField(value = "category_id")
    private Integer categoryId;

}
