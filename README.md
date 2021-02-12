# ProtoToJson
[![maven-central](https://img.shields.io/maven-central/v/io.github.zabuzard.prototojson/prototojson)](https://img.shields.io/maven-central/v/io.github.zabuzard.prototojson/prototojson) [![javadoc](https://javadoc.io/badge2/io.github.zabuzard.prototojson/prototojson/javadoc.svg)](https://javadoc.io/doc/io.github.zabuzard.prototojson/prototojson) [![Java](https://img.shields.io/badge/Java-11%2B-ff696c)](https://img.shields.io/badge/Java-11%2B-ff696c) [![license](https://img.shields.io/github/license/Zabuzard/ProtoToJson)](https://img.shields.io/github/license/Zabuzard/ProtoToJson)

ProtoToJson is a tool to decode and view binary protobuf messages
as readable JSON.

It is able to decode any message, provided a descriptor of its
protobuf schema was put into its cache.

The tool offers an API as well as a small desktop application.

# Requirements

* Requires at least **Java 11**

# Download

Maven:

```xml
<dependency>
   <groupId>io.github.zabuzard.prototojson</groupId>
   <artifactId>prototojson</artifactId>
   <version>1.1</version>
</dependency>
```

Jar downloads are available from the [release section](https://github.com/ZabuzaW/ProtoToJson/releases).

# Documentation

* [API Javadoc](https://javadoc.io/doc/io.github.zabuzard.prototojson/prototojson)
  or alternatively from the [release section](https://github.com/ZabuzaW/ProtoToJson/releases)

# Descriptor cache

In order to decode protobuf messages, the tool uses protobuf descriptor files
which have to be provided in its cache. The cache for the desktop application is located at
```
%LOCALAPPDATA%\ProtoToJson\descriptorCache
```

Such descriptor files `foo.desc` can be obtained by executing
```
protoc --descriptor_set_out foo.desc foo.proto
```
on the protobuf schema `foo.proto`. However, this requires
the [protobuf compiler protoc](https://developers.google.com/protocol-buffers)
to be installed.

# Developer API

The module exports the package
```
de.zabuza.prototojson.api;
```
which contains an API `ProtoToJson.java` that can be used as Java library as well.
An example usage could be:
```java
DescriptorCache cache = DescriptorCache.fromDirectory(Path.of("descriptorCache"));
ProtoToJson protoToJson = ProtoToJson.fromCache(cache);

String json = protoToJson.toJson(Path.of("someProtoMessage.message"));
```

# Desktop application

Upon launch, the application reads its descriptor cache located at
```
%LOCALAPPDATA%\ProtoToJson\descriptorCache
```
If it was started with an argument, the first argument will be interpreted as path
to a binary protobuf message file to decode. Otherwise, the user is prompted to select one.

![Select file dialog](https://i.imgur.com/82keZOg.png)

The tool then decodes the message into JSON, provided a corresponding descriptor was found,
and displays the result in a text editor window.

![Decoded message](https://i.imgur.com/EcrpK72.png)
