package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.ActEnroll;
import com.gsccs.sme.api.domain.Activity;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ActivityServiceI;
import com.gsccs.sme.plat.svg.model.ActenrollT;
import com.gsccs.sme.plat.svg.model.ActivityT;
import com.gsccs.sme.plat.svg.service.ActivityService;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 活动服务接口
 * 
 * @author x.d zhang
 * 
 */
public class ActivityServiceAPI implements ActivityServiceI {

	@Autowired
	private SclassService sclassService;
	@Autowired
	private ActivityService activityService;

	@Override
	public Activity getActivity(Long id) throws ApiException {

		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		ActivityT activityT = activityService.findById(id);
		if (null != activityT) {
			Activity activity = new Activity();
			try {
				BeanUtilsEx.copyProperties(activity, activityT);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return activity;
		}
		return null;
	}

	@Override
	public void addActivity(Activity activity) throws ApiException {

		if (null == activity) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		try {
			ActivityT activityT = new ActivityT();
			BeanUtilsEx.copyProperties(activityT, activity);
			activityService.insert(activityT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delActivity(Long id) throws ApiException {
		activityService.delActivity(id);
	}

	@Override
	public void updateActivity(Activity activity) throws ApiException {
		if (null == activity) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			ActivityT activityT = new ActivityT();
			BeanUtilsEx.copyProperties(activityT, activity);
			activityService.update(activityT);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public List<Activity> queryActivityList(Activity param, String order,
			int page, int pagesize) throws ApiException {
		List<Activity> list = null;
		ActivityT t = null;
		if (null != param) {
			t = new ActivityT();
			BeanUtilsEx.copyProperties(t, param);
		}

		List<ActivityT> activityTs = activityService.find(t, order, page,
				pagesize);

		if (null != activityTs && activityTs.size() > 0) {
			list = new ArrayList<Activity>();
			for (ActivityT activityT : activityTs) {
				Activity activity_ = new Activity();
				BeanUtilsEx.copyProperties(activity_, activityT);
				list.add(activity_);
			}
		}
		return list;
	}

	@Override
	public int count(Activity param) throws ApiException {
		if (null != param) {
			ActivityT t = new ActivityT();
			BeanUtilsEx.copyProperties(t, param);
			return activityService.count(t);
		}
		return 0;
	}


	@Override
	public void addActEnroll(ActEnroll actEnroll) throws ApiException {
		if (null == actEnroll || null == actEnroll.getActid()
				|| null == actEnroll.getUserid()) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			ActenrollT actenrollT = new ActenrollT();
			BeanUtilsEx.copyProperties(actenrollT, actEnroll);
			activityService.insert(actenrollT);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cancelActEnroll(Long actid, Long userid) throws ApiException {
		if (null == actid || null == userid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		activityService.delete(actid, userid);
	}

	@Override
	public Datagrid queryEnrollActList(Long userid, String order, int currPage,
			int pageSize) throws ApiException {
		return activityService.enrollActList(userid, order, currPage, pageSize);
	}

}
