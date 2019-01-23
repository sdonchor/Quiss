
CREATE TABLE `answers` (
  `a_id` int(11) NOT NULL,
  `content` varchar(220) COLLATE utf8_polish_ci NOT NULL,
  `q_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

CREATE TABLE `banned_ips` (
  `ip` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

CREATE TABLE `finished_games` (
  `fg_id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `report` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

CREATE TABLE `questions` (
  `q_id` int(11) NOT NULL,
  `content` text COLLATE utf8_polish_ci NOT NULL,
  `qs_id` int(11) NOT NULL,
  `correct_answer` varchar(220) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

CREATE TABLE `question_sets` (
  `qs_id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

ALTER TABLE `answers`
  ADD PRIMARY KEY (`a_id`),
  ADD KEY `q_id` (`q_id`);

ALTER TABLE `banned_ips`
  ADD PRIMARY KEY (`ip`);

ALTER TABLE `finished_games`
  ADD PRIMARY KEY (`fg_id`);

ALTER TABLE `questions`
  ADD PRIMARY KEY (`q_id`),
  ADD KEY `qs_id` (`qs_id`),
  ADD KEY `correct_answer` (`correct_answer`);

ALTER TABLE `question_sets`
  ADD PRIMARY KEY (`qs_id`),
  ADD UNIQUE KEY `name` (`name`);

ALTER TABLE `answers`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `finished_games`
  MODIFY `fg_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `questions`
  MODIFY `q_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `question_sets`
  MODIFY `qs_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `answers`
  ADD CONSTRAINT `answers_ibfk_1` FOREIGN KEY (`q_id`) REFERENCES `questions` (`q_id`) ON DELETE CASCADE;

ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`qs_id`) REFERENCES `question_sets` (`qs_id`) ON DELETE CASCADE;
  
  INSERT INTO `question_sets` (`qs_id`, `name`) VALUES
(1, 'Filozofia');
  
  INSERT INTO `questions` (`q_id`, `content`, `qs_id`, `correct_answer`) VALUES
(1, 'Który dział filozofi traktuje o bycie?', 1, 'metafizyka'),
(2, 'Czym jest dajmonion?', 1, 'głos sumienia'),
(3, 'Wybierz odpowiedz fałszywą:', 1, ' pojęcie prajdedni pochodzi od Arystotelesa'),
(4, 'Który ustrój polityczny jest najlepszy według Arystotelesa?', 1, 'królestwo'),
(5, 'Kogo nazywamy ojcem filozofi nowożytnej?', 1, 'Kartezjusz');


  
  INSERT INTO `answers` (`a_id`, `content`, `q_id`) VALUES
(1, 'metafizyka', 1),
(2, 'epistemologia', 1),
(3, 'etyka', 1),
(4, 'aksjologia', 1),
(5, 'ułuda/złuda', 2),
(6, 'cnota', 2),
(7, 'głos sumienia', 2),
(8, 'materia', 2),
(9, 'Sokrates popełnił samobójstwo', 3),
(10, ' sw. Tomasz uważał że dusza i ciało żyją że sobą w harmonii', 3),
(11, 'sw.Augustyn uważał że dusza jest więzieniem ciała', 3),
(12, ' pojęcie prajdedni pochodzi od Arystotelesa', 3),
(13, 'Arystokracja', 4),
(14, 'Tyrania', 4),
(15, 'demokracja', 4),
(16, 'królestwo', 4),
(17, 'Platon', 5),
(18, 'Sokrates', 5),
(19, 'Kartezjusz', 5),
(20, 'Immanuel Kant', 5);



  
  
  
COMMIT;
