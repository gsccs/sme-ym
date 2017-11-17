package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.Park;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ParkServiceI;
import com.gsccs.sme.plat.svg.model.ParkT;
import com.gsccs.sme.plat.svg.service.ParkService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 园区服务接口
 * 
 * @author x.d zhang
 * 
 */
public class ParkServiceAPI implements ParkServiceI {

	@Autowired
	private ParkService parkService;
	
	
	@Override
	public Park getPark(Long id) throws ApiException {

		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		ParkT parkT = parkService.findById(id);
		if (null != parkT) {
			Park park = new Park();
			try {
				BeanUtilsEx.copyProperties(park, parkT);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return park;
		}
		return null;
	}

	
	

	@Override
	public List<Park> queryParkList(Park param, String order,
			int page, int pagesize) throws ApiException {
		List<Park> list = null;
		ParkT t = null;
		if (null != param) {
			t = new ParkT();
			BeanUtilsEx.copyProperties(t, param);
		}

		List<ParkT> parkTs = parkService.find(t, order, page,
				pagesize);

		if (null != parkTs && parkTs.size() > 0) {
			list = new ArrayList<Park>();
			for (ParkT parkT : parkTs) {
				Park park_ = new Park();
				BeanUtilsEx.copyProperties(park_, parkT);
				list.add(park_);
			}
		}
		return list;
	}

	@Override
	public int count(Park param) throws ApiException {
		if (null != param) {
			ParkT t = new ParkT();
			BeanUtilsEx.copyProperties(t, param);
			return parkService.count(t);
		}
		return 0;
	}

}
