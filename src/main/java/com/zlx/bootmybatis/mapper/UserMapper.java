package com.zlx.bootmybatis.mapper;

import com.zlx.bootmybatis.entity.User;
import org.apache.ibatis.annotations.*;

//指定这是一个mapper
@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    //自增id
//    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(id,name) values(#{id},#{name})")
    public int insertUser(User user);

    @Update("update user set name=#{name} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from user where id={id}")
    public int deleteUser(User user);

}
