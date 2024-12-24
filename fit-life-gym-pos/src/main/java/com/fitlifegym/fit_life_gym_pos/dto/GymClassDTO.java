package com.fitlifegym.fit_life_gym_pos.dto;

import com.fitlifegym.fit_life_gym_pos.entity.GymMember;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:59 PM
 * @since : 12/23/2024
 **/

/**
 * Data Transfer Object (DTO) for representing a gym class.
 * Contains details about the gym class, including its name and the list of members enrolled in the class.
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GymClassDTO {
    private Long id;

    private String name;

    private List<GymMember> gymMembers = new ArrayList<>();
}
