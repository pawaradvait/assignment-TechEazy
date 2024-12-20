CREATE TABLE IF NOT EXISTS `student` (
                                             `id` int AUTO_INCREMENT PRIMARY KEY,
                                             `name` varchar(100) NOT NULL,
                                             `address` varchar(10) NOT NULL,
                                             `email` varchar(100) NOT NULL,
                                            `password` varchar(100) NOT NULL,
                                            `role` varchar(100)

);

CREATE TABLE IF NOT EXISTS `subject` (
                                          `id` int AUTO_INCREMENT PRIMARY KEY,
                                          `name` varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `person_subject` (


                                                `person_id` int NOT NULL,
                                                  `subject_id` int NOT NULL,
                                                   PRIMARY KEY (`person_id`, `subject_id`),
                                                FOREIGN KEY (`person_id`) REFERENCES `student` (`id`),
                                                FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
);