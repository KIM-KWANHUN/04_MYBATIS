package com.ohgiraffers.section03.remix.model.dao;

import com.ohgiraffers.section03.remix.dto.MenuDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface MenuMapper {

    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByMenuCode(int code);

    int insertNewMenu(MenuDTO newmenu);

    int modifyMenu(MenuDTO newMenu);

    int deleteMenu(MenuDTO deleteMenu);
}
