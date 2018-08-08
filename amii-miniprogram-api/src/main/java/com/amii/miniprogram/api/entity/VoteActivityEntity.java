package com.amii.miniprogram.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "amp_vote_activity")
public class VoteActivityEntity
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;

    @Column(name = "publish_user_id")
    @JsonProperty("publish_user_id")
    private Integer publishUserId;

    @Column(name = "uid")
    @JsonProperty("uid")
    private String uid;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "weixin")
    @JsonProperty("weixin")
    private String weixin;

    @Column(name = "miniprogram_url")
    @JsonProperty("miniprogram_url")
    private String miniprogramUrl;

    @Column(name = "vote_type")
    @JsonProperty("vote_type")
    private Integer voteType;

    @Column(name = "start_time")
    @JsonProperty("start_time")
    private Integer startTime;

    @Column(name = "end_time")
    @JsonProperty("end_time")
    private Integer endTime;

    @Column(name = "create_time")
    @JsonProperty("create_time")
    private Integer createTime;

    @Column(name = "update_time")
    @JsonProperty("update_time")
    private Integer updateTime;

    @Column(name = "delete_time")
    @JsonProperty("delete_time")
    private Integer deleteTime;

    public Integer getId ()
    {
        return id;
    }

    public Integer getPublishUserId ()
    {
        return this.publishUserId;
    }

    public void setPublishUserId (Integer publishUserId)
    {
        this.publishUserId = publishUserId;
    }

    public String getUid ()
    {
        return this.uid;
    }

    public void setUid (String uid)
    {
        this.uid = uid;
    }

    public String getName ()
    {
        return this.name;
    }

    public void setName (
        String name)
    {
        this.name = name;
    }

    public String getWeixin ()
    {
        return this.weixin;
    }

    public void setWeixin (
        String weixin)
    {
        this.weixin = weixin;
    }

    public String getMiniprogramUrl ()
    {
        return this.miniprogramUrl;
    }

    public void setMiniprogramUrl (
        String miniprogramUrl)
    {
        this.miniprogramUrl = miniprogramUrl;
    }

    public Integer getVoteType ()
    {
        return this.voteType;
    }

    public void setVoteType (
        Integer voteType)
    {
        this.voteType = voteType;
    }

    public Integer getStartTime ()
    {
        return this.startTime;
    }

    public void setStartTime (
        Integer startTime)
    {
        this.startTime = startTime;
    }

    public Integer getEndTime ()
    {
        return this.endTime;
    }

    public void setEndTime (
        Integer endTime)
    {
        this.endTime = endTime;
    }

    public Integer getCreateTime ()
    {
        return this.createTime;
    }

    public void setCreateTime (
        Integer createTime)
    {
        this.createTime = createTime;
    }

    public Integer getUpdateTime ()
    {
        return this.updateTime;
    }

    public void setUpdateTime (
        Integer updateTime)
    {
        this.updateTime = updateTime;
    }

    public Integer getDeleteTime ()
    {
        return this.deleteTime;
    }

    public void setDeleteTime (
        Integer deleteTime)
    {
        this.deleteTime = deleteTime;
    }
}
