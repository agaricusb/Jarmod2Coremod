Jarmod2Coremod - a coremod to load jarmods

1. Install jarmod2coremod in "coremods"
2. Place your jarmods in "jarmods"
3. Start Minecraft and see if your jarmods load

Warning: experimental, may be buggy.

Important Notes:

* Rename jarmod2coremod to begin with "AAA-" to load before other coremods, if needed
* Rename the jarmods to control their loader, they will be sorted before loading
* If you have trouble, test by installing jarmods into the jar instead

Compilation:

* Install [Maven](http://maven.apache.org/)
* `mvn initialize -P -built`
* `mvn package`

Downloads:

* Latest builds available at Buildhive: [![Build Status](https://buildhive.cloudbees.com/job/agaricusb/job/Jarmod2Coremod/badge/icon)](https://buildhive.cloudbees.com/job/agaricusb/job/Jarmod2Coremod/)

