package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.section01.xmlconfig.model.service.MenuService;

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

    public MenuController() {
        this.menuService = new MenuService();
    }

    public void selectAllMenu() {

        menuService.selectAllMenu();


    }


}
