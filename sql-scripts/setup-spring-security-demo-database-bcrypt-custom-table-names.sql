USE `employee_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Estrutura da tabela `members`
--

CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserindo dados na tabela `members`
--
-- NOTA: As senhas são encriptadas usando o BCrypt
--
-- Gerador de Bcrypt: https://www.bcryptcalculator.com/
--
-- A senha padrão é: fun123
--

INSERT INTO `members`
VALUES
('user1','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('user2','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('user3','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);


--
-- Estrutura da tabela `authorities`
--

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserindo dados na tabela `roles`
--

INSERT INTO `roles`
VALUES
('user1','ROLE_EMPLOYEE'),
('user2','ROLE_EMPLOYEE'),
('user2','ROLE_MANAGER'),
('user3','ROLE_EMPLOYEE'),
('user3','ROLE_MANAGER'),
('user3','ROLE_ADMIN');
