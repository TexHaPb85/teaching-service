insert into user_accounts (rate_value, user_name) values (0.2, 'texhapb997');

insert into user_credentials (account_name, password, phone_number, email)
values ('texhapb997', '$2a$10$6sxqFyAflxnc9Wspi9XXaOsrqXLRMwIaChyNhE6oB2Dlo8DJo99Ui','0995581611', 'texhapb997@gmail.com');

insert into user_roles (user_email, roles)
values ('texhapb997@gmail.com', 'STUDENT');

insert into account_course_relations
(course_id, grade_of_course_complexity, grade_of_student, registered_at, user_account_id, relation_id)
values ('java_base_2022', -1, -1, '2022-06-07T09:55:28.030388300', 'texhapb997', 'java_base_2022_texhapb997');
