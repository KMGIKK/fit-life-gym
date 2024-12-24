package com.fitlifegym.fit_life_gym_pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private GymMember gymMember;

    private LocalDate paymentDate;
}
