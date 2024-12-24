package com.fitlifegym.fit_life_gym_pos.service.impl;

import com.fitlifegym.fit_life_gym_pos.dto.AttendanceDTO;
import com.fitlifegym.fit_life_gym_pos.dto.GymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.dto.PaymentDTO;
import com.fitlifegym.fit_life_gym_pos.dto.requestDTO.ResponseGymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.entity.Attendance;
import com.fitlifegym.fit_life_gym_pos.entity.GymClass;
import com.fitlifegym.fit_life_gym_pos.entity.GymMember;
import com.fitlifegym.fit_life_gym_pos.entity.Payment;
import com.fitlifegym.fit_life_gym_pos.exception.NotFoundException;
import com.fitlifegym.fit_life_gym_pos.repository.GymClassRepository;
import com.fitlifegym.fit_life_gym_pos.repository.GymMemberrepository;
import com.fitlifegym.fit_life_gym_pos.service.GymMemberService;
import com.fitlifegym.fit_life_gym_pos.util.MembershipType;
import com.fitlifegym.fit_life_gym_pos.util.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:10 PM
 * @since : 12/23/2024
 **/

/**
 * Implementation of the GymMemberService interface.
 * Provides business logic for managing gym members, including creating, retrieving, updating,
 * and deleting gym members as well as handling related entities such as gym classes, payments, and attendances.
 */
@Service
public class GymMemberServiceIMPL implements GymMemberService {

    @Autowired
    private GymMemberrepository gymMemberrepository;

    @Autowired
    private GymClassRepository gymClassRepository;

    @Autowired
    MemberMapper memberMapper;

    /**
     * Saves a new gym member based on the provided GymMemberDTO.
     * Maps the DTO to a GymMember entity, handles related entities like enrolled classes, payments,
     * and attendances, and then saves the gym member to the repository.
     *
     * @param gymMemberDTO the DTO containing gym member data to be saved
     * @return a message indicating whether the save operation was successful or not
     */
    @Override
    public String saveGymMember(GymMemberDTO gymMemberDTO) {
        try {
            GymMember gymMember = new GymMember();
            gymMember.setName(gymMemberDTO.getName());
            gymMember.setEmail(gymMemberDTO.getEmail());
            gymMember.setMembershipType(gymMemberDTO.getMembershipType());

            //many to many
            List<GymClass> enrolledClasses = new ArrayList<>();
            for (int i = 0; i < gymMemberDTO.getEnrolledClassIds().size(); i++) {
                Long classId = gymMemberDTO.getEnrolledClassIds().get(i);
                Optional<GymClass> gymClassOptional = gymClassRepository.findById(classId);
                if (gymClassOptional.isPresent()) {
                    enrolledClasses.add(gymClassOptional.get());  // Add to the list if found
                } else {
                    // If the GymClass is not found, throw an exception
                    throw new RuntimeException("GymClass not found with id: " + classId);
                }
            }
            gymMember.setEnrolledClasses(enrolledClasses);

            //one to many
            List<Payment> payments = new ArrayList<>();
            for (int i = 0; i < gymMemberDTO.getPayments().size(); i++) {
                PaymentDTO paymentDTO = gymMemberDTO.getPayments().get(i);
                Payment payment = new Payment();
                payment.setAmount(paymentDTO.getAmount());
                payment.setPaymentDate(paymentDTO.getPaymentDate());
                payment.setGymMember(gymMember);
                payments.add(payment);
            }
            gymMember.setPayments(payments);

            //one to many
            List<Attendance> attendances = new ArrayList<>();
            for (int i = 0; i < gymMemberDTO.getAttendances().size(); i++) {
                AttendanceDTO attendanceDTO = gymMemberDTO.getAttendances().get(i);
                Attendance attendance = new Attendance();
                attendance.setCheckInTime(attendanceDTO.getCheckInTime());
                attendance.setCheckOutTime(attendanceDTO.getCheckOutTime());
                attendance.setGymMember(gymMember);
                attendances.add(attendance);
            }
            gymMember.setAttendances(attendances);


            gymMemberrepository.save(gymMember);



            return "saved";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Retrieves a gym member by their unique member ID.
     * Converts the GymMember entity to a ResponseGymMemberDTO using the mapper.
     * Throws an exception if the member does not exist.
     *
     * @param memberId the unique ID of the gym member to retrieve
     * @return a ResponseGymMemberDTO containing the details of the gym member
     * @throws NotFoundException if no gym member is found with the given ID
     */
    @Override
    public ResponseGymMemberDTO getMemberById(long memberId) {
            if(gymMemberrepository.existsById(memberId)){
                GymMember gymMember = gymMemberrepository.getReferenceById(memberId);
                ResponseGymMemberDTO responseGymMemberDTO = memberMapper.entityToDto(gymMember);

                return responseGymMemberDTO;
            }else {
                throw new NotFoundException("Member Not found");
            }

    }

    /**
     * Deletes a gym member by their unique member ID.
     * If the member exists, they are removed from the repository.
     * Throws an exception if no member is found with the given ID.
     *
     * @param memberId the unique ID of the gym member to delete
     * @return a success message indicating that the member was deleted
     * @throws NotFoundException if no gym member is found with the given ID
     */
    @Override
    public String deleteMember(long memberId) {
        if(gymMemberrepository.existsById(memberId)){
            gymMemberrepository.deleteById(memberId);
            return "deleted successfully" +memberId;
        }else {
            throw new NotFoundException("Member Not found");
        }

    }

    /**
     * Retrieves all gym members from the repository.
     * If members are found, they are mapped to GymMemberDTO objects and returned.
     * Throws an exception if no gym members are found.
     *
     * @return a list of GymMemberDTO objects representing all gym members
     * @throws NotFoundException if no gym members are found in the repository
     */
    @Override
    public List<GymMemberDTO> getAllMembers() {
        List<GymMember> gymMembers = gymMemberrepository.findAll();

        if(gymMembers.size()>0){

            List<GymMemberDTO> gymMemberDTOS=memberMapper.entityListToDtoList(gymMembers);
            return gymMemberDTOS;
        }else {
            throw new NotFoundException("Member Not found");
        }

    }

//    @Override
//    public List<GymMemberDTO> getMembersByMembershipType(MembershipType membershipType) {
//
//        List<GymMemberDTO> gymMembers = gymMemberrepository.findByMembershipType(membershipType);
//        if(gymMembers.size()>0){
//
//            List<GymMemberDTO> gymMemberDTOS=memberMapper.entityListToDtoList(gymMembers);
//            return gymMemberDTOS;
//        }else {
//            throw new NotFoundException("Member Not found");
//        }
//    }


}
