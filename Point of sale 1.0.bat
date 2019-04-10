@ECHO OFF
set path="C:\Program Files\Java\jdk-11\bin";
TITLE Point of sale
javac -d class ./src/*.java


set CLASSPATH=.\class
java Main

PAUSE