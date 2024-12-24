package com.fitlifegym.fit_life_gym_pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:46 PM
 * @since : 12/23/2024
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private GymMember gymMember;
}