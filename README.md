# Multi-Tenant Application with Spring Boot

This project is a simple multi-tenant application built using Spring Boot. It demonstrates how to configure and manage multiple tenants with isolated data sources and how to handle user data within each tenant.

## Features

- **Multi-Tenant Support**: The application supports multiple tenants with isolated data sources.
- **Tenant-Aware User Management**: Users are managed within the context of a tenant, ensuring data isolation.
- **Dynamic DataSource Routing**: The application dynamically routes database queries to the appropriate data source based on the current tenant context.

## Project Structure

- **`TenantContext`**: Manages the current tenant information in a thread-local variable.
- **`TenantAwareDataSource`**: Custom `DataSource` implementation that routes database queries to the appropriate data source based on the current tenant.
- **`DataSourceConfig`**: Configures the default and tenant-specific data sources.
- **`User`**: The `User` entity representing users in the system, with tenant-specific data.
- **`UserRepository`**: Repository interface for `User` entity.
- **`UserService`**: Service layer for handling user-related operations.
- **`UserController`**: REST controller for managing users.

## Setup and Configuration

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL Database

### Database Configuration

Ensure you have a MySQL database running. You can use a single database or multiple databases for different tenants.

Update the `application.properties` file with your MySQL connection details:

## Running the Application

### Clone the repository:

```bash
git clone https://github.com/yourusername/multi-tenant-app.git
cd multi-tenant-app
```

## Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

## Access the Application

The application will be available at [http://localhost:9090](http://localhost:9090).

## API Endpoints

### User Endpoints

- **GET /users**: Retrieve a list of all users for the current tenant.
- **POST /users**: Create a new user in the current tenant.

### Tenant Endpoints

- **POST /tenants/{tenantId}/users**: Add a user to a specific tenant.
- **GET /tenants/{tenantId}/users**: Retrieve all users for a specific tenant.

## Contributing

Feel free to submit issues, fork the repository, and send pull requests!
