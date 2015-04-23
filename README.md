# java-EE-sose-15

Java EE Project for SoSe 2015

# Database
Set up steps for your Database:
 1. Create a schema: 'votes' 
 2. Set your config settings in hibernate.cfg.xml
 3. Set your config settings in the pom.xml in the flywaydb plugin
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
after that you get a votes.war.
Deploy this votes.war to your application server.
