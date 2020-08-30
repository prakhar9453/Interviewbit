### Interviewbit

### Projects Deliverable
```bash
1. Create Interview such that there should not be clash of any or both of the interviewee or interviewer, taking in account that interviewer can also be interviewee and interviewee can also be an interviewer for some other interview.
2. List all the interview scheduled.
3. Edit the interview taking in account the (1) point.
```

### Deployed link to the project
```bash
https://interviewbit2.herokuapp.com/
```

### How to run the Backend and Frontend Server on Local System
```bash
1. Clone the repo on you local machine.
2. For Frontend(ReactJS)
     i. npm install
     ii. npm run build
     iii. npm start
3. For Backend(Java(SpringBoot))
    i. run and build the project
```

### Backend Database Schema
```bash
1. Person (MailId(Key), Name)
2. Interview (IntervieId(Key),InterviewerMailId(Foreign Key), IntervieweeMailId(foreign Key),StartTime, EndTime)

```
### API
```bash
1. GET https://interviewbit1.herokuapp.com/interview                           //to list the interview details
2. POST https://interviewbit1.herokuapp.com/                                  //to create an interview
3. PUT https://interviewbit1.herokuapp.com/{interviewID}                      //to edit the interview
```

### Database Used
```bash
1. Derby (RDBMS) (Inbuilt in SpringBoot)
```

### How to connect with SQL in your local system
```bash
1. Add this dependency in pom.xml
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
2. Add the following lines in application.properties

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/{database}
spring.datasource.username={username}
spring.datasource.password={Password}
```

### Classes used
```bash
1. Details(InterviewId, InterviewerName, InterviewerMailId, IntervieweeName, IntervieweeMailId,StartTime, EndTime)
2. Person(MailId, Name)
3. Interview(InterviewId, InterviewerMailId, IntervieweeMailId,StartTime, EndTime)
```
