package com.gaebaljip.exceed.member.adapter.in;

import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.dto.request.CreateMemberRequest;
import com.gaebaljip.exceed.member.application.port.in.CreateMemberCommand;
import com.gaebaljip.exceed.member.application.port.in.CreateMemberUsecase;
import com.gaebaljip.exceed.member.domain.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1")
public class CreateMemberController {

    private final CreateMemberUsecase createMemberUsecase;

    @PostMapping("/members")
    public ApiResponse<?> createMember(@Valid @RequestBody CreateMemberRequest request) {
        CreateMemberCommand command = CreateMemberCommand.builder()
                .height(request.height())
                .weight(request.weight())
                .gender(request.gender())
                .etc(request.etc())
                .age(request.age())
                .activity(Activity.valueOf(request.activity())).build();
        createMemberUsecase.execute(command);
        return ApiResponseGenerator.success(HttpStatus.CREATED);
    }
}
