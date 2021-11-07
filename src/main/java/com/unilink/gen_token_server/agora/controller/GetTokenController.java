package com.unilink.gen_token_server.agora.controller;

import com.unilink.gen_token_server.agora.media.RtcTokenBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agora")
@CrossOrigin
public class GetTokenController {
    static String appId = "3edfb43ed6874aa68d5a5bdab571f1be";
    static String appCertificate = "c41f721d63194fafa2000419465b8047";
    static int expirationTimeInSeconds = 3600;
    @GetMapping("/token/{channelName}")
    public String getToken(@PathVariable(name = "channelName") String channelName){
        RtcTokenBuilder token = new RtcTokenBuilder();
        int timestamp = (int)(System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        String result = token.buildTokenWithUid(appId, appCertificate,
                channelName, 0, RtcTokenBuilder.Role.Role_Publisher, timestamp);
        return result;
    }
}
