package com.ssg.webmvc_member.controller;

import com.ssg.webmvc_member.dao.MemberDAO;
import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "memberController", urlPatterns = "/member/mem.do")
public class MemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<MemberDTO> dtoList = memberService.listAll(); //MemberDTO 객체를 담은 리스트 생성
            request.setAttribute("dtoList", dtoList); //해당 list를 dtoList라는 이름으로 담기
            request.getRequestDispatcher("/WEB-INF/member/listMembers.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
//            throw new ServletException("list error"); //서블렛 익셉션이 로그인 필터에서 자꾸 걸려서 빼주었다.
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
