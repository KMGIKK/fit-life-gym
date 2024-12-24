package com.fitlifegym.fit_life_gym_pos.dto.requestDTO;

import com.fitlifegym.fit_life_gym_pos.util.MembershipType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:18 PM
 * @since : 12/23/2024
 **/

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGymMemberDTO {
    private String name;
    private String email;
    private MembershipType membershipType;
}
