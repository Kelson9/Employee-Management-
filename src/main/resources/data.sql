 
CREATE TABLE Employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  Name VARCHAR(250) NOT NULL,
  Email VARCHAR(250) NOT NULL,
);
 
INSERT INTO Employee(Name,Email) VALUES
  ('KCEE', 'Bil@gmail.com'),
  ('KELLO','Bri@gmail.com'),
  ('KENNY', 'Kelo@gmail.com');

SELECT * FROM Employee