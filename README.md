# configure spring-boot with sonar
1 - download sonarqube  : https://www.sonarqube.org/downloads/  
  - download sonar-scanner
2 - extract file then go to sonarqube-9.7.0.61563\bin\windows-x86-64\  
3 - open  startSonar.bat  
4 - open localhost:9000 
	login : admin ; password : admin   
5 - add this plugins to the spring project  

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			
			<plugin>
				<groupId>org.sonarsource.scanner.maven</groupId>
				<artifactId>sonar-maven-plugin</artifactId>
				<version>3.8.0.2131</version>
			</plugin>
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.5</version>
				<executions>
					<execution>
						<id>prepare-agent</id>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
6 - mvn update   
7 - run as mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install   
8 - create sonar token : go to account/security/  
9 - create sonar-project.proprties   
	sonar.projectKey=sonarqube-test:admin  
	sonar.host.url=http://127.0.0.1:9000/  
	sonar.java.binaries=./target  
	sonar.sourceEncoding=UTF-8  
	sonar.login = admin  
	sonar.password = 123456  
10 - run  sonar-scanner -D.login=squ_6ff8b77aecd693bbcf71fb0c70ae2ded561bf195  

