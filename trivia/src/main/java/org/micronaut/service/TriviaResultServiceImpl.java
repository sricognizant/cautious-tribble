package org.micronaut.service;

import org.micronaut.Utils;
import org.micronaut.domain.Response;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;
import org.micronaut.repository.TriviaResultRepository;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

import static org.micronaut.Utils.dateFormat;


@Singleton
public class TriviaResultServiceImpl implements TriviaResultService {

    private TriviaResultRepository triviaResultRepository;

    public TriviaResultServiceImpl(TriviaResultRepository triviaResultRepository) {
        this.triviaResultRepository = triviaResultRepository;
    }

    @Override
    public ResultAttempt postTriviaResults(ResultAttempt resultAttempt) {
        return triviaResultRepository.save(resultAttempt);
    }

    // cant pass unit test
    @Override
    public List<ResultAttemptDTO> getResults(long userId) {

        List<ResultAttempt> resultAttempts = triviaResultRepository.findByUserId(userId);

        List<ResultAttemptDTO> resultAttemptDTOS  = resultAttemptDTOList(resultAttempts);

        return resultAttemptDTOS;
    }

    @Override
    public List<ResultAttemptDTO> resultAttemptDTOList(List<ResultAttempt> resultAttempts) {
        List<ResultAttemptDTO> resultAttemptDTOS = new LinkedList<>();
        for (ResultAttempt resultAttempt : resultAttempts) {
            String date = dateFormat(resultAttempt.getLocalDateTime());

            ResultAttemptDTO resultAttemptDTO = new ResultAttemptDTO(
                    resultAttempt.getUserId(),
                    date, resultAttempt.getQuestion(), resultAttempt.getAnswer(),
                    String.valueOf(resultAttempt.isCorrect())
            );

            resultAttemptDTOS.add(resultAttemptDTO);
        }

        return resultAttemptDTOS;
    }

    @Override
    public int checkResponse(Response response) {
        String[] choiceArray = response.getChoices().split("\\|");
        return choiceArray[response.getCorrectAnswer()].equals(response.getAnswer()) ? 1 : 0;
    }

    @Override
    public ResultAttemptDTO resultAttemptDTO(ResultAttempt resultAttempt) {

        String date = dateFormat(resultAttempt.getLocalDateTime());

        ResultAttemptDTO resultAttemptDTO = new ResultAttemptDTO(resultAttempt.getUserId(),
                date, resultAttempt.getQuestion(), resultAttempt.getAnswer(),
                String.valueOf(resultAttempt.isCorrect())
        );

        return resultAttemptDTO;
    }
}
