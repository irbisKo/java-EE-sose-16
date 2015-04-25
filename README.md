# java-EE-sose-15

Java EE Project for SoSe 2015

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

# Documentation
For further information as well as guidelines for the participation in this project see the [Wiki](https://github.com/ndea/java-EE-sose-15/wiki). More documentation will be added while carrying out the project. The wiki may very likely be the final document handed in when finishing the course. 



