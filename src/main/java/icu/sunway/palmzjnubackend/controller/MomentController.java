package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.MomentPojo;
import icu.sunway.palmzjnubackend.service.MomentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MomentController {
    private final MomentService momentService;

    public MomentController(MomentService momentService) {
        this.momentService = momentService;
    }

    @GetMapping(value = "/api/moments")
    public List<MomentPojo> getMomentsByPage(int current, int size) {
        return momentService.getMomentsByPage(current, size);
    }
}
