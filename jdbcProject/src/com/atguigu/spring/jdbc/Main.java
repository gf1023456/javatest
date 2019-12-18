package com.atguigu.spring.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Main {
	 ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
     
     JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);
	/**
	 * 增删改的通用方法
	 */
	@Test
	public void t1() {
		// TODO Auto-generated method stub
          
            //id name age
          /*  String sql="insert into student values(null,?,?)";
            int row = jt.update(sql, "tom",20);
            System.out.println(row);*/
            
           /* jt.update("update student set name=?,age=? where id=?","jack",30,1);*/
            
	}
	
	 /**
	  * 查询一行一列
	  */
	@Test
	public void t2() {
		 String stuName = jt.queryForObject("select name from student where id=?", String.class,1);
		 System.out.println(stuName);
		
	}
	
	 /**
	  * 查询一行多列
	  */
	@Test
	public void t3() {
		 //orm 对象关系映射
		RowMapper<Student> rowMapper=new BeanPropertyRowMapper<>(Student.class);
		 Student stu = jt.queryForObject("select * from student where id=?", rowMapper,1);
		 System.out.println(stu);
		
	}
	 /**
	  * 查询多行多列
	  */
	@Test
	public void t4() {
		 //orm 对象关系映射
		RowMapper<Student> rowMapper=new BeanPropertyRowMapper<>(Student.class);
		List<Student> stu = jt.query("select * from student", rowMapper);
		 System.out.println(stu);
		
	}
	
	
	/**
	 * 批量增删改
	 */
	 @Test
	public void t5() {
		   List<Object[]> args=new ArrayList<Object[]>();
		    args.add(new Object[] {1});
		    args.add(new Object[] {2});
		   // args.add(new Object[] {"赵六",60});
		   
		   
		//  int[] batchUpdate = jt.batchUpdate("insert into student values(null,?,?)", args);
		  /*int[] batchUpdate = jt.batchUpdate("delete from student where id=?", args);*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
            
            


}
