package com.ohgiraffers.section01.mybatis.View;

import com.ohgiraffers.section01.mybatis.Model.dto.MenuDTO;

import java.sql.SQLOutput;
import java.util.List;

public class PrintResults {


    public static void selectMenuCode(MenuDTO menuDTO) {
        System.out.println(menuDTO.getMenuCode() + "요청하신 메뉴 코드 조회 결과 입니다.");
        System.out.println(menuDTO);
    }

    public void selectAllSuccessMessage(List<MenuDTO> menuList) {

        System.out.println("요청하신 전체 메뉴 조회 결과 입니다.");

        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }

        System.out.println("==================================================");
    }

    public void printError (String error) {
        String errorMessage = "";
        switch (error) {
            case "selectAll" :
                errorMessage = "메뉴 전체조회에 실패하셨습니다.";
                break;
            case "selectMenuCode" :
                errorMessage = "메뉴코드 조회에 실패하셨습니다.";
                break;
            case "insertError" :
                errorMessage = "메뉴추가에 실패하셨습니다.";
                break;
            case "selectMenuByPrice" :
                errorMessage = "메뉴가격 조회에 실패하였습니다.";
        }

        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode) {
            case "insert" :
                successMessage = "신규 메뉴 등록 성공!!!";
                break;
            case "update" :
                successMessage = "메뉴 수정 성공!!!";
                break;
            case "delete" :
                successMessage = "메뉴 삭제 성공!!!!";
        }

        System.out.println(successMessage);
    }


    public void printmenuByPrice(List<MenuDTO> menuList) {
        System.out.println(menuList + "요청하신 가격 조회입니다.");
    }
}


