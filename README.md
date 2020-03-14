# Gradle Testing 

Minimal project with gradle to understand the basics.

Execute build;
```shell 
$ gradle build
```

Execute Tests
```shell
$ gradle test
```

Test a particular class
```java
$ gradle test --tests SomeClass
```

Clean Build directories
```
$ gradle clean
``` 

Check for installed depencies:
```gradle
$ gradle dependencies
$ gradle dependencies --configuration compile/testCompile
```

### Project structure

```text
/SomeApp
    ├──/build.gradle
    ├──/src
    |   └──/org
    |   	└──/rogamba
    |			└──/SomeClass.java
    └──/tst
        └──/org
            └──/rogamba
                └──/SomeClass.java
```

### Adding Gradle to a project

To add gradle to your project, you need to first add the build.gradle file to your project root. To specify the root directories for main and tests, add the lines:
```groovy
sourceSets {
  main { java.srcDirs = ['main'] }
  main { java.srcDirs = ['test'] }
}
```

Code and build. Then run it with:
```shell
$ java -cp ':build/libs/ProjectClass.jar' org.rgamba.projectname.ProjectClass
```

### Building a fat jar

In order to build a .jar file that contains all of it's dependencies (fat jar), we have to specify it inside the build.gradle file adding these a lines:

```groovy
// Where the main method of the application resides
mainClassName = 'org.rogamba.project.MainClass'
// Here we set the manifest main class attribute and include the dependencies
jar {
    manifest {
        attributes 'Main-Class' : 'org.rogamba.gradleproject.GradleProject'
    }
    from {
      	// This can also be the runtimeClasspath, depending the use case
        configurations.compileClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }
}
```

To execute the fat-jar:
```shell
$ java -jar build/libs/filename.jar
```


### Essentials of the build.gradle file:

```groovy
sourceSets {
    main { java.srcDirs = ['src'] }
    // We need to specify the test directory 
    // for the classpath.
    test { java.srcDirs = ['tst'] }
}

dependencies {
    // ... other stuff
    testImplementation 'junit:junit:4.12'
}

test {
    useJUnit()
    // We can filter test here
    includeTestsMatching "org.gradle.internal.*"
}
```