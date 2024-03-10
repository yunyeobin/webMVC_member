package com.ssg.webmvc_member.controller;

import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modifyMemberController", urlPatterns = "/member/modMember.do")
public class ModifyMemberController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid");
        MemberDTO memberDTO = null;
        try {
            memberDTO = memberService.read(mid);
            System.out.println(memberDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("dto", memberDTO);
        request.getRequestDispatcher("/WEB-INF/member/modifyMember.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO memberDTO = MemberDTO.builder()
                .mid(request.getParameter("mid"))
                .mpw(request.getParameter("mpw"))
                .mname(request.getParameter("mname"))
                .mmail(request.getParameter("mmail"))
                .build();
        System.out.println(memberDTO);
        try {
            memberService.modify(memberDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        response.sendRedirect("/member/mem.do");
    }
}
