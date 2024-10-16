package com.ohgiraffers.section01.mybatis.Model.service;

import com.ohgiraffers.section01.mybatis.Model.dao.MenuMapper;
import com.ohgiraffers.section01.mybatis.Model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.mybatis.Common.MenuTemplate.getSqlSession;

public class MenuService {

    private MenuMapper mapper;

    public List<MenuDTO> menuSelectAll() {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuDTO = mapper.menuSelectAll();

        sqlSession.close();

        return menuDTO;
    }

    public MenuDTO menuCodeSelect(int code) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menuDTO = mapper.menuCodeSelect(code);

        sqlSession.close();

        return menuDTO;
    }

    public boolean menuInsert(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MenuMapper.class);

        int result = mapper.menuInsert(menuDTO);

        if(result > 0 ) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }


    public List<MenuDTO> menuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuDTO = mapper.menuByPrice(price);

        sqlSession.close();

        return menuDTO;
    }
}
