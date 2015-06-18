# Chattr [![Build Status](https://travis-ci.org/romejoe/Chattr.svg?branch=master)](https://travis-ci.org/romejoe/Chattr)

Another chat application, but with fine grain, pluggable encryption for chats and other cool things. 

## Installation

| Requirements |
| ------------ |
| JDK 8        |
| Maven        |

1. Download and install [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) from oracle.
  
	- Verify installation with `java -version`.
  
- Install Maven

		brew update && brew install maven 

- Install dependencies

		mvn clean install

- Run Chattr server/client

		java -jar Server/target/Server-1.0-SNAPSHOT.jar
		java -jar ThickClient/target/ThickClient-1.0-SNAPSHOT.jar
