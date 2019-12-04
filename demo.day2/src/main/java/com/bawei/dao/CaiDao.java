package com.bawei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bawei.entity.Cai;
import com.bawei.entity.Liao;


public interface CaiDao {
    //list查询列表
	List<Cai> list(@Param("mohu")String mohu);
	//查询id 对应的主料
	List<Liao> findByidLiao(Integer id);
    //查询全部主料
	List<Liao> liaos();
    //添加菜单
	int addcai(Cai cai);
    //添加中间表
	int addzhu(@Param("cid")Integer cid,@Param("lids") Integer[] lids);
    //查询id对应的菜单
	Cai Byid(Integer id);
    //修改菜单
	int caiUpdate(Cai cai);
   //删除cid对应的中间表
	int delzhu(Integer cid);
    //删除菜单
	int dels(String ids);
    //删除ids字符串对应的中间表
	int delszhu(String ids);
	
	Cai look(Integer id);

}
