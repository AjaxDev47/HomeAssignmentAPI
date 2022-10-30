HomeAssignment

SERVER SIDE (OTP API)

This api service is build on : JAVA SPRING BOOT
IDE USED : VS Code

SETUP INSTRUCTION:


1. IN VsCode you need to install two extension
2. First is : Spring Initializr Java Support (Microsoft)
3. Second is : Extension Pack for java (Microsoft)
4.Then you need to create a project 
5. For creating you need to open command pallete for opening hold (Ctrl+Shift+P)
6. Here you can type maven and it will Show you (Spring Initializr :Create a Maven Project)
7. Then you have to select boot version (Select 2.7.5)
8. Then Language JAVA, KOTLIN or Groovy (Select JAVA) 
9. Then it will ask for Group ID (com.OTPApi)
10. Then Artifact ID (Enter name of the project)
11. Specify packaging type (JAR)
12. Select JAVA Version (Select JAVA 11)
13. Select Dependencies : Spring Web web dependency
14. Then it will ask you where you want generate this project, generate it


DEPENDENCIES :

1. I used Spring Web Web dependencies for rest API creation and calling.


HOW TO USE :

1. You need to run OTPapiApplication.java 




HOW TO USE ENTIRE PROJECT PROPERLY ::

1. You will run main application file of Spring boot (In this case : You need to run OTPapiApplication.java )
2. You will run the Android app and then from there you will send the request by tapping request otp 
3. then Spring boot terminal will provide you OTP
4. If you will enter the OTP within 30 seconds it will expire and no longer can be used, for this I had also given a 30 second timer in the app
5. If you enter correct otp it will Open the login Activity.
