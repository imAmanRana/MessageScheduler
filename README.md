# MessageScheduler
RESTful Web Service that schedules messages to be printed at specific time

### Requirements
* Min. JDK 1.8 version (i used jdk12.0.2)
* MySQL Database
* Gradle ( i used 6.4.1)
* Java IDE (Eclipse, Intellij...)

### Configuring Application

1. Clone the [Repository](https://github.com/imAmanRana/MessageScheduler.git) onto local machine.
2. Import this Repository as a Gradle project into your preferred IDE. (All dependencies would be atomatically added to the project)
3. Before running we need to setup database.
    1. login to your sql host (localhost:3306, in my case)
    2. [Optional]Create a new user  (iqvia)
    3. Note down the password (IqVia@542)
    4. Now login as this new user.
    5. Create a new Database (iqvia_messageScheduler)
    6. Dump the sql file provied at *src/main/resources/database/quartzTables.sql* into this database.
4. Update the **src/main/resources/application.properties file**
    1. *spring.datasource.url*
        - Specify the mysql host url (eg: localhost:3306)
        - Database Name created earlier (eg: iqvia_messageScheduler)
    2. *spring.datasource.username*
        - User to this above database(iqvia_messageScheduler) (eg: iqvia)
    3. *spring.datasource.password*
        - User Password (IqVia@542)
5. All set, run the file **MessageSchedulerApplication.java** as java application


### Testing the application
We can use any REST client to test this application, I used *curl*

```
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/schedulemessage --data '{
"content" : "Demo Message",
"deliveryTime" : "2020-07-19T17:32:16"
}'
```

Json data passed in request should have these 2 fields:
1. **content** - the message to be printed on console
2. **deliveryTime** - the time at which this message to be printed, in *ISO-8601* format ,such as 2007-12-03T10:15:30 

Empty message or past delivery time message is not accepted.
