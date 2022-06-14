
insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, paren_topic_id)
values ('data_types_basic',
        'Data Types',
        '
        <p>int for integers</p>
        <p>example: int i = 12; </p>
        <p>double for fractional numbers:</p>' ||
        '<p>example: double d = 12.2; </p>
        <p>String for strings:</p> ' ||
        '<p>example: String s = "example string"; </p>' ||
        '<p>Any primitive type can be converter to String by using of String.value.of()</p>' ||
        '<p>example: String sConverted = String.valueOf(12.2); //sConverted == "12.2" </p>
        <p>boolean for expression that returns true/false:</p>' ||
        '<p>example: boolean b = 5 > 5; // true </p>
        <br>
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