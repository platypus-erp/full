package org.platypus.erp.rest.payload;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class PayloadModule extends SimpleModule {
    public PayloadModule() {
        super(PayloadModule.class.getSimpleName(), VersionUtil.versionFor(PayloadModule.class));
        addDeserializer(PayLoad.class, new CreatePayloadDeSerializer());
        addSerializer(PayLoad.class, new CreatePayloadSerializer());
    }

    public class CreatePayloadDeSerializer extends JsonDeserializer<PayLoad> {
        @Override
        public PayLoad deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            return RestPayLoad.fill(node, PayLoad::new);
        }
    }

    public class CreatePayloadSerializer extends JsonSerializer<PayLoad> {
        @Override
        public void serialize(PayLoad value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
            RestPayLoad.unFill(gen, value);
        }
    }
}
