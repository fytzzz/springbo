package com.example.demo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		int size = UserMapper.selectAll().size();
		UserMapper.insert(new User("aa", "a123456", "1", "aaa"));
		UserMapper.insert(new User("bb", "b123456", "2", "bbb"));
		UserMapper.insert(new User("cc", "b123456", "3", "ccc"));

		Assert.assertEquals(UserMapper.selectAll().size(), size + 3);
	}

	@Test
	public void testGetOne() throws Exception {
		User user = UserMapper.selectByPrimaryKey(1L);
		Long userId = user.getId();
		Assert.assertEquals(userId, Long.valueOf(1));
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = UserMapper.selectAll();
		System.out.println(users.toString());
	}

	@Test
	public void testUpdate() throws Exception {
		User user = UserMapper.selectByPrimaryKey(1L);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.updateByPrimaryKey(user);
		Assert.assertTrue(("neo".equals(UserMapper.selectByPrimaryKey(1L).getNickName())));
	}
}
