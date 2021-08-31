package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Description UserMapper
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    int deleteByPrimaryKey(Integer id);

    @Insert("insert into modelTwo (id, uname, password, age) " +
            "values (#{id,jdbcType=VARCHAR}, " +
            "#{uname,jdbcType=VARCHAR}, " +
            "#{password,jdbcType=VARCHAR})" +
            "#{age,jdbcType=INTEGER})")
    int insert(User record);


    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(User record);


    @Select("select * from modelTwo where id = #{id}")
    User selectLastId(Integer id);

}
