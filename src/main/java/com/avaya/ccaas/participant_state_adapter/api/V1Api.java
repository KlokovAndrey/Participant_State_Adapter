/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.avaya.ccaas.participant_state_adapter.api;

import com.avaya.ccaas.participant_state_adapter.model.ErrorResponse;
import com.avaya.ccaas.participant_state_adapter.model.Participant;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-05T13:03:21.077191100+03:00[Europe/Moscow]")
@Validated
@Api(value = "v1", description = "the v1 API")
public interface V1Api {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /v1/participants
     * add new participant to the call
     *
     * @param participant participant metadata (required)
     * @return Accepted (status code 202)
     *         or Bad input (status code 400)
     */
    @ApiOperation(value = "", nickname = "addParticipant", notes = "add new participant to the call", response = String.class, tags={ "Participant state", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Accepted", response = String.class),
        @ApiResponse(code = 400, message = "Bad input", response = ErrorResponse.class) })
    @PostMapping(
        value = "/v1/participants",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<String> addParticipant(@ApiParam(value = "participant metadata" ,required=true )  @Valid @RequestBody Participant participant) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /v1/participants/{participantId}
     * remove participant from the call
     *
     * @param participantId The unique 36 character id that represents the participant (required)
     * @return Accepted (status code 202)
     *         or Bad input (status code 400)
     */
    @ApiOperation(value = "", nickname = "removeParticipant", notes = "remove participant from the call", response = String.class, tags={ "Participant state", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Accepted", response = String.class),
        @ApiResponse(code = 400, message = "Bad input", response = ErrorResponse.class) })
    @PostMapping(
        value = "/v1/participants/{participantId}",
        produces = { "application/json" }
    )
    default ResponseEntity<String> removeParticipant(@Size(min=36,max=36) @ApiParam(value = "The unique 36 character id that represents the participant",required=true) @PathVariable("participantId") String participantId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
