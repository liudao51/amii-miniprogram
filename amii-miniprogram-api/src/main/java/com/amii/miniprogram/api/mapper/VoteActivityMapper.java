package com.amii.miniprogram.api.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.amii.miniprogram.api.entity.VoteActivityEntity;

@Mapper
public interface VoteActivityMapper
{
    @Select("SELECT * FROM amp_vote_activity WHERE id = #{id}")
    @Results({
                 @Result(property = "id", column = "id"),
                 @Result(property = "publishUserId", column = "publish_user_id"),
                 @Result(property = "uid", column = "uid"),
                 @Result(property = "name", column = "name"),
                 @Result(property = "weixin", column = "weixin"),
                 @Result(property = "miniprogramUrl", column = "miniprogram_url"),
                 @Result(property = "voteType", column = "vote_type"),
                 @Result(property = "startTime", column = "start_time"),
                 @Result(property = "endTime", column = "end_time"),
                 @Result(property = "createTime", column = "create_time"),
                 @Result(property = "updateTime", column = "update_time"),
                 @Result(property = "deleteTime", column = "delete_time")
             })
    public VoteActivityEntity getOne (@Param("id") Integer id);

    @Select("SELECT * FROM amp_vote_activity WHERE delete_time = 0")
    @Results({
                 @Result(property = "id", column = "id"),
                 @Result(property = "publishUserId", column = "publish_user_id"),
                 @Result(property = "uid", column = "uid"),
                 @Result(property = "name", column = "name"),
                 @Result(property = "weixin", column = "weixin"),
                 @Result(property = "miniprogramUrl", column = "miniprogram_url"),
                 @Result(property = "voteType", column = "vote_type"),
                 @Result(property = "startTime", column = "start_time"),
                 @Result(property = "endTime", column = "end_time"),
                 @Result(property = "createTime", column = "create_time"),
                 @Result(property = "updateTime", column = "update_time"),
                 @Result(property = "deleteTime", column = "delete_time")
             })
    public List<VoteActivityEntity> getList ();
}
