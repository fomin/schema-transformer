package io.github.fomin.oasgen;

public enum ObjectParserState {
    PARSE_START_OBJECT_OR_END_ARRAY_OR_NULL,
    PARSE_FIELD_NAME_OR_END_OBJECT,
    PARSE_FIELD_VALUE,
    FINISHED_VALUE,
    FINISHED_NULL,
    FINISHED_ARRAY,
}
