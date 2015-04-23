# java-EE-sose-15

Java EE Project for SoSe 2015

# Database
Set up steps for your Database:
 1. Create a schema: 'votes' 
 2. Set your config settings in 'src/main/resources/hibernate.cfg.xml'. (See snippet below
```xml
 <property name="hibernate.connection.username">root</property>
 <property name="hibernate.connection.password"></property>
 <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/votes</property>
```
 3. Set your config settings in the pom.xml in the flywaydb plugin. (See snippet below)
```xml
 <plugin>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-maven-plugin</artifactId>
    <version>3.2.1</version>
    <configuration>
         <url>jdbc:mysql://localhost:3306/votes</url>
         <user>root</user>
         <password>mySecretPwd</password>
     </configuration>
 </plugin>
```
Omit the password tag if your database has no password set.
 4. Migrate database with
```bash 
    mvn compile flyway:migrate
```

Migrations are going to

```bash
main/resources/db/migration

use the following naming convention:

Vx__ACTION.sql  #x is incrementing

```

# Build

```bash
 mvn clean install
```
After that you get a votes.war, located in target/votes.war
Deploy votes.war to your application server.

# Install & Deployment

Use the provided script app_deploy

```bash
 ./app_deploy setup
 ./app_deploy create-domain votes
 ./app_deploy start votes
 ./app_deploy deploy target/votes.war
```

to redeploy use 
```bash
 ./app_deploy deploy target/votes.war
```

to stop the domain 

```bash
 ./app_deploy stop votes
```

