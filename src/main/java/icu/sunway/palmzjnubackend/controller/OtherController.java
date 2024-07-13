package icu.sunway.palmzjnubackend.controller;

import icu.sunway.palmzjnubackend.model.Result;
import icu.sunway.palmzjnubackend.utils.AliOssUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class OtherController {

    private final AliOssUtil aliOssUtil;

    public OtherController(AliOssUtil aliOssUtil) {
        this.aliOssUtil = aliOssUtil;
    }

    @PostMapping("/api/upload")
    //请求中要携带上需要上传的文件
    public Result<String> saveOss(MultipartFile file) {
        try {
            // 获取原始的文件名
            String originalFilename = file.getOriginalFilename();
            // 在oss中存储名字就是UUID + 文件的后缀名
            String objectName = null;
            if (originalFilename != null) {
                objectName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            String resultURL = aliOssUtil.upload(file.getBytes(), objectName);
            return new Result<>(200, "success", resultURL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/secret")
    public Result<String> getSecret() {
        return new Result<>(200, "success", "wx622113ff58e2b46b,360464608fc569e5867a35e4cf5bb309");
    }
}
