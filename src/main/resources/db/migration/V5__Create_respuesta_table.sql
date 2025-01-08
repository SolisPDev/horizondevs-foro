
CREATE TABLE respuesta (
  id INT PRIMARY KEY AUTO_INCREMENT,
  mensaje TEXT,
  id_topico INT,
  id_usuario INT,
  fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
  solucion BOOLEAN,
  FOREIGN KEY (id_topico) REFERENCES topico(id),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);