drop table if exists MEAL_FOOD_TB;
drop table if exists MEAL_TB;
drop table if exists MEMBER_TB;
drop table if exists FOOD_TB;

CREATE TABLE `MEMBER_TB`
(
    `MEMBER_PK`             bigint(20)   NOT NULL AUTO_INCREMENT,
    `CREATED_DATE`          datetime(6)  NOT NULL,
    `UPDATED_DATE`          datetime(6)  NOT NULL,
    `MEMBER_ACTIVITY`       varchar(255) NOT NULL,
    `MEMBER_AGE`            int(11)      NOT NULL,
    `MEMBER_ETC`            varchar(255) NOT NULL,
    `MEMBER_GENDER`         tinyint(1)   NOT NULL,
    `MEMBER_HEIGHT`         double       NOT NULL,
    `MEMBER_IDENTIFICATION` varchar(255) NOT NULL,
    `MEMBER_WEIGHT`         double       NOT NULL,
     PRIMARY KEY (`MEMBER_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `FOOD_TB`
(
    `FOOD_PK`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `FOOD_CALORIE`       double       NOT NULL,
    `FOOD_CARBOHYDRATE`  double       NOT NULL,
    `FOOD_FAT`           double       NOT NULL,
    `FOOD_MAIN_CATEGORY` varchar(255) NOT NULL,
    `FOOD_NAME`          varchar(255) NOT NULL,
    `FOOD_PROTEIN`       double       NOT NULL,
    `FOOD_SERVING_SIZE`  double       NOT NULL,
    `FOOD_SUB_CATEGORY`  varchar(255) NOT NULL,
    PRIMARY KEY (`FOOD_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `MEAL_TB`
(
    `MEAL_PK`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `CREATED_DATE`       datetime(6)  NOT NULL,
    `UPDATED_DATE`       datetime(6)  NOT NULL,
    `MEAL_TYPE`          varchar(255) NOT NULL,
    `MEAL_FOOD_MULTIPLE` double       NOT NULL,
    `MEMBER_FK`          bigint(20) DEFAULT NULL,
    PRIMARY KEY (`MEAL_PK`),
    KEY `FK5napxbpjxsev8lnx004fcrqrn` (`MEMBER_FK`),
    CONSTRAINT `FK5napxbpjxsev8lnx004fcrqrn` FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `MEAL_FOOD_TB`
(
    `MEAL_FOOD_PK` bigint(20)  NOT NULL AUTO_INCREMENT,
    `CREATED_DATE` datetime(6) NOT NULL,
    `UPDATED_DATE` datetime(6) NOT NULL,
    `FOOD_FK`      bigint(20) DEFAULT NULL,
    `MEAL_FK`      bigint(20) DEFAULT NULL,
    PRIMARY KEY (`MEAL_FOOD_PK`),
    KEY `FKdipb7hg6jdu5764nq3wcnviua` (`FOOD_FK`),
    KEY `FKr2altmd95kev38n36mno92lsi` (`MEAL_FK`),
    CONSTRAINT `FKdipb7hg6jdu5764nq3wcnviua` FOREIGN KEY (`FOOD_FK`) REFERENCES `FOOD_TB` (`FOOD_PK`),
    CONSTRAINT `FKr2altmd95kev38n36mno92lsi` FOREIGN KEY (`MEAL_FK`) REFERENCES `MEAL_TB` (`MEAL_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



