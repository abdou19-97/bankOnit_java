
ATM.class: ATM.java User.class
	javac -g ATM.java

User.class: User.java Savings.class Checking.class
	javac -g User.java
Savings.class: Savings.java Checking.class
	javac -g Savings.java
Checking.class: Checking.java
	javac -g Checking.java
clean:
	rm *.class

run: ATM.class
	java ATM

debug: ATM.class
	jdb ATM
