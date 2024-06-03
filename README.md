# Appium TheScore Assessment

Overview
This project contains an Appium mobile assessment implemented in Cucumber BDD automation
framework with a Page Object Model design. It includes a simple test case covering the Leagues 
feature of the application. All steps are written in Gherkin language for easy understanding.


Prerequisites
=================================================

Ensure you have the following tools and libraries installed:

Appium 2.5.4
Maven (Build automation tool)
Java 21
Cucumber (BDD)
Gherkin (DSL)
TestNG (Test Management library for parallel testing)
Log4J (Logging framework)
Extent Reports (Reporting framework)
JSON (Test Data)


Devices Used
=========================================
M1: Google Pixel 6 Real Device
M2: Emulated Medium Android Phone (API 34)


  instractions
=========================================
-Trigger the test from the terminal using the command mvn test or mvn clean test. Appium does not need to be loaded separately.
Connect your phones. If you want to use only one phone, please comment out one suite in TestNG.xml.
The "theScore_ Sports News & Scores_24.9.0" APK from APKPure was used. It is attached to the project for convenience.
If you are using a real Android phone, please provide the udid and deviceName in TestNG.xml.
The framework is implemented to work on both Android and iOS apps using the same script.



Bug Report
=========================================
Bug Report

Title: Inconsistent Behavior in Choosing Recommended Team Functionality

Description:
Upon testing the swiping functionality on the Recommended Team tabs, I encountered inconsistent behavior. Specifically, when New, Unregistered user swipes 'left' to choose "NFLFAN" Leage, Teams are not presented  in the recommended list.
Steps to Reproduce:

As a New or Unregistered User open the application.
Click on the "Get Started" button.
Swipe 'up' to select a league.
Click on the "Continue" button.
Swipe 'left' to choose "NFLFAN" from the recommended.

Expected Behavior:
A List of team of "NFLFAN" league presented below.

Actual Behavior:
List of team not presented. Error message -" Looks like your having difficalty loading the app, try tapping this toggle and then refresh the page. Learn More.
Environment:

Device: [Device Name, Google Pixel 6 - real device]
Operating System: [Operating System Version, e.g., Android 14]
Application Version: ["theScore_ Sports News & Scores_24.9.0"]
Device: [Device Name, Medium Phone API 34 - emulated device]
Operating System: [Operating System Version, e.g., Android 14]
Application Version: ["theScore_ Sports News & Scores_24.9.0"]
Additional Information:

Severity - low
Environment - Production
Discovered - 06.03.2024
SDET - Candidate Bogdan T

ps pictures are resources/Bug photos




