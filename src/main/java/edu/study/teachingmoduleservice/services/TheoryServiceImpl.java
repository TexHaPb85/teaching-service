package edu.study.teachingmoduleservice.services;

import edu.study.teachingmoduleservice.domain.study.TaskMaterial;
import edu.study.teachingmoduleservice.domain.study.TheoryMaterial;
import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.domain.user.UserAccount;
import edu.study.teachingmoduleservice.repository.AccountTaskRelationRepository;
import edu.study.teachingmoduleservice.repository.TheoryRepository;
import edu.study.teachingmoduleservice.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

    public void graduateTheoryComplexity(Float grade, String theoryId, User user) {
        TheoryMaterial theoryMaterial = theoryRepository.findById(theoryId).get();
        int numberOfGrades = 17;
        Float oldComplexity = theoryMaterial.getComplexityValue();
        Float complexitySetByAuthor = theoryMaterial.getDefaultComplexityValue();
        Float abs = Math.abs(user.getAccount().getRateValue()-oldComplexity);
        Float newComplexity = complexitySetByAuthor + oldComplexity * numberOfGrades * abs + grade
                                                 / numberOfGrades * abs + 2;

        theoryMaterial.setComplexityValue(newComplexity);
    }

    public TheoryMaterial getTheoryByTopic(String topicId, UserAccount userAccount) {
        List<TheoryMaterial> allTopicScopedTheory = theoryRepository.findAll().stream()
                .filter(theoryMaterial -> topicId.equals(theoryMaterial.getParentTopic().getTopicId()))
                .collect(Collectors.toList());

        TheoryMaterial theoryWithSuitableComplexity = allTopicScopedTheory.get(0);
        Float complexityRateDiffOfSuitableTheory = Math
                .abs(theoryWithSuitableComplexity.getComplexityValue() - userAccount.getRateValue());

        for (TheoryMaterial theoryMaterial : allTopicScopedTheory) {
            Float complexityRateDiff = Math.abs(theoryMaterial.getComplexityValue() - userAccount.getRateValue());
            if (complexityRateDiff < complexityRateDiffOfSuitableTheory) {
                complexityRateDiffOfSuitableTheory = complexityRateDiff;
                theoryWithSuitableComplexity = theoryMaterial;
            }
        }

        return theoryWithSuitableComplexity;
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
