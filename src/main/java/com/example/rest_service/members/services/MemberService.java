package com.example.rest_service.members.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.rest_service.members.dto.MemberDTO;
import com.example.rest_service.members.models.Member;
import com.example.rest_service.members.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDTO> getFamilyTree(Long familyId) {
        List<Member> members = memberRepository.findByFamilyId(familyId);
        List<Member> rootMembers =
                members.stream().filter(m -> m.getParent() == null).collect(Collectors.toList());
        return rootMembers.stream().map(MemberDTO::new).collect(Collectors.toList());
    }
}
