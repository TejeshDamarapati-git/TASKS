package com.mayuratech.api.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mayuratech.api.entity.User;
import com.mayuratech.api.payload.JWTAuthRequest;
import com.mayuratech.api.payload.JWTAuthResponse;
import com.mayuratech.api.payload.SignUpDto;
import com.mayuratech.api.repository.UserRepository;
import com.mayuratech.api.security.CustomUserDetailsService;
import com.mayuratech.api.utility.JWTUtility;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JWTUtility jwtUtility ;
    
    @Autowired
    private CustomUserDetailsService userService;

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody JWTAuthRequest jwtRequest) throws Exception{
    	
    	
    	try {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        		jwtRequest.getUsernameOrEmail(), jwtRequest.getPassword()));
    	}catch(BadCredentialsException e) {
    		throw new Exception("Invalid Credentials",e); 
    	}
    	
    	final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsernameOrEmail());
    	final String generatedToken = jwtUtility.generateToken(userDetails);

        return new ResponseEntity<>(new JWTAuthResponse(generatedToken),HttpStatus.OK);
    }
    @PostMapping(path="/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
    	
    	if (userRepository.existsByEmail(signUpDto.getEmail())) {
    	    return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
    	}
    	if(userRepository.existsByUserName(signUpDto.getUserName())) {
    		return new ResponseEntity<>("UserName already exists", HttpStatus.BAD_REQUEST);
    	}

        User user = new User();
        user.setFullName(signUpDto.getFullName());
        user.setUserName(signUpDto.getUserName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setMobile(signUpDto.getMobile());
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    
    @Value("${file.upload-dir}")
    String File_Directory;
    @PostMapping("/uploadFile")
    public ResponseEntity<Object> fileUpload (@RequestParam("File") MultipartFile file) throws IOException{
    	File myFile=new File(File_Directory+file.getOriginalFilename());
    	myFile.createNewFile();
    	FileOutputStream fos = new FileOutputStream(myFile);
    	fos.write(file.getBytes());
    	fos.close();
    	return new ResponseEntity<Object> ("File Uploaded Succesfully",HttpStatus.OK);
    }
    
    
    
}