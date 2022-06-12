package edu.study.teachingmoduleservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AnswerDto {
    private String answerStr;

    @Override
    public String toString() {
        return "AnswerDto{" +
                "answer='" + answerStr + '\'' +
                '}';
    }
}
