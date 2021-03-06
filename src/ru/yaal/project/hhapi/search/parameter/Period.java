package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

import static java.lang.String.format;

/**
 * ������ ������ ��������: �� ������� ���� ������ ��������.
 * �������� 30 ���� (����������� HeadHunter).
 */
public final class Period implements ISearchParameter {
    public static final int MIN_PERIOD = 1;
    public static final int MAX_PERIOD = 30;
    private Integer period;

    /**
     * ������ ������ ��������: �� ������� ���� ������ ��������.
     *
     * @param period ������ ������ ��������. �������� 30 ���� (����������� HeadHunter).
     */
    public Period(Integer period) throws SearchException {
        setPeriod(period);
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.PERIOD, String.valueOf(getPeriod()));
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) throws SearchException {
        if (period < MIN_PERIOD || period > MAX_PERIOD) {
            throw new SearchException(
                    format("������������ ������. ��������� %d-%d. �������� %d.", MIN_PERIOD, MAX_PERIOD, period));
        }
        this.period = period;
    }

    @Override
    public String getSearchParameterName() {
        return "������";
    }
}
