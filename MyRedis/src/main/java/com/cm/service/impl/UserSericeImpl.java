package com.cm.service.impl;

import com.cm.bean.User;
import com.cm.common.Pager;
import com.cm.dao.UserDAO;
import com.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSericeImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RedisTemplate redisTemplate;

    private ValueOperations<String,User> valueOperations;


    @Override
    public void save(Object obj) {

    }

    @Override
    public void remove(Object obj) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(Object obj) {
        userDAO.update(obj);
        Long id = ((User) obj).getId();
        valueOperations = redisTemplate.opsForValue();
        User user = valueOperations.get("user-"+id);
        if (user != null) {
            Object object =  userDAO.getById(id);
            if (object != null) {
                valueOperations.set("user-"+id,(User) object);
            }
        }
    }

    @Override
    public Object getById(Long id) {
        Object object = userDAO.getById(id);
        valueOperations = redisTemplate.opsForValue();
        User user = valueOperations.get("user-"+id);
        if (user != null){
            System.out.println("从缓存中获取");
            return user;
        }else{
            if (object != null) {
                valueOperations.set("user-"+id,(User)object);
            }
            System.out.println("从数据库获取");
            return object;
        }
    }

    @Override
    public List<Object> listAll() {
        return null;
    }

    @Override
    public Pager listPager(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
        return null;
    }
}
