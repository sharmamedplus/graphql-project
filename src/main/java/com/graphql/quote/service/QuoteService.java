package com.graphql.quote.service;


import com.graphql.quote.dto.QuoteDTO;

import java.util.List;

public interface QuoteService {
    List<QuoteDTO> getQuotes();
}
