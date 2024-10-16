package com.ohgiraffers.section01.mybatis.Controller;

import com.ohgiraffers.section01.mybatis.Model.dto.MenuDTO;
import com.ohgiraffers.section01.mybatis.Model.dto.SearchCriteria;
import com.ohgiraffers.section01.mybatis.Model.service.MenuService;
import com.ohgiraffers.section01.mybatis.View.PrintResults;

import java.util.List;
import java.util.Map;

public class MenuController {
    private final MenuService menuService;
    private final PrintResults printResults;

    public  MenuController() {
        this.menuService = new MenuService();
        this.printResults = new PrintResults();
    }

    public void menuSelectAll() {

       List<MenuDTO> menuList = menuService.menuSelectAll();

       if(menuList != null) {
           printResults.selectAllSuccessMessage(menuList);
       } else {
           System.out.println("selectAll");
       }
    }

    public void menuCodeSelect(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menuDTO = menuService.menuCodeSelect(code);

        if(menuDTO != null) {
            PrintResults.selectMenuCode(menuDTO);
        } else {
            System.out.println("selectMenuCode");
        }
    }

    public void menuInsert(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int category = Integer.parseInt(parameter.get("category"));

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuCode(code);
        menuDTO.setMenuName(name);
        menuDTO.setmenuPrice(price);
        menuDTO.setCategoryCode(category);

        if(menuService.menuInsert(menuDTO)) {
            printResults.printSuccessMessage("insert");
        } else {
            printResults.printError("insertError");
        }
    }

    public void menuByPrice(Map<String, String> parameter) {
        int price = Integer.parseInt(parameter.get("price"));

        List<MenuDTO> menuList = menuService.menuByPrice(price);

        if(menuList != null) {
            printResults.printmenuByPrice(menuList);
        } else {
            printResults.printError("selectMenuByPrice");
        }

    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
       List<MenuDTO> menuList = menuService.searchMenuBySupCategory(searchCriteria);

    }
}
