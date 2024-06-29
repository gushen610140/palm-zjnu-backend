package icu.sunway.palmzjnubackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPojo {

    @TableId(value = "_id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "user_avatar")
    private String userAvatar;

    @TableField(value = "date")
    private String date;

    @TableField(value = "content")
    private String content;

    @TableField(value = "likes")
    private Integer likes;
}
