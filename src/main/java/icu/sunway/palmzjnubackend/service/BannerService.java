package icu.sunway.palmzjnubackend.service;

import icu.sunway.palmzjnubackend.mapper.BannerMapper;
import icu.sunway.palmzjnubackend.model.Banner;
import icu.sunway.palmzjnubackend.type.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    private final BannerMapper bannerMapper;

    public BannerService(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }

    public Result<List<Banner>> getBanners() {
        return new Result<>(200, "success", bannerMapper.selectList(null));
    }
}
