package com.fitlifegym.fit_life_gym_pos.util.mappers;

import com.fitlifegym.fit_life_gym_pos.dto.GymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.dto.requestDTO.ResponseGymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.entity.GymMember;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:35 PM
 * @since : 12/23/2024
 **/

/**
 * Mapper interface for converting between GymMember entities and GymMemberDTO objects.
 * Uses MapStruct for automatic generation of the implementation.
 * Provides methods for mapping individual GymMember objects and lists of GymMember objects.
 */

@Mapper(componentModel = "spring")
public interface MemberMapper {

    /**
     * Converts a list of GymMember entities to a list of GymMemberDTOs.
     * @param gymMembers the list of GymMember entities to be converted
     * @return the list of mapped GymMemberDTOs
     */
   List<GymMemberDTO> entityListToDtoList(List<GymMember> gymMembers);


    /**
     * Converts a single GymMember entity to a ResponseGymMemberDTO.
     * @param gymMember the GymMember entity to be converted
     * @return the mapped ResponseGymMemberDTO
     */
    ResponseGymMemberDTO entityToDto(GymMember gymMember);


}
