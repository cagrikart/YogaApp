package com.ileyazilim.yogaapp.util;

import com.ileyazilim.yogaapp.dto.LessonsRequest;
import com.ileyazilim.yogaapp.dto.LessonsResponse;
import com.ileyazilim.yogaapp.dto.ReservationRequest;
import com.ileyazilim.yogaapp.dto.ReservationResponse;
import com.ileyazilim.yogaapp.entities.Lessons;
import com.ileyazilim.yogaapp.entities.Reservation;
import com.ileyazilim.yogaapp.entities.User;
import com.ileyazilim.yogaapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class LessonsMapperUtil {
    private UserRepository userRepository;

    public LessonsResponse listLessons(Lessons lessons) {
        LessonsResponse response = new LessonsResponse();
        response.setDateTime(lessons.getDateTime());
        response.setProcess(lessons.getProcess());
        response.setSession(lessons.getSession());
        response.setFinishingDate(lessons.getFinishingDate());
        response.setStartingDate(lessons.getStartingDate());
        response.setUserId(lessons.getUsers().getId());
        return response;
    }
    public Lessons postLessons(LessonsRequest request) {
        Lessons lessons  = new Lessons();
        lessons.setDateTime(request.getDateTime());
        lessons.setSession(request.getSession());
        lessons.setProcess(request.getProcess());
        Optional<User> userOptional = this.userRepository.findById(request.getUserId());
        if (userOptional.isPresent()) {
            lessons.setUsers(userOptional.get());
        }
        lessons.setFinishingDate(request.getFinishingDate());
        lessons.setStartingDate(request.getStartingDate());
        return lessons;
    }
}
