package com.fitlifegym.fit_life_gym_pos.dto;

import com.fitlifegym.fit_life_gym_pos.entity.Attendance;
import com.fitlifegym.fit_life_gym_pos.entity.GymClass;
import com.fitlifegym.fit_life_gym_pos.entity.Payment;
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
 * @Time :12:59 PM
 * @since : 12/23/2024
 **/

/**
 * Data Transfer Object (DTO) for representing a gym member.
 * Contains information about the gym member, including their personal details, membership type, enrolled classes,
 * payments, and attendance records.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GymMemberDTO {
    private Long id;
    private String name;
    private String email;
    private MembershipType membershipType;
    private List<Long> enrolledClassIds;
    private List<PaymentDTO> payments;
    private List<AttendanceDTO> attendances;
}
