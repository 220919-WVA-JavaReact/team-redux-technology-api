package com.revature.aspects;

import com.revature.annotations.Secured;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.AuthorizationException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.services.TokenService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {
    private HttpServletRequest req;
    private TokenService ts;

    @Autowired
    public SecurityAspect(HttpServletRequest req, TokenService ts){
        this.req = req;
        this.ts = ts;
    }

    @Around("@annotation(com.revature.annotations.Secured)")
    public Object secure(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Secured securedAnnotation = method.getAnnotation(Secured.class);
        List<String> allowedRoles = Arrays.asList(securedAnnotation.rolesAllowed());

        String token = req.getHeader("Authorization");

        UserDTO user = ts.TokenDetails(token);

        if(!allowedRoles.contains(user.getRole().toString())){
            throw new AuthorizationException();
        }
        return pjp.proceed();
    }

    @Around("@annotation(com.revature.annotations.Authenticated)")
    public Object authenticate(ProceedingJoinPoint pjp) throws Throwable {
        String token = req.getHeader("Authorization");

        UserDTO user = ts.TokenDetails(token);

        Object[] args = pjp.getArgs();

        if (args == null || args.length == 1){
            throw new UserNotFoundException();
        }

        String id = (String) args[0];

        if (id == null || !id.equals(user.getUser_id())){
            throw new AuthorizationException();
        }
        return pjp.proceed();
    }
}
