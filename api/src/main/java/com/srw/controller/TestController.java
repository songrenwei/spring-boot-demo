package com.srw.controller;

import com.alibaba.excel.EasyExcel;
import com.srw.common.component.excel.DataModel;
import com.srw.common.component.excel.DownloadData;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2020/12/31 16:27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/getConfig")
    public R getConfig() throws Exception {
        return R.success();
    }

    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding("utf-8");
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

    public static void main(String[] args) {
        System.out.println("song".indexOf("ong"));
    }

}
