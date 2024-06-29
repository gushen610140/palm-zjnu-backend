package icu.sunway.palmzjnubackend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.sunway.palmzjnubackend.dao.MomentDao;
import icu.sunway.palmzjnubackend.pojo.MomentPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentService {
    private final MomentDao momentDao;

    public MomentService(MomentDao momentDao) {
        this.momentDao = momentDao;
    }

    public List<MomentPojo> getMomentsByPage(int current, int size) {
        return momentDao.selectPage(new Page<>(current, size), null).getRecords();
    }


}
