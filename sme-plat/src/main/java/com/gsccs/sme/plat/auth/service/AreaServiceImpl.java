package com.gsccs.sme.plat.auth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.AreaMapper;
import com.gsccs.sme.plat.auth.model.AreaExample;
import com.gsccs.sme.plat.auth.model.AreaT;
import com.gsccs.sme.plat.auth.model.DictItemExample;

/**
 * 
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Resource
	private AreaMapper areaMapper;
	
	@Override
	public List<AreaT> getByParId(Integer parid){
		return areaMapper.selectByParId(parid);
	}

	@Override
	public List<AreaT> find(AreaT area, String order, int currPage, int pageSize) {
		AreaExample example = new AreaExample();
		AreaExample.Criteria c = example.createCriteria();
		List<Integer> pids = new ArrayList<Integer>();
		
		pids.add(0);
		pids.add(area.getId());
		c.andParentidIn(pids);
		/*Area area_ = areaMapper.selectByPrimaryKey(area.getId());
		if (null != area_){
			if (area_.getLevel()!=1){
				getsubs(area_.getId());
			}
		}*/
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return areaMapper.selectPageByExample(example);
	}
	
	public List<AreaT> getsubs(Integer pid){
		AreaExample example = new AreaExample();
		AreaExample.Criteria c = example.createCriteria();
		c.andParentidEqualTo(pid);
		return areaMapper.selectByExample(example);
	}

	@Override
	public int count(AreaT area) {
		AreaExample example = new AreaExample();
		AreaExample.Criteria c = example.createCriteria();
		proSearchParam(area,c);
		return areaMapper.countByExample(example);
	}
	
	public void proSearchParam(AreaT area, AreaExample.Criteria criteria) {
		if (null != area){
			if (null == area.getParentid()){
				criteria.andParentidEqualTo(0);
			}else{
				criteria.andParentidEqualTo(area.getParentid());
			}
		}
	}

	@Override
	public String getAreaStr(Integer code) {
		String areastr="";
		AreaT areaT = areaMapper.selectByCode(code);
		if (null != areaT){
			areastr = areaT.getName();
			Integer parid = areaT.getParentid();
			if (null != parid && parid!=0){
				areastr = getAreaStr(parid,areastr)+areastr;
			}
		}
		return areastr;
	}
	
	public String getAreaStr(Integer code,String areastr) {
		AreaT areaT = areaMapper.selectByCode(code);
		if (null != areaT){
			areastr = areaT.getName();
			Integer parid = areaT.getParentid();
			if (null != parid && parid!=0){
				areastr = getAreaStr(parid,areastr)+areastr;
			}
		}
		return areastr;
	}

	@Override
	public List<AreaT> findAreaList(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			String[] idArray = ids.split(",");
			if (null != idArray && idArray.length > 0) {
				List<String> idstrlist = Arrays.asList(idArray);
				List<Integer> idlist = new ArrayList<>();
				for (String id : idstrlist) {
					if (StringUtils.isEmpty(id)) {
						idstrlist.remove(id);
					}else{
						idlist.add(Integer.valueOf(id));
					}
				}
				if (null != idlist && idlist.size() > 0) {
					AreaExample example = new AreaExample();
					AreaExample.Criteria c = example.createCriteria();
					c.andCodeIn(idlist);
					return areaMapper.selectByExample(example);
				}
			}
		}
		return null;
	}

}
