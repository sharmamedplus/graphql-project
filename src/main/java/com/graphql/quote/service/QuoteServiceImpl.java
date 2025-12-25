package com.graphql.quote.service;

import com.graphql.quote.dto.QuoteDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class QuoteServiceImpl implements QuoteService {
    @Override
    public List<QuoteDTO> getQuotes() {
        QuoteDTO quoteDTO = new QuoteDTO();
        quoteDTO.setId(UUID.randomUUID());

        UUID[] orgs = new UUID[]{UUID.randomUUID(), UUID.randomUUID()};
        quoteDTO.setOrgs(orgs);
        quoteDTO.setPrice(BigDecimal.valueOf(100));
        quoteDTO.setScore(0.85f);
        quoteDTO.setCreated(LocalDateTime.now());
        Map attributes =  new HashMap<>();
        attributes.put("Author", "Vijay Sharma");
        quoteDTO.setAttributes(attributes);
        quoteDTO.setSubjects(Arrays.asList(QuoteDTO.Subject.builder().name("Hindi").language("English").build()));
        return List.of(quoteDTO);
    }
}
