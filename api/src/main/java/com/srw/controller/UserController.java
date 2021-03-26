package com.srw.controller;

import com.alibaba.excel.EasyExcel;
import com.srw.business.UserService;
import com.srw.common.bean.JsonResult;
import com.srw.common.component.QRcode;
import com.srw.common.component.excel.DataModel;
import com.srw.common.component.excel.DownloadData;
import com.srw.persistence.entity.User;
import com.srw.persistence.mongodb.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    //    ========================================export======================================

    @GetMapping("export")
    public void export(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DataModel.class).sheet("模板").doWrite(data());
    }

    private List<DownloadData> data() {
        List<DownloadData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DownloadData data = new DownloadData();
            data.setString("字符串" + 0);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}
