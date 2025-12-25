package com.graphql.quote.resolver;

import com.graphql.quote.dto.QuoteDTO;
import com.graphql.quote.dto.QuoteNumber;
import com.graphql.quote.service.QuoteService;
import com.graphql.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
public class QuoteResolver {

    private final QuoteService quoteService;

    @QueryMapping("getQuotes")
    public List<QuoteDTO> getQuotes() {
        return quoteService.getQuotes();
    }

    @BatchMapping(typeName = "Quote", field = "quoteNumber")
    public List<List<QuoteNumber>> quoteNumber(List<QuoteDTO> quotes) {
        log.info("Batch mapping for quotesNumber called for {} quotes", quotes.size());
         return quotes.stream().map(QuoteDTO::getId)
                 .map(id -> Arrays.asList(QuoteNumber.builder().quoteNumber(Util.getQuoteNumber(id.toString())).build())).collect(Collectors.toList());
    }

}
