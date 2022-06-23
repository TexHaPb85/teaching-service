insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('conditions_basic1',
        '<p>What will be printed to console?
        int a = 12;
        if (a % 2 == 0) {
            System.out.println(a + " is even");
        } else {
            System.out.println(a + " is not even");
        }
        </p>
        ',
        'a is even',
        'QUESTION',
        0.1,
        'conditions');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('conditions_basic2',
        '<p>Write code, that check if variable "a" has even value.</p>
         <p>Fill the following code, return true if "a" is even:</p>' ||
        '{
int a = 12;
// write your code here
//return ;
};
        ',
        'true',
        'WRITE_CODE',
        0.3,
        'conditions');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('conditions_middle1',
        '<p>What will be printed to console?
        int a = 5;
        switch (a) {
            case 5: {System.out.println("a=5");}
            default: {System.out.println("a is not 5");}
        }</p>
        ',
        'a=5a is not 5',
        'QUESTION',
        0.4,
        'conditions');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('conditions_middle2',
        '<p>What will be printed to console?
        int a = 10;
        System.out.println(a > 5 ? "more" : "less");</p>
        ',
        'more',
        'QUESTION',
        0.4,
        'conditions');

insert into task_materials (task_id, question, answer, task_type, complexity_value, paren_topic_id)
values ('conditions_middle3',
        '<p>Write code, that will check whether string "str" contains.</p>
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
        'conditions');