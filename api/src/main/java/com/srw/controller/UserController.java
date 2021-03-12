package com.srw.controller;

import com.srw.business.UserService;
import com.srw.common.bean.JsonResult;
import com.srw.common.component.QRcode;
import com.srw.persistence.entity.User;
import com.srw.persistence.mongodb.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/10/13
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final QRcode qRcode;

    @GetMapping("/findList")
    public JsonResult<?> findList() {
        return JsonResult.successResponse(userService.findList());
    }

    @GetMapping("/query/{id}")
    public JsonResult<?> query(@PathVariable("id") Long id) {
        return JsonResult.successResponse(userService.query(id));
    }

    @PostMapping("/create")
    public JsonResult<?> create(@RequestBody User user) {
        return JsonResult.successResponse(userService.save(user));
    }

    @PostMapping("/delete")
    public JsonResult<?> delete(User user) {
        return JsonResult.successResponse(userService.delete(user));
    }

    @PostMapping("/update")
    public JsonResult<?> update(@RequestBody User user) {
        return JsonResult.successResponse(userService.update(user));
    }

    //    ========================================MongoDB======================================

    @PostMapping("/save")
    public JsonResult<?> save(@RequestBody UserInfo userInfo) {
        return JsonResult.successResponse(userService.save(userInfo));
    }

    @GetMapping("/list")
    public JsonResult<?> list() {
        return JsonResult.successResponse(userService.list());
    }


    @DeleteMapping("/remove")
    public JsonResult<?> remove(Long id) {
        return JsonResult.successResponse(userService.remove(id));
    }

    //    ========================================QRcode======================================

    @GetMapping("/qrcode")
    public void qrcode(HttpServletResponse response) {
        qRcode.generateQRcode(response);
    }

}
