insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('conditions_basic',
        'Сonditions Basic',
        '
<p><pre>To write useful programs, we almost always need to check conditions and react accordingly.
Conditional statements give us this ability. The simplest conditional statement in Java is the if statement:
    if (x > 0) {
        System.out.println("x is positive");
    }

The expression in parentheses is called the condition. If it is true, the statements in braces get executed.
A second form of conditional statement has two possibilities, indicated by if and else:

    if (x % 2 == 0) {
    System.out.println("x is even");
    } else {
     System.out.println("x is odd");
    }
The switch statement is a multi-way branch statement. In simple words, the Java switch statement
executes one statement from multiple conditions. It is like an if-else-if ladder statement.
It provides an easy way to dispatch execution to different parts of code based on the value of the expression.
It basically tests the equality of variables against multiple values.
</pre></p>
        <br>
       <iframe width="1280" height="720" src="https://www.youtube.com/embed/WiT0yakVp3A" title="Java Tutorial - if then else and switch case statements" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.2,
        0.2,
        'conditions');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('conditions_middle',
        'Сonditions Middle',
        '
<p><pre>Java is equipped with a selection operator that allows us to construct a conditional expression.
The use of a conditional expression can in some cases simplify the code with respect to the use of an if-else statement.

Conditional expression

    Syntax:

    condition ? expression-1 : expression-2
    • condition is a boolean expression
    • expression-1 and expression-2 are two arbitrary expressions, which must be of the same type

        <img src="https://static.javatpoint.com/core/images/conditional-operator-in-java3.png">

    Semantics:

    Evaluate condition . If the result is true, then evaluate expression-1 and return its value, otherwise evaluate
    expression-2 and return its value.

    Example:
    System.out.println("bigger value = " + (a > b)? a : b);
    </pre></p>
        <br>
        <iframe width="1280" height="720" src="https://www.youtube.com/embed/Kgp2N7qmk1s" title="Conditional Operator in Java" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.5,
        0.5,
        'conditions');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('loops_basic',
        'Loops Basic',
        '
<p><pre>Looping in programming languages is a feature which facilitates the execution of a set of
instructions/functions repeatedly while some condition evaluates to true.
Java provides three ways for executing the loops. While all the ways provide similar basic functionality,
they differ in their syntax and condition checking time.
while loop: A while loop is a control flow statement that allows code to be executed repeatedly based
on a given Boolean condition.
The while loop can be thought of as a repeating if statement.

    Syntax :

    while (boolean condition)
     {
    loop statements...
    }

<img src="https://media.geeksforgeeks.org/wp-content/uploads/Loop1.png">

for loop: for loop provides a concise way of writing the loop structure.
Unlike a while loop, a for statement consumes the initialization, condition
and increment/decrement in one line thereby providing a shorter, easy to debug structure of looping.
    Syntax:

    for (initialization condition; testing condition;increment/decrement)
    {
    statement(s)
    }

    <img src="https://media.geeksforgeeks.org/wp-content/uploads/loop2.png">

do while: do while loop is similar to while loop with only difference that it checks
for condition after executing the statements

<img src="https://media.geeksforgeeks.org/wp-content/uploads/loop3.png">
</pre></p>
        <br>
        <iframe width="1280" height="720" src="https://www.youtube.com/embed/6djggrlkHY8" title="Java For Beginners: While, Do While & For Loops (7/10)" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.2,
        0.2,
        'loops');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('loops_middle',
        'Loops Middle',
        '
<p><pre>For-each is another array traversing technique like for loop, while loop, do-while loop introduced in Java5.
It starts with the keyword for like a normal for-loop.
Instead of declaring and initializing a loop counter variable, you declare a variable that is the same type
as the base type of the array, followed by a colon, which is then followed by the array name.
In the loop body, you can use the loop variable you created rather than using an indexed array element.
It’s commonly used to iterate over an array or a Collections class (eg, ArrayList)

    Syntax:

    for (type var : array)
    {
    statements using var;
    }

Limitations of for-each loop decision-making:
    1. For-each loops are not appropriate when you want to modify the array;
    2. For-each loops do not keep track of index. So we can not obtain array index using For-Each loop;
    3. For-each only iterates forward over the array in single steps;
    4. For-each cannot process two decision making statements at once;
    5. For-each also has some performance overhead over simple iteration;
</pre></p>
        <br>
        <iframe width="1280" height="720" src="https://www.youtube.com/embed/6SweFjpcYOI" title="For Each Loop in Java" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.6,
        0.6,
        'loops');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('arrays_basic',
        'Arrays Basic',
        '
<p><pre>An array object (or simply array) contains a collection of elements of the same type,
each of which is indexed(i.e., identified) by a number. A variable of type array contains a reference
to an array object.

To use an array in Java we have to:
    1. declare a variable of type array that allows us to refer to an array object;
    2. construct the array object specifying its dimension (number of elements of the array object);
    3. access the elements of the array object through the array variable in order to assign or obtain their values
    (as if they were single variables).

The general form of a one-dimensional array declaration is
    type var-name[];
    OR
    type[] var-name;

An array declaration has two components: the type and the name. type declares the element type of the array.
The element type determines the data type of each element that comprises the array.Like an array of integers,
we can also create an array of other primitive data types like char, float, double, etc.,
or user-defined data types (objects of a class).
Thus, the element type for the array determines what type of data the array will hold.

    Example:

    both are valid declarations
    int intArray[];
    or int[] intArray;

When an array is declared, only a reference of an array is created. To create or give memory to the array,
you create an array like this:

The general form of new as it applies to one-dimensional arrays appears as follows:
    var-name = new type [size];

Here, type specifies the type of data being allocated, size determines the number of elements in the array,
and var-name is the name of the array variable that is linked to the array.To use new to allocate an array,
you must specify the type and number of elements to allocate.

    Example:

    int intArray[];    //declaring array
    intArray = new int[20];  // allocating memory to array
    OR
    int[] intArray = new int[20]; // combining both statements in one
</pre></p>
        <br>
        <iframe width="1280" height="720" src="https://www.youtube.com/embed/o2ARur9hs9M" title="Java Programming Tutorial 33 - Intro To Arrays" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.2,
        0.2,
        'arrays');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('arrays_middle',
        'Arrays Middle',
        '
<p><pre>Multidimensional Arrays can be defined in simple words as array of arrays. Data in multidimensional
arrays are stored in tabular form (in row major order).

Syntax:

    data_type[1st dimension][2nd dimension][]..[Nth dimension] array_name = new data_type[size1][size2]….[sizeN];

where:

    data_type: Type of data to be stored in the array. For example: int, char, etc.
    dimension: The dimension of the array created.
    For example: 1D, 2D, etc.
    array_name: Name of the array
    size1, size2, …, sizeN: Sizes of the dimensions respectively.

Examples:

    Two dimensional array:
    int[][] twoD_arr = new int[10][20];

    Three dimensional array:
    int[][][] threeD_arr = new int[10][20][30];

Size of multidimensional arrays: The total number of elements that can be stored in a multidimensional array
can be calculated by multiplying the size of all the dimensions.

For example:
The array int[][] x = new int[10][20] can store a total of (10*20) = 200 elements.
Similarly, array int[][][] x = new int[5][10][20] can store a total of (5*10*20) = 1000 elements.

Two – dimensional array is the simplest form of a multidimensional array. A two – dimensional array
can be seen as an array of one – dimensional array for easier understanding.

Indirect Method of Declaration:

    Declaration – Syntax:

    data_type[][] array_name = new data_type[x][y];
            For example: int[][] arr = new int[10][20];


    Initialization – Syntax:

    array_name[row_index][column_index] = value;
            For example: arr[0][0] = 1;

Direct Method of Declaration:

Syntax:

data_type[][] array_name = {
                             {valueR1C1, valueR1C2, ....},
                             {valueR2C1, valueR2C2, ....}
                           };

For example: int[][] arr = {{1, 2}, {3, 4}};</pre></p>
        <br>
        <iframe width="853" height="480" src="https://www.youtube.com/embed/ctab5xPv-Vk" title="Java Programming Tutorial - 33 - Multidimensional Arrays" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.65,
        0.65,
        'arrays');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('list_and_set_basic',
        'List and Set Basic',
        '
<p><pre>List in Java provides the facility to maintain the ordered collection. It contains the index-based
methods to insert, update, delete and search the elements. It can have the duplicate elements also.
We can also store the null elements in the list.

The List interface is found in the java.util package and inherits the Collection interface.
It is a factory of ListIterator interface. Through the ListIterator, we can iterate the list
in forward and backward directions. The implementation classes of List interface are ArrayList, LinkedList,
Stack and Vector. The ArrayList and LinkedList are widely used in Java programming. The Vector class
is deprecated since Java 5.

List is an interface, and the instances of List can be created in the following ways:

    List a = new ArrayList();
    List b = new LinkedList();
    List c = new Vector();
    List d = new Stack();

A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction.
The Set interface contains only methods inherited from Collection and adds the restriction
that duplicate elements are prohibited.

Set also adds a stronger contract on the behavior of the equals and hashCode operations,
allowing Set instances to be compared meaningfully even if their implementation types differ.

Since Set is an interface, we cannot create objects from it.
In order to use functionalities of the Set interface, we can use these classes:

    HashSet
    LinkedHashSet
    EnumSet
    TreeSet

</pre></p>
        <br>
        <iframe width="853" height="480" src="https://www.youtube.com/embed/ctab5xPv-Vk" title="Java Programming Tutorial - 33 - Multidimensional Arrays" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.2,
        0.2,
        'collections_framework_1');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('list_and_set_middle',
        'List and Set Middle',
        '
<p><pre>Methods of List

The List interface includes all the methods of the Collection interface. Its because Collection is a super interface of List.

Some of the commonly used methods of the Collection interface that is also available in the List interface are:

    add() - adds an element to a list
    addAll() - adds all elements of one list to another
    get() - helps to randomly access elements from lists
    iterator() - returns iterator object that can be used to sequentially access elements of lists
    set() - changes elements of lists
    remove() - removes an element from the list
    removeAll() - removes all the elements from the list
    clear() - removes all the elements from the list (more efficient than removeAll())
    size() - returns the length of lists
    toArray() - converts a list into an array
    contains() - returns true if a list contains specified element

Methods of Set

The Set interface includes all the methods of the Collection interface. It is because Collection is a super interface of Set.

Some of the commonly used methods of the Collection interface that is also available in the Set interface are:

    add() - adds the specified element to the set
    addAll() - adds all the elements of the specified collection to the set
    iterator() - returns an iterator that can be used to access elements of the set sequentially
    remove() - removes the specified element from the set
    removeAll() - removes all the elements from the set that is present in another specified set
    retainAll() - retains all the elements in the set that are also present in another specified set
    clear() - removes all the elements from the set
    size() - returns the length (number of elements) of the set
    toArray() - returns an array containing all the elements of the set
    contains() - returns true if the set contains the specified element
    containsAll() - returns true if the set contains all the elements of the specified collection
    hashCode() - returns a hash code value (address of the element in the set)

To learn about more methods of the Set interface, visit Java Set (official Java documentation).
</pre></p>
        <br>
        <iframe width="1280" height="720" src="https://www.youtube.com/embed/kHstgo8sDa4" title="Java Programming Tutorial 45 - Working with Lists (List Methods)" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.6,
        0.6,
        'collections_framework_1');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('list_and_set_advanced',
        'List and Set Advanced',
        '
<p><pre>List and Set both are interfaces. They both extends Collection interface.
In this post we are discussing the differences between List and Set interfaces in java.

List and Set differences

    1) List is an ordered collection it maintains the insertion order, which means upon displaying
    the list content it will display the elements in the same order in which they got inserted into the list.
    Set is an unordered collection, it doesn’t maintain any order. There are few implementations of Set
    which maintains the order such as LinkedHashSet (It maintains the elements in insertion order).

    2) List allows duplicates while Set doesn’t allow duplicate elements. All the elements of a Set
    should be unique if you try to insert the duplicate element in Set it would replace the existing value.

    3) List implementations: ArrayList, LinkedList etc.
    Set implementations: HashSet, LinkedHashSet, TreeSet etc.

    4) List allows any number of null values. Set can have only a single null value at most.

    5) ListIterator can be used to traverse a List in both the directions(forward and backward)
    However it can not be used to traverse a Set. We can use Iterator (It works with List too) to traverse a Set.

    6) List interface has one legacy class called Vector whereas Set interface does not have any legacy class.

When to use Set and When to use List?

The usage is purely depends on the requirement:

    If the requirement is to have only unique values then Set is your best bet as any implementation
    of Set maintains unique values only.

    If there is a need to maintain the insertion order irrespective of the duplicity then List is a best option.
    Both the implementations of List interface – ArrayList and LinkedList sorts the elements in their insertion order
</pre></p>
        <br>
        <iframe width="1280" height="679" src="https://www.youtube.com/embed/xHOmXGhq9nI" title="Difference between List and Set in Java | Java Interview" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.8,
        0.8,
        'collections_framework_1');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('map_interface_basic',
        'Map interface Basic',
        '
<p><pre>The map interface is present in java.util package represents a mapping between a key and a value.
The Map interface is not a subtype of the Collection interface.
Therefore it behaves a bit differently from the rest of the collection types. A map contains unique keys.

Maps are perfect to use for key-value association mapping such as dictionaries. The maps are used to perform
lookups by keys or when someone wants to retrieve and update elements by keys. Some common scenarios are as follows:

    A map of error codes and their descriptions.
    A map of zip codes and cities.
    A map of managers and employees. Each manager (key) is associated with a list of employees (value) he manages.
    A map of classes and students. Each class (key) is associated with a list of students (value).

    <img src="https://media.geeksforgeeks.org/wp-content/uploads/20220112221354/javamaphierarchy-660x330.jpg">

Since Map is an interface, objects cannot be created of the type map. We always need a class that extends
this map in order to create an object. And also, after the introduction of Generics in Java 1.5,
it is possible to restrict the type of object that can be stored in the Map.

Syntax: Defining Type-safe Map

   Map hm = new HashMap();
   // Obj is the type of the object to be stored in Map

Characteristics of a Map Interface

    1. A Map cannot contain duplicate keys and each key can map to at most one value.
    Some implementations allow null key and null values like the HashMap and LinkedHashMap,
    but some do not like the TreeMap.
    2. The order of a map depends on the specific implementations. For example,
    TreeMap and LinkedHashMap have predictable orders, while HashMap does not.
    3. There are two interfaces for implementing Map in java. They are Map and SortedMap,
    and three classes: HashMap, TreeMap, and LinkedHashMap.
</pre></p>
        <br>
        <iframe width="1280" height="720" src="https://www.youtube.com/embed/jErVacMSkJg" title="Java Map and HashMap Tutorial (Java Collections) | Key-Value Pair Entry #10.3" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.2,
        0.2,
        'collections_framework_2');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('map_interface_middle',
        'Map interface Middle',
        '
<p><pre>Methods in Map Interface

    clear() - This method is used to clear and remove all of the elements or mappings from a specified Map collection.

    containsKey(Object) - This method is used to check whether a particular key is being mapped into the Map or not.
    It takes the key element as a parameter and returns True if that element is mapped in the map.
    containsValue(Object) - This method is used to check whether a particular value is being mapped
    by a single or more than one key in the Map. It takes the value as a parameter and returns True if
    that value is mapped by any of the key in the map.

    entrySet() - This method is used to create a set out of the same elements contained in the map.
    It basically returns a set view of the map or we can create a new set and store the map elements into them.
    equals(Object) - This method is used to check for equality between two maps. It verifies whether the elements
    of one map passed as a parameter is equal to the elements of this map or not.

    get(Object) - This method is used to retrieve or fetch the value mapped by a particular
    key mentioned in the parameter. It returns NULL when the map contains no such mapping for the key.

    hashCode() - This method is used to generate a hashCode for the given map containing keys and values.

    isEmpty() - This method is used to check if a map is having any entry for key and value pairs.
    If no mapping exists, then this returns true.

    keySet() - This method is used to return a Set view of the keys contained in this map.
    The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.

    put(Object, Object) - This method is used to associate the specified value with the specified key in this map.

    putAll(Map) - This method is used to copy all of the mappings from the specified map to this map.

    remove(Object) - This method is used to remove the mapping for a key from this map if it is present in the map.

    size() - This method is used to return the number of key/value pairs available in the map.

    values() - This method is used to create a collection out of the values of the map.
    It basically returns a Collection view of the values in the HashMap.
    getOrDefault(Object key, V defaultValue) - Returns the value to which the specified key is mapped,
    or defaultValue if this map contains no mapping for the key.

    merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction) - If the specified key
    is not already associated with a value or is associated with null, associates it with the given non-null value.

    putIfAbsent(K key, V value) - If the specified key is not already associated with a value
    (or is mapped to null) associates it with the given value and returns null, else returns the curassociaterent value.
</pre></p>
        <br>
        <iframe width="1280" height="720" src="https://www.youtube.com/embed/H62Jfv1DJlU" title="Map and HashMap in Java - Full Tutorial" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
        0.7,
        0.7,
        'collections_framework_2');

insert into theory_materials (theory_id, title, text_of_theoryhtml, complexity_value, default_complexity_value, paren_topic_id)
values ('map_interface_advanced',
        'Map interface Advanced',
        '
<p><pre>Classes that implement the Map interface are depicted in the below media and described later as follows:

<img src="https://contribute.geeksforgeeks.org/wp-content/uploads/Selection_030.png">

Class 1: HashMap

    HashMap is a part of Java’s collection since Java 1.2. It provides the basic implementation
    of the Map interface of Java. It stores the data in (Key, Value) pairs. To access a value one must know its key.
    This class uses a technique called Hashing. Hashing is a technique of converting a large String to a small
    String that represents the same String.

    Example

         // Java Program to illustrate the Hashmap Class

         // Importing required classes
         import java.util.*;

         // Main class
         public class GFG {

             // Main driver method
             public static void main(String[] args)
             {

                 // Creating an empty HashMap
                 Map<String, Integer> map = new HashMap<>();

                 // Inserting entries in the Map
                 // using put() method
                 map.put("vishal", 10);
                 map.put("sachin", 30);
                 map.put("vaibhav", 20);

                 // Iterating over Map
                 for (Map.Entry<String, Integer> e : map.entrySet())

                     // Printing key-value pairs
                     System.out.println(e.getKey() + " "
                                        + e.getValue());
             }
         }

Class 2: LinkedHashMap

    LinkedHashMap is just like HashMap with an additional feature of maintaining an order of elements inserted into it.
    HashMap provided the advantage of quick insertion, search, and deletion but it never maintained
    the track and order of insertion which the LinkedHashMap provides where the elements
    can be accessed in their insertion order.

    Example

         // Java Program to Illustrate the LinkedHashmap Class

         // Importing required classes
         import java.util.*;

         // Main class
         public class GFG {

             // Main driver method
             public static void main(String[] args)
             {

                 // Creating an empty LinkedHashMap
                 Map<String, Integer> map = new LinkedHashMap<>();

                 // Inserting pair entries in above Map
                 // using put() method
                 map.put("vishal", 10);
                 map.put("sachin", 30);
                 map.put("vaibhav", 20);

                 // Iterating over Map
                 for (Map.Entry<String, Integer> e : map.entrySet())

                     // Printing key-value pairs
                     System.out.println(e.getKey() + " "
                                        + e.getValue());
             }
         }

Class 3: TreeMap

    The TreeMap in Java is used to implement the Map interface and NavigableMap along with the Abstract Class.
    The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map
    creation time, depending on which constructor is used. This proves to be an efficient way of sorting
    and storing the key-value pairs. The storing order maintained by the treemap must be consistent with
    equals just like any other sorted map, irrespective of the explicit comparators.

    Example

         // Java Program to Illustrate TreeMap Class
         // Importing required classes
         import java.util.*;
         // Main class
         public class GFG {

             // Main driver method
             public static void main(String[] args)
             {

                 // Creating an empty TreeMap
                 Map<String, Integer> map = new TreeMap<>();

                 // Inserting custom elements in the Map
                 // using put() method
                 map.put("vishal", 10);
                 map.put("sachin", 30);
                 map.put("vaibhav", 20);

                 // Iterating over Map using for each loop
                 for (Map.Entry<String, Integer> e : map.entrySet())

                     // Printing key-value pairs
                     System.out.println(e.getKey() + " "
                                        + e.getValue());
             }

Performing Various Operations using Map Interface and HashMap Class

Since Map is an interface, it can be used only with a class that implements this interface.
Now, let’s see how to perform a few frequently used operations on a Map using the widely used HashMap class.
And also, after the introduction of Generics in Java 1.5, it is possible to restrict the type of
object that can be stored in the map.

Operation 1: Adding Elements

    In order to add an element to the map, we can use the put() method.
    However, the insertion order is not retained in the hashmap. Internally, for every element,
    a separate hash is generated and the elements are indexed based on this hash to make it more efficient.

    Example

        // Java program to demonstrate
        // the working of Map interface

        import java.util.*;
        class GFG {
            public static void main(String args[])
            {
                // Default Initialization of a
                // Map
                Map<Integer, String> hm1 = new HashMap<>();

                // Initialization of a Map
                // using Generics
                Map<Integer, String> hm2
                    = new HashMap<Integer, String>();

                // Inserting the Elements
                hm1.put(1, "Geeks");
                hm1.put(2, "For");
                hm1.put(3, "Geeks");

                hm2.put(new Integer(1), "Geeks");
                hm2.put(new Integer(2), "For");
                hm2.put(new Integer(3), "Geeks");

                System.out.println(hm1);
                System.out.println(hm2);
            }
        }

Operation 2: Changing Element

    After adding the elements if we wish to change the element, it can be done by again adding the element
    with the put() method. Since the elements in the map are indexed using the keys, the value of the key
    can be changed by simply inserting the updated value for the key for which we wish to change.

    Example

        // Java program to demonstrate
        // the working of Map interface

        import java.util.*;
        class GFG {
            public static void main(String args[])
            {

                // Initialization of a Map
                // using Generics
                Map<Integer, String> hm1
                    = new HashMap<Integer, String>();

                // Inserting the Elements
                hm1.put(new Integer(1), "Geeks");
                hm1.put(new Integer(2), "Geeks");
                hm1.put(new Integer(3), "Geeks");

                System.out.println("Initial Map " + hm1);

                hm1.put(new Integer(2), "For");

                System.out.println("Updated Map " + hm1);
            }
        }

Operation 3: Removing Elements

    In order to remove an element from the Map, we can use the remove() method.
    This method takes the key value and removes the mapping for a key from this map if it is present in the map.

    Example

        // Java program to demonstrate
        // the working of Map interface

        import java.util.*;
        class GFG {

            public static void main(String args[])
            {

                // Initialization of a Map
                // using Generics
                Map<Integer, String> hm1
                    = new HashMap<Integer, String>();

                // Inserting the Elements
                hm1.put(new Integer(1), "Geeks");
                hm1.put(new Integer(2), "For");
                hm1.put(new Integer(3), "Geeks");
                hm1.put(new Integer(4), "For");

                // Initial Map
                System.out.println(hm1);

                hm1.remove(new Integer(4));

                // Final Map
                System.out.println(hm1);
            }
        }
 </pre></p>
         <br>
         <iframe width="1280" height="622" src="https://www.youtube.com/embed/bOzD-WaQi0g" title="Play With Map Interface In Java | Map | HashMap | LinkedHashMap | TreeMap | NavigableMap" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>',
         0.95,
         0.95,
         'collections_framework_2');