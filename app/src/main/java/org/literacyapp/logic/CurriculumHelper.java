package org.literacyapp.logic;

import android.content.Context;
import android.util.Log;

import org.literacyapp.LiteracyApplication;
import org.literacyapp.dao.LetterDao;
import org.literacyapp.dao.NumberDao;
import org.literacyapp.model.Student;
import org.literacyapp.model.content.Letter;
import org.literacyapp.model.content.Number;
import org.literacyapp.model.enums.content.LiteracySkill;
import org.literacyapp.model.enums.content.NumeracySkill;

import java.util.ArrayList;
import java.util.List;

public class CurriculumHelper {

    public static final int INITIAL_LETTER_COUNT = 3;

    public static final int INITIAL_NUMBER_COUNT = 3;

    private LetterDao letterDao;

    private NumberDao numberDao;

    public CurriculumHelper(Context context) {
        Log.i(getClass().getName(), "CurriculumHelper");

        LiteracyApplication literacyApplication = (LiteracyApplication) context;
        letterDao = literacyApplication.getDaoSession().getLetterDao();
        numberDao = literacyApplication.getDaoSession().getNumberDao();
    }

    /**
     * If the Student has not yet been identified, use {@code null} as parameter to fall back to
     * default list.
     */
    public List<Letter> getAvailableLetters(Student student) {
        Log.i(getClass().getName(), "getAvailableLetters");

        List<Letter> letters = new ArrayList<>();

        if (student == null) {
            // TODO: check for learning events
            // Student not yet identified. Fall back to default list.
            letters = letterDao.queryBuilder()
                    .orderDesc(LetterDao.Properties.UsageCount)
                    .orderAsc(LetterDao.Properties.Text)
                    .limit(INITIAL_LETTER_COUNT)
                    .list();
        } else {
            // Build list based on Student's current level.
            // TODO
            throw new UnsupportedOperationException("Not yet implemented");
        }

        return letters;
    }

    /**
     * If the Student has not yet been identified, use {@code null} as parameter to fall back to
     * default list.
     */
    public List<Number> getAvailableNumbers(Student student) {
        Log.i(getClass().getName(), "getAvailableNumbers");

        List<Number> numbers = new ArrayList<>();

        if (student == null) {
            // TODO: check for learning events
            // Student not yet identified. Fall back to default list.
            numbers = numberDao.queryBuilder()
                    .where(NumberDao.Properties.Value.notEq(0))
                    .orderAsc(NumberDao.Properties.Value)
                    .limit(INITIAL_NUMBER_COUNT)
                    .list();
        } else {
            // Build list based on Student's current level.
            // TODO
            throw new UnsupportedOperationException("Not yet implemented");
        }

        return numbers;
    }

    /**
     * If the Student has not yet been identified, use {@code null} as parameter to fall back to
     * default list.
     */
    public List<LiteracySkill> getAvailableLiteracySkills(Student student) {
        Log.i(getClass().getName(), "getAvailableLiteracySkills");

        List<LiteracySkill> literacySkills = new ArrayList<>();

        if (student == null) {
            // TODO: check for learning events
            // Student not yet identified. Fall back to default list.
            literacySkills.add(LiteracySkill.ORAL_VOCABULARY);
            literacySkills.add(LiteracySkill.LISTENING_COMPREHENSION);
            literacySkills.add(LiteracySkill.CONCEPTS_ABOUT_PRINT);
            literacySkills.add(LiteracySkill.PHONEMIC_AWARENESS);
            literacySkills.add(LiteracySkill.LETTER_IDENTIFICATION);
        } else {
            // Build list based on Student's current level.
            // TODO
            throw new UnsupportedOperationException("Not yet implemented");
        }

        return literacySkills;
    }

    /**
     * If the Student has not yet been identified, use {@code null} as parameter to fall back to
     * default list.
     */
    public List<NumeracySkill> getAvailableNumeracySkills(Student student) {
        Log.i(getClass().getName(), "getAvailableNumeracySkills");

        List<NumeracySkill> numeracySkills = new ArrayList<>();

        if (student == null) {
            // TODO: check for learning events
            // Student not yet identified. Fall back to default list.
            numeracySkills.add(NumeracySkill.ORAL_COUNTING);
            numeracySkills.add(NumeracySkill.ONE_TO_ONE_CORRESPONDENCE);
            numeracySkills.add(NumeracySkill.NUMBER_IDENTIFICATION);
        } else {
            // Build list based on Student's current level.
            // TODO
            throw new UnsupportedOperationException("Not yet implemented");
        }

        return numeracySkills;
    }
}
