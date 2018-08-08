package com.amii.miniprogram.api.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amii.miniprogram.api.dao.VoteActivityDao;
import com.amii.miniprogram.api.entity.VoteActivityEntity;

@Service
public class VoteActivityService
{
    @Autowired
    private VoteActivityDao voteActivityDao;

    /**
     * TODO: 发布投票活动
     *
     * @return
     */
    public Boolean publishVoteActivity ()
    {
        return true;
    }

    /**
     * TODO: 取得一个投票活动
     *
     * @param id
     *
     * @return
     */
    public VoteActivityEntity oneVoteActivity (Integer id)
    {
        return voteActivityDao.oneVoteActivity(id);
    }

    /**
     * TODO: 取得投票活动列表
     *
     * @param page
     * @param pageSize
     *
     * @return
     */
    public Map<String, Object> listVoteActivity (Integer page, Integer pageSize)
    {
        return voteActivityDao.listVoteActivity(page, pageSize);
    }
}
