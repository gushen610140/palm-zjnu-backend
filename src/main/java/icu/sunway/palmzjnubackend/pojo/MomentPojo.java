package icu.sunway.palmzjnubackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String userId;

    private String userName;

    private String userAvatar;

    private String date;

    private String content;

    private List<String> images;

    private Integer likes;

    private List<CommentPojo> comments;

}
