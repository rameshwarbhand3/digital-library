CREATE DATABASE  IF NOT EXISTS `digital_library_db`;
USE `digital_library_db`;

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `copies` int(11) DEFAULT NULL,
  `copies_available` int(11) DEFAULT NULL,
  `category` varchar(11) DEFAULT NULL,
  `img` MEDIUMBLOB  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `book` VALUES (1,'JavaScript Cookbook','Luv, Zofia','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin risus tortor, condimentum eget sapien ac, dapibus varius ligula. Maecenas justo erat, semper sed nunc vel, vulputate eleifend dui. Integer id ipsum vitae nisi malesuada feugiat. Proin sit amet quam laoreet, feugiat mi vitae, vestibulum dui. Aliquam erat volutpat. Etiam hendrerit erat nec mi auctor elementum. Curabitur vestibulum lectus a ante tempor tincidunt et sed orci. Proin maximus tortor in risus auctor efficitur. Phasellus quam mauris, laoreet et feugiat ac, imperdiet at quam. Nullam sollicitudin nec diam vel finibus.', 10, 10, 'FE', 'http://localhost:8080/images/js-cookbook.png');

INSERT INTO `book` VALUES (2,'Become a Guru in JavaScript','Luv, Lena','Pellentesque varius aliquam lacus quis rhoncus. Nam a dui lectus. Vestibulum libero elit, ultricies sit amet sagittis eu, molestie at velit. Donec tincidunt tempus magna, quis facilisis libero elementum non. Sed velit lacus, laoreet sed augue fermentum, sagittis convallis metus. Sed nec est at massa venenatis aliquet. Donec pretium interdum fringilla. Sed ornare tellus enim, a tincidunt libero dictum vitae. Proin bibendum posuere dui. Donec sagittis neque massa, sed semper nulla vehicula at.', 15, 15,  'FE','http://localhost:8080/images/become-a-guru-in-js.png');

INSERT INTO `book` VALUES (3,'Exploring Vue.js','Luv, Jakub','Proin at urna faucibus, pretium mi in, dapibus metus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam elementum ligula ut vestibulum tincidunt. Aenean dignissim enim eu libero accumsan, ultricies efficitur mauris bibendum. Sed vel blandit ligula, non tincidunt velit. Suspendisse vulputate tristique enim, a vulputate arcu accumsan vitae. Donec egestas ornare velit vestibulum tincidunt. Suspendisse ac dui nec tellus vulputate aliquet. Curabitur vitae mauris in turpis vulputate hendrerit at eget urna. Donec at suscipit nisi. Ut sit amet dignissim orci. Nunc sit amet tristique enim. Phasellus consectetur auctor dignissim. Curabitur cursus turpis dapibus, molestie dui finibus, molestie ante. Proin quis justo ut ipsum aliquet venenatis in ut enim.', 10, 10, 'FE', 'http://localhost:8080/images/exploring-vue-js.png');

INSERT INTO `book` VALUES (4,'Advanced Techniques in Big Data','Luv, Alexander','Nunc eget lorem ac neque tincidunt mollis. Fusce finibus laoreet nunc nec hendrerit. Curabitur eu placerat urna, sit amet pellentesque enim. Donec velit ligula, congue eu lobortis vel, interdum nec tellus. Nulla nisl ipsum, porta non egestas sed, vulputate quis nisi. Etiam pellentesque in velit non convallis. Nullam id risus quis augue posuere sodales vel maximus justo. Maecenas nec leo a nibh aliquet placerat nec sed massa. Duis sit amet nisi libero. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus non viverra dolor. Pellentesque ligula mauris, congue quis neque quis, mollis scelerisque ligula. Pellentesque semper, erat commodo luctus mollis, nulla ipsum consectetur dolor, quis blandit massa sem fringilla libero. Maecenas eget mi nec est condimentum fermentum. Vivamus vehicula est sit amet ante gravida, eu finibus quam elementum. Proin egestas leo eu sagittis euismod.', 12, 12, 'Data','http://localhost:8080/images/advanced-tech-in-big-data.png');

INSERT INTO `book` VALUES(5,'Crash Course in Big Data','Luv, Judy','Morbi eu tempus eros, in imperdiet sem. Nulla sed sagittis nisl, porttitor fringilla libero. Nullam ut urna aliquet, hendrerit quam in, dignissim diam. In in nibh vel nisi fermentum pretium sit amet vitae mi. Pellentesque eget augue efficitur, volutpat tellus eget, fringilla augue. Pellentesque tempus mi ac risus lacinia, et tincidunt lectus rutrum. Nullam et nibh a odio luctus tincidunt nec in ipsum. Sed ac est nulla. Nulla purus turpis, dignissim sit amet euismod lobortis, consequat ut dui. Maecenas commodo velit in elementum placerat. Nam sit amet blandit ante, sit amet mollis neque. Ut placerat venenatis leo sit amet dapibus. Nunc varius cursus lobortis. Aenean euismod dui at diam euismod aliquet. Fusce feugiat orci nec commodo placerat.', 20, 20, 'Data','http://localhost:8080/images/crash-course-in-big-data.png');

INSERT INTO `book` VALUES (6,'Beginners Guide to SQL','Luv, Anup','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin risus tortor, condimentum eget sapien ac, dapibus varius ligula. Maecenas justo erat, semper sed nunc vel, vulputate eleifend dui. Integer id ipsum vitae nisi malesuada feugiat. Proin sit amet quam laoreet, feugiat mi vitae, vestibulum dui. Aliquam erat volutpat. Etiam hendrerit erat nec mi auctor elementum. Curabitur vestibulum lectus a ante tempor tincidunt et sed orci. Proin maximus tortor in risus auctor efficitur. Phasellus quam mauris, laoreet et feugiat ac, imperdiet at quam. Nullam sollicitudin nec diam vel finibus.', 20, 20, 'Data','http://localhost:8080/images/beginners-guide-to-sql.png');

INSERT INTO `book` VALUES (7,'Advanced Techniques in JavaScript','Luv, Yasemin', 'Pellentesque varius aliquam lacus quis rhoncus. Nam a dui lectus. Vestibulum libero elit, ultricies sit amet sagittis eu, molestie at velit. Donec tincidunt tempus magna, quis facilisis libero elementum non. Sed velit lacus, laoreet sed augue fermentum, sagittis convallis metus. Sed nec est at massa venenatis aliquet. Donec pretium interdum fringilla. Sed ornare tellus enim, a tincidunt libero dictum vitae. Proin bibendum posuere dui. Donec sagittis neque massa, sed semper nulla vehicula at.', 20, 20,'FE','http://localhost:8080/images/advanced-technique-in-js.png');

INSERT INTO `book` VALUES(8,'Introduction to Spring Boot','Luv, Fatma','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin risus tortor, condimentum eget sapien ac, dapibus varius ligula. Maecenas justo erat, semper sed nunc vel, vulputate eleifend dui. Integer id ipsum vitae nisi malesuada feugiat. Proin sit amet quam laoreet, feugiat mi vitae, vestibulum dui. Aliquam erat volutpat. Etiam hendrerit erat nec mi auctor elementum. Curabitur vestibulum lectus a ante tempor tincidunt et sed orci. Proin maximus tortor in risus auctor efficitur. Phasellus quam mauris, laoreet et feugiat ac, imperdiet at quam. Nullam sollicitudin nec diam vel finibus.', 10, 10, 'BE','http://localhost:8080/images/introduction-to-spring-boot.png');

INSERT INTO `book` VALUES(9,'Become a Guru in React.js','Luv, Andrey','Pellentesque varius aliquam lacus quis rhoncus. Nam a dui lectus. Vestibulum libero elit, ultricies sit amet sagittis eu, molestie at velit. Donec tincidunt tempus magna, quis facilisis libero elementum non. Sed velit lacus, laoreet sed augue fermentum, sagittis convallis metus. Sed nec est at massa venenatis aliquet. Donec pretium interdum fringilla. Sed ornare tellus enim, a tincidunt libero dictum vitae. Proin bibendum posuere dui. Donec sagittis neque massa, sed semper nulla vehicula at.', 15, 15, 'FE','http://localhost:8080/images/become-a-guru-in-react-js.png');

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `rating` decimal (3,2) DEFAULT NULL,
  `book_id` BIGINT(20) DEFAULT NULL,
  `review_description` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



INSERT INTO `review` VALUES
	(1, 'example1user@email.com', NOW(), 4, 1, 'First book is pretty good book overall'),
	(2, 'example2user@email.com', NOW(), 4.5, 2, 'Second books is pretty good book overall');


DROP TABLE IF EXISTS `checkout`;

CREATE TABLE `checkout` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) DEFAULT NULL,
  `checkout_date` varchar(45) DEFAULT NULL,
  `return_date` varchar(45) DEFAULT NULL,
  `book_id` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- INSERT INTO `checkout` VALUES
-- 	(1, 'example1user@email.com', '2022-05-22', '2022-06-25', 1),
--     (2, 'example2user@email.com', '2022-05-22', '2022-06-26', 1),
--     (3, 'example1user@email.com', '2022-05-22', '2022-06-01', 2);



DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `question` text DEFAULT NULL,
  `admin_email` varchar(45) DEFAULT NULL,
  `response` text DEFAULT NULL,
  `closed` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- INSERT INTO `messages` VALUES
-- 	(1, 'example3user@email.com', 'What should we do here?', 'I have been trying to work this out for a long time and no matter what happens I cannot figure this dang thing out', 'example1user@email.com', 'I do not know what to tell you friend. You are on your own.', 1),
--     (2, 'example2user@email.com', 'What should we do here example 2 user?', 'I have been trying to work this out for a long time and no matter what happens I cannot figure this dang thing out', 'example1user@email.com', 'I do not know what to tell you friend. You are on your own.',  1);


DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) DEFAULT NULL,
  `checkout_date` varchar(45) DEFAULT NULL,
  `returned_date` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `img` MEDIUMBLOB  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;




