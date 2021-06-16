package com.sam.springsecirityjwt;

import com.sam.models.User;
import com.sam.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomLoginFailureHandler.class);
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("User Failed To Login: ");
        String username = request.getParameter("username");
        System.out.println("UserName: " + username);
        User user = this.userService.findByUsername(username);
        if (user != null) {
            log.info("User Found  Login:{}", username);
            if (user.isEnabled() && !user.getUserLocked()) {

                if (user.getFailedAttempt() < UserService.MAX_FAILED_ATTEMPTS - 1) {
                    this.userService.updateFailedAttempts(user.getFailedAttempt() + 1, user.getUsername());
                    exception =  new LockedException("Invalid User name or password: Please provide the correct details, Your account will be locked on 3 failed attempts: Failed Attempt: "+user.getFailedAttempt());
                } else {
                    this.userService.lockUser(user);
                    exception = new LockedException("User Account Is Locked Please contact the System Admin");
                }
            }

        } else {
            System.out.println("User Does not exist");
            log.info("User Does not exist", username);
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}
