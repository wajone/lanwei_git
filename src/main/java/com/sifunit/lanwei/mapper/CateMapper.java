package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.vo.ProceCateTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CateMapper {

    List<ProceCateTree> getProceCateTree();
}