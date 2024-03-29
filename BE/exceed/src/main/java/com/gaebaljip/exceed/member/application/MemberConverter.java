package com.gaebaljip.exceed.member.application;

import com.gaebaljip.exceed.member.adapter.out.persistence.MemberEntity;
import com.gaebaljip.exceed.member.domain.GuestModel;
import com.gaebaljip.exceed.member.domain.MemberModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberConverter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberEntity toEntity(GuestModel guestModel, String etc) {
        return MemberEntity.builder()
                .loginId(guestModel.getLoginId())
                .password(bCryptPasswordEncoder.encode(guestModel.getPassword()))
                .weight(guestModel.getWeight())
                .height(guestModel.getHeight())
                .age(guestModel.getAge())
                .gender(guestModel.getGender())
                .etc(etc)
                .activity(guestModel.getActivity())
                .role(guestModel.getRole())
                .build();
    }

    public MemberModel toModel(MemberEntity memberEntity) {
        return MemberModel.builder()
                .height(memberEntity.getHeight())
                .weight(memberEntity.getWeight())
                .gender(memberEntity.getGender())
                .activity(memberEntity.getActivity())
                .age(memberEntity.getAge())
                .build();
    }
}
