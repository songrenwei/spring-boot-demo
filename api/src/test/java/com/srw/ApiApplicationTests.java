package com.srw;

import com.srw.business.helper.ParamDigestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ApiApplicationTests {

    @Test
    void contextLoads() {
        //两个请求一样，但是请求时间差一秒
        String req = "{\n" +
                "\"requestTime\" :\"20190101120001\",\n" +
                "\"requestValue\" :\"1000\",\n" +
                "\"requestKey\" :\"key\"\n" +
                "}";

        String req2 = "{\n" +
                "\"requestTime\" :\"20190101120002\",\n" +
                "\"requestValue\" :\"1000\",\n" +
                "\"requestKey\" :\"key\"\n" +
                "}";

        //全参数比对，所以两个参数MD5不同
        String dedupMD5 = ParamDigestHelper.delDuplicationMD5(req);
        String dedupMD52 = ParamDigestHelper.delDuplicationMD5(req2);
        System.out.println("req1MD5 = "+ dedupMD5+" , req2MD5="+dedupMD52);

        //去除时间参数比对，MD5相同
//        String dedupMD53 = ReqDedupHelper.dedupParamMD5(req,"requestTime");
//        String dedupMD54 = ReqDedupHelper.dedupParamMD5(req2,"requestTime");
//        System.out.println("req1MD5 = "+ dedupMD53+" , req2MD5="+dedupMD54);
















    }

}
