Example Maven project that shows:
* that modules ("projects") can have parent-child ("inheritance") relationships
* that modules can have dependency ("uses") relationships

Run mvn clean install and see
* how Maven downloads the external dependencies, those are stashed in ~/.m2/repository
* how the following goals are executed: clean, resources, compile, testResources, testCompile, test, jar, install

Compared to the Ant build-file, some stuff is already available but you need lots of code to override defaults
* run mvn javadoc:javadoc and see the generated report(s) in the target folder(s)
* run mvn checkstyle:checkstyle and see the generated report(s) in the target folder(s)