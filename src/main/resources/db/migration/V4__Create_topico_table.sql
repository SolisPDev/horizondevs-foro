
CREATE TABLE topico (
  id INT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(255) NOT NULL,
  mensaje TEXT,
  fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
  status ENUM('activo', 'inactivo'),
  autor INT,
  id_curso INT,
  FOREIGN KEY (autor) REFERENCES usuario(id),
  FOREIGN KEY (id_curso) REFERENCES curso(id)
);