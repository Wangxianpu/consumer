CREATE TABLE `t_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `bank_acc_no` varchar(50) DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(50) NOT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` varchar(50) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`user_id`),
  KEY `bank_code` (`bank_acc_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3

create table t_bank_account(
	bank_acc_no VARCHAR(32) not null   		comment '银行账号',
	bank_name VARCHAR(50) not  null 	comment '银行名称',
	amount decimal  default 0  		 		comment '金额',
	create_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP	comment '创建时间',
	created_by VARCHAR(50) not null  	comment '创建人',
	update_date datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP	comment '更新时间',
	updated_by VARCHAR(50)not null  	comment '更新人',
	PRIMARY KEY (`bank_acc_no`)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
