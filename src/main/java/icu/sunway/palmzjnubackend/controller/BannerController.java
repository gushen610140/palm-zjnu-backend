package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.BannerPojo;
import icu.sunway.palmzjnubackend.service.BannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {
    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/api/banners")
    public List<BannerPojo> getAllBanners() {
        return bannerService.getAllBanners();
    }
}
