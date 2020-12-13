
mvn -Pjooq generate-sources

mvn -Pflyway initialize -Dflyway.defaultSchema=test_jooq -Dflyway.user=postgres -Dflyway.password=postgres

java -Dmicro-config-path=/xx/aaa

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

jersey -- 6.5 Mb






