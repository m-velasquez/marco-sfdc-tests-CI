# sfdc-tests

WHAT IS IT?
-----------

sfdc-tests project has as main objective to automate acceptance test cases of SalesForce web page using
Selenium, TestNG and Cucumber technologies, and use other services like docker, BrowserStack and SauceLabs for automated
testing.

Additional technologies:

    -SonarQube.


REQUIREMENTS AND SET CONFIGURATIONS
-----------------------------------

The required configuration for this framework is the following:

    -Java 11+
    -Gradle

Once those requirements are done, follow these steps:

    -Open the Gradle properties file e.g. gradle.properties file

Set the required parameters:

    *username= Is the user account name of SalesForce.
    *password= Is the Password of the user in SalesForce.
    *browser= Is the browser where the test are going to be executed, it could have 4 values: Firefox, Chrome,
    Browserstack or Saucelabs.
        In case to fill with Browserstack or Saucelabs to remote execution, the following variables should
        have a configured value:
        -remoteUserName= Is the username of Saucelabs or Browserstack.
        -remoteKey= Is the key provided by your account on Saucelabs or Browserstack.
        -remoteBrowser= Is the browser that you want to execute your test remotely. (e.g. Chrome)
        -remoteBrowserVersion= Is the version of the browser wrote before ^. (e.g. 54.0)
        -remotePlatform= Is the OS where you want to execute your test. (e.g. Windows)
        -remotePlatformVersion= Is the OS version. (e.g. 8.1)
        -remoteResolution= Is the resolution of the screen. (e.g. 1920x1080)
After executing those steps the frame should be executed.

To execute by command line you can use the following:

        ```javascript

        gradle clean check
        -Pusername= SalesForce username -Ppassword= SalesForce password
        -PremoteUserName= remoteUserName  -PremoteKey= remoteKey
        -Pbrowser= remoteBrowser(COULD BE REMOTE AS BROWSERSTACK OR SAUCELABS)
        -PremoteBrowser=remoteBrowser -PremoteBrowserVersion=remoteBrowserVersion - PdockerUrl= dockerUrl
        -PremotePlatformVersion=remotePlatformVersion -PremotePlatform=remotePlatform -PremoteResolution=remoteResolution

        ```
