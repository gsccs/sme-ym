package com.gsccs.sme.plat.auth.service;

import java.util.List;

import com.gsccs.sme.plat.auth.model.App;
import com.gsccs.sme.plat.auth.model.User;

/**
 * <p>User: x.d zhang
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface AppService {


    public App createApp(App app);
    public App updateApp(App app);
    public void deleteApp(Long appId);

    public App findOne(Long appId);
    public List<App> findAll();
    
    public List<App> find(App param, String order, int currPage, int pageSize);

    public Integer count(App param);
    /**
     * 根据appKey查找AppId
     * @param appKey
     * @return
     */
    public Long findAppIdByAppKey(String appKey);
}
