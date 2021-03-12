package com.srw;

import com.srw.client.MyClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/3/12 14:38
 */
@SpringBootTest
public class ForestTest {

    @Autowired
    private MyClient myClient;

    @Test
    public void test() {
        myClient.getLocation("124.730329","31.463683");
    }

}
