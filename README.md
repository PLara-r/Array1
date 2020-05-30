# Builder разница между String и StringBuilder
10: String alpha = "";
11: for(char current = 'a'; current <= 'z'; current++)
12:  alpha += current;
13: System.out.println(alpha);

вывод  abcdefghijklmnopqrstuvwxyz
Пустой Stringв строке 10 создается, а затем строка 12 добавляет "a". 
Однако, поскольку Stringобъект является неизменным, новый Stringобъект назначается alphaи «»объект получает право на сборку мусора.
В следующий раз в цикле alphaназначается новый Stringобъект "ab", и "a"объект становится пригодным для сбора мусора.
Следующая итерация правопреемников alphaк "abc"и "ab"объект получает право на сбор мусора, и так далее.
Эта последовательность событий продолжается, и после 26 итераций цикла создается всего 27 объектов, 
большинство из которых сразу же пригодны для сборки мусора.
Это очень неэффективно. К счастью, у Java есть решение.
StringBuilderКласс создает Stringбез сохранения всех этих промежуточных Stringзначений.
В отличие от Stringкласса, StringBuilderне является неизменным.

аналогичный код для StringBuilder
15: StringBuilder alpha = new StringBuilder();
16: for(char current = 'a'; current <= 'z'; current++)
17:  alpha.append(current);
18: System.out.println(alpha);//abcdefghijklmnopqrstuvwxyz

В строке 15 создается новый StringBuilderобъект.
Вызов в append()строке 17 добавляет символ к StringBuilderобъекту
каждый раз через цикл for и добавляет значение current в конец alpha. 
Этот код повторно использует то же самое, StringBuilderне создавая промежуточный Stringкаждый раз.

4: StringBuilder a = new StringBuilder("abc");
5: StringBuilder b = a.append("de");
6: b = b.append("f").append("g");
7: System.out.println("a=" + a);
8: System.out.println("b=" + b);
вывод
a=abcdefg
b=abcdefg
 Здесь только один StringBuilderобъект. Мы знаем это, потому что new StringBuilder()звонили только один раз. В строке 5 есть две переменные, ссылающиеся на этот объект, который имеет значение "abcde". В строке 6 эти две переменные все еще ссылаются на тот же объект, который теперь имеет значение "abcdefg". Кстати, возвращение назад bничего не делает. bуже указывает на это StringBuilder.
