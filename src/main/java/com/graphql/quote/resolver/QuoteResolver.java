package com.graphql.quote.resolver;

import com.graphql.quote.dto.QuoteDTO;
import com.graphql.quote.service.QuoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class QuoteResolver {

    private final QuoteService quoteService;

    @QueryMapping("getQuotes")
    public List<QuoteDTO> getQuotes() {
        return quoteService.getQuotes();
    }

}
