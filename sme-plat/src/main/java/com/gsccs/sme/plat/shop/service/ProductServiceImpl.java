package com.gsccs.sme.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.shop.dao.ProductImgTMapper;
import com.gsccs.sme.plat.shop.dao.ProductTMapper;
import com.gsccs.sme.plat.shop.model.ProductImgT;
import com.gsccs.sme.plat.shop.model.ProductImgTExample;
import com.gsccs.sme.plat.shop.model.ProductT;
import com.gsccs.sme.plat.shop.model.ProductTExample;

/**
 * 产品业务
 * 
 * @author x.d zhang
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductTMapper productTMapper;
	@Autowired
	private ProductImgTMapper pImgMapper;

	@Override
	public Long addProduct(ProductT p) {
		if (null != p) {
			int salenum = p.getSalenum() == null ? 0 : p.getSalenum();
			int storenum = p.getStorenum() == null ? 0 : p.getStorenum();
			int evalnum = p.getEvalnum() == null ? 0 : p.getEvalnum();
			int locknum = p.getLocknum() == null ? 0 : p.getLocknum();
			p.setSalenum(salenum);
			p.setStorenum(storenum);
			p.setEvalnum(evalnum);
			p.setLocknum(locknum);
			productTMapper.insert(p);

			return p.getId();
		}
		return null;
	}

	@Override
	public ProductT getProduct(Long pid) {
		ProductT productT = productTMapper.selectByPrimaryKey(pid);
		return productT;
	}

	@Override
	public void editProductStatus(Long productId, String status) {
		ProductT pt = null;
		if (null != productId && null != status) {
			pt = productTMapper.selectByPrimaryKey(productId);
			pt.setStatus(status);
			productTMapper.updateByPrimaryKey(pt);
		}

	}

	@Override
	public void delProduct(Long pId) {
		if (null != pId) {
			productTMapper.deleteByPrimaryKey(pId);
		}
	}

	@Override
	public void editProduct(ProductT pt) {
		productTMapper.updateByPrimaryKey(pt);
	}

	@Override
	public List<ProductT> find(ProductT param, String order, int page,
			int pagesize) {
		ProductTExample example = new ProductTExample();
		ProductTExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		example.setCurrPage(page);
		example.setPageSize(pagesize);
		return productTMapper.selectPageByExample(example);
	}

	/**
	 * 处理查询条件
	 * 
	 * @param ProductT
	 * @param criteria
	 */
	public void proSearchParam(ProductT p, ProductTExample.Criteria criteria) {
		if (p != null) {
			if (p.getId() != null) {
				criteria.andIdEqualTo(p.getId());
			}

			if (StringUtils.isNotEmpty(p.getTitle())) {
				criteria.andTitleLike("'%" + p.getTitle() + "%'");
			}

			if (StringUtils.isNotEmpty(p.getIstop())) {
				criteria.andIstopEqualTo(p.getIstop());
			}

			if (StringUtils.isNotEmpty(p.getIshot())) {
				criteria.andIshotEqualTo(p.getIshot());
			}

			if (StringUtils.isNotEmpty(p.getStatus())) {
				criteria.andStatusEqualTo(p.getStatus());
			}
			
			if (null != p.getCorpid()) {
				criteria.andCorpidEqualTo(p.getCorpid());
			}
		}
	}

	@Override
	public List<ProductImgT> getImgByPid(Long pid) {
		ProductImgTExample example = new ProductImgTExample();
		ProductImgTExample.Criteria c = example.createCriteria();
		c.andProductidEqualTo(pid);
		return pImgMapper.selectByExample(example);
	}

	@Override
	public Long[] addListImg(Long sid, List<ProductImgT> pitList) {
		if (null != pitList && pitList.size() > 0) {
			Long[] ids = new Long[pitList.size()];
			int i = 0;
			for (ProductImgT pt : pitList) {
				pImgMapper.insert(pt);
				ids[i] = pt.getId();
				i++;
			}
			return ids;
		}
		return null;
	}

	@Override
	public int count(ProductT param) {
		ProductTExample example = new ProductTExample();
		ProductTExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return productTMapper.countByExample(example);
	}

	@Override
	public void productUnsale(Long sid) {
		// TODO Auto-generated method stub

	}

}
