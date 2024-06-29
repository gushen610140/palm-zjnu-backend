package icu.sunway.palmzjnubackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "moments")
public class MomentPojo {

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

    @TableField(value = "images")
    private List<String> images;

    @TableField(value = "likes")
    private Integer likes;

    @TableField(value = "comments")
    private List<CommentPojo> comments;

}
