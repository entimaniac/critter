CREATE TABLE `critter`.`GroupTwitterCredentials` (
  `group_id` VARCHAR(36) NOT NULL,
  `token` VARCHAR(64) NOT NULL,
  `token_secret` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`group_id`));
