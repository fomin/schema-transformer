package io.github.fomin.oasgen.java.jackson

import io.github.fomin.oasgen.JsonSchema
import io.github.fomin.oasgen.JsonType

class ArrayConverterMatcher : ConverterMatcher {
    override fun match(converterRegistry: ConverterRegistry, jsonSchema: JsonSchema): ConverterWriter? {
        return when (jsonSchema.type) {
            is JsonType.ARRAY -> object : ConverterWriter {
                private val itemsSchema = jsonSchema.items()
                        ?: error("array schema should have items schema at $jsonSchema")

                override val jsonSchema = jsonSchema

                override fun valueType() =
                        "java.util.List<${converterRegistry[itemsSchema].valueType()}>"

                override fun parserCreateExpression() =
                        "new io.github.fomin.oasgen.ArrayParser<>(${converterRegistry[itemsSchema].parserCreateExpression()})"

                override fun writerCreateExpression() =
                        "new io.github.fomin.oasgen.ArrayWriter<>(${converterRegistry[itemsSchema].writerCreateExpression()})"

                override fun generate(): ConverterWriter.Result {
                    return ConverterWriter.Result(null, listOf(itemsSchema))
                }
            }
            else -> null
        }
    }
}
