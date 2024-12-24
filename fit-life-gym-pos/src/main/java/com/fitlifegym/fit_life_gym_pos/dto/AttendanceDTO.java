package com.fitlifegym.fit_life_gym_pos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:01 PM
 * @since : 12/23/2024
 **/

/**
 * Data Transfer Object (DTO) for representing the attendance details of a gym member.
 * Contains information about the check-in and check-out times of the member.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDTO {

    private Long id;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

}
