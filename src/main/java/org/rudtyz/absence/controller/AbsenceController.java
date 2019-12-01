package org.rudtyz.absence.controller;

import com.fasterxml.jackson.annotation.JsonRawValue;
import org.rudtyz.absence.model.Absence;
import org.rudtyz.absence.service.AbsenceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@RestController
@RequestMapping("/absence")
public class AbsenceController {

    @JsonRawValue
    private static final String returnMsgOK = "{\"msg\":\"OK\"}";


    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @PostMapping(value = "/register")
    String registerAbsence(@Valid Absence absence, BindingResult result) throws BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        }

        absenceService.addAbsence(absence);
        return returnMsgOK;
    }

    @PostMapping(value = "/register_all")
    String registerAllAbsence(  @Valid
                                @NotNull
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                @RequestParam
                                Date beginDate,

                                @Valid
                                @NotNull
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                @RequestParam
                                Date endDate) {

        return returnMsgOK;
    }
}
