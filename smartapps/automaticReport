/**
 *  automaticReport
 *
 *  Copyright 2015 Yves Racine
 *  linkedIn profile: ca.linkedin.com/pub/yves-racine-m-sc-a/0/406/4b/ 
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
 
import java.text.SimpleDateFormat
import groovy.json.JsonSlurper

definition(
    name: "automaticReport",
    namespace: "yracine",
    author: "Yves Racine",
    description: "This smartapp allows a ST user to generate daily or weekly report on their Automatic Connected vehicle",
    category: "My Apps",
	iconUrl: "https://www.automatic.com/_assets/images/favicons/favicon-32x32-3df4de42.png",
	iconX2Url: "https://www.automatic.com/_assets/images/favicons/favicon-96x96-06fd8c85.png",
	iconX3Url: "https://www.automatic.com/_assets/images/favicons/favicon-96x96-06fd8c85.png")

preferences {
	section("About") {
		paragraph "automaticReport, the smartapp that generates daily runtime reports about your Automatic connected vehicle"
		paragraph "Version 0.9\n\n" +
			"If you like this app, please support the developer via PayPal:\n\nyracine@yahoo.com\n\n" +
			"Copyright©2015 Yves Racine"
		href url: "http://github.com/yracine", style: "embedded", required: false, title: "More information...",
		description: "http://github.com/yracine"	}

	section("Generate daily or weekly report (maximum 7 days) for this Automatic Connected Vehicle") {
		input "automatic", "device.myAutomaticDevice", title: "Automatic?"

	}
	section("Start date for the report, format = YYYY-MM-DD") {
		input "givenStartDate", "text", title: "Beginning Date [default=yesterday]", required:false
	}        
	section("Start time for report HH:MM (24HR)") {
		input "givenStartTime", "text", title: "Beginning time [default=00:00]",  required:false	
	}        
	section("End date for the report = YYYY-MM-DD") {
		input "givenEndDate", "text", title: "End Date [default=today]", required:false
	}        
	section("End time for the report (24HR)" ) {
		input "givenEndTime", "text", title: "End time [default=00:00]", required:false
	}        
	section( "Notifications" ) {
		input "sendPushMessage", "enum", title: "Send a push notification?", metadata:[values:["Yes", "No"]], required: false
		input "phoneNumber", "phone", title: "Send a text message?", required: false
    }
	section("Detailed Notifications") {
		input "detailedNotif", "Boolean", title: "Detailed Notifications?",metadata:[values:["true", "false"]], required:false
    }
    
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	unschedule()    
	initialize()
}

def initialize() {

	subscribe(app, appTouch)
	generateReport()    
}

def appTouch(evt) {
	generateReport()
}


private def generateReport() {
	def msg
	String dateTime    

	String dateInLocalTime = new Date().format("yyyy-MM-dd", location.timeZone) 
	String timezone = new Date().format("zzz", location.timeZone)
	String dateAtMidnight = dateInLocalTime + " 00:00 " + timezone    
    log.debug("generateReport>date at Midnight in UTC= ${dateAtMidnight}")
	Date endDate = formatDate(dateAtMidnight) 
	Date startDate = endDate -1
    
	if (settings.givenStartDate) { 
		def givenStartTime=(settings.givenStartTime) ?:"00:00"    
		dateTime = givenStartDate + " " + givenStartTime + " " + timezone
		log.debug( "Start datetime= ${dateTime}" )
 		startDate = formatDate(dateTime)
	}
    
    if (settings.givenEndDate) {
		def givenEndTime=(settings.givenEndTime) ?:"00:00"    
		dateTime = givenEndDate  + " " + givenEndTime + " " + timezone
		log.debug( "End datetime= ${dateTime}" )
		endDate = formatDate(dateTime)
	}

	log.debug("generateReport>startDate in UTC = ${String.format('%tF %<tT',startDate)}," +
		"endDate in UTC= ${String.format('%tF %<tT', endDate)}")
	automatic.getTrips("","", startDate,endDate, null, 'true')
	def currentTripList = automatic.currentTripsList
	def tripFields =null   
	if (!currentTripList) {
		log.debug "generateReport> empty tripList exiting"
		return    	
	} 
	def tripList=currentTripList.toString().split(",")    
	log.debug "generateReport> tripList= $tripList"

	tripList.each {
		String tripId = it
		log.debug "generateReport> tripId= $tripId"
		automatic.getTrips("",tripId,null,null,null,'true')
		String tripData = automatic.currentTripsData
		if (!tripData) {
			return        
		}     
		try {
			tripFields = new JsonSlurper().parseText(tripData)   
//			log.debug("generateReport> vehicle_events=$tripFields.vehicle_events[0]")            
		} catch (e) {
			log.error("generateReport>tripData not formatted correctly or empty (exception $e), exiting")
			return
		} 
		String startAddress=tripFields.start_address.name
		String endAddress=tripFields.end_address.name        
		String eventCreatedAt
		def vehicleEvents=(tripFields?.vehicle_events instanceof List)?    
			tripFields?.vehicle_events[0]:
			tripFields?.vehicle_events
        
		vehicleEvents.each {
			def type = it.type        
			if (type == 'speeding') {
				eventCreatedAt=formatDateInLocalTime(it.started_at.substring(0,19)+ 'Z')
				def startDistance = it.start_distance_m
				def endDistance= it.end_distance_m
				float startPos= getDistance(startDistance)
				float endPos= getDistance(endDistance)                
				log.debug ("event startedAt: ${it.started_at}, eventCreatedInLocalTime=$eventCreatedAt, timezone=${tripFields.end_timezone}")
				def speed =it.velocity_kph
				float speedValue=getSpeed(speed)
				msg = "automaticReport>${automatic} was speeding (speed> ${speedValue.round()}${getSpeedScale()}) at ${eventCreatedAt} on trip ${tripId} from ${startAddress} to ${endAddress};" +
                	"start Trip Distance=${startPos.round()}${getDistanceScale()},end Trip Distance=${endPos.round()}${getDistanceScale()}"
				send msg
			}            
	        
			if (type =='hard_brake') {
				eventCreatedAt=formatDateInLocalTime(it.created_at.substring(0,19)+ 'Z')
				def gforce=it.g_force   
				def lon =it.lon
				def lat = it.lat                
				log.debug ("event createdAt: ${it.created_at}, eventCreatedInLocalTime=$eventCreatedAt, timezone=${tripFields.end_timezone}")
				msg = "automaticReport>${automatic} triggerred the ${type} event (gforce=${gforce}, lat=${lat},lon=${lon}) at ${eventCreatedAt} on trip ${tripId} from ${startAddress} to ${endAddress} "
				send msg            
			}                
			if (type=='hard_accel') {
				eventCreatedAt=formatDateInLocalTime(it.created_at.substring(0,19)+ 'Z')   
				def gforce=it.g_force                
				def lon =it.lon
				def lat = it.lat                
				log.debug ("event createdAt: ${it.created_at}, eventCreatedInLocalTime=$eventCreatedAt, timezone=${tripFields.end_timezone}")
				msg = "automaticReport>${automatic} triggerred the ${type} event (gforce=${gforce}, lat=${lat},lon=${lon}) at ${eventCreatedAt} on trip ${tripId} from ${startAddress} to ${endAddress} "
				send msg            
			}
		} /* end each vehicle Event */       
	} /* end each Trip List */
}

private def getSpeed(value) {
	if (!value) {
		return 0    
	}    
	if(getTemperatureScale() == "C"){
		return value
	} else {
		return milesToKm(value)
	}
}

private def getSpeedScale() {
	def scale= getTemperatureScale()
	if (scale == 'C') {
		return "kmh"
	}
	return "mph"
}

private def milesToKm(distance) {
	if (!distance) {
		return 0    
	}    
	return (distance * 1.609344) 
}

private def kmToMiles(distance) {
	if (!distance) {
		return 0    
	}    
	return (distance * 0.62137) 
}
private def getDistance(value) {
	if (!value) {
		return 0    
	}    
	def km = value/1000
	if (getTemperatureScale() == "C"){
		return km
	} else {
		return kmToMiles(km)
	}
}

private def getDistanceScale() {
	def scale= getTemperatureScale()
	if (scale == 'C') {
		return "km"
	}
	return "mi"
}

private String formatDateInLocalTime(dateInString, timezone='') {
	def myTimezone=(timezone)?TimeZone.getTimeZone(timezone):location.timeZone 
	if ((dateInString==null) || (dateInString.trim()=="")) {
		return (new Date().format("yyyy-MM-dd HH:mm:ss", myTimezone))
	}    
	SimpleDateFormat ISODateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
	Date ISODate = ISODateFormat.parse(dateInString)
	String dateInLocalTime =new Date(ISODate.getTime()).format("yyyy-MM-dd HH:mm:ss", myTimezone)
	return dateInLocalTime
}


private def formatDate(dateString) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm zzz")
	Date aDate = sdf.parse(dateString)
	return aDate
}

private send(msg) {
	if ( sendPushMessage != "No" ) {
		log.debug( "sending push message" )
		sendPush( msg )
       
	}
	if ( phoneNumber ) {
		log.debug( "sending text message" )
 		sendSms( phoneNumber, msg )
	}

	log.debug msg
}
