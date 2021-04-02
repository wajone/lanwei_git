package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Material;
import com.sifunit.lanwei.domain.Stock;
import com.sifunit.lanwei.service.IMaterialService;
import com.sifunit.lanwei.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("material")
public class MaterialController {

    @Autowired
    IMaterialService materialService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<Material> pageInfo = materialService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "material/material_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(Material material) {
        SysResult sysResult = new SysResult(false);
        int count = materialService.insertSelective(material);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("添加成功!");
        } else {
            sysResult.setData("添加失败!");
        }
        return sysResult;
    }

    @GetMapping("toAdd")
    public String toAdd() {
        return "material/material_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long materilaId, Model model) {
        Material material = materialService.selectByPrimaryKey(materilaId);
        model.addAttribute("material", material);
        return "material/material_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Material material) {
        SysResult sysResult = new SysResult(false);
        int count = materialService.updateByPrimaryKeySelective(material);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }

    @GetMapping("delById")
    @ResponseBody
    public SysResult delById(Long materialId) {
        System.out.println(materialId);
        SysResult sysResult = materialService.delById(materialId);
        return sysResult;
    }
}
