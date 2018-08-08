package com.amii.miniprogram.api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amii.miniprogram.api.constant.ApiConstant;
import com.amii.miniprogram.api.entity.VoteActivityEntity;
import com.amii.miniprogram.api.exception.AppException;
import com.amii.miniprogram.api.mapper.VoteActivityMapper;
import com.amii.miniprogram.api.util.LogToolkit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Repository
public class VoteActivityDao
{
    @Autowired
    private VoteActivityMapper voteActivityMapper;

    /**
     * TODO: 获取一个活动详情
     *
     * @param id
     *
     * @return VoteActivityEntity
     */
    public VoteActivityEntity oneVoteActivity (Integer id)
    {
        VoteActivityEntity voteActivity = null;

        try {
            voteActivity = voteActivityMapper.getOne(id);
        } catch (Exception e) {
            throw new AppException(ApiConstant.Message.CODE_11103, 11103);
        }

        return voteActivity;
    }

    /**
     * TODO: 获取活动列表
     *
     * @return List
     */
    public Map<String, Object> listVoteActivity (Integer page, Integer pageSize)
    {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            PageHelper.startPage(page, pageSize, true);
            // 查询结果
            List<VoteActivityEntity> voteActivityEntityList = voteActivityMapper.getList();
            map.put("voteActivityEntityList", voteActivityEntityList);

            // 分页信息
            PageInfo<VoteActivityEntity> pageInfo = new PageInfo<VoteActivityEntity>(voteActivityEntityList);
            map.put("pageInfo", pageInfo);
        } catch (Exception e) {
            throw new AppException(ApiConstant.Message.CODE_11103, 11103);
        }

        return map;
    }
}
