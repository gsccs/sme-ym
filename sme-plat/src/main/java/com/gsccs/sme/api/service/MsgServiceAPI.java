package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.base.Msg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.plat.auth.model.MsgT;
import com.gsccs.sme.plat.auth.service.MsgService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 
 * @author x.d zhang
 * 
 */
public class MsgServiceAPI implements MsgServiceI {

	@Autowired
	private MsgService msgService;

	@Override
	public Msg getMsg(String id) throws ApiException {
		Msg o = null;
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		MsgT t = msgService.findById(id);
		if (null != t) {
			try {
				o = new Msg();
				BeanUtilsEx.copyProperties(o, t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return o;
	}

	@Override
	public void addMsg(Msg msgo) throws ApiException {
		if (null == msgo) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		MsgT msgT = new MsgT();
		BeanUtilsEx.copyProperties(msgT, msgo);
		msgService.createMsg(msgT);
	}

	@Override
	public void updateMsg(Msg msg) throws ApiException {
		if (null == msg) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		MsgT msgT = new MsgT();
		BeanUtilsEx.copyProperties(msgT, msg);
		msgService.updateMsg(msgT);
	}

	@Override
	public void delete(String id) throws ApiException {
		msgService.deleteMsg(id);
	}

	@Override
	public List<Msg> findMsgList(Msg param, String order, int page, int pagesize)
			throws ApiException {
		List<Msg> list = null;
		MsgT consultT = null;
		if (null != param) {
			consultT = new MsgT();
			BeanUtilsEx.copyProperties(consultT, param);
		}

		List<MsgT> dblist = msgService.find(consultT, order, page, pagesize);

		if (null != dblist && dblist.size() > 0) {
			list = new ArrayList<Msg>();
			for (MsgT content_ : dblist) {
				Msg info_ = new Msg();
				BeanUtilsEx.copyProperties(info_, content_);
				list.add(info_);
			}
		}
		return list;
	}

	@Override
	public Integer countMsgs(Msg param) throws ApiException {
		MsgT consultT = null;
		if (null != param) {
			consultT = new MsgT();
			BeanUtilsEx.copyProperties(consultT, param);
		}
		return msgService.count(consultT);
	}

}
