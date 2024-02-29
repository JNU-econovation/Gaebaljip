package com.gaebaljip.exceed.nutritionist.adapter.in;

import com.gaebaljip.exceed.nutritionist.application.port.in.GetAnalysisUsecase;
import com.gaebaljip.exceed.common.CommonApiTest;
import com.gaebaljip.exceed.common.WithMockGuestUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetAnalysisController.class)
class GetAchieveControllerTest extends CommonApiTest {

    @MockBean
    private GetAnalysisUsecase getAchieveUsecase;

    @Test
    @WithMockGuestUser
    void getAchieve() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/v1/achieve/2023-12-08")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());
    }
}