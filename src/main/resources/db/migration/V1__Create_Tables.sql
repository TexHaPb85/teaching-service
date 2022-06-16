drop table if exists account_course_relations CASCADE;
drop table if exists account_task_relations CASCADE;
drop table if exists account_theory_material_relations CASCADE;
drop table if exists courses CASCADE;
drop table if exists task_materials CASCADE;
drop table if exists theory_materials CASCADE;
drop table if exists topics CASCADE;
drop table if exists user_accounts CASCADE;
drop table if exists user_credentials CASCADE;
drop table if exists user_roles CASCADE;

create table account_course_relations (relation_id varchar(255) not null, grade_of_course_complexity float, grade_of_student float, registered_at timestamp, course_id varchar(255), user_account_id varchar(255), primary key (relation_id));
create table account_task_relations (relation_id varchar(255) not null, date_of_passing timestamp, grade_of_student float, grade_of_task_complexity float, user_account_id varchar(255), task_id varchar(255), primary key (relation_id));
create table account_theory_material_relations (relation_id varchar(255) not null, grade_of_task_complexity float, user_account_id varchar(255), theory_material_id varchar(255), primary key (relation_id));
create table courses (course_id varchar(255) not null, complexity_value float, description varchar(255), hours float, primary key (course_id));
create table task_materials (task_id varchar(255) not null, answer varchar(255), complexity_value float, default_complexity_value float, question varchar(255), task_type varchar(255), paren_topic_id varchar(255), primary key (task_id));
create table theory_materials (theory_id varchar(255) not null, complexity_value float, default_complexity_value float, text_of_theoryhtml varchar(1020), title varchar(255), paren_topic_id varchar(255), primary key (theory_id));
create table topics (topic_id varchar(255) not null, complexity_value float, description varchar(255), hours float, parent_course_id varchar(255), primary key (topic_id));
create table user_accounts (user_name varchar(255) not null, rate_value float, primary key (user_name));
create table user_credentials (email varchar(255) not null, password varchar(255), phone_number varchar(255), account_name varchar(255), primary key (email));
create table user_roles (user_email varchar(255) not null, roles varchar(255));