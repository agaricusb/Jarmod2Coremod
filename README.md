Jarmod2Coremod - a coremod to load jarmods

1. Install jarmod2coremod in "coremods"
2. Place your jarmods in "jarmods" in "CLIENT" or "SERVER" subfolders, as appropriate
3. Start Minecraft and see if your jarmods load

Important Notes:

* Rename the jarmods to control their loader, they will be sorted alphabetically before loading
* If you have trouble, test by installing jarmods into the jar instead
* **Before reporting issues in Jarmod2Coremod, test the same jarmods installed normally, without Jarmod2Coremod -- Jarmod2Coremod does not and cannot add jarmod compatibility where there is none, it only eases jarmod installation**

Compilation:

* Install [Maven](http://maven.apache.org/)
* `mvn initialize -P -built`
* `mvn package`

Downloads:

Latest release: https://bitbucket.org/agaricusb/jarmod2coremod/downloads/AAA-Jarmod2Coremod-1.0.jar

Development builds available at Buildhive: [![Build Status](https://buildhive.cloudbees.com/job/agaricusb/job/Jarmod2Coremod/badge/icon)](https://buildhive.cloudbees.com/job/agaricusb/job/Jarmod2Coremod/)

