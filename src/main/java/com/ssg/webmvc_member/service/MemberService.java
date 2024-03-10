package com.ssg.webmvc_member.service;

import com.ssg.webmvc_member.dao.MemberDAO;
import com.ssg.webmvc_member.domain.MemberVO;
import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE();

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public List<MemberDTO> listAll() throws Exception {
        List<MemberVO> voList = memberDAO.listMembers();
        List<MemberDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, MemberDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    public void register(MemberDTO memberDTO) throws Exception {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.registerMember(memberVO);
    }

    public void modify(MemberDTO memberDTO) throws Exception {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.modifyOne(memberVO);
    }

    public MemberDTO read(String mid) throws Exception {
        MemberVO memberVO = memberDAO.selectOne(mid);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }

    public void delete(String mid) throws Exception {
        memberDAO.deleteOne(mid);
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO memberVO = memberDAO.getLoginInfo(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }

}
