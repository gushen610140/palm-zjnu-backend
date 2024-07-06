package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.MomentPojo;
import icu.sunway.palmzjnubackend.service.MomentService;
import icu.sunway.palmzjnubackend.type.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MomentController {
    private final MomentService momentService;

    public MomentController(MomentService momentService) {
        this.momentService = momentService;
    }

    @GetMapping(value = "/api/moments")
    public Result<List<MomentPojo>> getMomentsByPage(int current, int size) {
        List<MomentPojo> moments = momentService.getMomentsByPage(current, size);
        return new Result<>(200, "success", moments);
    }

    @PostMapping("/api/moments")
    public void addMoment(@RequestBody MomentPojo moment) {
        momentService.addMoment(moment);
    }
}
