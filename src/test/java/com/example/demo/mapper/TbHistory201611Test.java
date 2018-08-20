package com.example.demo.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.TbHistory201611;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbHistory201611Test {

	@Autowired
	private TbHistory201611Mapper tbHistory201611Mapper;

	@Test
	public void testGetOne() throws Exception {
		TbHistory201611 history = tbHistory201611Mapper.getOne(80L);
		Integer hisId = history.getId();
		Assert.assertEquals(hisId, Integer.valueOf((int) 80L));
	}

	@Test
	public void testInsert() {
		TbHistory201611 history = tbHistory201611Mapper.getOne(80L);
		history.setPhone("15220289885");
		tbHistory201611Mapper.insert(history);
	}
}
