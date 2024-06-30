package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.dao.BannerDao;
import icu.sunway.palmzjnubackend.pojo.BannerPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    private final BannerDao bannerDao;

    public BannerService(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

    public List<BannerPojo> getAllBanners() {
        return bannerDao.selectList(null);
    }
}
