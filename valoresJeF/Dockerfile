# Usa Maven com Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto
COPY jogoVivi/pom.xml .
COPY jogoVivi/src ./src

# Compila o projeto
RUN mvn clean package -DskipTests

# Cria a imagem final com apenas o JAR
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
