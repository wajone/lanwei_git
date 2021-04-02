package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Material;
import com.sifunit.lanwei.domain.Product;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.MaterialMapper;
import com.sifunit.lanwei.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class MaterialServiceImpl extends BaseServiceImpl<Material> implements IMaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public IBaseMapper<Material> getMapper() {
        return materialMapper;
    }

    @Override
    public PageInfo<Material> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Material> list = materialMapper.list();
        PageInfo<Material> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long materialId) {
        SysResult sysResult = new SysResult();
        Material material = new Material();
        material.setMaterialId(materialId);
        material.setFlag(false);
        int count = materialMapper.updateByPrimaryKeySelective(material);
        if (count == 0) {
            sysResult.setResult(false);
            sysResult.setData("删除失败！");
        } else {
            sysResult.setData("删除成功！");
            sysResult.setResult(true);
        }
        return sysResult;
    }
}