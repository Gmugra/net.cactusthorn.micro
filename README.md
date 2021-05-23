

Prove of concept, which shows how to construct you own, feature reach, java based web-framework from public available libraries.

Idea is to check, is it really possible to get a set of tools, sufficient for modern web application, which normally we got from big frameworks (e.g. Spring) with **very small effort**.

Potential benefits of this approach:
* To get exactly tools which you want
* To have in application only JARs which you need
* To have much more control without any "magic"
* To minimize size of final application artifact

============================

mvn -Pjooq generate-sources

mvn -Pflyway initialize -Dflyway.defaultSchema=test_jooq -Dflyway.user=postgres -Dflyway.password=postgres

e.g.
java -Dpass=megapass -Dmicro-config-path=/xx/aaa -jar db-0.2.jar

java -Dpass=megapass -jar db-0.2.jar

---------------

one-jar -- 70Kb (rejected: problems)

Dependency injection:
* [Dagger 2](https://dagger.dev/) -- 40 Kb
* [Guice](https://github.com/google/guice) -- 2 Mb (rejected: too big VS Dagger)
* [HK2](https://javaee.github.io/hk2/) -- 2 Mb (rejected: too big VS Dagger)

Configuration management
* [OWNER](https://github.com/lviggiano/owner) -- 100 Kb
* [Config](https://github.com/Gmugra/net.cactusthorn.config) -- 70 Kb + TOML support (+500 Kb)

Logging
* [Slf4j](http://www.slf4j.org/) + [Logback](http://logback.qos.ch/) -- 800 Kb
* [Log4j](https://logging.apache.org/log4j/2.x/manual/api.html) -- 2 Mb  (rejected: too big VS Slf4j + Logback)

Database migrations
* [Flyway](https://flywaydb.org/) -- 700 Kb 
* [Liquibase](https://www.liquibase.org/) -- 3.3 Mb (rejected: too big VS flyway)

Database
* [HikariCP](https://github.com/brettwooldridge/HikariCP) -- 200 Kb
* PostgreSQL JDBC -- 1 Mb
* [jOOQ](https://www.jooq.org/) -- 3.5 Mb
* [Jdbi](http://jdbi.org/) -- 2 Mb 	:bangbang:

Embed Servlet container
* [Jetty](https://www.eclipse.org/jetty/) -- 2.1 Mb
* [Tomcat](https://tomcat.apache.org/) -- 3.3 Mb
* [Undertow](https://undertow.io/) -- 4 Mb

JAX-RS
* [Jersey](https://eclipse-ee4j.github.io/jersey/)
  * jersey-server -- 3 Mb
  * jersey-hk2 -- 1.5 Mb
  * jersey-container-servlet-core -- +75 Kb
  * jersey-media-json-jackson -- 2 Mb
  * jersey-mvc -- 150 Kb

Template Engine
* [Thymeleaf](https://www.thymeleaf.org/) - 1.5 Mb
