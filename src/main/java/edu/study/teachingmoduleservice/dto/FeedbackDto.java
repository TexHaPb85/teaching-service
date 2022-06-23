package edu.study.teachingmoduleservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FeedbackDto {
    private Float gradeOfComplexity;
    private String comment;
    private String taskOfTheoryId;

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "gradeOfComplexity=" + gradeOfComplexity +
                ", comment='" + comment + '\'' +
                ", taskOfTheoryId='" + taskOfTheoryId + '\'' +
                '}';
    }
}
