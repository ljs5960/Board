SET foreign_key_checks = 0;

-- USER 
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
	`id`	VARCHAR(10)	NOT NULL,
	`password`	VARCHAR(20)	NOT NULL,
	`is_admin`	BOOLEAN	NOT NULL	DEFAULT false,
    
    PRIMARY KEY(id)
);

-- POST
DROP TABLE IF EXISTS `Post`;
CREATE TABLE `Post` (
	`id`	INT	NOT NULL AUTO_INCREMENT,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	TEXT	NULL,
	`file_id`	INT	NULL,
	`user_id`	VARCHAR(10)	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`modified_at`	DATETIME	NULL,
	`is_deleted`	BOOLEAN	NULL,
	`parent_post_id`	INT	NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(file_id) REFERENCES File(file_id),
    FOREIGN KEY(user_id) REFERENCES User(id),
    FOREIGN KEY(parent_post_id) REFERENCES Post(id)
);


-- Comment 
DROP TABLE IF EXISTS `Comment`;
CREATE TABLE `Comment` (
	`id`	INT	NOT NULL AUTO_INCREMENT,
	`content`	TEXT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`user_id`	VARCHAR(10)	NOT NULL,
	`post_id`	INT	NOT NULL,
	`parent_comment_id`	INT	NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES User(id),
    FOREIGN KEY(post_id) REFERENCES Post(id),
    FOREIGN KEY(parent_comment_id) REFERENCES Comment(id)
);


-- LIKE 
DROP TABLE IF EXISTS `Like`;
CREATE TABLE `Like` (
	`like_id`	INT	NOT NULL AUTO_INCREMENT,
	`user_id`	VARCHAR(10)	NOT NULL,
	`post_id`	INT	NOT NULL,
    
    PRIMARY KEY(like_id),
    FOREIGN KEY(user_id) REFERENCES User(id),
    FOREIGN KEY(post_id) REFERENCES Post(id)
);

-- FILE 
DROP TABLE IF EXISTS `File`;
CREATE TABLE `File` (
	`file_id`	INT	NOT NULL AUTO_INCREMENT,
	`name`	VARCHAR(50)	NOT NULL,
	`post_id`	INT	NOT NULL,
    
    PRIMARY KEY(file_id),
    FOREIGN KEY(post_id) REFERENCES Post(id)
);