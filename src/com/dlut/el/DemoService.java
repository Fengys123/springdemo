package com.dlut.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *  ${key名称}：
 * 1、用户获取外部文件中指定key的值
 * 2、可以出现在xml配置文件中，也可以出现在注解@Value中
 * 3、获取properties中环境变量
 * #{表达式}：
 * 1、SpEL表达式的格式，详情点击[Spring的EL表达式](http://blog.csdn.net/u012834750/article/details/79388294)
 * 2、可以出现在xml配置文件中，也可以出现在注解@Value中
 * 3、可以任意表达式，支持运算符等
 * ---------------------
 * 作者：淡淡的倔强
 * 来源：CSDN
 * 原文：https://blog.csdn.net/u012834750/article/details/79388373
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
@Configuration
@Service
@PropertySource("classpath:com/dlut/el/test.properties")
public class DemoService
{
    @Value("属性")
    private String another;

    /*public void setAnother(String another)
    {
        this.another = another;
    }

    public String getAnother()
    {
        return another;
    }*/

    //注入系统的属性
    @Value("#{systemProperties['os.name']}")
    private String OSName;

    //注入一个随机数
    @Value("#{T(java.lang.Math).random() * 100}")
    private double randomNumber;

    //注入一个URL地址
    @Value("http://www.baidu.com")
    private Resource testUrl;

    //注入一个文件
    @Value("classpath:com/dlut/el/test.txt")
    private Resource testFile;

    //注入配置文件方法一
    @Value("${book.name}")
    private String bookName;

    //注入配置文件方法二
    @Autowired
    private Environment environment;

    //注入配置文件方法三
    //@Bean
    /*public static PropertyPlaceholderConfigurer propertyConfigure()
    {
        return new PropertyPlaceholderConfigurer();
    }*/

    public void outputResource()
    {
        System.out.println("another:" + another);
        System.out.println("OSName:" + OSName);
        System.out.println("randomNumber:" + randomNumber);
        try
        {
            System.out.println("testUrl:" + testUrl.getURI());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("testFile:" + testFile.getFilename());
        try
        {
            System.out.println("testFile:" + IOUtils.toString(testFile.getInputStream()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("bookName:" + bookName);
        System.out.println("environment:" + environment.getProperty("book.author"));
        //这个配置累不会用,明天研究一下
        //propertyConfigure().set;
        //System.out.println("bookName:" + );
    }


}
