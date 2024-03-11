package com.ssg.webmvc_member.controller;

import com.ssg.webmvc_member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteMemberController", urlPatterns = "/member/delMember.do")
public class DeleteMemberController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //회원목록에서 삭제 버튼을 누르면 Post요청을 받게 된다.
        String mid = request.getParameter("mid");
        try {
            //DB에서 delete하는 delete()메서드 실행..
            memberService.delete(mid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/member/mem.do");
    }
}
