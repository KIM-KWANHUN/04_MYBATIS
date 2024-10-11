package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {

    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);// 쿼리문을 동작시킬수 있는 아이디

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria); // 쿼리문을 동작시킬수 있는 아이디

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);
}
