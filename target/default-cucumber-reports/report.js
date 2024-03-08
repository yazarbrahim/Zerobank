$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login to the application",
  "description": "  As a authorized user should be able to login to the application\n  under with valid credentials.",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login_page"
    }
  ]
});
formatter.scenario({
  "name": "Login the application",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login_page"
    },
    {
      "name": "@login_valid_credentials"
    },
    {
      "name": "@smoke_test"
    },
    {
      "name": "@login_invalid_credentials"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on main page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinitions.user_is_on_main_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click the \"signing\" button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinitions.user_click_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters authorized information",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinitions.user_enters_authorized_information()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verify that \"Zero - Account Summary\" page title displayed",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinitions.user_verify_that_page_title_displayed(String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: Check yopur code expected:\u003c[Zero - Account Summary]\u003e but was:\u003c[Privacy error]\u003e\n\tat org.junit.Assert.assertEquals(Assert.java:115)\n\tat com.zerobank.stepdefinitions.LoginStepDefinitions.user_verify_that_page_title_displayed(LoginStepDefinitions.java:42)\n\tat ✽.User verify that \"Zero - Account Summary\" page title displayed(file:src/test/resources/features/Login.feature:12)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login with wrong cradentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login_invalid_credentials"
    }
  ]
});
formatter.step({
  "name": "User is on main page",
  "keyword": "Given "
});
formatter.step({
  "name": "User click the \"signing\" button",
  "keyword": "When "
});
formatter.step({
  "name": "User enters wrong \"\u003cusername\u003e\" username and \"\u003cpassword\u003e\" password",
  "keyword": "Then "
});
formatter.step({
  "name": "User verifies that \"Login and/or password are wrong.\" message is displayed",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "wrongUsername",
        "wrongPassword"
      ]
    },
    {
      "cells": [
        "wrongUsername",
        "password"
      ]
    },
    {
      "cells": [
        "username",
        "wrongpassword"
      ]
    },
    {
      "cells": [
        "username",
        ""
      ]
    },
    {
      "cells": [
        "",
        "password"
      ]
    },
    {
      "cells": [
        "",
        ""
      ]
    },
    {
      "cells": [
        "USERNAME",
        "PASSWORD"
      ]
    },
    {
      "cells": [
        "USERNAME",
        "password"
      ]
    },
    {
      "cells": [
        "username",
        "PASSWORD"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login with wrong cradentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login_page"
    },
    {
      "name": "@login_invalid_credentials"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on main page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinitions.user_is_on_main_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click the \"signing\" button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinitions.user_click_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters wrong \"wrongUsername\" username and \"wrongPassword\" password",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinitions.user_enters_wrong_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies that \"Login and/or password are wrong.\" message is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinitions.user_verifies_that_message_is_displayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with wrong cradentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login_page"
    },
    {
      "name": "@login_invalid_credentials"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on main page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinitions.user_is_on_main_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click the \"signing\" button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefinitions.user_click_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters wrong \"wrongUsername\" username and \"password\" password",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinitions.user_enters_wrong_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies that \"Login and/or password are wrong.\" message is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinitions.user_verifies_that_message_is_displayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with wrong cradentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login_page"
    },
    {
      "name": "@login_invalid_credentials"
    }
  ]
});
