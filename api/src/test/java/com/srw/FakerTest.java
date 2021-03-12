package com.srw;

import com.github.javafaker.Faker;
import com.srw.mock.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/12/25 16:32
 */
@SpringBootTest
public class FakerTest {

    @Test
    public void testFake() {

        Faker fakerWithCN = new Faker(Locale.CHINA); // 中国

        for (int i = 0; i < 10; i++) {

            UserInfo userInfo = new UserInfo();

            userInfo.setRealName(fakerWithCN.name().fullName());
            userInfo.setCellPhone(fakerWithCN.phoneNumber().cellPhone());
            userInfo.setCity(fakerWithCN.address().city());
            userInfo.setStreet(fakerWithCN.address().streetAddress());
            userInfo.setUniversityName(fakerWithCN.university().name());
            System.out.println("userInfo = " + userInfo);

        }

    }

}
