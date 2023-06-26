-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 26, 2023 at 07:17 AM
-- Server version: 8.0.17
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_viewer`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(15) NOT NULL,
  `book_name` varchar(350) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_author` varchar(350) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_year` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_image_link` varchar(350) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_type` varchar(350) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `book_name`, `book_author`, `book_year`, `book_image_link`, `book_description`, `book_type`, `book_url`) VALUES
(1, 'IntroductionToJavaProgramming', 'Y. Daniel Liang', '2015', 'javaBook.png', 'The chapters can be grouped into five parts that, taken together, form a comprehensive introduction to Java programming, data structures and algorithms, and database and Web programming. \r\nBecause knowledge is cumulative, the early chapters provide the conceptual basis for understanding programming and guide students through simple examples and exercises; subsequent \r\nchapters progressively present Java programming in detail, culminating with the development \r\nof comprehensive Java application', 'tecnology', 'javabook.pdf'),
(2, 'ArtificialIntelligenceStructuresAndStrateg', 'AddisonWesley', '2009', 'AIBook.png', 'I was very pleased to be asked to produce the sixth edition of my artificial intelligence\r\nbook. It is a compliment to the earlier editions, started over twenty years ago, that our\r\napproach to AI has been so highly valued. It is also exciting that, as new development in\r\nthe field emerges, we are able to present much of it in each new edition. We thank our\r\nmany readers, colleagues, and students for keeping our topics relevant and our presentation up to date. \r\nMany sections of the earlier edi', 'tecnology', 'AIBook.pdf'),
(3, 'IntroductionToAlgorithms', 'Thomas H. Cormen', '2009', 'AlogorithmsBook.png', 'efore there were computers, there were algorithms. But now that there are computers, there are even more algorithms, and algorithms lie at the heart of computing.\r\nThis book provides a comprehensive introduction to the modern study of computer algorithms. It presents many algorithms and covers them in considerable\r\ndepth, yet makes their design and analysis accessible to all levels of readers. We\r\nhave tried to keep explanations elementary without sacrificing depth of coverage\r\nor mathematical', 'tecnology', 'algorithms.pdf'),
(4, 'DigitalDesign5thEdition', 'MorrisMichaelCiletti', '2013', 'DigitalDesignBook.png', 'Since the fourth edition of Digital Design, the commercial availability of devices using \r\ndigital technology to receive, manipulate, and transmit information seems to have \r\nexploded. Cell phones and handheld devices of various kinds offer new, competing \r\nfeatures almost daily. Underneath the attractive graphical user interface of all of these \r\ndevices sits a digital system that processes data in a binary format. The theoretical \r\nfoundations of these systems have not changed much; indeed, on', 'tecnology', 'DigitalDesign.pdf'),
(5, 'COMPUTERNETWORKING', 'James F. Kurose', '2013', 'NetworkBook.png', 'We think one important reason for this success has been that our book continues to offer\r\na fresh and timely approach to computer networking instruction. We’ve made changes\r\nin this sixth edition, but we’ve also kept unchanged what we believe (and the instructors and students who have used our book have confirmed) to be the most important\r\naspects of this book: its top-down approach, its focus on the Internet and a modern\r\ntreatment of computer networking, its attention to both principles and p', 'tecnology', 'networkBook.pdf'),
(6, 'The Technique of Psychotherapy', ' Wolberg, Lewis R. M.D', '2014', 'selfDevelopmentBook1.png', 'The Technique of Psychotherapy provides one of the most remarkably comprehensive discussions of specifically what to do in psychotherapy that is currently available. The range and specificity of the topics covered is truly astounding. The topics covered deal with almost every conceivable question that the beginning therapist might ask an expert. This book is remarkable not only in the comprehensiveness of its coverage of specific aspects of therapy, but also in the flexibility and freedom of dog', 'selfDevelopment', 'TechniqueoOfPsychotherapy.pdf'),
(7, 'The Self and Therapy', ' Levin, Jerome D. Ph.D.', '2016', 'selfDevelopmentBook2.png', 'This is a book about our understanding of the self and of narcissism, healthy and pathological, over the course of history. Focusing on modern developments from the philosophical debates of the 17th-century to contemporary psychoanalytical conceptualizations, it has a direct import theoretically for personality theory and philosophical psychology, and practically for counseling, psychotherapy, and psychoanalysis.\r\n\r\nThe book is unique in integrating the philosophical, psychological, and psychoan', 'selfDevelopment', 'THE_SELF_AND_THERAPY.pdf'),
(8, 'Achieving Success With ADHD', ' Sachar, David B. M.D.', '2018', 'selfDevelopmentBook3.png', 'his book describes tricks and tactics, strategies and systems, all based on behavioral modification', 'selfDevelopment', 'AchievingSuccess.pdf'),
(9, 'The Psychotherapy Guidebook', ' Herink, Paul Richard', '2017', 'selfDevelopmentBook4.png', 'This unique guide brings together clear, concise articles on 255 varieties of psychotherapy making it by far the best single overview of a complex and crowded field. Each article was written especially for this volume by a leading authority on that specific therapy, each article provides definitions of the therapy, its history, techniques and application. For the student, the therapist, the patient and the interested lay person. The Psychotherapy Guidebook is a vital charting of an area whose fr', 'selfDevelopment', 'The Psychotherapy Guidebook.pdf'),
(10, 'See What I\'m Saying:What Children Tell Us Through Their Art', ' Levick, Myra Ph.D., ATR-BC', '2019', 'selfDevelopmentBook5.png', 'Is your child in good emotional health? Overly fearful? Struggling with a problem? Typical for his or her age? Myra Levick, Ph.D., says that the answers to all these questions can be seen in how and what your child draws. Dr. Levick, recognized expert in the filed of art therapy, discusses what children communicate through their art and gives practical tools for assessing their intellectual development and emotional development. A psychologist and an art psychotherapist, Dr. Levick is a pioneer ', 'selfDevelopment', 'See What I\'m Saying.pdf'),
(11, 'Ulysses', 'James Joyce', '2005', 'novelsBook1.png', 'The most famous day in literature is June 16, 1904, when a certain Mr. Leopold Bloom of Dublin eats a kidney for breakfast, attends a funeral, admires a girl on the beach, contemplates his wife’s imminent adultery, and, late at night, befriends a drunken young poet in the city’s red-light district.\r\n\r\nAn earthy story, a virtuoso technical display, and a literary revolution all rolled into one, James Joyce’s Ulysses is a touchstone of our modernity and one of the towering achievements of the huma', 'novels', 'Ulysses.pdf'),
(12, 'A PORTRAIT OF THE ARTIST AS A YOUNG MAN', 'James Joyce', '1916', 'novelsBook2.png', 'Published in 1916, James Joyce’s semiautobiographical tale of his alter ego, Stephen Dedalus, is a coming-of-age story like no other. A bold, innovative experiment with both language and structure, the work has exerted a lasting influence on the contemporary novel; Alfred Kazin commented that “Joyce dissolved mechanism in literature as effectively as Einstein destroyed it in physics.” Reviewing the book in The New Republic, H. G. Wells wrote, “Like some of the best novels in the world it is the ', 'novels', 'A PORTRAIT OF THE ARTIST AS A YOUNG MAN.pdf'),
(13, 'THE WAY OF ALL FLESH', 'Samuel Butler', '1873', 'novelsBook3.png', 'Written between 1873 and 1884 but not published until 1903, Butler’s novel about the fortunes of the Pontifex family is a thinly veiled account of his own upbringing and a scathingly funny depiction of the hypocrisy underlying nineteenth-century domestic life. George Bernard Shaw hailed the novel as “one of the summits of human achievement” and William Maxwell claimed that it was the one Victorian novel he would save if his house caught on fire', 'novels', 'THE WAY OF ALL FLESH.pdf'),
(14, 'THE HEART IS A LONELY HUNTER', 'Carson McCullers', '1940', 'novelsBook4.png', 'Published in 1940, The Heart Is a Lonely Hunter follows a handful of outsiders in a small Georgia town: a young girl, a doctor, a deaf-mute, the owner of a diner, and an antagonistic wanderer. The novel was an overnight sensation and made Carson McCullers extremely famous. When it was first reviewed in The New York Times, Rose Feld wrote: “No matter what the age of its author, The Heart Is a Lonely Hunter would be a remarkable book. . . . When one reads that Carson McCullers is a girl of 22 it b', 'novels', 'THE HEART IS A LONELY HUNTER.pdf'),
(15, 'THE RAINBOW', 'D.H. Lawrence', '1915', 'novelsBook5.png', 'The Rainbow is the epic story of three generations of the Brangwens, a Midlands family. A visionary novel, it explores the complex sexual and psychological relationships between men and women in an increasingly industrialized world. Originally published in England in 1915, The Rainbow was the subject of an obscenity trial, as a result of which over a thousand copies were burned. Although it was available in the United States, it would be banned in England for many years.', 'novels', 'THE RAINBOW.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(15) NOT NULL,
  `user_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_email` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_password`, `user_phone`) VALUES
(2, 'leen_1990', 'leen_1990@yahoo.com', '5050', '1020101025'),
(21, 'abood_2000', 'abd2000@yahoo.com', '12345', '0795410867'),
(22, 'tamer_2005', 'tamer2005@gmail.com', '1234', '1233214568'),
(23, 'ts_2000', 'test2000@yahoo.com', '8520', '1234567120'),
(34, 'ts_2', 'tareq2000@yahoo.com', '1234', '0725410867');

-- --------------------------------------------------------

--
-- Table structure for table `user_book`
--

CREATE TABLE `user_book` (
  `user_id_foerign` int(15) NOT NULL,
  `book_id_foerign` int(15) NOT NULL,
  `is_fav` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_book`
--

INSERT INTO `user_book` (`user_id_foerign`, `book_id_foerign`, `is_fav`) VALUES
(2, 1, 1),
(2, 3, 1),
(2, 13, 1),
(21, 1, 1),
(21, 2, 1),
(21, 15, 1),
(22, 2, 1),
(22, 3, 1),
(22, 6, 1),
(23, 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`,`book_name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email_uniqe` (`user_id`,`user_email`) USING BTREE;

--
-- Indexes for table `user_book`
--
ALTER TABLE `user_book`
  ADD PRIMARY KEY (`user_id_foerign`,`book_id_foerign`),
  ADD KEY `book_id_foerign` (`book_id_foerign`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_book`
--
ALTER TABLE `user_book`
  ADD CONSTRAINT `user_book_ibfk_1` FOREIGN KEY (`user_id_foerign`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_book_ibfk_2` FOREIGN KEY (`book_id_foerign`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
