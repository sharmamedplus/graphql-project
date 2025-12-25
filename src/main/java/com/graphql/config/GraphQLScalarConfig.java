package com.graphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Configuration
public class GraphQLScalarConfig {


    public static final GraphQLScalarType ZonedDateTimeScalar = GraphQLScalarType.newScalar()
            .name("DateTime")
            .description("Java DateTime type supporting both LocalDateTime and ZonedDateTime")
            .coercing(new Coercing<Object, String>() {
                @Override
                @NonNull
                public String serialize(@NonNull Object dataFetcherResult) throws CoercingSerializeException {
                    if (dataFetcherResult instanceof ZonedDateTime) {
                        return ((ZonedDateTime) dataFetcherResult).format(DateTimeFormatter.ISO_INSTANT);

                    } else if (dataFetcherResult instanceof LocalDateTime) {
                        return ((LocalDateTime) dataFetcherResult).atZone((ZoneId.systemDefault())).format(DateTimeFormatter.ISO_INSTANT);
                    }
                    throw new CoercingSerializeException("Expected a ZonedDateTime or LocalDateTime object but was " + dataFetcherResult.getClass().getName());
                }

                @Override
                @NonNull
                public Object parseValue(@NonNull Object input) throws CoercingParseValueException {
                    try {
                        if(input instanceof String) {
                            String dateString = (String) input;
                            if(dateString.endsWith("Z") || dateString.endsWith("+") || dateString.endsWith("-")) {
                                return ZonedDateTime.parse(dateString);
                            }else{
                                return LocalDateTime.parse(dateString);
                            }
                        }
                        throw  new CoercingParseValueException("Expected a String but was "+ input.getClass().getName());
                    } catch (DateTimeParseException e) {
                        throw new CoercingParseValueException("Invalid date format : " + input, e);
                    }
                }

                @Override
                public Object parseLiteral(@NonNull Object input) throws CoercingParseValueException{
                    try {
                        if(input instanceof String) {
                            String dateString = (String) input;
                            if(dateString.endsWith("Z") || dateString.endsWith("+") || dateString.endsWith("-")) {
                                return ZonedDateTime.parse(dateString);
                            }else{
                                return LocalDateTime.parse(dateString);
                            }
                        }
                        throw  new CoercingParseValueException("Expected a String but was "+ input.getClass().getName());
                    } catch (DateTimeParseException e) {
                        throw new CoercingParseValueException("Invalid date format : " + input, e);
                    }
                }
            })
            .build();

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .scalar(ExtendedScalars.Date)
                .scalar(ExtendedScalars.UUID)
                .scalar(ExtendedScalars.Currency)
                .scalar(ExtendedScalars.GraphQLBigDecimal)
                .scalar(ExtendedScalars.Json)
                .scalar(ZonedDateTimeScalar);
    }
}
