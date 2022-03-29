CREATE TABLE `user` (
    `id` VARCHAR(36) unique NOT NULL,
    `first_last_name` VARCHAR(45) NOT NULL,
    `nickname` VARCHAR(45) unique NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
    )
    ENGINE = InnoDB;



CREATE TABLE `project` (
    `id` VARCHAR(36) unique NOT NULL,
    `name` VARCHAR(45) unique NOT NULL,
    `description` VARCHAR(256) NOT NULL,
    `closing_date` DATETIME NOT NULL,
    `visibility` TINYINT(1) NOT NULL DEFAULT 0,
    `id_project_admin` VARCHAR(36) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `id_project_admin` FOREIGN KEY (`id_project_admin`) REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;



CREATE TABLE `user2project` (
    `id` VARCHAR(36) unique NOT NULL,
    `id_project` VARCHAR(36) NOT NULL,
    `id_user` VARCHAR(36) NOT NULL,
    `status` TINYINT(1) NOT NULL DEFAULT 1,
    `start_date` DATETIME NOT NULL,
    `end_date` DATETIME NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `id_project` FOREIGN KEY (`id_project`) REFERENCES `project` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


CREATE TABLE `team` (
    `id` VARCHAR(36) unique NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `id_team_lead` VARCHAR(36) NOT NULL,
    `id_project` VARCHAR(36) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `id_team_lead` FOREIGN KEY (`id_team_lead`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `id_project` FOREIGN KEY (`id_project`)  REFERENCES `project` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


CREATE TABLE `user2team` (
    `id` VARCHAR(36) unique NOT NULL,
    `id_user` VARCHAR(36) NOT NULL,
    `id_team` VARCHAR(36) NOT NULL,
    `status` TINYINT(1) NOT NULL DEFAULT 1,
    `start_date` DATETIME NOT NULL,
    `end_date` VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `id_user` FOREIGN KEY (`id_user`)
    REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `id_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;



CREATE TABLE `task2user` (
    `id` VARCHAR(36) unique NOT NULL,
    `id_user` VARCHAR(36) NOT NULL,
    `id_task` VARCHAR(36) NOT NULL,
    `assign_date` DATETIME NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `id_task` FOREIGN KEY (`id_task`) REFERENCES `task` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;



CREATE TABLE `task` (
    `id` VARCHAR(36) unique NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NOT NULL,
    `closing_date` DATETIME NOT NULL,
    `status` TINYINT(1) NOT NULL DEFAULT 0,
    `id_project` VARCHAR(36) NOT NULL,
    `id_task2user` VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `id_project` FOREIGN KEY (`id_project`) REFERENCES `project` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `id_task2user` FOREIGN KEY (`id_task2user`) REFERENCES `task2user` (`id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL )
    ENGINE = InnoDB;


CREATE TABLE `comment` (
    `id` VARCHAR(36) unique NOT NULL,
    `content` VARCHAR(45) NOT NULL,
    `date_time` DATETIME NOT NULL,
    `id_user` VARCHAR(36) NOT NULL,
    `id_task` VARCHAR(36) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `id_task` FOREIGN KEY (`id_task`) REFERENCES `task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


CREATE TABLE `task2team` (
    `id` VARCHAR(36) unique NOT NULL,
    `id_task` VARCHAR(36) NOT NULL,
    `id_team` VARCHAR(36) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `id_task` FOREIGN KEY (`id_task`) REFERENCES `task` (`id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL ,
    CONSTRAINT `id_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;