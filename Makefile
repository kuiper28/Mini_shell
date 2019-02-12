.PHONY: build clean run
build:
	#mkdir classes;
	javac *.java
	#javac -cp classes src/*.java -d classes;
clean:
	rm *.class
