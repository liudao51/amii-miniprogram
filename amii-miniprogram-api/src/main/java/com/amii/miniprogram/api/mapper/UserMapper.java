package com.amii.miniprogram.api.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.amii.miniprogram.api.entity.UserEntity;

public interface UserMapper
{
    @Select("SELECT * FROM users")
    @Results({
                 @Result(property = "nickname", column = "nickname"),
                 @Result(property = "phone", column = "phone")
             })
    public List<UserEntity> getAll ();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
                 @Result(property = "nickname", column = "nickname"),
                 @Result(property = "phone", column = "phone")
             })
    public UserEntity getOne (Long id);

    @Insert("INSERT INTO users(nickname,phone) VALUES(#{nickname}, #{phone})")
    public void insert (UserEntity user);

    @Update("UPDATE users SET nickname=#{nickname},phone=#{phone} WHERE id =#{id}")
    public void update (UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    public void delete (Long id);
}
