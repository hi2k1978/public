JAVAC=javac
JAVA=java
JAVADOC=javadoc
JAVADOC_DIR=html
JAVADOC_SUBPACKAGES=item:sorter
SRC=Main.java
BIN=$(SRC:.java=)

all: build
.PHONY: all

clean:
	@find . -name "*.class" | xargs rm
.PHONY: clean

build:
	$(JAVAC) -Xlint $(SRC)
.PHONY: build

run:
	$(JAVA) $(BIN)
.PHONY: run

doc:
	$(JAVADOC) -d $(JAVADOC_DIR) -subpackages $(JAVADOC_SUBPACKAGES) $(SRC)
.PHONY: doc
