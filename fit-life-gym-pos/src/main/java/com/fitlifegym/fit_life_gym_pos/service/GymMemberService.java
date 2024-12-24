package com.fitlifegym.fit_life_gym_pos.service;

import com.fitlifegym.fit_life_gym_pos.dto.GymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.dto.requestDTO.ResponseGymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.util.MembershipType;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:09 PM
 * @since : 12/23/2024
 **/
public interface GymMemberService {

    String saveGymMember(GymMemberDTO gymMemberDTO);

    ResponseGymMemberDTO getMemberById(long memberId);

    String deleteMember(long memberId);

    List<GymMemberDTO> getAllMembers();

 //   List<GymMemberDTO> getMembersByMembershipType(MembershipType membershipType);
}
