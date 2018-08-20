package com.example.demo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	private UserMapper UserMapper;
	
	@Test
	public void testInsert() throws Exception {	
		int size = UserMapper.getAll().size();
		UserMapper.insert(new UserEntity("aa", "a123456", "1"));
		UserMapper.insert(new UserEntity("bb", "b123456", "2"));
		UserMapper.insert(new UserEntity("cc", "b123456", "3"));

		Assert.assertEquals(UserMapper.getAll().size(),size + 3);
	}
	
	@Test
	public void testInsert2() throws Exception {		
		UserMapper.delete(1L);
		UserMapper.delete(2L);
		UserMapper.delete(3L);
		int size = UserMapper.getAll().size();
		UserMapper.insert2(new UserEntity(1L,"aa1", "a123456", "1"));
		UserMapper.insert2(new UserEntity(2L,"bb1", "b123456", "2"));
		UserMapper.insert2(new UserEntity(3L,"cc1", "b123456", "3"));
		Assert.assertEquals(UserMapper.getAll().size(),size + 3);
	}
	
	@Test
	public void testGetOne() throws Exception {
		UserEntity user = UserMapper.getOne(1L);
		Long userId = user.getId();
		Assert.assertEquals(userId,Long.valueOf(1));
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		System.out.println(users.toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(1L);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(1L).getNickName())));
	}
}
