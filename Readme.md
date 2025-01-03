# Spring AI - Medium Blog Repository

Welcome to the GitHub repository for the "Spring AI" Medium blog. This repository contains all the source code, configurations, and instructions for the examples and implementations described in the blog.

---

## **Overview**
This project showcases how to leverage Artificial Intelligence capabilities in Spring-based applications. It includes integrations with:

- **Ollama**: A modern AI model runner.
- **Groq**: A platform for high-performance AI workloads.

In the blog, we cover:
1. Setting up your environment.
2. Implementing AI-driven features using Spring.
3. Enhancing functionality with external AI tools like Ollama and Groq.

---

## **Installation Guide**

### **Prerequisites**

Before proceeding, ensure you have the following installed:
- **Java 21 or higher**
- **Gradle**
- **Git**
- A compatible IDE (e.g., IntelliJ IDEA, Eclipse)

---

### **Setting up the Project**

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd <repository-name>
   ```

2. **Build the Project:**
   ```bash
   ./gradlew clean build
   ```

3. **Run the Application:**
   ```bash
   ./gradlew bootRun
   ```

The application should now be running on [http://localhost:8080](http://localhost:8080).

---

## **Integrating with Ollama**

Ollama is a powerful AI model runner that enables seamless integration of advanced AI models into your application.

### **Installation**

1. Visit the [Ollama website](https://ollama.ai/) to download the latest version.
2. Follow the installation instructions for your operating system:
    - **macOS:**
      ```bash
      brew install ollama
      ```
    - **Windows:**
      Download and run the installer from the official website.
    - **Linux:**
      ```bash
      curl -fsSL https://ollama.ai/install.sh | bash
      ```

3. Verify the installation:
   ```bash
   ollama --version
   ```

### **Using Ollama in Your Application**

Refer to the configuration in `src/main/resources/application.yml` to set up Ollama API keys and endpoints. Make sure to test the connection using the built-in diagnostics command:

```bash
ollama test
```

---

## **Signing up for Groq**

Groq is a platform designed for high-performance AI workloads, enabling efficient execution of machine learning models.

### **Signup Process**

1. Visit the [Groq Signup Page](https://groq.com/signup).
2. Provide the required details and create an account.
3. Verify your email address and log in to the Groq dashboard.

### **API Key Configuration**

1. In the Groq dashboard, navigate to **API Keys**.
2. Generate a new API key and note it down.
3. Add the API key to your application configuration in `application.yml`:

---

## **Key Features**
- Dynamic keyword detection and response handling.
- Modular design to easily integrate AI capabilities into any Spring-based application.

---

## **Contributing**
We welcome contributions! To contribute:
1. Fork the repository.
2. Create a new branch for your feature/bug fix.
3. Submit a pull request with a detailed description of your changes.

---

## **License**
This project is licensed under the MIT License. See the `LICENSE` file for more details.

---

## **Contact**
For questions or feedback, reach out via the GitHub Issues page or contact us directly at [support@springai.com](mailto:support@springai.com).

Happy coding!
