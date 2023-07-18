﻿## Java_Core
Создать приложение с вложенностью пакетов не менее 3х, где будет класс для входа и несколько классов с логикой. Пример: приложение для внесения заметок во внешний файл с обязательной фиксацией времени
пример:
Введите заметку: Hello, world!
Дозапись в файл: 16.07.2023 -> Hello, world

### Скомпилируйте и запустите посредством CLI

#### команды в терминале:
1. javac -sourcepath ./src -d out src/ru/gb/jcore/regular/sample/Main.java

2. java -classpath ./out ru.gb.jcore.regular.sample.Main

3. javadoc -d docs -sourcepath ./src -cp ./out -subpackages ru


