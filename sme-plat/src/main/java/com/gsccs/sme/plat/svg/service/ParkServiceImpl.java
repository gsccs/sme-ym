package com.gsccs.sme.plat.svg.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.plat.auth.dao.DictItemTMapper;
import com.gsccs.sme.plat.auth.service.AreaService;
import com.gsccs.sme.plat.svg.dao.ParkAttachMapper;
import com.gsccs.sme.plat.svg.dao.ParkMapper;
import com.gsccs.sme.plat.svg.model.AppealAttachT;
import com.gsccs.sme.plat.svg.model.ParkAttach;
import com.gsccs.sme.plat.svg.model.ParkExample;
import com.gsccs.sme.plat.svg.model.ParkT;
import com.gsccs.sme.plat.svg.model.SclassT;

/**
 * 园区业务
 * 
 * @创建时间：2016.3.1
 */
@Service(value = "parkService")
public class ParkServiceImpl implements ParkService {

	@Autowired
	private ParkMapper parkMapper;
	@Autowired
	private ParkAttachMapper parkAttachMapper;
	@Autowired
	private AreaService areaService;

	/**
	 * 根据id查询
	 */
	@Override
	public ParkT findById(Long id) {
		ParkT t = parkMapper.selectByPrimaryKey(id);
		return t;
	}

	/**
	 * 添加
	 */
	@Override
	public void insert(ParkT parkT) {
		if (null == parkT) {
			return;
		}
		parkT.setAddtime(new Date());
		parkT.setStatus("0");
		parkMapper.insert(parkT);
		
		if (null != parkT.getAttachs() && parkT.getAttachs().size() > 0) {
			for (Attach attach : parkT.getAttachs()) {
				ParkAttach attachT = new ParkAttach();
				attachT.setParkid(parkT.getId());
				attachT.setFilename(attach.getFilename());
				attachT.setFilepath(attach.getFilepath());
				attachT.setFiletype(attach.getFiletype());
				parkAttachMapper.insert(attachT);
			}
		}
	}

	/**
	 * 修改
	 */
	@Override
	public void update(ParkT parkT) {
		if (null != parkT) {
			parkMapper.updateByPrimaryKeySelective(parkT);
		}
	}

	@Override
	public List<ParkT> find(ParkT sitemT, String order, int currPage,
			int pageSize) {
		ParkExample example = new ParkExample();
		ParkExample.Criteria criteria = example.createCriteria();
		proSearchParam(sitemT, criteria);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		} else {
			example.setOrderByClause(" indexnum ");
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return parkMapper.selectPageByExample(example);
	}

	@Override
	public void delete(Long id) {
		parkMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int count(ParkT sitemT) {
		ParkExample example = new ParkExample();
		ParkExample.Criteria criteria = example.createCriteria();
		proSearchParam(sitemT, criteria);
		return parkMapper.countByExample(example);
	}

	public void proSearchParam(ParkT sitemT, ParkExample.Criteria criteria) {
		if (null != sitemT) {
			if (StringUtils.isNotEmpty(sitemT.getTitle())) {
				criteria.andTitleLike("%" + sitemT.getTitle() + "%");
			}

			if (null != sitemT.getSvgid()) {
				criteria.andSvgidEqualTo(sitemT.getSvgid());
			}

			if (null != sitemT.getSvgid()) {
				criteria.andSvgidEqualTo(sitemT.getSvgid());
			}
			if (null != sitemT.getStatus()) {
				criteria.andStatusEqualTo(sitemT.getStatus());
			}
		}
	}

}
