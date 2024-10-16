package com.ohgiraffers.section01.mybatis.Model.dao;

import com.ohgiraffers.section01.mybatis.Model.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> menuSelectAll();

    MenuDTO menuCodeSelect(int code);

    int menuInsert(MenuDTO menuDTO);

    List<MenuDTO> menuByPrice(int price);
}
