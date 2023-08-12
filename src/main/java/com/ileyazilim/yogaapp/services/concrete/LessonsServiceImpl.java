package com.ileyazilim.yogaapp.services.concrete;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.core.utilities.results.SuccessDataResult;
import com.ileyazilim.yogaapp.dto.*;
import com.ileyazilim.yogaapp.entities.Lessons;
import com.ileyazilim.yogaapp.entities.Reservation;
import com.ileyazilim.yogaapp.entities.User;
import com.ileyazilim.yogaapp.repository.LessonsRepository;
import com.ileyazilim.yogaapp.repository.UserRepository;
import com.ileyazilim.yogaapp.services.abstracts.LessonsService;
import com.ileyazilim.yogaapp.util.LessonsMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LessonsServiceImpl implements LessonsService {
    private LessonsRepository lessonsRepository;
    private LessonsMapperUtil  mapperUtil;
    private UserRepository userRepository;
    @Override
    public DataResult<List<LessonsResponse>> listLessons() {
        List<Lessons>lessons = lessonsRepository.findAll();
        List<LessonsResponse> responses = lessons.stream().map(mapperUtil::listLessons).collect(Collectors.toList());
        return new SuccessDataResult<>(responses, "listl lessons");
    }

    @Override
    public DataResult<List<Lessons>> getLessonsByUserId(Long userId) {
        return new SuccessDataResult<>(lessonsRepository.findByUsersId(userId));

    }

    @Override
    public Result createLessons(LessonsRequest lessonsRequest) {
        Lessons lessons = mapperUtil.postLessons(lessonsRequest);
        Lessons savedLessons = this.lessonsRepository.save(lessons);
        return new SuccessDataResult<>(savedLessons, "added reservation");
    }

    @Override
    public Result updateLessonsProcess(LessonsUpdateRequest request, Long lessonsId) {
        Optional<Lessons> lessonsDb = this.lessonsRepository.findById(lessonsId);
        Optional<User> userDb = this.userRepository.findById(request.getUserId());
        User user = userDb.get();
        Lessons lessons = null;

        if (lessonsDb.isPresent()) {
            lessons = lessonsDb.get();
            lessons.setProcess(request.getProcess());
            lessons.setUsers(user);
        }
        Lessons updatelessons = lessonsRepository.save(lessons);
        return new SuccessDataResult<>(updatelessons,"update process");

    }
}
