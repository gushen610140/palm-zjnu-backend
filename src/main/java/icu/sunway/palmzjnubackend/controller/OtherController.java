package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.type.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class OtherController {

    @Value("${picture-path.dir}")
    private String picturePath;

    @PostMapping("/api/image")
    public Result<String> postImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = picturePath + fileName;
            file.transferTo(new File(filePath));
            return new Result<>(200, "success", fileName);
        } catch (IOException e) {
            return new Result<>(400, "fail", e.getMessage());
        }
    }
}
