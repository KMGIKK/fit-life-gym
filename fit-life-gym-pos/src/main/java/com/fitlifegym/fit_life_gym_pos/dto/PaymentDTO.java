package com.fitlifegym.fit_life_gym_pos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:59 PM
 * @since : 12/23/2024
 **/

/**
 * Data Transfer Object (DTO) for representing a payment made by a gym member.
 * Contains details about the payment, including the payment amount and date.
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private Double amount;
    private LocalDate paymentDate;
}
