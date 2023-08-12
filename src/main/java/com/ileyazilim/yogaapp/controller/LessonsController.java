package com.ileyazilim.yogaapp.controller;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.LessonsRequest;
import com.ileyazilim.yogaapp.dto.LessonsResponse;
import com.ileyazilim.yogaapp.dto.LessonsUpdateRequest;
import com.ileyazilim.yogaapp.entities.Lessons;
import com.ileyazilim.yogaapp.services.abstracts.LessonsService;
import com.ileyazilim.yogaapp.services.abstracts.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@AllArgsConstructor
public class LessonsController {
    private LessonsService lessonsService;

    @GetMapping("/listLessons")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public DataResult<List<LessonsResponse>> listLessons() {
        return this.lessonsService.listLessons();
    }

    @GetMapping("/getLessonsByUserId/{userId}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public DataResult<List<Lessons>> getLessonsByUserId(Long userId) {
        return this.lessonsService.getLessonsByUserId(userId);
    }

    @PostMapping("/createLessons")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public Result createLessons(@RequestBody LessonsRequest lessonsRequest) {
        return this.lessonsService.createLessons(lessonsRequest);
    }


    @PostMapping("/updateLessonsProcess")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public Result updateLessonsProcess(@RequestBody LessonsUpdateRequest request,@PathVariable Long lessonsId) {
        return this.lessonsService.updateLessonsProcess(request,lessonsId);

    }
}
