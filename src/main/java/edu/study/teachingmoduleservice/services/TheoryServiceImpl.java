package edu.study.teachingmoduleservice.services;

import edu.study.teachingmoduleservice.domain.study.TheoryMaterial;
import edu.study.teachingmoduleservice.repository.TheoryRepository;
import edu.study.teachingmoduleservice.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TheoryServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TheoryServiceImpl.class);
    private final TheoryRepository theoryRepository;
    private final TopicRepository topicRepository;

    public TheoryServiceImpl(TheoryRepository theoryRepository, TopicRepository topicRepository) {
        this.theoryRepository = theoryRepository;
        this.topicRepository = topicRepository;
    }

    public List<TheoryMaterial> getAllTheories() {
        try {
            LOGGER.info("getAllTheories method returns all theories");
            return theoryRepository.findAll();
        } catch (Exception e){
            LOGGER.error("exception is thrown in method getAllTheories");
            return Collections.emptyList();
        }
    }

    public TheoryMaterial getTheoryById(String theoryId){
        return theoryRepository.findById(theoryId).orElseThrow(NoSuchElementException::new);
    }

    public TheoryMaterial getTheoryByTopic(String topicId, String userId) {
        return  topicRepository.findById(topicId).get().getTheoryMaterials().get(1);
    }


    public void addTheory(TheoryMaterial theoryMaterial) {
        try {
            theoryRepository.save(theoryMaterial);
            LOGGER.info("addTheory method, saves theory with theoryId: {}", theoryMaterial.getTheoryId());
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method addTheory while saving theory with theoryId: {}", theoryMaterial.getTheoryId());
        }
    }

    public void removeTheory(String theoryId) {
        try {
            TheoryMaterial theoryMaterial = theoryRepository.findById(theoryId).orElseThrow(NoSuchElementException::new);
            theoryRepository.delete(theoryMaterial);
            LOGGER.info("removeTheory method, removes theory with theoryId: {}", theoryId);
        } catch (Exception e) {
            LOGGER.error("exception is thrown in method removeTheory while removing theory with theoryId: {}", theoryId);
        }
    }

}
