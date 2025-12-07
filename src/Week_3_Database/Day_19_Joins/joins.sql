-- 1. Create the Majors table
CREATE TABLE majors (
    major_id INT AUTO_INCREMENT PRIMARY KEY,
    major_name VARCHAR(50) NOT NULL
);

-- 2. Add some data
INSERT INTO majors (major_name) VALUES ('Computer Science');
INSERT INTO majors (major_name) VALUES ('Electrical Engineering');
INSERT INTO majors (major_name) VALUES ('Physics');

SELECT * FROM majors;

-- 1. Add the column
alter table students add column major_id int;

-- 2. Assign majors to existing students (using updates)
update students set major_id = 2 where id = 1;
update students set major_id = 3 where id = 2;
update students set major_id = 1 where id = 3;

-- Verify
select * from students;


SELECT
    students.name,
    students.age,
    majors.major_name
FROM students
JOIN majors ON students.major_id = majors.major_id;

INSERT INTO students (name, age, grade, major_id) VALUES ('spider man', 20, 96.5, 3);

select * from students;

update students set major_id = 99 where id = 5;

select * from students;

SELECT
    students.name,
    students.age,
    majors.major_name
FROM students
JOIN majors ON students.major_id = majors.major_id;
SELECT
    students.name,
    students.age,
    majors.major_name
FROM students
LEFT JOIN majors ON students.major_id = majors.major_id;