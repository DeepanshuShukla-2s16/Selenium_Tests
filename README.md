
# ===================== How to Read Data from `.properties` File =====================

## What I Did:
1. Created a `.properties` file named `config.properties` inside the `testdata` folder in the project directory.
2. Added the key-value pairs in the file.
3. Created a class named ConfigUtils under the path src/test/java/learning/config/utils/.
   ### Key Steps in the Code:
   1. Create a Properties object to handle the key-value pairs.
   2. Locate the config.properties file using the FileInputStream and open it in reading mode.
   3. Load the key-value pairs from the file into the Properties object using properties.load() method.
   4. Use getProperty(key) to fetch specific values.

## Benefits:
1. Centralized configuration management.
2. Easy to update or change configurations without modifying the Java code.
