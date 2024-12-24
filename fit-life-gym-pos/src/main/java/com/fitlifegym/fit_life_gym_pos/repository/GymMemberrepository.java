package com.fitlifegym.fit_life_gym_pos.repository;

import com.fitlifegym.fit_life_gym_pos.dto.GymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.entity.GymMember;
import com.fitlifegym.fit_life_gym_pos.util.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:40 PM
 * @since : 12/23/2024
 **/
@Repository
@EnableJpaRepositories
public interface GymMemberrepository extends JpaRepository<GymMember,Long> {
    List<GymMemberDTO> findByMembershipType(MembershipType membershipType);
    // Find members by their membership type
//    @Query("SELECT m FROM gym_member m WHERE m.membershipType = :membershipType")
//    List<GymMember> findByMembershipType(@Param("membershipType") MembershipType membershipType);
}
