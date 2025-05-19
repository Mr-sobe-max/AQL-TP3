# TP3 : Tests d'Intégration avec JUnit 5 et Mockito - Partie 1

Ce projet implémente le TP3 sur les tests d'intégration en Java avec JUnit 5 et Mockito, en explorant les interactions entre modules, bases de données et API.

## Objectifs
- Comprendre les concepts des tests d'intégration en Java.
- Pratiquer l'écriture de tests d'intégration avec JUnit 5.
- Implémenter des mocks pour isoler les dépendances pendant les tests.

## Structure du Projet
- **src/main/java/org.example.com/EXO01/** :
  - `User.java`, `UserRepository.java`, `UserService.java`
- **src/main/java/org.example.com/EXO02/** :
  - `Order.java`, `OrderDao.java`, `OrderService.java`, `OrderController.java`
- **src/main/java/org.example.com/EXO03/** :
  - `Product.java`, `ApiException.java`, `ProductApiClient.java`, `ProductService.java`
- **src/test/java/EXO01/** :
  - `UserServiceTest.java`
- **src/test/java/EXO02/** :
  - `OrderControllerTest.java`
- **src/test/java/EXO03/** :
  - `ProductServiceTest.java`
- **pom.xml** : Configuration Maven.
- **README.md** : Ce fichier.

## Exercices
- **Exercice 1 : Interaction Simple entre Modules** 
  - Scénario : Une classe UserService récupère les données d’un utilisateur via UserRepository.
  - Classes :
    - UserService : Contient getUserById(long id).
    - UserRepository : Interface avec findUserById(long id).
    - User : Modèle de données.
  - Tests : Test d’interaction, utilise un mock pour UserRepository.
  - Fichier : EXO01/UserServiceTest.java
  - Réponses aux Tâches :
    - La classe UserService est implémentée avec la méthode getUserById, qui appelle UserRepository.findUserById.
    - L’interface UserRepository définit findUserById(long id), retournant un objet User.
    - Le test testGetUserById dans UserServiceTest.java utilise un mock de UserRepository, configuré pour retourner un utilisateur spécifique. Il appelle getUserById et vérifie le résultat.
    - Le test utilise verify(userRepository).findUserById(1L) pour confirmer que findUserById est appelé avec l’argument 1L.

- **Exercice 2 : Interaction avec une Base de Données avec des Mocks**
  - Scénario : Une classe OrderController crée une commande via OrderService, qui enregistre les données avec OrderDao.
  - Classes :
    - OrderController : Contient createOrder(Order order).
    - OrderService : Contient createOrder(Order order).
    - OrderDao : Interface avec saveOrder(Order order).
    - Order : Modèle de données.
  - Tests : Test d’interaction, utilise des mocks pour OrderService et OrderDao.
  - Fichier : EXO02/OrderControllerTest.java
  - Réponses aux Tâches :
    - La classe OrderController est implémentée avec createOrder, qui appelle OrderService.createOrder.
    - La classe OrderService implémente createOrder, qui appelle OrderDao.saveOrder.
    - L’interface OrderDao définit saveOrder(Order order) pour simuler l’accès à la base de données.
    - Le test testCreateOrder dans OrderControllerTest.java utilise des mocks pour OrderService et OrderDao. Il appelle createOrder sur OrderController et vérifie les interactions.
    - Le test utilise verify(orderService).createOrder(order) et verify(orderDao).saveOrder(order) pour confirmer que les méthodes sont appelées avec le bon objet Order.



- **Exercice 3 : Intégration d'API avec Mocking**
  - Scénario : Une classe ProductService récupère des données produit via ProductApiClient.
  - Classes :
    - ProductService : Contient getProduct(String productId).
    - ProductApiClient : Interface avec getProduct(String productId).
    - Product : Modèle de données.
    - ApiException : Exception pour les erreurs d’API.
  - Tests : Test d’interaction, utilise un mock pour ProductApiClient.
  - Fichier : EXO03/ProductServiceTest.java
  - Réponses aux Tâches :
    - La classe ProductService est implémentée avec getProduct, qui appelle ProductApiClient.getProduct.
    - L’interface ProductApiClient définit getProduct(String productId), simulant un appel d’API.
    - Le test ProductServiceTest.java contient trois scénarios :
    - testGetProductSuccess : Mock retourne un produit valide, vérifie le résultat.
    - testGetProductInvalidFormat : Mock lève une ApiException pour un format invalide, vérifie l’exception.
    - testGetProductApiFailure : Mock lève une ApiException pour une erreur d’API, vérifie l’exception.
    - Chaque test utilise verify(productApiClient).getProduct("123") pour confirmer que getProduct est appelé avec l’argument "123". Les scénarios testent la réussite, le format incompatible, et l’échec d’API.



## Auteurs:
[BOUKHIBAR Mounir]

