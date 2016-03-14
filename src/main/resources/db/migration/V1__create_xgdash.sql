CREATE TABLE `customer` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`first_name` varchar(100) NOT NULL,
	`last_name` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `xg_ktv`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`kid` NVARCHAR(32) NOT NULL,
	`password` NVARCHAR(32) NOT NULL,
	`reg_date` TIMESTAMP NOT NULL,
	`k_name` NVARCHAR(128) NOT NULL,
	`k_call_no` NVARCHAR(16),
	`k_address` NVARCHAR(128),
	PRIMARY KEY (`id`),
	UNIQUE UQ_xg_user_kid(`kid`)
)
;


CREATE TABLE `xg_user`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(32) NOT NULL,
	`tel_no` NVARCHAR(16) NOT NULL,
	`password` NVARCHAR(32),
	`aliase` NVARCHAR(32),
	`reg_date` TIMESTAMP NOT NULL,
	`email` NVARCHAR(32),
	`qq` NVARCHAR(16),
	`weixin` NVARCHAR(16),
	PRIMARY KEY (`id`),
	UNIQUE UQ_user_tel_no(`tel_no`)
)
;



CREATE TABLE `xg_service_type`
(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(32) NOT NULL,
	`type_code` NVARCHAR(16) NOT NULL,
	PRIMARY KEY (`id`)
)
;

CREATE TABLE `xg_service_state`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`kid` BIGINT NOT NULL,
	`type_code` INTEGER NOT NULL,
	`start_date` DATETIME NOT NULL,
	`expire_date` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_order`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`kid` NVARCHAR(32) NOT NULL,
	`user_id` BIGINT NOT NULL,
	`service_type` INTEGER NOT NULL,
	`total_price` DECIMAL(10) NOT NULL,
	`amount` INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_service`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(32) NOT NULL,
	`buy_time` INTEGER,
	`type_code` NVARCHAR(16),
	`price` DECIMAL(10) NOT NULL,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_time_fee_rate`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(32) NOT NULL,
	`rate_json` TEXT NOT NULL,
	`kid` NVARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_buyout_fee_rate`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` BIGINT,
	`rate_json` TEXT NOT NULL,
	`kid` NVARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_room_type`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(32) NOT NULL,
	`enable` BOOL NOT NULL,
	`priority` INTEGER NOT NULL,
	`buyout_frid` BIGINT NOT NULL,
	`time_frid` BIGINT NOT NULL,
	`lowest_consume_price` DECIMAL(10) NOT NULL,
	`amount_consume_price` DECIMAL(10) NOT NULL,
	`kid` NVARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_room`
(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(32) NOT NULL,
	`enable` BOOL NOT NULL,
	`key_code` NVARCHAR(32) NOT NULL,
	`type_id` BIGINT NOT NULL,
	`kid` NVARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_goods_type`
(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(32) NOT NULL,
	`priority` INTEGER NOT NULL,
	`is_combo` BOOL NOT NULL,
	`enable` BOOL NOT NULL,
	`kid` NVARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_goods_combo`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`goods_id` BIGINT NOT NULL,
	`count` INTEGER NOT NULL,
	`combo_id` BIGINT NOT NULL,
	`kid` NVARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`)
)
;


CREATE TABLE `xg_goods`
(
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(32) NOT NULL,
	`key_code` NVARCHAR(32) NOT NULL,
	`bar_code` NVARCHAR(32),
	`enable` BOOL NOT NULL,
	`priority` INTEGER NOT NULL,
	`py_code` NVARCHAR(32),
	`price_01` DECIMAL(10),
	`price_02` DECIMAL(10),
	`price_03` DECIMAL(10),
	`type_id` BIGINT NOT NULL,
	`kid` NVARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE UQ_goods_bar_code(`bar_code`)
)
;

