# Hamza Raji

## Architecture Microservices - Gestion de Tâches Collaboratives

Projet développé avec Spring Boot et architecture microservices utilisant Spring Cloud, Eureka et API Gateway.

### 🏗️ Services Implémentés

- **User Service** (port 8082) : Gestion des utilisateurs
- **Task Service** (port 8083) : Gestion des tâches
- **API Gateway** (port 8888) : Routage dynamique
- **Eureka Server** (port 8761) : Service Discovery

### ✅ Étapes Réalisées

#### 1. Réalisation du UserService (3 points)
- API REST : GET/DELETE `/api/users/{id}`, GET/POST `/api/users`
- Entité `Users` avec id, firstName, lastName, email
- Repository JPA et Service

#### 2. Réalisation du TaskService (4 points)
- API REST : GET/DELETE `/api/tasks/{id}`, GET/POST `/api/tasks`
- Entité `Task` avec id, titre, description, statut (OUVERTE, EN_COURS, TERMINEE)
- Assignment multiple d'utilisateurs par tâche

#### 3. Bonnes Pratiques - UserService (3 points)
- Mappers (`UsersMapper`)
- DTOs : `UsersDTO` et `UsersResponseDTO` ✅ (Bonus +2)
- Couche Service avec abstraction

#### 4. Bonnes Pratiques - TaskService (Bonus +2)
- Mappers et DTOs
- Couche Service abstraite
- Entité `UserProxy` pour l'intégration

#### 5. Intégration Feign (3 points)
- `UsersClient` : Communication TaskService → UserService
- Circuit Breaker avec fallback method dans l'interface

#### 6. Service de Discovery - Eureka (2 points)
- Configuration Eureka Server
- Enregistrement des services avec `@EnableDiscoveryClient`

#### 7. API Gateway Dynamique (2 points)
- Spring Cloud Gateway sur le port 8888
- Routage dynamique basé sur Eureka
- Routes configurées pour User et Task Services

#### 8. Résilience avec Resilience4J (3 points)
- Circuit Breaker sur `UsersClient.getUsersByIds()`
- Fallback method retournant une liste vide en cas de défaillance
- Configuration adaptée aux microservices

### 🚀 Technologies Utilisées

- Java 17+
- Spring Boot 3.x
- Spring Cloud (Gateway, Eureka, OpenFeign)
- Resilience4j
- JPA/Hibernate
- Maven
- Lombok

### 📝 Points Clés

- Pattern DTO pour le transfert de données
- Mappers pour conversion entité ↔ DTO
- Feign pour communication inter-services
- Circuit Breaker pour résilience
- Service Discovery dynamique
- API Gateway centralisée
