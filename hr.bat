call mvn -B -s settings.xml -DskipTests=true clean package
call java -DDATABASE_URL="postgres://user:password@localhost:5432/flug_project" -jar target/dependency/webapp-runner.jar target/*.war
