

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

dagger -- 40 Kb

guice -- 2 Mb (rejected: too big VS dagger)
hk2 -- 2 Mb (rejected: too big VS dagger)

owner -- 100 Kb
slf4j+logback -- 800 Kb

log4j -- 2 Mb  (rejected: too big VS slf4j+logback)

HikariCP -- 200 Kb
PostgreSQL JDBC -- 1 Mb
flyway -- 700 Kb

jooq -- 3.5 Mb

jetty -- 2.1 Mb

jersey-server -- 3 Mb
    jersey-hk2 -- 1.5 Mb
    jersey-container-servlet-core -- +75 Kb
    jersey-media-json-jackson -- 2 Mb
    jersey-mvc -- 150 Kb


thymeleaf - 1.5 Mb





