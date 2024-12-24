package com.fitlifegym.fit_life_gym_pos.controller;

import com.fitlifegym.fit_life_gym_pos.dto.GymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.dto.requestDTO.ResponseGymMemberDTO;
import com.fitlifegym.fit_life_gym_pos.service.GymMemberService;
import com.fitlifegym.fit_life_gym_pos.util.MembershipType;
import com.fitlifegym.fit_life_gym_pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:05 PM
 * @since : 12/23/2024
 **/

/**
 * REST controller for managing gym members.
 * Provides endpoints for creating, retrieving, and deleting gym member information.
 */

@RestController
@RequestMapping("api/v1/gym-member")
public class GymMemberController {
    @Autowired
    private GymMemberService gymMemberService;

    /**
     * Adds a new gym member to the system.
     *
     * @param gymMemberDTO the data transfer object containing gym member details.
     * @return a ResponseEntity containing a StandardResponse with the operation's result.
     *         Status code 201 (Created) is returned upon success.
     */

    @PostMapping("/save-member")
    public ResponseEntity<StandardResponse> addGymMember(@RequestBody GymMemberDTO gymMemberDTO){
        String message = gymMemberService.saveGymMember(gymMemberDTO);
        return new ResponseEntity<StandardResponse> (new StandardResponse(201,"success",message), HttpStatus.CREATED);

    }

    /**
     * Retrieves details of a specific gym member by their ID.
     *
     * @param memberId the ID of the gym member to be retrieved.
     * @return a ResponseEntity containing a StandardResponse with the gym member details.
     *         Status code 200 (OK) is returned upon success.
     */

    @GetMapping(path= "/get-member-by-id", params = "id")
    public ResponseEntity<StandardResponse> getMemberById(@RequestParam(value = "id" )long memberId){
        ResponseGymMemberDTO responseGymMemberDTO=gymMemberService.getMemberById(memberId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"success", responseGymMemberDTO),HttpStatus.OK);
    }

//    @GetMapping("/get-member-by-membership-type")
//    public ResponseEntity<StandardResponse> getGymMembersByMembershipType(@RequestParam MembershipType membershipType) {
//        List<GymMemberDTO> allMembers = gymMemberService.getMembersByMembershipType(membershipType;
//
//        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"success",allMembers),HttpStatus.OK);
//
//    }

    /**
     * Retrieves a list of all gym members.
     *
     * @return a ResponseEntity containing a StandardResponse with the list of all gym members.
     *         Status code 200 (OK) is returned upon success.
     */

    @GetMapping(path="/get-all-members")
    public ResponseEntity<StandardResponse> getAllMembers(){
        List<GymMemberDTO> allMembers = gymMemberService.getAllMembers();

        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"success",allMembers),HttpStatus.OK);
    }

    /**
     * Deletes a gym member from the system by their ID.
     *
     * @param memberId the ID of the gym member to be deleted.
     * @return a ResponseEntity containing a StandardResponse with the operation's result.
     *         Status code 200 (OK) is returned upon success.
     */

    @DeleteMapping(path = "/delete-member", params = "id")
    public ResponseEntity<StandardResponse> deleteMember(@RequestParam(value = "id" )long memberId) {
        String message = gymMemberService.deleteMember(memberId);
        return new ResponseEntity<>(new StandardResponse(200, "success", message), HttpStatus.OK);
    }




}
