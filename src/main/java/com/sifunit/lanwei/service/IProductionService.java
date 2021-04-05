package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Production;
import com.sifunit.lanwei.vo.ProductionDetail;
import org.springframework.ui.Model;

public interface IProductionService extends IBaseService<Production> {

    PageInfo<Production> getPageInfo(Page page, Model model);
}
