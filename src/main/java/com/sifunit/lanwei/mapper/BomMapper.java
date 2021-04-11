package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Bom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BomMapper extends IBaseMapper<Bom> {

    List<Bom> list();
}