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
        //회원목록에서 수정 버튼을 누르면 ModifyMemberController에 Get요청이 오게 된다.
        String mid = request.getParameter("mid");
        MemberDTO memberDTO = null;
        try {
            //mid에 해당하는 한개의 DTO객체를 가져와 memberDTO에 담는다.
            memberDTO = memberService.read(mid);
            System.out.println(memberDTO);
            //dto라는 이름으로 해당 memberDTO를 담는다.
        request.setAttribute("dto", memberDTO);
        //모두함께 modifyMember.jsp로
        request.getRequestDispatcher("/WEB-INF/member/modifyMember.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
//            throw new ServletException("modify error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //modifyMember.jsp에서 입력된 파라미터들로 다시 DTO를 구성한다.
        //mid는 읽기전용이라 바꿀수 없었으므로 그대로, 나머지는 수정했다면 수정한 값으로 다시 들어간다.
        MemberDTO memberDTO = MemberDTO.builder()
                .mid(request.getParameter("mid"))
                .mpw(request.getParameter("mpw"))
                .mname(request.getParameter("mname"))
                .mmail(request.getParameter("mmail"))
                .build();
        //잘 들어갔나 확인차 출력한번.
        System.out.println(memberDTO);
        try {
            //modify메소드를 통해 DB에 update해준다.
            memberService.modify(memberDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        response.sendRedirect("/member/mem.do");
    }
}
