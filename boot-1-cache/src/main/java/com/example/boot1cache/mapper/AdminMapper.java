package com.example.boot1cache.mapper;


import com.example.boot1cache.entity.Admin;
import org.apache.ibatis.annotations.*;

//@Mapper
//所有的maper都要加上这个，很麻烦，在主配置的类加上@MapperScan
public interface AdminMapper {


    @Select("select * from admin where a_id=#{id}")
    public Admin getUserById(Integer id);

    //自增id
//    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into admin(a_id,a_name) values(#{id},#{name})")
    public int insertUser(Admin admin);

    @Update("update admin set name=#{a_name} where id=#{id}")
    public int updateUser(Admin admin);

    @Delete("delete from admin where id={a_id}")
    public int deleteUser(Admin admin);

}
