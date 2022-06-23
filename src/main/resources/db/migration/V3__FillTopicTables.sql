insert into courses (course_id, description, complexity_value, hours)
values ('java_base_2022', 'Bacics of Java programming language', 0.2, 20.0);

insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('data_types', 'Bacics of Java programming language Data Types', 'java_base_2022', 0.2);
insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('conditions', 'Conditions in Java if/else, switch/case', 'java_base_2022', 0.2);
insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('loops', 'Loops in Java for/while/do-while', 'java_base_2022', 0.2);
insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('arrays', 'Arrays in Java', 'java_base_2022', 0.2);
insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('collections_framework_1', 'List and Set interfaces', 'java_base_2022', 0.2);
insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('collections_framework_2', 'Map interface', 'java_base_2022', 0.2);