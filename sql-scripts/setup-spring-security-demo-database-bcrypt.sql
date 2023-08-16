USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserindo dados na tabela `users`
--
-- NOTA: as senhas estão encriptadas usando bcrypt
--
-- geração de bcrypt: https://www.bcryptcalculator.com/
--
-- Senha padrão: fun123
--

INSERT INTO `users` 
VALUES 
('user1','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('user2','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('user3','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);


--
-- Estrutura da tabela `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserindo dados na tabela `authorities`
--

INSERT INTO `authorities` 
VALUES 
('user1','ROLE_EMPLOYEE'),
('user2','ROLE_EMPLOYEE'),
('user2','ROLE_MANAGER'),
('user3','ROLE_EMPLOYEE'),
('user3','ROLE_MANAGER'),
('user3','ROLE_ADMIN');