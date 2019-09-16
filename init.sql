create DATABASE if not exists `mybatis`;
use `mybatis`;

CREATE TABLE IF NOT EXISTS `user`
(
    `id`   int         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50) NOT NULL,
    `age`  int         NOT NULL,
    `sex`  int         NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- 正在导出表  mybatis.user 的数据：3 rows
DELETE
FROM `user`;

INSERT INTO `user` (`id`, `name`, `age`, `sex`)
VALUES (1, '张三', 42, 0),
       (2, '李四', 15, 0),
       (3, '王五', 45, 0),
       (4, '赵六', 47, 0),
       (5, '孙艳', 26, 1);