package com.ileyazilim.yogaapp.services.abstracts;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.*;
import com.ileyazilim.yogaapp.entities.Lessons;
import com.ileyazilim.yogaapp.entities.Reservation;

import java.util.List;

public interface LessonsService {
    DataResult<List<LessonsResponse>> listLessons();
    DataResult<List<Lessons>> getLessonsByUserId(Long userId);
    Result createLessons(LessonsRequest lessonsRequest);
    Result updateLessonsProcess(LessonsUpdateRequest request, Long lessonsId) ;
}
