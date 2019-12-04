package com.bawei.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bawei.dao.CaiDao;
import com.bawei.entity.Cai;
import com.bawei.entity.Liao;
import com.bawei.service.CaiService;

@Transactional
@Service("service")
public class CaiServiceImpl implements CaiService {
	@Autowired
	CaiDao caiDao;

	@Override
	public List<Cai> list(String mohu) {
		
		return caiDao.list(mohu);
	}

	@Override
	public List<Liao> liaos() {
		
		return caiDao.liaos();
	}

	@Override
	public boolean addCai(Cai cai) {
		int i=caiDao.addcai(cai);
		if(i>0){
			 i=caiDao.addzhu(cai.getCid(),cai.getLids());
		}
		return i>0;
	}

	@Override
	public Cai Byid(Integer id) {
		
		return caiDao.Byid(id);
	}

	@Override
	public boolean caiUpdate(Cai cai) {
		int i=caiDao.caiUpdate(cai);
		if(i>0){
			i=caiDao.delzhu(cai.getCid());
			if(i>0){
				i=caiDao.addzhu(cai.getCid(),cai.getLids());
			}
		
		}
		return i>0;
	}

	@Override
	public boolean dels(String ids) {
		int i=caiDao.dels(ids);
		if(i>0){
			 i=caiDao.delszhu(ids);
			
		}
		return i>0;
	}

	@Override
	public Cai look(Integer id) {
		
		return caiDao.look(id);
	}

}
