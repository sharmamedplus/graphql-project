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
        quoteDTO.setId(UUID.fromString("a279e697-7048-4d5c-8ab4-d5f95b72f6fa"));

        UUID[] orgs = new UUID[]{UUID.randomUUID(), UUID.randomUUID()};
        quoteDTO.setOrgs(orgs);
        quoteDTO.setPrice(BigDecimal.valueOf(100));
        quoteDTO.setScore(0.85f);
        quoteDTO.setCreated(LocalDateTime.now());
        Map attributes =  new HashMap<>();
        attributes.put("Author", "Vijay Sharma");
        quoteDTO.setAttributes(attributes);
        quoteDTO.setSubjects(Arrays.asList(QuoteDTO.Subject.builder().name("Hindi").language("English").build()));

        QuoteDTO quoteDTO2 = new QuoteDTO();
        quoteDTO2.setId(UUID.fromString("aa9dccd5-2713-4549-b577-9e728fcfc3ad"));

        UUID[] orgs2 = new UUID[]{UUID.randomUUID(), UUID.randomUUID()};
        quoteDTO2.setOrgs(orgs2);
        quoteDTO2.setPrice(BigDecimal.valueOf(100));
        quoteDTO2.setScore(0.85f);
        quoteDTO2.setCreated(LocalDateTime.now());
        Map attributes2 =  new HashMap<>();
        attributes2.put("Author", "Vijay Sharma");
        quoteDTO2.setAttributes(attributes2);
        quoteDTO2.setSubjects(Arrays.asList(QuoteDTO.Subject.builder().name("Maths").language("English").build()));

        return List.of(quoteDTO, quoteDTO2);
    }
}
