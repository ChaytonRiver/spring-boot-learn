package com.chayton.i18n.web.controller;

import com.chayton.i18n.web.model.LoginModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 11:18
 */
@RestController
@RequestMapping("/api/i18n")
public class I18nController {


    @PostMapping("/login")
    public ResponseEntity login(@Validated @RequestBody LoginModel loginModel) {

        return ResponseEntity.ok("OK");
    }


    @GetMapping()
    public ResponseEntity changeLanguage() {
        return ResponseEntity.ok("OK");
    }
}
