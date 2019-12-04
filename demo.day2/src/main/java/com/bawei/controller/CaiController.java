package com.bawei.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.entity.Cai;
import com.bawei.entity.Liao;
import com.bawei.service.CaiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @author 宋佳乐
 *    控制层
 *
 */
@Controller
public class CaiController {
	@Autowired
	CaiService service;
	@RequestMapping("list.do")
	//列表查询
	public String list(Model m,String mohu,@RequestParam(defaultValue="1")Integer currentPage){
		System.out.println("???"+currentPage);
		PageHelper.startPage(currentPage,2);
		System.out.println("------------"+mohu);
		List<Cai> list=service.list(mohu);
		System.out.println("+++++"+list);
		PageInfo<Cai> pageInfo = new PageInfo<Cai>(list);
		m.addAttribute("list",list);
		m.addAttribute("pageInfo", pageInfo);
		m.addAttribute("mohu",mohu);
		return "list";		
	}
	
	@RequestMapping("toadd.do")
	public String toadd(Model m,Cai cai){
		m.addAttribute("cai", cai);
		List<Liao> liaos=service.liaos();
		System.out.println("22"+liaos);
		m.addAttribute("list",liaos);		
		return "add";		
	}
	@RequestMapping("add.do")
	//添加菜单
	public String addcai(Model m,@Validated @ModelAttribute("cai")Cai cai,BindingResult br){
		System.out.println("555");
		if(!(cai.getPrice()>0)){
			br.rejectValue("price", null,"价格要大于0");
		}
		if(!((cai.getLids().length)>1)){
			br.rejectValue("lids", null,"主料至少2项");
		}
		if(br.hasErrors()){
			System.out.println("进来了");
			List<Liao> liaos=service.liaos();
			m.addAttribute("list",liaos);	
			return "add";
		}
		boolean flag=service.addCai(cai);
		
		
		return "redirect:list.do";
		
	}
	@RequestMapping("toUpdate.do")
	public String toUpdate(Model m,Integer id){
		System.out.println("33"+id);
		Cai cais=service.Byid(id);		
		m.addAttribute("cai",cais);
		List<Liao> liaos=service.liaos();
		
		m.addAttribute("list",liaos);	
		
			
		
		return "update";
		
	}
	@RequestMapping("update.do")
	               
	public String caiUpdate(Model m,Cai cai){
	
		boolean flag=service.caiUpdate(cai);
		
		
		return "redirect:list.do";
		
	}
	@ResponseBody
	@RequestMapping("delete.do")
	//删除菜单
	public Object dels(String ids){
		
		boolean flag=service.dels(ids);
		
		
		return flag;
		
		
	}
	@RequestMapping("look.do")
	public String look(Integer id,Model m){
		Cai list=service.look(id);
		System.out.println(list);
		m.addAttribute("list",list);
	
		return "look";
		
	}

}
