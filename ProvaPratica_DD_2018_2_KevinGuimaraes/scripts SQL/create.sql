CREATE SCHEMA caminhosuave ;
use caminhosuave;
CREATE TABLE caminhosuave.ALUNO (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  sobrenome varchar(200) not null,
  matricula VARCHAR(45) NOT NULL,
  nota_P1 DOUBLE NULL,
  nota_P2 DOUBLE NULL,
  peson double null,
  trab1 double null,
  trab2 double null,
  pesot double null,
  nivel varchar(100) null,
  PRIMARY KEY (id),
  UNIQUE INDEX matricula_UNIQUE (matricula ASC)
);