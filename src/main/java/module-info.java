/**
 * API to convert binary protobuf messages to readable JSON, based on user provided protobuf descriptors. See {@link
 * de.zabuza.prototojson.pub.api.ProtoToJson} for details.
 * <p>
 * Also offers a desktop application that wraps the APIs functionality, see {@link
 * de.zabuza.prototojson.pub.app.AppMain}.
 */
module de.zabuza.prototojson {
	requires com.google.protobuf;
	requires com.google.protobuf.util;
	requires com.google.gson;
	requires java.desktop;
	requires rsyntaxtextarea;

	exports de.zabuza.prototojson.pub.api;
	exports de.zabuza.prototojson.pub.app;
}