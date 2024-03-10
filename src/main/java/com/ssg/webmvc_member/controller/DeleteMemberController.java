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
        String mid = request.getParameter("mid");
        try {
            memberService.delete(mid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/member/mem.do");
    }
}
