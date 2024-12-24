package com.fitlifegym.fit_life_gym_pos.entity;

import com.fitlifegym.fit_life_gym_pos.util.MembershipType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:48 PM
 * @since : 12/23/2024
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class GymMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    @OneToMany(mappedBy = "gymMember")
    private List<Payment> payments;

    @ManyToMany
    @JoinTable(
            name = "member_classes",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<GymClass> enrolledClasses = new ArrayList<>();

    @OneToMany(mappedBy = "gymMember", cascade = CascadeType.ALL)
    private List<Attendance> attendances = new ArrayList<>();

}