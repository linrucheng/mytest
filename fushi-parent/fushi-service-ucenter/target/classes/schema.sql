DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` varchar(32) ,
                         `username` varchar(255) ,
                         `password` varchar(255) ,
                         `phone` varchar(255),
                         `id_number` varchar(255) ,
                         `create_time` datetime ,
                         PRIMARY KEY (`id`)
) ;
