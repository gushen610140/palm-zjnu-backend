package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.model.Comment;
import icu.sunway.palmzjnubackend.model.Moment;
import icu.sunway.palmzjnubackend.model.Result;
import icu.sunway.palmzjnubackend.service.MomentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MomentController {
    private final MomentService momentService;

    public MomentController(MomentService momentService) {
        this.momentService = momentService;
    }

    @GetMapping(value = "/api/moments")
    public Result<List<Moment>> getMoments(int current, int size) {
        return momentService.getMoments(current, size);
    }

    @PostMapping("/api/moment")
    public Result<Moment> postMoment(@RequestBody Moment moment) {
        return momentService.postMoment(moment);
    }

    @PutMapping("/api/moment/likes")
    public Result<String> putMomentLikes(@RequestParam String momentId, @RequestParam String userId) {
        return momentService.putMomentLikes(momentId, userId);
    }

    @PutMapping("/api/moment/comments")
    public Result<Moment> putMomentComments(@RequestBody Comment comment) {
        return momentService.putMomentComments(comment);
    }
}
