package com.example.boot1cache.service;

import com.example.boot1cache.entity.User;
import com.example.boot1cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;


    /**
     * 讲方法的运行结果进行缓存，以后取相同数据，直接重缓存中取，不调用方法
     * cacheManager管理多个cache组件，对缓存真正的crdu操作在cache组件中，
     * 每一个缓存组件都一个自己的名字
     *  cacheName/value 指定缓存组件的名字，将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存
     *  key：缓存数据使用的key，默认使用方法参数的值 id，方法的返回值,key = "#id"
     *  spel表达式：#id ，#a0 #p0 #root.args[0]
     *  keyGenerate:key生成器，可以指定key生成器组件id
     *  key/keyGenerator:二选一使用
     *  cacheManager：指定缓存管理器，例如redis 或memorycache，
     *  或cacheResolver缓存解析器，也是二选一
     *  condition：指定符合条件才缓存,condition = "#id>0"
     *  unless:否定缓存，unless为true，方法的返回值就不会被缓存，可以获取结果进行判断
     *  unless = "#result==null" 为空就不缓存
     *  sync：是否使用异步模式x,异步的方式将缓存结果存在缓存中，但不能和unless一起使用
     *
     *  默认是simple缓存，concurrent
     *  1cacheManager(concrrentMapcacheManager)按名称得到组件cache(currentMapCache)
     *  2key是generator生成的，默认是simplekeygenerator
     *
     *  ,keyGenerator = "myKeyGenerator",unless = "#result==null"
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "user")
    public User getUser(Integer id){
        return userMapper.getUserById(id);
    }


    /**
     *  @CachePut,即调用方法，有更新缓存
     *  修改了数据库的某个数据，同事更新缓存
     *  先调方法，再将结果放在缓存
     *  1key = "#user.id"
     *  2key=result。id返回值的id
     *  指定放入缓存的id，以便下次查到跟新后的数据
     *  cacheable不能用result，因为在调用方法前就区得到缓存，此时返回值还没生成
     *
     * @param id
     * @return
     */
    @CachePut(cacheNames = "user",key = "#user.id")
    public User updateUser(User user){

        userMapper.updateUser(user);
        return user;
    }

    /**
     * 清除缓存，
     * key=“”#id指定要清除的数据
     * ,allEntries = true,默认删除user缓存的所有信息
     * beforeInvocation =true 缓存的清除是否在方法执行之前清除
     * 默认为false
     * @param id
     * @return
     */
    @CacheEvict(value = "user",key = "#id" )
    public void deleteUser(Integer id){
        System.out.println("删除");

    }
    /**
     * @Caching 结合了三个cache，可以同时指定多个规则
     */


}
