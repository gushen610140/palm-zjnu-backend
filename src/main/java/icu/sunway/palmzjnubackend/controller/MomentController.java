package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.pojo.CommentPojo;
import icu.sunway.palmzjnubackend.pojo.MomentPojo;
import icu.sunway.palmzjnubackend.service.MomentService;
import icu.sunway.palmzjnubackend.type.Result;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/moments/likes/add")
    public Result<String> addMomentLike(@RequestParam String momentId, @RequestParam String userId) {
        return momentService.addLikes(momentId, userId);
    }

    @PostMapping("/api/moments/comments/add")
    public Result<MomentPojo> addMomentComment(@RequestBody CommentPojo comment) {
        return momentService.addMomentComment(comment);
    }
}
