package icu.sunway.palmzjnubackend.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.sunway.palmzjnubackend.mapper.MomentMapper;
import icu.sunway.palmzjnubackend.model.Comment;
import icu.sunway.palmzjnubackend.model.Moment;
import icu.sunway.palmzjnubackend.type.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentService {
    private final MomentMapper momentMapper;

    public MomentService(MomentMapper momentMapper) {
        this.momentMapper = momentMapper;
    }

    public Result<List<Moment>> getMoments(int current, int size) {
        QueryWrapper<Moment> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("date");
        List<Moment> moments = momentMapper.selectPage(new Page<>(current, size), queryWrapper).getRecords();
        return new Result<>(200, "success", moments);
    }

    public Result<Moment> postMoment(Moment moment) {
        momentMapper.insert(moment);
        return new Result<>(200, "success", moment);
    }

    public Result<String> putMomentLikes(String momentId, String userId) {
        QueryWrapper<Moment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", momentId);
        Moment moment = momentMapper.selectOne(queryWrapper);
        JSONArray likes = JSON.parseArray(moment.getLikes());
        if (likes.contains(userId)) {
            return new Result<>(400, "fail", moment.getLikes());
        }
        likes.add(userId);
        String newLikes = JSON.toJSONString(likes);
        moment.setLikes(newLikes);
        momentMapper.updateById(moment);
        return new Result<>(200, "success", newLikes);
    }

    public Result<Moment> putMomentComments(Comment comment) {
        QueryWrapper<Moment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", comment.getMomentId());
        Moment moment = momentMapper.selectOne(queryWrapper);
        JSONArray momentComments = JSON.parseArray(moment.getComments());
        momentComments.add(comment);
        moment.setComments(JSON.toJSONString(momentComments));
        momentMapper.updateById(moment);
        return new Result<>(200, "success", moment);
    }

}
