# java-EE-sose-15

Java EE Project for SoSe 2015

# Database
Migrate database with
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
