insert into courses (course_id, description, complexity_value, hours)
values ('java_base_2022', 'Bacics of Java programming language', 0.2, 20.0);

insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('data_types', 'Bacics of Java programming language Data Types', 'java_base_2022', 0.2);
insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('conditions', 'Conditions in JavaL if/else, switch/case', 'java_base_2022', 0.2);
insert into topics (topic_id, description, parent_course_id, complexity_value)
values ('loops', 'Loops in Java for/while/do-while', 'java_base_2022', 0.2);

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, paren_topic_id)
values ('data_types_basic',
'Data Types',
'
int for integers, double for digids like 0.5, String for strings, boolean for true/false
<iframe width="1213" height="480" src="https://www.youtube.com/embed/QnkevG92lqk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
0.2,
'data_types');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, paren_topic_id)
values ('data_types_middle',
'Data Types',
'
<p>Data types are divided into two groups:
Primitive data types - includes byte, short, int, long, float, double, boolean and char
Non-primitive data types - such as String, Arrays and Classes (you will learn more about these in a later chapter)</p>
<img src="https://static.javatpoint.com/images/java-data-types.png">
<iframe width="1213" height="480" src="https://www.youtube.com/embed/qUXbJziVs_o" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
0.7,
'data_types');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, paren_topic_id)
values ('if_condition_basic',
'if() Condition',
'Use the if statement to specify a block of Java code to be executed if a condition is true.
Syntax
if (condition) {
  // block of code to be executed if the condition is true
}
Java has the following conditional statements:

Use if to specify a block of code to be executed, if a specified condition is true
Use else to specify a block of code to be executed, if the same condition is false
Use else if to specify a new condition to test, if the first condition is false
Use switch to specify many alternative blocks of code to be executed',
0.2,
'conditions');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, paren_topic_id)
values ('for_loop_basic',
'For loop',
'Syntax
for (statement 1; statement 2; statement 3) {
  // code block to be executed
}
Statement 1 is executed (one time) before the execution of the code block.
Statement 2 defines the condition for executing the code block.
Statement 3 is executed (every time) after the code block has been executed.',
0.2,
'loops');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_basic',
'What will be printed to console?
int a = 10;
System.out.println(++a);
',
'11',
'QUESTION',
0.1,
'data_types');