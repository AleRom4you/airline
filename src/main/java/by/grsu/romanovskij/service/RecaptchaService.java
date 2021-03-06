package by.grsu.romanovskij.service;

import by.grsu.romanovskij.controller.UserRegistrationController;
import com.sun.xml.internal.ws.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecaptchaService {
    private static final Logger logger = Logger.getLogger(UserRegistrationController.class);

    @Value("6LcQpnIUAAAAACuoTyDlnN4Ayg5Raz4teRnHbcua")
    String recaptchaSecret;

    private static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public String verifyRecaptcha(String ip, String recaptchaResponse){
        Map<String, String> body = new HashMap<>();
        body.put("secret", recaptchaSecret);
        body.put("response", recaptchaResponse);
        body.put("remoteip", ip);
        logger.debug("Request body for recaptcha: " + body);

        ResponseEntity<Map> recaptchaResponseEntity = restTemplateBuilder.build()
                .postForEntity(GOOGLE_RECAPTCHA_VERIFY_URL +
                        "?secret={secret}&response={response}&remoteip={remoteip}", body, Map.class, body);

        logger.error("Response from recaptcha: " + recaptchaResponseEntity);

        Map<String, Object> responseBody = recaptchaResponseEntity.getBody();

        boolean recaptchaSucess = (Boolean)responseBody.get("success");
        if ( !recaptchaSucess) {
            List<String> errorCodes = (List)responseBody.get("error-codes");
            String errorMessage = errorCodes.stream()
                    .map(s -> RecaptchaUtil.RECAPTCHA_ERROR_CODE.get(s))
                    .collect(Collectors.joining(", "));
            return errorMessage;
        }else {
            return "";
        }
    }
}

class RecaptchaUtil {
    public static final Map<String, String>
            RECAPTCHA_ERROR_CODE = new HashMap<>();

    static {
        RECAPTCHA_ERROR_CODE.put("missing-input-secret",
                "The secret parameter is missing");
        RECAPTCHA_ERROR_CODE.put("invalid-input-secret",
                "The secret parameter is invalid or malformed");
        RECAPTCHA_ERROR_CODE.put("missing-input-response",
                "The response parameter is missing");
        RECAPTCHA_ERROR_CODE.put("invalid-input-response",
                "The response parameter is invalid or malformed");
        RECAPTCHA_ERROR_CODE.put("bad-request",
                "The request is invalid or malformed");
    }
}