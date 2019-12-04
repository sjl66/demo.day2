package com.bawei.service;

import java.util.List;

import com.bawei.entity.Cai;
import com.bawei.entity.Liao;

public interface CaiService {

	List<Cai> list(String mohu);

	List<Liao> liaos();

	boolean addCai(Cai cai);

	Cai Byid(Integer id);

	boolean caiUpdate(Cai cai);

	boolean dels(String ids);

	Cai look(Integer id);

}
