-- auto Generated on 2020-04-17
-- DROP TABLE IF EXISTS user_mybatishelper;
CREATE TABLE user_mybatishelper(
                                   userid INT (11) NOT NULL AUTO_INCREMENT COMMENT 'userid',
                                   username VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'username',
                                   birth DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'birth',
                                   salary DECIMAL (13,4) NOT NULL DEFAULT -1 COMMENT '工资明细',
                                   INDEX `ix_username_salary`(username,salary),
                                   PRIMARY KEY (userid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_mybatishelper';
