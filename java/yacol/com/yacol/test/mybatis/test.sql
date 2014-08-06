CREATE TABLE `user_info` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `user_id` varchar(30) NOT NULL,
   `user_name` varchar(30) DEFAULT NULL,
   `point` double DEFAULT NULL,
   `insert_time` datetime DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1