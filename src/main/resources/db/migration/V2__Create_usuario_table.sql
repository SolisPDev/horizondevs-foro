
CREATE TABLE usuario (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  correoElectronico VARCHAR(100) UNIQUE NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  id_perfil INT,
  FOREIGN KEY (id_perfil) REFERENCES perfil(id)
);