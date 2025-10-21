# 🧪 TodoMVC Automation Project (Selenium + TestNG + POM)

## 📋 Description

Ce projet automatise les tests de l’application [TodoMVC Angular](https://todomvc.com/examples/angular/dist/browser/#/all)
à l’aide de **Selenium WebDriver**, **TestNG** et du **Page Object Model (POM)**.

L’objectif est de démontrer une architecture de test moderne, maintenable et extensible, basée sur Maven.

---

## ⚙️ Technologies et versions

| Outil | Version | Rôle |
|-------|----------|------|
| Java | 17+ | Langage principal |
| Maven | 3.9+ | Gestion des dépendances |
| Selenium | 4.34.0 | Automatisation du navigateur |
| TestNG | 7.11.0 | Framework de test |
| POM (Page Object Model) | — | Architecture de séparation des pages |
| Chrome / Firefox / Edge | latest | Navigateurs supportés |

---

## 🗂️ Structure du projet

```
📦 todo-automation
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┗ 📂 java
 ┃ ┃   ┗ 📂 com.todo.utils         # BasePage & Setup (initialisation du WebDriver)
 ┃ ┣ 📂 test
 ┃ ┃ ┗ 📂 java
 ┃ ┃   ┗ 📂 com.todo.tests         # Classes de test (ex: TodoTest)
 ┃ ┗ 📂 com.todo.page              # Classes POM (ex: TodoPage)
 ┣ 📜 pom.xml                      # Configuration Maven
 ┣ 📜 testng.xml                   # Fichier de configuration TestNG
 ┗ 📜 README.md                    # Documentation du projet
```

---

## 🧩 Installation

1. **Cloner le projet :**
   ```bash
   git clone https://github.com/<ton-repo>/todo-automation.git
   cd todo-automation
   ```

2. **Importer dans ton IDE préféré (Eclipse / IntelliJ)**  
   Sélectionne : `Import as Maven Project`

3. **Vérifie les dépendances :**
   ```bash
   mvn clean install
   ```

---

## 🚀 Exécution des tests

### ➤ Depuis Eclipse / IntelliJ
- Clique droit sur `testng.xml` → **Run As → TestNG Suite**

### ➤ Depuis la ligne de commande
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### ➤ Exemple de fichier `testng.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="TodoSuite">
    <parameter name="browser" value="chrome" />
    <test name="TodoTests">
        <classes>
            <class name="com.todo.tests.TodoTest"/>
        </classes>
    </test>
</suite>
```

---

## 🧱 Exemple d’architecture POM

### `BasePage.java`
- Initialise le WebDriver en fonction du navigateur.
- Charge les propriétés depuis `env-config.properties`.

### `Setup.java`
- Configure l’environnement avant chaque test (`@BeforeMethod`).
- Ferme le navigateur après chaque test (`@AfterMethod`).

### `TodoPage.java`
- Contient les localisateurs et les actions (ajouter un todo, vérifier un todo).

### `TodoTest.java`
- Teste l’ajout d’un élément todo et vérifie son affichage.

---

## ✅ Exemple de test exécuté

```java
@Test
public void testAddTodo() {
    todoPage = new TodoPage();
    String newTodo = "Learn Selenium";
    todoPage.addTodo(newTodo);
    Assert.assertTrue(todoPage.isTodoAdded(newTodo), "Todo item was not added!");
}
```

Résultat attendu :
```
[INFO] Test Passed: Todo item was successfully added.
```

---

## 🧠 Bonnes pratiques

- Utiliser **le pattern POM** pour séparer la logique de test et les interactions UI.
- Centraliser les propriétés dans `env-config.properties`.
- Utiliser des **assertions TestNG** (`Assert.assertTrue`, etc.).
- Exécuter les tests sur plusieurs navigateurs via `<parameter name="browser">`.

---

## 🧰 Commandes utiles Maven

| Commande | Description |
|-----------|-------------|
| `mvn clean` | Supprime les fichiers de build précédents |
| `mvn test` | Exécute les tests définis dans `testng.xml` |
| `mvn surefire-report:report` | Génère un rapport TestNG HTML |

---

## 📄 Licence

Ce projet est open-source, librement réutilisable pour l’apprentissage et la pratique du test automatisé avec Selenium + TestNG.

---

👨‍💻 **Auteur :** *Ton Nom*  
📧 **Contact :** *ton.email@example.com*
