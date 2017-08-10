/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年3月28日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.test
 * Test.java
 */
package com.tsdvip.test;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsdvip.dao.UserDao;
import com.tsdvip.service.BoardService;
import com.tsdvip.service.BoardServiceImp;


/**
 * 
 * @author 
 * @since 2017年3月28日 下午12:38:16
 * @version   
 */
public class MybatisTest {
	

	@Resource
	private UserDao userDao;
	ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-service.xml","spring-mybatis.xml");
	}
	
	@Test
	public void testDataSource(){
		BoardService service = ctx.getBean("boardService",BoardServiceImp.class);
		
		System.out.println(service.listBoards());
	}
	
	/*@Test
	public void testSqlSessionFactory(){
		SqlSessionFactory ssf = ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(ssf);
	}
	
	@Test
	public void testMapperScanner(){
		MapperScannerConfigurer mapper = ctx.getBean("mapperScanner",MapperScannerConfigurer.class);
		System.out.println(mapper);
	}
	*/
	
}
