# Usa Maven com Java 23
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto
COPY valoresJeF/pom.xml .
COPY valoresJeF/src ./src

# Compila o projeto
RUN mvn clean package -DskipTests

# Cria a imagem final com apenas o JAR
FROM eclipse-temurin:23-jdk

WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
