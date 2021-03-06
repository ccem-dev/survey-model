package org.ccem.otus.survey.template.item.fillingRules.validators.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.MaxDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;

public class MaxDateTest {

	private MaxDate maxDate;
	private JsonObject json;

	@Before
	public void setUp() {
		json = mockJson();

		maxDate = SurveyTemplate.getGsonBuilder().create().fromJson(json, MaxDate.class);
	}

	@Test
	public void should_deserialize_correctly_MinDate() {
		assertEquals("StudioObject", maxDate.extents);
		assertEquals("Rule", maxDate.objectType);
		assertTrue(maxDate.data.canBeIgnored);
		assertEquals("maxDate", maxDate.validatorType);
		assertEquals("2017-02-17 00:00:00.000", maxDate.data.reference.getFormattedValue());
	}

	private JsonObject mockJson() {
		json = new JsonObject();
		json.addProperty("extends", "StudioObject");
		json.addProperty("objectType", "Rule");
		json.addProperty("validatorType", "maxDate");
		json.add("data", getData());

		return json;
	}

	private JsonObject getData() {
		JsonObject reference = new JsonObject();
		reference.addProperty("objectType", "ImmutableDate");
		reference.addProperty("value", "2017-02-17 00:00:00.000");

		JsonObject data = new JsonObject();
		data.addProperty("canBeIgnored", true);
		data.add("reference", reference);

		return data;
	}

}
