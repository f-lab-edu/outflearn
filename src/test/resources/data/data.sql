INSERT INTO member (id, name) values
(101, 'member-student101'),
(102, 'member-student102'),
(201, 'member-teacher201'),
(202, 'member-teacher202');

INSERT INTO student (id, member_id, nickname) values
(101, 101, 'student101'),
(102, 102, 'student102');

INSERT INTO teacher (id, member_id, nickname) values
(201, 201, 'teacher201'),
(202, 202, 'teacher202');

INSERT INTO course (id, title, fee, teacher_id) values
(101, '멘토링101', 30000, 201),
(102, '멘토링102', 30000, 202);
