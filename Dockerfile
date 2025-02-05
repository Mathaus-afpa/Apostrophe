# Étape 1 : Build de l'application avec Maven et Java 21
FROM eclipse-temurin:21-jdk as builder
WORKDIR /app

# Installer Maven et MySQL client
RUN apt-get update && apt-get install -y maven mysql-client

# Copier les projets et builder
COPY Java /app/Java
COPY JavaEE /app/JavaEE
COPY Conception /app/Conception

RUN mvn clean install -f Java/pom.xml
RUN mvn clean package -f JavaEE/pom.xml

# Étape 2 : Image finale avec Tomcat et MySQL
FROM tomcat:10.1-jdk21

# Installer MySQL Server
RUN apt-get update && apt-get install -y mysql-server

# Configurer MySQL
COPY Conception/creationBase.sql /docker-entrypoint-initdb.d/
COPY Conception/donnees.sql /docker-entrypoint-initdb.d/

# Démarrer MySQL et charger les données
RUN service mysql start && \
    mysql -e "CREATE DATABASE ApostropheIvre;" && \
    mysql ApostropheIvre < /docker-entrypoint-initdb.d/creationBase.sql && \
    mysql ApostropheIvre < /docker-entrypoint-initdb.d/donnees.sql

# Supprimer les applications Tomcat par défaut
RUN rm -rf /usr/local/tomcat/webapps/*

# Copier l’application JavaEE
COPY --from=builder /app/JavaEE/target/*.war /usr/local/tomcat/webapps/ROOT.war

RUN mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/classes

RUN echo "jdbc.url=jdbc:mysql://mysql:3306/ApostropheIvre" > /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/db.properties && \
    echo "jdbc.login=abd" >> /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/db.properties && \
    echo "jdbc.password=root" >> /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/db.properties


# Exposer les ports
EXPOSE 8080 3306

# Démarrer MySQL et Tomcat
CMD service mysql start && catalina.sh run