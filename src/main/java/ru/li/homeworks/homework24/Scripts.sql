
--Студенты
CREATE TABLE students (
	student_id serial4 NOT NULL,
	student_name varchar(100) NOT NULL,
	CONSTRAINT students_pkey PRIMARY KEY (student_id)
);

--Тесты
CREATE TABLE tests (
	test_id serial4 NOT NULL,
	test_name varchar(100) NOT NULL,
	CONSTRAINT tests_pkey PRIMARY KEY (test_id),
	CONSTRAINT tests_un UNIQUE (test_name)
);

--Вопросы
CREATE TABLE questions (
	question_id serial4 NOT NULL,
	question_name varchar(250) NOT NULL,
	CONSTRAINT questions_pkey PRIMARY KEY (question_id),
	CONSTRAINT questions_un UNIQUE (question_name)
);

--Ответы
CREATE TABLE answers (
	answer_id serial4 NOT NULL,
	answer_name varchar(250) NOT NULL,
	CONSTRAINT answers_pkey PRIMARY KEY (answer_id),
	CONSTRAINT answers_un UNIQUE (answer_name)
);

--Прохождение тестов
CREATE TABLE "passing" (
	passing_id serial4 NOT NULL,
	passing_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	student_id int4 NOT NULL,
	test_id int4 NOT NULL,
	CONSTRAINT passing_pkey PRIMARY KEY (passing_id),
	CONSTRAINT passing_fk_student_id FOREIGN KEY (student_id) REFERENCES students(student_id),
	CONSTRAINT passing_fk_test_id FOREIGN KEY (test_id) REFERENCES tests(test_id)
);

--Содержимое тестов с указанием правильных ответов
CREATE TABLE "content" (
	content_id serial4 NOT NULL,
	test_id int4 NOT NULL,
	question_id int4 NOT NULL,
	answer_id int4 NOT NULL,
	correct bool NOT NULL,
	CONSTRAINT content_pkey PRIMARY KEY (content_id),
	CONSTRAINT content_un UNIQUE (test_id, question_id, answer_id),
	CONSTRAINT content_fk_answer_id FOREIGN KEY (answer_id) REFERENCES answers(answer_id),
	CONSTRAINT content_fk_question_id FOREIGN KEY (question_id) REFERENCES questions(question_id),
	CONSTRAINT content_fk_test_id FOREIGN KEY (test_id) REFERENCES tests(test_id)
);

--История ответов прохождения тестов
CREATE TABLE history (
	history_id serial4 NOT NULL,
	history_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	passing_id int4 NOT NULL,
	content_id int4 NOT NULL,
	CONSTRAINT history_pkey PRIMARY KEY (history_id),
	CONSTRAINT history_fk_content_id FOREIGN KEY (content_id) REFERENCES "content"(content_id),
	CONSTRAINT history_fk_passing_id FOREIGN KEY (passing_id) REFERENCES "passing"(passing_id)
);
