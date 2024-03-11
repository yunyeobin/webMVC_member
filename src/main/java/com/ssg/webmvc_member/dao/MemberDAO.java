package com.ssg.webmvc_member.dao;

import com.ssg.webmvc_member.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public List<MemberVO> listMembers() throws Exception {
        String sql = "select * from mvc_member";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<MemberVO> memberVOList = new ArrayList<>();
        while (rs.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .mid(rs.getString(1))
                    .mpw(rs.getString(2))
                    .mname(rs.getString(3))
                    .mmail(rs.getString(4))
                    .joinDate(rs.getDate(5).toLocalDate()).build();
            memberVOList.add(memberVO);

        }
        return memberVOList;

    }

    public void registerMember(MemberVO memberVO) throws Exception {
        String sql = "insert into mvc_member (mid, mpw, mname, mmail, joinDate) values (?,?,?,?,now())";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, memberVO.getMid());
        pstmt.setString(2, memberVO.getMpw());
        pstmt.setString(3, memberVO.getMname());
        pstmt.setString(4, memberVO.getMmail());
//        pstmt.setDate(5, Date.valueOf(memberVO.getJoinDate()));
        pstmt.executeUpdate();
    }

    public MemberVO selectOne(String mid) throws Exception {

        String sql = "select * from mvc_member where mid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, mid);

        @Cleanup ResultSet resultSet = pstmt.executeQuery();

        resultSet.next();

        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .mmail(resultSet.getString("mmail"))
                .joinDate(resultSet.getDate("joindate").toLocalDate()).build();

        return memberVO;
    }


    public void modifyOne(MemberVO memberVO) throws Exception {

        String sql = "update mvc_member set mpw =?, mname = ?, mmail = ? where mid =?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, memberVO.getMpw());
        pstmt.setString(2, memberVO.getMname());
        pstmt.setString(3, memberVO.getMmail());
        pstmt.setString(4, memberVO.getMid());
        pstmt.executeUpdate();
    }

    public void deleteOne(String mid) throws Exception {
        String sql = "delete from mvc_member where mid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, mid);
        pstmt.executeUpdate();
    }

    public MemberVO getLoginInfo(String mid, String mpw) throws Exception{
        String sql = "select mid, mpw, mname, mmail from mvc_member where mid = ? and mpw = ?";

        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        memberVO = MemberVO.builder()
                .mid(rs.getString(1))
                .mpw(rs.getString(2))
                .mname(rs.getString(3))
                .mmail(rs.getString(4))
//                .joinDate(rs.getDate(5).toLocalDate())
                .build();

        return memberVO;
    }
}

