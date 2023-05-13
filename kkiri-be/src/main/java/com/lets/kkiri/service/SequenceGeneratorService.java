package com.lets.kkiri.service;

import com.lets.kkiri.entity.Sequence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Slf4j
@Service
@RequiredArgsConstructor
public class SequenceGeneratorService {
    private final MongoOperations mongoOperations;
    public Long generateSequence(String seqName) {
        Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true), Sequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}