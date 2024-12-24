package com.fitlifegym.fit_life_gym_pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:47 PM
 * @since : 12/23/2024
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "enrolledClasses")
    private List<GymMember> gymMembers = new ArrayList<>();
}
