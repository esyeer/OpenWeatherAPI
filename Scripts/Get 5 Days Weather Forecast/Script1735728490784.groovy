import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.RequestObject
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
import static org.assertj.core.api.Assertions.*

//Create request with parameter lat, lon, and appid
def requestObject = findTestObject('Get5daysWeatherForcest',[
    'lat' : GlobalVariable.lat,
	'lon' : GlobalVariable.lon,
    'appid' : GlobalVariable.API_KEY
	])

// Get the base URL from the test object
def baseURL = requestObject.getRestUrl()

// Append parameters to the base URL
requestObject.setRestUrl(baseURL + "?lat=${GlobalVariable.lat}&lon=${GlobalVariable.lon}&appid=${GlobalVariable.API_KEY}")

//println("Request URL: " + requestObject.getRestUrl())

//send API request
def response = WS.sendRequest(requestObject)

//verify the status code
WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

// Parse response
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

//assert city name
assert jsonResponse.city.name == 'Rawa Barat'

//assert country
assert jsonResponse.city.country == 'ID'

//assert latitude
assert jsonResponse.city.coord.lat == -6.2838

//assert Longitude
assert jsonResponse.city.coord.lon == 106.8049

//assert list data
assert jsonResponse.list != null : "Weather list is null"
assert jsonResponse.list.size() > 0 : "Weather list is empty"

//// assert response body each item !=null
jsonResponse.list.each { item ->
	assert item.dt != null : "Missing 'dt'"
	assert item.main != null : "Missing 'main'"
	assert item.weather != null : "Missing 'weather'"
	assert item.weather.main != null : "Missing 'weather' main"
	assert item.wind != null : "Missing 'wind'"
	assert item.clouds != null : "Missing 'clouds'"
}

KeywordUtil.markPassed("5 Day Weather Forecast validation passed.")