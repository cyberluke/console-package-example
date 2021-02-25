# Banking Software Company - Package Information App

1) Install Java from www.java.com
2) Open terminal and run 'java -jar banking-1.0.0-jar-with-dependencies.jar'
3) Then you can input weight (kg) and postal code separated by space, ie. '3.4 08801'
4) Every minute you will get a list of current packages

Optional program arguments:

'java -jar app.jar inputfile feefile'

You can add input file only or both input file with fee file. Examples are in /data folder.


# Developer documentation
The app has been tested in Eclipse IDE and Intellij IDEA. It is a classic Maven app and is using Lombok plugin.
IntelliJ IDEA has Lombok built-in. You just need to enable annotation processor. Eclipse setup is not that straightforward.
Official Lombok website mentions this blog article for quick setup: https://www.baeldung.com/lombok-ide

Runtime data is stored in ArrayList. Because only one thread is reading and only one thread is writing to this data structure, 
synchronization is made using Collections.synchronizedList. This provides efficient throughput for this use case as it will 
provide synchronization on a method level. If you need to perform more advanced operations, you could use data structures from Concurrent Java APIs
(for example ConcurrentHashMap). Display service is already transforming above mentioned synchronized ArrayList into a HashMap, 
so a change to ConcurrentHashMap is a matter of a small refactoring.

NOTE:
This code example is way too simple to employ design patterns, but there was at least try to use Crate design pattern 
(someone call it idiom, it is not mentioned in GoF, but you can Google it and it is mentioned in Rudolf Pecinovsky books).