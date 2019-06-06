package com.chayton;

import com.chayton.dynamicds.DynamicDataSourceApplication;
import com.chayton.dynamicds.service.IDateSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 17:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicDataSourceApplication.class)
public class TestDynamicDS {

    private Logger logger = LoggerFactory.getLogger(TestDynamicDS.class);
    //
    @Autowired
    private IDateSourceService dynamicServcice;

    @Test
    public void test() {
//        Integer integer = dynamicServcice.ds1();
//        logger.info("integer:"+integer);
//        String ds2 = dynamicServcice.ds2();
//        logger.info("ds2:"+ds2);
        List<String> master = dynamicServcice.findMaster();
        logger.info("master:{}", master);

        List<String> boots = dynamicServcice.findApt();
        logger.info("apt:{}", boots);
        List<String> schools = dynamicServcice.findSchool();
        logger.info("schools:{}", schools);
    }

}