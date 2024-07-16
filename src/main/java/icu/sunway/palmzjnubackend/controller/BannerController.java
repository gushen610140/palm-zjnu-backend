package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.model.Banner;
import icu.sunway.palmzjnubackend.model.Result;
import icu.sunway.palmzjnubackend.service.BannerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class BannerController {
    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/api/banners")
    public Result<List<Banner>> getBanners() {
        return bannerService.getBanners();
    }
}
