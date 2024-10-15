package com.ohgiraffers.section01.mybatis.View;

import com.ohgiraffers.section01.mybatis.Controller.MenuController;
import com.ohgiraffers.section01.mybatis.Model.dto.MenuDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuView {


    public void diplay() {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do{
            System.out.println("메뉴조회");
            System.out.println("1. 메뉴 전체조회");
            System.out.println("2. 코드를 입력하여 메뉴 조회");
            System.out.println("3. 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("번호를 입력해주세요 : ");
            int menunumber = sc.nextInt();

            switch (menunumber) {
                case 1 : menuController.menuSelectAll();
                break;
                case 2 : menuController.menuCodeSelect(inputSelectCode());
                break;
                case 3 : menuController.menuInsert(inputMenuInsert());
                break;
//                case 4 : menuController.menuUpdate(inputMenuUpdate());
//                break;
//                case 5 : menuController.menuDelete(inputMenuDelete());
//                break;
                case 9 :
                    System.out.println("프로그램을 종료합니다.");
                    return;

            }

        } while(true);
    }

    private Map<String, String> inputMenuInsert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("신규로 추가할 메뉴 코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.print("신규로 추가할 메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("신규로 추가할 메뉴 가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.println("신규로 추가할 메뉴 카테고리를 입력하세요 : ");
        String category = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code",code);
        parameter.put("name",name);
        parameter.put("price",price);
        parameter.put("category",category);

        return parameter;
    }

    private static Map<String, String> inputSelectCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 메뉴의 코드를 입력해주세요 : ");
        String menuCode = sc.nextLine();

        Map<String ,String> parameter = new HashMap<>();
        parameter.put("menuCode",menuCode);

        return parameter;
    }

}
