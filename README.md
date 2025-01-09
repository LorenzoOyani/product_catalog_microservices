
### Endpoints
1. **GET /products** - Fetch all products (with pagination).
    - **Query Parameters**:
        - `page` (integer, optional): Page index, starting from 0 (default: 0).
        - `size` (integer, optional): Items per page (default: 10).
    - **Response**:
      ```json
      {
        "content": [
          {
            "code": "P001",
            "name": "Wireless Speaker",
            "description": "Portable Bluetooth speaker with great sound.",
            "price": 100.00,
            "imageUrl": "https://example.com/speaker.jpg"
          }
        ],
        "pageNumber": 0,
        "totalPages": 1,
        "totalElements": 10,
        "isFirst": true,
        "isLast": true,
        "hasNext": false,
        "hasPrevious": false
      }
      ```

2. **GET /products/{code}** - Fetch a product's details by unique `code`.
    - **Path Variable**: 
      - `code` (string): The unique identifier for the product.
    - **Response**:
      ```json
      {
        "code": "P001",
        "name": "Wireless Speaker",
        "description": "Portable Bluetooth speaker with great sound.",
        "price": 100.00,
        "imageUrl": "https://example.com/speaker.jpg"
      }
      ```

---

## Future Roadmap 🌟

This initial implementation is the starting point of a larger e-commerce project. Upcoming features that will be added include:

### Planned Enhancements
- **Product Management Features**:
  - Add, Update, and Delete (CRUD) operations for catalog items.
- **Search and Filter**:
  - Implement search functionality by name, description, or price range.
  - Add filtering options (e.g., category, brand, etc.).
- **Product Categorization**:
  - Add categories and subcategories for better product organization.
- **Sorting Options**:
  - Enable sorting (e.g., by price, name, etc.) on paginated responses.
- **Authentication and Security**:
  - Integrate user authentication for restricted operations.
- **Event-Driven Features**:
  - Add event publishing for product updates using technologies like Kafka or RabbitMQ.
- **Data Validation and Error Handling**:
  - Advanced input validation and detailed error messaging.
- **Switch Database**:
  - Current setup uses H2 (in-memory database) for development. Extend support for MySQL or PostgreSQL for production.

---

## Technologies and Architecture 🛠️

- **Backend Framework**: Spring Boot 3.4.1
- **Database**: postgreSQL
- **Persistence**: Spring Data JPA for seamless data access.
- **Java Version**: OpenJDK 21
- **API Standards**: RESTful services.

---

## How to Run 🏃‍♂️

### Prerequisites:
1. **Java 21** or above installed.
2. **Maven** for dependency management and building the application.
3. **Docker** (optional) for database setup, if extending with real DB storage.

### Steps to Run Locally:
1. Clone the repository:
   ```bash
   git clone https://github.com/LorenzoOyani/catalog-service.git
   cd catalog-service
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

3. Open the application in your browser or API tool (e.g., Postman) at:
   ```
   http://localhost:8080/api/catalog
   ```

---

## Configuration 🔧

The service uses a default in-memory database (H2). Configuration can be modified in `src/main/resources/application.properties`:

### Default Configuration
```properties
# Server Port
server.port=8080

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:catalog
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

# JPA Settings
spring.jpa.show-sql=true
```

To change the database, update the `spring.datasource.url` property to reflect your desired database system (e.g., MySQL or PostgreSQL).

---

## Testing ✅

### Unit Testing
Execute unit tests with the following command:
```bash
mvn test
```

Extend the test suite as new features are added (e.g., controller tests, service tests, etc.).

### Manual Testing
Use tools like **Postman** or **curl** to test the endpoints and validate responses.

---

## Contributing 🤝

Contributions are welcome! Here’s how you can contribute:
1. Fork the repository.
2. Commit your changes to a branch.
3. Raise a pull request describing your contribution.

Future contributors are encouraged to help implement planned features from the roadmap above.

---

## Licensing 📜

This project is open-source and available under the [MIT License](LICENSE). Feel free to use it for your own projects.

---

## Contact 📬

For questions, feature requests, or feedback, contact:

- **Developer**: Lawrence Jerumeh 
- **Email**: [Jerumehlawrence@gmail.com](mailto:jerumehlawrence@gmail.com)  
- **GitHub**: [your-username](https://github.com/LorenzoOyani)

Feel free to reach out for collaboration opportunities!

---

**This is just the first step — there’s much more to come! Follow the roadmap to see what’s next in the evolution of the Catalog Service.**
