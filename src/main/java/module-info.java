import io.github.zabuzard.prototojson.api.ProtoToJson;
import io.github.zabuzard.prototojson.app.AppMain;

/**
 * API to convert binary protobuf messages to readable JSON, based on user provided protobuf descriptors. See {@link
 * ProtoToJson} for details.
 * <p>
 * Also offers a desktop application that wraps the APIs functionality, see {@link
 * AppMain}.
 */
module io.github.zabuzard.prototojson {
	requires com.google.protobuf;
	requires com.google.protobuf.util;
	requires com.google.gson;
	requires java.desktop;
	requires rsyntaxtextarea;

	exports io.github.zabuzard.prototojson.api;
	exports io.github.zabuzard.prototojson.app;
}