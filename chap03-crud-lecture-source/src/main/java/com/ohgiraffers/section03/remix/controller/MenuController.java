package com.ohgiraffers.section03.remix.controller;

import com.ohgiraffers.section03.remix.dto.MenuDTO;
import com.ohgiraffers.section03.remix.service.MenuService;
import com.ohgiraffers.section03.remix.view.PrintResult;

import java.util.List;
import java.util.Map;

public class MenuController {

    /* comment.
     *   Controller 의 역활
     *   view 에서 사용자가 입력한 정보를 파라미터 형태로 전달 받으면
     *   전달 받은 값들을 검증하거나, 추가적인 정보가 필요하면 가공을 한 뒤
     *   service 쪽으로 전달하기 위한 인스턴스를 생성하여 담고
     *   service 의 비즈니스 로직을 담당하는 메소드를 호출한다.
     *   또한 호출한 수행 결과를 반환 받아 어떤 view 를 보여줄지
     *   결정하는 역활을 수행하게 된다. */

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();
        // 즉 값이 존재한다면, 정상 조회
        if(menuList != null) {
            printResult.printMenuList(menuList);
        }else {
            printResult.printErrorMessage("selectList");
        }

    }

    public void selectMenuByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.selectMenuByMenuCode(code);

        if(menu != null) {
            printResult.printMenu(menu);
        }else {
            printResult.printErrorMessage("selectOne");
        }
       }

    public void insertNewMenu(Map<String, String> parameter) {
        String menuName = parameter.get("name");
        int menuPrice = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("category"));

        MenuDTO newmenu = new MenuDTO();
        newmenu.setMenuName(menuName);
        newmenu.setMenuPrice(menuPrice);
        newmenu.setCategoryCode(categoryCode);

        if(menuService.insertNewMenu(newmenu)){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }

    }

    public void modifyMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("code"));
        String menuName = parameter.get("name");
        int menuPrice = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO newMenu = new MenuDTO();
        newMenu.setMenuCode(menuCode);
        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);

        if(menuService.modifyMenu(newMenu)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printSuccessMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("code"));

        MenuDTO deleteMenu = new MenuDTO();
        deleteMenu.setMenuCode(menuCode);

        if(menuService.deleteMenu(deleteMenu)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}



