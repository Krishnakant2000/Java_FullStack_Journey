-- 1. Create the Database (The Warehouse)
CREATE DATABASE fullstack_db;

-- 2. Select the Database to use
USE fullstack_db;

-- 3. Create the Table (The Excel Sheet)
-- We define columns and their types:
-- INT = Number, VARCHAR(50) = String up to 50 chars
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Automatically numbers rows 1, 2, 3...
    name VARCHAR(50) NOT NULL,         -- Cannot be empty
    age INT,
    grade DOUBLE
);

-- 4. INSERT Data (Create)
INSERT INTO students (name, age, grade) VALUES ('Iron Man', 40, 95.5);
INSERT INTO students (name, age, grade) VALUES ('Captain America', 100, 88.0);
INSERT INTO students (name, age, grade) VALUES ('Thor', 1500, 92.0);
-- DELETE FROM students WHERE id = 4; -- Removes the duplicate row


update students set age=101 where id=2;

-- 5. SELECT Data (Read)
-- The * means "All Columns"
SELECT * FROM students;