### oo_boot_camp_template_kotlin

Copyright (c) 2025-26 by Fred George  
author: Fred George  fredgeorge@acm.org  
May be used freely except for training; license required for training.

## OO Boot Camp starting template for Kotlin class

Kotlin is relatively easy to setup with IntelliJ IDEA.
Gradle is used for building and testing the project, and is a
prerequisite. Install if necessary.
The following instructions are for installing the code 
in IntelliJ IDEA by JetBrains. 
Adapt as necessary for your environment.

Note: This implementation was set up to use:

- IntelliJ 2025.3.1.1 (Ultimate Edition)
- Kotlin 2.3.0 (targeting Java 21 bytecode)
- Java SDK 25 LTS (Oracle)
- Gradle 9.2.1
- JUnit Jupiter 6.0.1 for testing

Open the reference code:

- Download the source code from github.com/fredgeorge
    - Clone, or pull and extract the zip
- Open IntelliJ
- Choose "Open" (it's a Gradle project)
- Navigate to the reference code root, and enter

Source and test directories should already be tagged as such,
with test directories in green.

Confirm that everything builds correctly (and necessary libraries exist).
There should be errors in RectangleTest.
Fixing them is the first exercise!

Several settings may need to be manually changed if using IntelliJ IDEA:

- In File - Project Structure - Project Settings - Project, set SDK to 25 (or whatever you earlier SDK)
- In File - Settings - Build, Execution, Deployment - Compiler - Kotlin Compiler, set Target JVM version to 21
- In File - Settings - Build, Execution, Deployment - Build Tools - Gradle, set Gradle JVM to JAVA_HOME or explicitly
