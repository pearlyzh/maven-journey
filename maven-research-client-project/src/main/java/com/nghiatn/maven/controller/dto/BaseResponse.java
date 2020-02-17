package com.nghiatn.maven.controller.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nghiatn
 */

@Getter
@Setter
@Builder
public class BaseResponse {
    private static final String INIT_RESPONSE_MESSAGE = "INIT";

    @SerializedName("returncode")
    int returnCode = 0;

    @SerializedName("returnmessage")
    String returnMessage = INIT_RESPONSE_MESSAGE;
}
