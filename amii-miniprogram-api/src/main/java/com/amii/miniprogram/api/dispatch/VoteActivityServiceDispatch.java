package com.amii.miniprogram.api.dispatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amii.miniprogram.api.constant.ApiConstant;
import com.amii.miniprogram.api.entity.VoteActivityEntity;
import com.amii.miniprogram.api.exception.AppException;
import com.amii.miniprogram.api.service.VoteActivityService;
import com.amii.miniprogram.api.util.ConfigToolkit;
import com.amii.miniprogram.api.util.response.ApiPaper;
import com.github.pagehelper.PageInfo;

@Component
public class VoteActivityServiceDispatch extends ServiceDispatch
{
    @Autowired
    private VoteActivityService service;

    /**
     * TODO: 根据方法名调用不同的方法
     *
     * @param methodName 方法名
     * @param params     方法参数
     *
     * @return Object
     *
     * @throws AppException
     */
    @Override
    public Object requestMethod (String methodName, Map<String, Object> params) throws AppException
    {
        Object data = null;

        // 调用publishtVoteActivity方法
        if ("publishVoteActivity".equals(methodName)) {
            data = this.publishVoteActivity(params);
        }
        // 调用detailtVoteActivity方法
        else if ("detailVoteActivity".equals(methodName)) {
            data = this.detailVoteActivity(params);
        }
        // 调用listtVoteActivity方法
        else if ("listVoteActivity".equals(methodName)) {
            data = this.listVoteActivity(params);
        }

        // 没有匹配到方法
        else {
            throw new AppException(ApiConstant.Message.CODE_11101, 11101);
        }

        return data;
    }

    /**
     * TODO: publishtVoteActivity方法
     *
     * @param params
     *
     * @return Object
     */
    private Object publishVoteActivity (Map<String, Object> params)
    {
        Map<String, String> data = new HashMap<String, String>();

        Boolean rs = this.service.publishVoteActivity();

        if (rs.equals(true)) {
            data.put("status", "1");
        } else {
            data.put("status", "0");
        }

        return data;
    }

    /**
     * TODO: detailtVoteActivity方法
     *
     * @param params
     *
     * @return Object
     */
    private Object detailVoteActivity (Map<String, Object> params)
    {
        Map<String, Object> data = new HashMap<String, Object>();

        // id
        Integer id = 0;
        try {
            id = Integer.parseInt(params.get("id").toString().trim());
        } catch (Exception nfe) {
            throw new AppException("id" + ApiConstant.Message.CODE_14999, 14999);
        }
        if (id <= 0) {
            throw new AppException("id" + ApiConstant.Message.CODE_14999, 14999);
        }

        // 调用服务
        VoteActivityEntity voteActivity = this.service.oneVoteActivity(id);

        // 过滤/映射字段
        if (null != voteActivity) {
            Map<String, Object> voteActivityItem = new HashMap<String, Object>();
            voteActivityItem.put("id", voteActivity.getId());
            voteActivityItem.put("publish_user_id", voteActivity.getPublishUserId());
            voteActivityItem.put("name", voteActivity.getName());

            data.put("vote_activity", voteActivityItem);
        }

        return data;
    }

    /**
     * TODO: listtVoteActivity方法
     *
     * @param params
     *
     * @return Object
     */
    private Object listVoteActivity (Map<String, Object> params)
    {
        Map<String, Object> data = new HashMap<String, Object>();

        // page
        Integer page = 0;
        try {
            // 默认值为1
            page = (null == params.get("page")) ? 1 : Integer.parseInt(params.get("page").toString().trim());
            if (page < 0) {
                throw new AppException("page" + ApiConstant.Message.CODE_14999, 14999);
            }
        } catch (Exception nfe) {
            throw new AppException("page" + ApiConstant.Message.CODE_14999, 14999);
        }

        // pageSize
        Integer pageSize = 0;
        try {
            // 默认值为10
            pageSize = (null == params.get("page_size")) ? Integer.parseInt(ConfigToolkit.getProperty("app_pageSize"))
                : Integer.parseInt(params.get("page_size").toString().trim());
            if (pageSize <= 0) {
                throw new AppException("page_size" + ApiConstant.Message.CODE_14999, 14999);
            }
        } catch (Exception nfe) {
            throw new AppException("page_size" + ApiConstant.Message.CODE_14999, 14999);
        }

        // 调用服务
        Map<String, Object> voteActivitysAndPageInfo = this.service.listVoteActivity(page, pageSize);

        // 过滤/映射字段
        if (null != voteActivitysAndPageInfo) {
            List<VoteActivityEntity> voteActivityEntityList = (List<VoteActivityEntity>) voteActivitysAndPageInfo
                .get("voteActivityEntityList");
            List<Map> voteActivityList = new ArrayList<Map>();
            Map<String, Object> voteActivityItem = null;
            VoteActivityEntity voteActivityEntity = null;
            for (int i = 0; i < voteActivityEntityList.size(); i++) {
                voteActivityEntity = voteActivityEntityList.get(i);
                voteActivityItem = new HashMap<String, Object>();
                voteActivityItem.put("id", voteActivityEntity.getId());
                voteActivityItem.put("publish_user_id", voteActivityEntity.getPublishUserId());
                voteActivityItem.put("name", voteActivityEntity.getName());
                voteActivityList.add(voteActivityItem);
            }
            data.put("vote_activitys", voteActivityList);

            PageInfo<VoteActivityEntity> pagerInfo = (PageInfo<VoteActivityEntity>) voteActivitysAndPageInfo.get("pageInfo");
            Integer apiPagerPage = pagerInfo.getPageNum();
            Integer apiPagerPrePage = (0 == pagerInfo.getPrePage()) ? 1 : pagerInfo.getPrePage();
            Integer apiPagerNextPage = (0 == pagerInfo.getNextPage()) ? pagerInfo.getPages() : pagerInfo.getNextPage();
            Integer apiPagerPageSize = pagerInfo.getPageSize();
            Integer apiPagerPageCount = pagerInfo.getPages();
            Long apiPagerResultCount = pagerInfo.getTotal();
            ApiPaper apiPager = new ApiPaper(apiPagerPage, apiPagerPrePage, apiPagerNextPage, apiPagerPageSize, apiPagerPageCount,
                                             apiPagerResultCount);
            data.put("pager", apiPager);
        }

        return data;
    }
}