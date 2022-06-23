insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_basic1',
        '<pre>What will be printed to console?
        int a = 10;
        System.out.println(++a);</pre>
        ',
        '11',
        'QUESTION',
        0.1,
        'data_types');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_basic2',
        '<pre>Write code, that will increase integer variable "a" by 1 and return it as a String.
         Fill the following code:' ||
        '{
int a = 0;
// write your code here
return String.valueOf(a);
}</pre>;
        ',
        '1',
        'WRITE_CODE',
        0.3,
        'data_types');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_middle1',
        '<p>
        What will be printed to console?</p>
        <p>int a = 10;</p>
        <p>int b = a--;</p>
        <p>int c = --b;</p>
        <p>b*=5;</p>
        <p>System.out.println("a=" + (++a) + ", b=" + b + ", c=" + c);
        </p>
        ',
        'a=10, b=45, c=9',
        'QUESTION',
        0.39,
        'data_types');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_middle2',
'<pre>What will be printed to console?
int a = 10;
int b = --a;
int c = --b;
c%=--a;
System.out.println("a=" + a + ", b=" + b + ", c=" + c);</pre>
',
        'a=8, b=8, c=0',
        'QUESTION',
        0.4,
        'data_types');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('data_types_middle3',
        '<p>Write code, that will increase integer variable "a" by 15 and return it as String.</p>
         <pre>Fill the following code:' ||
        '{
int a = 0;
// write your code here
return String.valueOf(a);
}</pre>;
        ',
        '15',
        'WRITE_CODE',
        0.38,
        'data_types');