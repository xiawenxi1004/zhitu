/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : shixun

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-11 19:17:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `banner`
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `url` int(11) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('1', 'http://api.zhituteam.com/upload/banner/banner.png');

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL,
  `label` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('0', '全部');
INSERT INTO `grade` VALUES ('1', '一年级');
INSERT INTO `grade` VALUES ('2', '二年级');
INSERT INTO `grade` VALUES ('3', '三年级');
INSERT INTO `grade` VALUES ('4', '四年级');
INSERT INTO `grade` VALUES ('5', '五年级');
INSERT INTO `grade` VALUES ('6', '六年级');
INSERT INTO `grade` VALUES ('7', '初一');
INSERT INTO `grade` VALUES ('8', '初二');
INSERT INTO `grade` VALUES ('9', '初三');
INSERT INTO `grade` VALUES ('10', '高一');
INSERT INTO `grade` VALUES ('11', '高二');
INSERT INTO `grade` VALUES ('12', '高三');

-- ----------------------------
-- Table structure for `subject`
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `label` varchar(10) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('0', '全部', null);
INSERT INTO `subject` VALUES ('13', '语文', 'http://api.zhituteam.com/upload/icon/chinese.png');
INSERT INTO `subject` VALUES ('14', '数学', 'http://api.zhituteam.com/upload/icon/math.png');
INSERT INTO `subject` VALUES ('15', '英语', 'http://api.zhituteam.com/upload/icon/english.png');
INSERT INTO `subject` VALUES ('16', '物理', 'http://api.zhituteam.com/upload/icon/physical.png');
INSERT INTO `subject` VALUES ('17', '化学', 'http://api.zhituteam.com/upload/icon/chemical.png');
INSERT INTO `subject` VALUES ('18', '生物', null);
INSERT INTO `subject` VALUES ('19', '政治', null);
INSERT INTO `subject` VALUES ('20', '历史', null);
INSERT INTO `subject` VALUES ('21', '地理', null);
INSERT INTO `subject` VALUES ('22', '音乐', null);
INSERT INTO `subject` VALUES ('23', '美术', null);

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realname` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `gradeId` int(11) DEFAULT '0',
  `subjectId` int(11) DEFAULT '0',
  `phone` varchar(25) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `techyear` int(11) DEFAULT NULL,
  `techtime` int(11) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `tech_type` int(5) DEFAULT NULL,
  `intro` varchar(150) DEFAULT NULL,
  `isCollect` int(5) DEFAULT '0',
  `teacherExperience` int(5) DEFAULT NULL,
  `teacherCase` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gradeID` (`gradeId`),
  KEY `subjectID` (`subjectId`),
  KEY `techtypeID` (`tech_type`),
  CONSTRAINT `gradeID` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`id`),
  CONSTRAINT `subjectID` FOREIGN KEY (`subjectId`) REFERENCES `subject` (`id`),
  CONSTRAINT `techtypeID` FOREIGN KEY (`tech_type`) REFERENCES `teacher_type` (`ttid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('3', '赵春华', '赵老师男', '4', '15', '110', '110', '2', '22', 'http://api.zhituteam.com/upload/userimage/562c11dfa9ec8a13e5d6f9a3fe03918fa1ecc0a1.jpg', '2', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);
INSERT INTO `teacher` VALUES ('4', '李东升', '李老师男', '6', '17', '120', '120', '3', '33', 'http://api.zhituteam.com/upload/userimage/5bafa40f4bfbfbede5659f3c71f0f736afc31fb0.jpg', '2', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);
INSERT INTO `teacher` VALUES ('5', '马晓静', '马老师女', '8', '18', '130', '110', '1', '44', 'http://api.zhituteam.com/upload/userimage/a9d3fd1f4134970a21f1be6c9ccad1c8a6865df6.jpg', '1', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);
INSERT INTO `teacher` VALUES ('6', '马小红', '马老师女', '9', '18', '140', '500', '10', '12', 'http://api.zhituteam.com/upload/userimage/11385343fbf2b2112c3c2c0dc38065380cd78e67.jpg', '2', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);
INSERT INTO `teacher` VALUES ('7', '吕阿克', '吕老师女', '2', '20', '150', '10000', '20', '12', 'http://api.zhituteam.com/upload/userimage/730e0cf3d7ca7bcb94b6696cb7096b63f724a8a0.jpg', '1', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);
INSERT INTO `teacher` VALUES ('8', '李明', '李老师男', '4', '15', '156', '150', '2', '18', 'http://api.zhituteam.com/upload/userimage/241f95cad1c8a786dc38e34d6e09c93d70cf5066.jpg', '2', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);
INSERT INTO `teacher` VALUES ('9', '刘刚', '刘老师男', '1', '13', '150', '220', '3', '12', 'http://api.zhituteam.com/upload/userimage/6609c93d70cf3bc7843c64afd800baa1cd112ab0.jpg', '1', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);
INSERT INTO `teacher` VALUES ('10', '王邓云', '王老师女', '1', '13', '520', '120', '5', '63', 'http://api.zhituteam.com/upload/userimage/83025aafa40f4bfbb6d337170a4f78f0f7361875.jpg', '1', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);
INSERT INTO `teacher` VALUES ('11', '吕刚', '吕老师男', '4', '15', '110', '125', '2', '15', 'http://api.zhituteam.com/upload/userimage/9d82d158ccbf6c81850b85abb53eb13533fa40b0.jpg', '1', '2014年至今，一直从事初中化学的教学工作。拥有3年教学经验，具有丰富的教学经验。知识功底深厚，教学经验丰富，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '0', null, null);

-- ----------------------------
-- Table structure for `teachercase`
-- ----------------------------
DROP TABLE IF EXISTS `teachercase`;
CREATE TABLE `teachercase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `content` text,
  `teacherId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `teacherID` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachercase
-- ----------------------------
INSERT INTO `teachercase` VALUES ('1', '朱同学跃居全省第一', '寒假开始跟着我学习。学生对化学没有信心，基础知识似是而非，选择题靠感觉，大题不得章法，没有形成良好的解题思路，没有答出要点。从身边的化学物质奇妙的化学现象着手，经过三四次课的引导，学生对化学不再惧怕，开始有了信心，逐渐去主动的学习知识，基础也越来越扎实。在后期的学习训练中，大题也开始得心应手。对于实验题和推断的分析方法，解题技巧也逐步完善', '3', '5');
INSERT INTO `teachercase` VALUES ('2', '刘同学，提分22分', '学生一直以来是在原地踏步，希望能更进一步，上课后发现学生学习停留在知识表层，只知道结果，没有继续深入了解结果产生的本质原因，学习中更多的是去记忆，没有形成知识脉络，不能应用学过的知识去解析试题。经过几次课，学生学习有了明显提升，给学生一个知识点，学生能引出一条条知识网络，实验等大题的解题的思路非常好，对知识的拔高拓展做得很好。', '4', '6');
INSERT INTO `teachercase` VALUES ('3', '王同学，被清华录取', '学生一直以来偏科严重，除了英语其他学科都很好，在我的带领下突飞猛进', '5', '7');
INSERT INTO `teachercase` VALUES ('4', '李同学提分很大', '学生一直以来是在原地踏步，希望能更进一步，上课后发现学生学习停留在知识表层，只知道结果，没有继续深入了解结果产生的本质原因，学习中更多的是去记忆，没有形成知识脉络，不能应用学过的知识去解析试题。经过几次课，学生学习有了明显提升，给学生一个知识点，学生能引出一条条知识网络，实验等大题的解题的思路非常好，对知识的拔高拓展做得很好。', '6', '8');
INSERT INTO `teachercase` VALUES ('5', '王同学，被清华录取', '学生一直以来偏科严重，除了英语其他学科都很好，在我的带领下突飞猛进', '7', '8');
INSERT INTO `teachercase` VALUES ('6', '李同学，哈哈哈', '学生一直以来偏科严重，除了英语其他学科都很好，在我的带领下突飞猛进', '8', '9');
INSERT INTO `teachercase` VALUES ('7', '郭同学666', '学生一直以来偏科严重，除了英语其他学科都很好，在我的带领下突飞猛进', '9', '12');
INSERT INTO `teachercase` VALUES ('8', '韩同学', '学生一直以来偏科严重，除了英语其他学科都很好，在我的带领下突飞猛进', '10', '169');
INSERT INTO `teachercase` VALUES ('9', '国同学', '学生一直以来偏科严重，除了英语其他学科都很好，在我的带领下突飞猛进', '11', '56');

-- ----------------------------
-- Table structure for `teacherexperience`
-- ----------------------------
DROP TABLE IF EXISTS `teacherexperience`;
CREATE TABLE `teacherexperience` (
  `id` int(11) NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `content` text,
  `teacherId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ExpID` (`teacherId`),
  CONSTRAINT `ExpID` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacherexperience
-- ----------------------------
INSERT INTO `teacherexperience` VALUES ('1', '毕业班化学教学', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '3');
INSERT INTO `teacherexperience` VALUES ('2', '毕业班化学教学', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '4');
INSERT INTO `teacherexperience` VALUES ('3', '毕业班化学教学', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '5');
INSERT INTO `teacherexperience` VALUES ('4', '毕业班化学教学', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '6');
INSERT INTO `teacherexperience` VALUES ('5', '毕业班', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '7');
INSERT INTO `teacherexperience` VALUES ('6', '毕业班化学教学', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '8');
INSERT INTO `teacherexperience` VALUES ('7', '毕业班化学教学', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '9');
INSERT INTO `teacherexperience` VALUES ('8', '毕业班化学教学', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '10');
INSERT INTO `teacherexperience` VALUES ('9', '毕业班化学教学', '2014年至今，一直从事初中高中化学的教学工作。拥有8年教学经验，具有丰富的毕业班教学经验。知识功底深厚，教学经验丰富，教学辅导中准确把握教材的重点难点以及考点。善于因材施教，以学生为教学核心，帮助学生完善知识体系，归纳总结解题方法，巩固强化解题技巧。所带学生成绩有明显提升，在中考高考屡获佳绩。', '11');

-- ----------------------------
-- Table structure for `teacher_type`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_type`;
CREATE TABLE `teacher_type` (
  `ttid` int(11) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ttid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_type
-- ----------------------------
INSERT INTO `teacher_type` VALUES ('0', '全部');
INSERT INTO `teacher_type` VALUES ('1', '专职教师');
INSERT INTO `teacher_type` VALUES ('2', '在校大学生');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL COMMENT 'md5',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '15981289999', '123');
INSERT INTO `user` VALUES ('3', '15981289998', '123');
INSERT INTO `user` VALUES ('4', '15988888888', '111');
INSERT INTO `user` VALUES ('6', '15988888881', '111');
INSERT INTO `user` VALUES ('7', '11', '11');
INSERT INTO `user` VALUES ('8', '123456', '123456');
INSERT INTO `user` VALUES ('10', '111', '111');
INSERT INTO `user` VALUES ('11', '222', '66');
INSERT INTO `user` VALUES ('12', '999', '999');
INSERT INTO `user` VALUES ('13', '99999', '999999');
INSERT INTO `user` VALUES ('14', '222222', '22222');
INSERT INTO `user` VALUES ('15', '88', '88');
INSERT INTO `user` VALUES ('16', '889999', '88');
INSERT INTO `user` VALUES ('17', '12345678', '12345678');
INSERT INTO `user` VALUES ('18', '12580', '12580');
INSERT INTO `user` VALUES ('19', '125800', '125800');
INSERT INTO `user` VALUES ('20', '1111', '111');
INSERT INTO `user` VALUES ('21', '111111111111', '11111111111');

-- ----------------------------
-- Table structure for `ut`
-- ----------------------------
DROP TABLE IF EXISTS `ut`;
CREATE TABLE `ut` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `tid` int(11) NOT NULL COMMENT 'teacher的ID',
  PRIMARY KEY (`id`),
  KEY `UID` (`uid`),
  KEY `TID` (`tid`),
  CONSTRAINT `TID` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`),
  CONSTRAINT `UID` FOREIGN KEY (`uid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ut
-- ----------------------------
INSERT INTO `ut` VALUES ('2', '7', '4');
INSERT INTO `ut` VALUES ('5', '10', '4');
INSERT INTO `ut` VALUES ('6', '10', '6');
INSERT INTO `ut` VALUES ('7', '10', '5');
INSERT INTO `ut` VALUES ('9', '3', '3');
INSERT INTO `ut` VALUES ('10', '4', '4');
INSERT INTO `ut` VALUES ('11', '6', '6');
INSERT INTO `ut` VALUES ('13', '8', '3');
INSERT INTO `ut` VALUES ('15', '17', '5');
INSERT INTO `ut` VALUES ('16', '17', '3');
INSERT INTO `ut` VALUES ('19', '19', '11');
INSERT INTO `ut` VALUES ('28', '7', '3');
