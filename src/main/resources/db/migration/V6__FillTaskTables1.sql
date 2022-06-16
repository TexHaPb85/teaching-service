insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_basic1',
        '<p>What will be printed to console?</p>
        <p>int a = 10;</p>
        <p>System.out.println(++a);</p>
        ',
        '11',
        'QUESTION',
        0.1,
        'data_types');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_basic2',
        '<p>Write code, that will increase integer variable "a" by 1 and return it.</p>
         <p>Fill the following code:</p>' ||
        '{
int a = 0;
// write your code here
return String.valueOf(a);
}1;
        ',
        '1',
        'WRITE_CODE',
        0.3,
        'data_types');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_middle1',
        '<p>What will be printed to console?
        int a = 10;
        int b = a--;
        int c = --b;
        b*=5;
        System.out.println("a=" + (++a) + ", b=" + b + ", c=" + c);</p>
        ',
        'a=10, b=45, c=9',
        'QUESTION',
        0.4,
        'data_types');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_middle2',
        '<p>What will be printed to console?
        int a = 10;
        int b = --a;
        int c = --b;
        c%=--a;
        System.out.println("a=" + a + ", b=" + b + ", c=" + c);</p>
        ',
        'a=8, b=8, c=0',
        'QUESTION',
        0.4,
        'data_types');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_middle3',
        '<p>Write code, that will increase integer variable "a" by 15 and return it.</p>
         <p>Fill the following code:</p>' ||
        '{
int a = 0;
// write your code here
return String.valueOf(a);
}1;
        ',
        '15',
        'WRITE_CODE',
        0.4,
        'data_types');