package icu.sunway.palmzjnubackend.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.sunway.palmzjnubackend.dao.MomentDao;
import icu.sunway.palmzjnubackend.pojo.CommentPojo;
import icu.sunway.palmzjnubackend.pojo.MomentPojo;
import icu.sunway.palmzjnubackend.type.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentService {
    private final MomentDao momentDao;

    public MomentService(MomentDao momentDao) {
        this.momentDao = momentDao;
    }

    public List<MomentPojo> getMomentsByPage(int current, int size) {
        QueryWrapper<MomentPojo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("date");
        return momentDao.selectPage(new Page<>(current, size), queryWrapper).getRecords();
    }

    public void addMoment(MomentPojo moment) {
        momentDao.insert(moment);
    }

    public Result<String> addLikes(String momentId, String userId) {
        QueryWrapper<MomentPojo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", momentId);
        MomentPojo moment = momentDao.selectOne(queryWrapper);
        JSONArray likes = JSON.parseArray(moment.getLikes());
        if (likes.contains(userId)) {
            return new Result<>(400, "fail", "用户已经喜欢");
        }
        likes.add(userId);
        String newLikes = JSON.toJSONString(likes);
        moment.setLikes(newLikes);
        momentDao.updateById(moment);
        return new Result<>(200, "success", newLikes);
    }

    public Result<MomentPojo> addMomentComment(CommentPojo commentPojo) {
        QueryWrapper<MomentPojo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", commentPojo.getMomentId());
        MomentPojo moment = momentDao.selectOne(queryWrapper);
        JSONArray momentComments = JSON.parseArray(moment.getComments());
        momentComments.add(commentPojo);
        moment.setComments(JSON.toJSONString(momentComments));
        momentDao.updateById(moment);
        return new Result<>(200, "success", moment);
    }

}
