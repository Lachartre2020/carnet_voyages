--
-- Création de la base de données
--
CREATE DATABASE carnetvoyage;

--
-- Création  user
--

CREATE USER 'usercarnetvoyage'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'carnetvoyage';

--
-- Attribution des droits
--

GRANT ALL ON carnetvoyage.* TO  'usercarnetvoyage'@'localhost';

--
-- Remonté des droits
--

FLUSH PRIVILEGES
