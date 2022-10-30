package com.otp.otpapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.otp.otpapi.entities.OTP;

@RestController
public class OtpController {

    final String valid = "VALID";
    final String invalid = "INVALID";

    
    OTP otp = null;

    @GetMapping("/otp")
    public OTP getOTP(){
        return this.otp;
    }

    @GetMapping("/status")
    public String getStatus(){
        return this.otp.getStatus();
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<OTP> verifyOtp(@RequestBody OTP otp){
        try{
            if(this.otp.getCode().equals(otp.getCode())){
                //System.out.println(this.otp.getCode());
                //System.out.println(otp.getCode());
                return ResponseEntity.ok().build();
            }
            else 
                return ResponseEntity.badRequest().build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/otp")
    public ResponseEntity<OTP> generateOTP(@RequestBody OTP otp){
        try{
            this.otp = new OTP();
            int randomPin   =(int) (Math.random()*9000)+1000;
            String code  = String.valueOf(randomPin);
            this.otp.setEmail(otp.getEmail());
            this.otp.setCode(code);
            this.otp.setStatus(valid);
            System.out.println("OTP: "+this.otp.getCode());
            //System.out.println(this.otp.toString());
            return ResponseEntity.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/otp")
    public ResponseEntity<OTP> updateStatus(@RequestBody OTP otp){
        try{
            this.otp.setStatus(invalid);
            //System.out.println(this.otp.toString());
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
