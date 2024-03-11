package com.ssg.webmvc_member.controller;

import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/member/loginMember.jsp").forward(request, response);
        //Get요청을 받으면 loginMember.jsp로 요청 전달
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("mid"); //입력받은 mid를 String 객체 mid에 저장
        String mpw = request.getParameter("mpw"); //입력받은 mpw를 String 객체 mpw에 저장
        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw); //DTO객체에 입력받은 mid,mpw를 담아만든 DTO객체를 담기
            HttpSession session = request.getSession(); //세션 생성
            session.setAttribute("loginInfo", memberDTO); //세션에 loginInfo라는 이름으로 위의 DTO를 담는다.
            response.sendRedirect("/member/mem.do"); //MemberController(회원목록)로~~
        } catch (Exception e) {
//            e.printStackTrace();
            response.sendRedirect("/login?result=error");
//            throw new ServletException("login error"); //서블렛 익셉션을 달아주니 자꾸 익셉션에 걸려서 빼주었다.
        }
    }
}
