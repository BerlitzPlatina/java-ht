package com.example.rest_service.members.controllers;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rest_service.families.dto.FamilyRequestDto;
import com.example.rest_service.families.dto.FamilyResponseDto;
import com.example.rest_service.members.dto.MemberDTO;
import com.example.rest_service.members.services.MemberService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/families/{familyId}/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembersOfFamily(@PathVariable Long familyId) {
        return ResponseEntity.ok(memberService.getFamilyTree(familyId));
    }
}
