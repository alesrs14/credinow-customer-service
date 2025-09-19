-- Insert sample customers
-- Note: Passwords will be encrypted by the service layer, this is just for reference
INSERT INTO customers (first_name, last_name, email, password, active) VALUES 
('Juan', 'Pérez', 'juan.perez@example.com', '$2a$10$8GmZp.7O0XKPgTXXj0hJLevC6X3HhgJYVJZRPKGBZPwt7NzLj2XCe', true),
('María', 'García', 'maria.garcia@example.com', '$2a$10$8GmZp.7O0XKPgTXXj0hJLevC6X3HhgJYVJZRPKGBZPwt7NzLj2XCe', true);
-- Default password for both users is 'password123'