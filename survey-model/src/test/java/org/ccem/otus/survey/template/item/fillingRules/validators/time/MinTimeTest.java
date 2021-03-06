package org.ccem.otus.survey.template.item.fillingRules.validators.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.time.MinTime;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;

public class MinTimeTest {
	
	private MinTime minTime;
	private JsonObject json;

	@Before
	public void setUp() {
		json = mockJson();

		minTime = SurveyTemplate.getGsonBuilder().create().fromJson(json, MinTime.class);
	}

	@Test
	public void should_deserialize_correctly_MinDate() {
		assertEquals("StudioObject", minTime.extents);
		assertEquals("Rule", minTime.objectType);
		assertTrue(minTime.data.canBeIgnored);
		assertEquals("minDate", minTime.validatorType);
		assertEquals("2017-02-16 01:00:00.000", minTime.data.reference.getFormattedValue());
	}

	private JsonObject mockJson() {
		json = new JsonObject();
		json.addProperty("extends", "StudioObject");
		json.addProperty("objectType", "Rule");
		json.addProperty("validatorType", "minDate");
		json.add("data", getData());

		return json;
	}

	private JsonObject getData() {
		JsonObject reference = new JsonObject();
		reference.addProperty("objectType", "ImmutableDate");
		reference.addProperty("value", "2017-02-16 01:00:00.000");

		JsonObject data = new JsonObject();
		data.addProperty("canBeIgnored", true);
		data.add("reference", reference);

		return data;
	}

}
