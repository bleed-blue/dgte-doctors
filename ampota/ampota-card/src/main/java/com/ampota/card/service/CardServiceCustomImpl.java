package com.ampota.card.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

import com.ampota.card.model.Card;
import com.ampota.card.util.CardParserUtil;
import com.ampota.shared.dto.card.CardInfo;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;

import xyz.xpay.shared.jpa.service.XpayJpaServiceCustomImpl;

public class CardServiceCustomImpl extends XpayJpaServiceCustomImpl<Card, CardInfo, CardService>
    implements CardServiceCustom {

    @PostConstruct
    public void loadCardsIfDatabaseEmpty() throws ParseException, FileNotFoundException, IOException {
        if (repo.count() > 0) {
            return;
        }
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(new ClassPathResource("scryfall-all-cards.json").getInputStream(), "UTF-8"));
        reader.beginArray();
        List<Card> cards = Lists.newArrayList();
        while (reader.hasNext()) {
            LinkedTreeMap<String, Object> jo = gson.fromJson(reader, LinkedTreeMap.class);
            cards.add(CardParserUtil.parseCard(jo));
        }
        reader.endArray();
        reader.close();
        repo.saveAll(cards);
    }

}