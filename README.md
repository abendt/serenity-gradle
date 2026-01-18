# Serenity report generation issue

Sample project to reproduce issue with Serenity report generation.

Running the test `SerenityTest` via IntelliJ will successfully generate report files in the directory `target/site/serenity`.

```
$ ./gradlew clean
# run tests via IDE
$ ls target/site/serenity
52ba3c8e88ca68169a7eb29fb253d7bfe75b22c4b70523d35a748246eb14f0b3.json  SERENITY-JUNIT-52ba3c8e88ca68169a7eb29fb253d7bfe75b22c4b70523d35a748246eb14f0b3.xml
flow
```

This also works via gradle if `SerenityTest` is the only test to run or if it is the last test to run (e.g. `ATest` and `SerenityTest`). Delete `ZTest` and run the tests via gradle.

```
$ rm src/test/kotlin/demo/ZTest.k
$ ./gradlew clean test
$ ls target/site/serenity/
07c09750e569b1dfa79da442fbe84740409c173e88734424727457610d72d53d.json  SERENITY-JUNIT-07c09750e569b1dfa79da442fbe84740409c173e88734424727457610d72d53d.xml
52ba3c8e88ca68169a7eb29fb253d7bfe75b22c4b70523d35a748246eb14f0b3.json  SERENITY-JUNIT-52ba3c8e88ca68169a7eb29fb253d7bfe75b22c4b70523d35a748246eb14f0b3.xml
flow
```

However, adding after adding another test `ZTest` no reports will be generated!
Restore `ZTest` and run the tests via gradle.

```
$ git restore src/test/kotlin/demo/ZTest.k
$ ./gradlew clean test
$ ls target/site/serenity
"target/site/serenity/": No such file or directory (os error 2)
```