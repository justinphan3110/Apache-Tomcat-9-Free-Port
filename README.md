# Apache-Tomcat-9-Free-Port
 ### When using Tomcat 9, user usually forgot to stop the server before shutting down IDE(eg Eclipse) this will create a problem when will try to run it again on other trials
 Free the Apache Tomcat  server port used by other LISTENING PORT (e.g 8080). Saved time instead of resetting the server / IDE / kill the port manually on CMD. 

 #### if you encounter the problems "Several ports (8005, 8080, 8009) required by Tomcat Server at localhost are already in use" in Eclipse when working with JSP, servlet:: 
  
 ```
Several ports (8005, 8080, 8009) required by Tomcat v6.0 Server at localhost are already in use. The server may already be running 

in another process, or a system process may be using the port. To start this server you will need to stop the other process or change the 

port number(s).

```
 
 ![image](https://user-images.githubusercontent.com/44376091/56432439-5494c680-629b-11e9-8cc9-01711f52ac48.png)


 #### or when using the cargo:run maven build with cargo-maven2-plugins

![image](https://user-images.githubusercontent.com/44376091/56432480-86a62880-629b-11e9-9d75-d4761fe67ee2.png)


## :arrow_forward: Demo
### Download the [For Users](https://github.com/justinphan3110/Apache-Tomcat-9-Free-Port/tree/master/Apache%20Tomcat%209%20Free%20Port%20(for%20User)) folder and run the [Tomcat9FreePort.exe](https://github.com/justinphan3110/Apache-Tomcat-9-Free-Port/blob/master/Apache%20Tomcat%209%20Free%20Port%20(for%20User)/Tomecat9FreePort.exe) file  WITH ADMINISTRATOR 

![image](https://user-images.githubusercontent.com/44376091/56432598-f3212780-629b-11e9-8dde-360a785e375c.png) 

![image](https://user-images.githubusercontent.com/44376091/56432643-24015c80-629c-11e9-8090-48ee554c3408.png)


##### Note: always keep the Tomcat9FreePort.exe file and Tomcat9FreePort.jar file in the same folder. 

#### You will be ask to enter the Tomcat server port number that you used to install Tomcat in the first place, the default is 8080. User using cargo-maven2-plugins will have the default as 8080 so click OK.

![image](https://user-images.githubusercontent.com/44376091/56432771-b570ce80-629c-11e9-9be2-3e1d40427ab1.png)

#### The Tomcat9FreePort.exe will scan (through cmd) to find the LISTENING PORT USING the port number that you provided and have you confirmed to Free this LISTENING PORT

![image](https://user-images.githubusercontent.com/44376091/56437482-9d557b00-62ad-11e9-9d2f-651b9980a073.png)

#### After you confirm to kill the LISTENING PORT, there will be a confirmation box 

![image](https://user-images.githubusercontent.com/44376091/56437583-04732f80-62ae-11e9-90d3-71fb5ffda143.png)


###  :large_blue_circle: Source Code 
 ##### The Project Code can be access [here](https://github.com/justinphan3110/Apache-Tomcat-9-Free-Port/tree/master/Aapache%20Tomcat%209%20Free%20Port%20(for%20Developer)/Tomcat9xPortInUse) 
 
 ### Build With
* [JavaFX](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm)
* [JavaFX Dialog](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html)

##  :large_blue_circle: More Resources 
### :page_facing_up: Setting up Tomcat Sever using cargo-maven2-plugin on Eclipse.
#### Insert the following plugin into your <plugins><plugins> in pom.xml file of your Maven Project
 ```
<plugin>
				<groupId>org.codehaus.cargo</groupId>
				<artifactId>cargo-maven2-plugin</artifactId>
				<version>1.6.7</version>
				<configuration>
					<container>
						<containerId>tomcat9x</containerId>
						<type>embedded</type>
					</container>
				</configuration>	
			</plugin>

```
#### Right click on the pom.xml file and RunAs --> Maven Build... --> In the Edit Configuration Windows, type Cargo:Run in the Goals Box 

![image](https://user-images.githubusercontent.com/44376091/56437998-726c2680-62af-11e9-880c-a7e8c35bb8ac.png)

#### Click Run and it will set up the Tomcat Sever 9 with default Port as 8080

![image](https://user-images.githubusercontent.com/44376091/56438158-f45c4f80-62af-11e9-89b1-0ef219db6956.png)

#### You can test the server through http://localhost:8080/project-name/file-name.html

## Author
  [Long Phan](https://github.com/justinphan3110)

