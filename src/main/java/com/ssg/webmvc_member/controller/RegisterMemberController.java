package com.ssg.webmvc_member.controller;

import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "registerMemberController", urlPatterns = "/registerMembers.do")
public class RegisterMemberController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("회원가입 doGet...");
        //registerMember.jsp로 요청 전달
        request.getRequestDispatcher("/WEB-INF/member/registerMember.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("회원가입 doPost...");
        //빌더를 이용하여 DTO객체에 입력받은 파라미터들을 담는다.
        MemberDTO memberDTO = MemberDTO.builder()
                .mid(request.getParameter("mid"))
                .mpw(request.getParameter("mpw"))
                .mname(request.getParameter("mname"))
                .mmail(request.getParameter("mmail"))
                .build();
        try {
            memberService.register(memberDTO);
            //register메소드를 이용해서 DB에 넣어줄 수 있다.(Insert)
        } catch (Exception e) {
            throw new ServletException("register error");
        }
        //하고나면 회원목록 화면으로 다시 간다.
        response.sendRedirect("/member/mem.do");
    }
}
