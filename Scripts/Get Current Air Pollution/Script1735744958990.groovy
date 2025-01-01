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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
import static org.assertj.core.api.Assertions.*

//Create request with parameter lat, lon, and appid
def requestObject = findTestObject('GetCurrentAirPollution',[
	'lat' : GlobalVariable.lat,
	'lon' : GlobalVariable.lon,
	'appid' : GlobalVariable.API_KEY
	])

// Get the base URL from the test object
def baseURL = requestObject.getRestUrl()

// Append parameters to the base URL
requestObject.setRestUrl(baseURL + "?lat=${GlobalVariable.lat}&lon=${GlobalVariable.lon}&appid=${GlobalVariable.API_KEY}")

//send API request
def response = WS.sendRequest(requestObject)

//assert the response status
assert response.getStatusCode() == 200 : "StatusCode expected '200' but was '${response.getStatusCode()}'"

// Parse response
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

//assert latitude
assert jsonResponse.coord.lat == -6.2838 : "Latitude expected '-6.2838' but was '${jsonResponse.coord.lat}'"

//assert Longitude
assert jsonResponse.coord.lon == 106.8049 : "Longitude expected '106.8049' but was '${jsonResponse.coord.lon}'"

//assert list contains data
assert jsonResponse.list != null : "Air pollution list is null"
assert jsonResponse.list.size() > 0 : "Air pollution list is empty"

// assert response body each item !=null
jsonResponse.list.each { item ->
    assert item.main != null : "Missing 'main'"
    assert item.main.aqi != null : "Missing 'aqi'"
    assert item.components != null : "Missing 'components'"
}

KeywordUtil.markPassed("Current Air Pollution Data validation passed.")