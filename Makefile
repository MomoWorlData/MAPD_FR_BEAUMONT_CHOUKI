# Default target
all: help

# Compile the project
compile:
	mvn compile

# Run tests
test:
	mvn test 

# Run the main class
run:
	mvn exec:java -Dexec.mainClass="io.github.leobeaumont.Main"

# Clean build artifacts
clean:
	mvn clean

# Open documentation
doc:
	xdg-open doc/index.html

# Show help message
help:
	@echo "make compile: compile classes"
	@echo "make test:    run tests"
	@echo "make run:     run Main"
	@echo "make clean:   clean build artifact"
	@echo "make doc:     open documentation"
	@echo "make help:    show this"

.PHONY: all compile test run clean doc
