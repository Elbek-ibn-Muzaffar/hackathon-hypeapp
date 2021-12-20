package com.hackathon.hypeapp.services;


import com.hackathon.hypeapp.payload.AuthRequest;
import com.hackathon.hypeapp.payload.AuthResponce;
import com.hackathon.hypeapp.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthResponce createToken(AuthRequest authRequest) throws Exception
    {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword())
            );
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("Password yoki login hato",e);
        }

        final UserDetails userDetails=userDetailsService.loadUserByUsername(authRequest.getEmail());

        final String jwt=jwtUtils.generateToken(userDetails);

        return new AuthResponce(jwt);
    }


}
