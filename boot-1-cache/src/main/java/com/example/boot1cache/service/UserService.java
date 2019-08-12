package com.example.boot1cache.service;

import com.example.boot1cache.entity.User;
import com.example.boot1cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;


    /**
     * 讲方法的运行结果进行缓存，以后取相同数据，直接重缓存中取，不调用方法
     * cacheManager管理多个cache组件，对缓存真正的crdu操作在cache组件中，
     * 每一个缓存组件都一个自己的名字
     *  cacheName/value 指定缓存组件的名字
     *  key：缓存数据使用的key，默认使用方法参数的值 id，方法的返回值
     *  spel表达式：#id ，#a0 #p0 #root.args[0]
     *  keyGenerate:key生成器，可以指定key生成器组件id
     *  key/keyGenerator:二选一使用
     *  cacheManager：指定缓存管理器，例如redis 或memorycache，
     *  或cacheResolver缓存解析器，也是二选一
     *  condition：指定符合条件才缓存,condition = "#id>0"
     *  unless:否定缓存，unless为true，方法的返回值就不会被缓存，可以获取结果进行判断
     *  unless = "#result==null" 为空就不缓存
     *  sync：是否使用异步模式x
     *
     *  默认是simple缓存，concurrent
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "user",key = "#id",unless = "#result==null")
    public User getUser(Integer id){
        return userMapper.getUserById(id);
    }

}
