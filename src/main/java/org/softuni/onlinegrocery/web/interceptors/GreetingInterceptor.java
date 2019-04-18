package org.softuni.onlinegrocery.web.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;

import static org.softuni.onlinegrocery.util.constants.AppConstants.*;

@Component
public class GreetingInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        if (modelAndView == null) {
            modelAndView = new ModelAndView();
        } else {
            LocalTime time = LocalTime.now();
            int hrs = time.getHour();
            if (hrs >= ZERO_NUMBER && hrs <= GREETING_INTERCEPTOR_TWELVE) {
                modelAndView.addObject(GREETING, GREETING_GOOD_MORNING);
            } else if (hrs > GREETING_INTERCEPTOR_TWELVE && hrs <= GREETING_INTERCEPTOR_SEVENTEEN) {
                modelAndView.addObject(GREETING, GREETING_GOOD_AFTERNOON);
            } else {
                modelAndView.addObject(GREETING, GREETING_GOOD_EVENING);
            }
        }
    }
}