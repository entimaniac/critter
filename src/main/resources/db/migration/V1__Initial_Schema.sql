CREATE  TABLE `User` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(65) NOT NULL ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));

CREATE TABLE `Creet` (
  `id` VARCHAR(36) NOT NULL,
  `message` varchar(120) NOT NULL,
  `user_id` VARCHAR(36) NOT NULL,
  `group_id` VARCHAR(36) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sent_to_twitter` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Groupe` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `twitter_handle` VARCHAR(45) NULL,
  `description` VARCHAR(500) NULL,
  `threshold` INT,
  `owner` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `UserGroupe` (
  `user_id` VARCHAR(36) NOT NULL,
  `group_id` VARCHAR(36) NOT NULL,
  UNIQUE INDEX `index_UNIQUE` (`user_id`, `group_id` ASC));

CREATE TABLE `Upvote` (
  `creet_id` VARCHAR(36) NOT NULL,
  `user_id` VARCHAR(36) NOT NULL,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE INDEX `index_UNIQUE` (`user_id`, `creet_id` ASC));

CREATE TABLE `Downvote` (
  `creet_id` VARCHAR(36) NOT NULL,
  `user_id` VARCHAR(36) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE INDEX `index_UNIQUE` (`user_id`, `creet_id` ASC));

