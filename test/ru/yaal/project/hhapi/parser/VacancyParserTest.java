package ru.yaal.project.hhapi.parser;

import org.junit.Test;
import ru.yaal.project.hhapi.HhConstants;
import ru.yaal.project.hhapi.loader.FakeContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.search.VacanciesList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class VacancyParserTest {
    @Test
    public void test() throws LoadException {
        IContentLoader loader = new FakeContentLoader();
        String content = loader.loadContent(HhConstants.VACANCIES_URL);
        IParser<VacanciesList> parser = new VacancyParser();
        VacanciesList vacancies = parser.parse(content);
        assertNotNull(vacancies);
        assertTrue(290000 < vacancies.getFound());
        assertTrue(20 == vacancies.getItems().size());
    }

}
