package com.srw;

import cn.hutool.core.io.FileUtil;
import com.srw.business.helper.ParamDigestHelper;
import com.srw.proxy.MyMethodInterceptor;
import com.srw.proxy.ProxyFactory;
import com.srw.proxy.RealSubject;
import com.srw.proxy.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;

@SpringBootTest
class ApiApplicationTests {

    @Autowired
    ProxyFactory proxyFactory;

    static{
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\code");
    }

    @Test
    void testJdkProxy() {
        Subject subject = (Subject)proxyFactory.getProxyInstance();
        subject.request();
        subject.request2();
    }

    @Test
    void testCglibProxy() {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(RealSubject.class);
        //设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());

        //这里的creat方法就是正式创建代理类
        RealSubject proxyDog = (RealSubject) enhancer.create();
        //调用代理类的eat方法
        proxyDog.request();
        proxyDog.request2();
    }

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
