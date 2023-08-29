package com.bankezy.helpers;

public class HTML {
    public static String htmlEmailTemplate(String token , String code){
        //verify account url
        String url="http://localhost:8080/verify?token="+token+"&code="+code;
        String emailTemplate="<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <!--<link rel='stylesheet' href='css/email.css'>-->\n" +
                "    <title>Email</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "            font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;\n" +
                "        }\n" +
                "\n" +
                "        /* main body styling*/\n" +
                "        body {\n" +
                "            height: 100vh;\n" +
                "            background-color: rgb(212, 222, 230);\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "\n" +
                "        /* <!--wrapper-->*/\n" +
                "        .wrapper {\n" +
                "            width: 550px;\n" +
                "            height: auto;\n" +
                "            padding: 15px;\n" +
                "            background-color: white;\n" +
                "            border-radius: 7px;\n" +
                "        }\n" +
                "\n" +
                "        /*   <!--email MSG header-->*/\n" +
                "        .email-msg-header {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .company-name {\n" +
                "            width: 100%;\n" +
                "            font-size: 35px;\n" +
                "            color: gray;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        /*<!--welcome text-->*/\n" +
                "        .welcome-text {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        /* <!--verify account button-->*/\n" +
                "        .verify-account-btn {\n" +
                "            padding: 15px;\n" +
                "            background-color: rgb(0, 109, 252);\n" +
                "            text-decoration: none;\n" +
                "            color: white;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "\n" +
                "        /*<!--copy right wrapper-->*/\n" +
                "        .copy-right {\n" +
                "            padding: 15px;\n" +
                "            color: gray;\n" +
                "            font-size: 14px;\n" +
                "            margin: 20px 0;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <!--wrapper-->\n" +
                "    <div class='wrapper'>\n" +
                "        <!--email MSG header-->\n" +
                "        <h2 class='email-msg-header'>\n" +
                "            Welcome And Thank You for Choosing\n" +
                "\n" +
                "        </h2>\n" +
                "        <!--end of email MSG header-->\n" +
                "        <!--company name-->\n" +
                "        <div class='company-name'>Bankezy</div>\n" +
                "        <!--end of company name-->\n" +
                "        <hr>\n" +
                "        <!--welcome text-->\n" +
                "        <p class='welcome-text'>\n" +
                "            Your Account has been successfully registered, please click below to verify your account.\n" +
                "        </p>\n" +
                "        <!--end of welcome text-->\n" +
                "        <br>\n" +
                "        <br>\n" +
                "        <!--verify account button-->\n" +
                "        <center><a href=' " + url+" ' class='verify-account-btn' role='button'>Verify Account</a></center>\n" +
                "        <!-- end of verify account button-->\n" +
                "\n" +
                "        <!--copy right wrapper-->\n" +
                "        <div class='copy-right'>\n" +
                "            &copy; Copy Right 2023. All rights reserved\n" +
                "        </div>\n" +
                "        <!--end of copy right wrapper-->\n" +
                "    </div>\n" +
                "    <!--end of wrapper-->\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        return emailTemplate;
    }
}
