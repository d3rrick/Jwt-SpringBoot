package io.guru.securityjwt.controller;

import io.guru.securityjwt.models.AuthRequest;
import io.guru.securityjwt.models.AuthResponse;
import io.guru.securityjwt.services.MyUserDetailsService;
import io.guru.securityjwt.util.JwtUtils;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static io.guru.securityjwt.util.GlobalVariables.EXPIRY_ADD;
@RestController
public class ApiController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtil;

    @GetMapping("/greet")
    public String getUser(){
        return "Hello World!";
    }

    @PostMapping("/auth/generate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                authRequest.getPassWord()));
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect credentials provided.");
        }

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authRequest.getUserName());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token,EXPIRY_ADD));

    }




}
