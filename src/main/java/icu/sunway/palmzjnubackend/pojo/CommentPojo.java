package icu.sunway.palmzjnubackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPojo {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String userId;

    private String userName;

    private String userAvatar;

    private String date;

    private String content;

    private Integer likes;
}
