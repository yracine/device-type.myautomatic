/**
 *  My Automatic Device
 *
 *  Copyright 2015 Yves Racine
 *  Version 0.9.6
 *  linkedIn profile: ca.linkedin.com/pub/yves-racine-m-sc-a/0/406/4b/
 *  Refer to readme file for installation instructions.
 *
 *  Code: https://github.com/yracine
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


// for the UI
preferences {
	input("vehicleId", "number", title: "vehicle [default=first Automatic vehicle found", description:
		"optional, the id of your Automatic connected vehicle (no spaces)")
	input("homeAddress", "text", title: "minimum Home Address info for presence settings", 
		description: "optional, ex. postal/zip code or street name, city")
	input("trace", "text", title: "trace", description:
		"Set it to true to enable tracing (no spaces) or leave it empty (no tracing)"
	)
    
}


metadata {
	definition (name: "My Automatic Device", namespace: "yracine", author: "Yves Racine") {
		capability "Refresh"
		capability "Polling"
		capability "Presence Sensor"

		command "poll"
		command "refresh"
		command "getCurrentUserInfo"
		command "getTrips"
		command "getVehicles"
		command "generateVehicleEvents"
		command "generateTripStats"
		command "generateVehicleRTEvents"        
        
		attribute "verboseTrace","string"
		
		attribute "userid","string"
		attribute "username", "string"
		attribute "email","string"
		attribute "firstName", "string"
		attribute "lastName", "string"
		attribute "vehicleId", "string"
		attribute "make","string"
		attribute "model", "string"
		attribute "submodel", "string"
		attribute "color","string"
		attribute "displayName", "string"
		attribute "year","string"

		attribute "locationId","string"
		attribute "timezone","string"

		attribute "tripsList","string"
		attribute "tripsData","string"


		attribute "tripsAvgAverageKmpl","string"
		attribute "tripsAvgDistanceM","string"
		attribute "tripsAvgDurationS","string"
		attribute "totalDistanceM","string"
		attribute "tripsAvgCostUsd", "string"
		attribute "tripsAvgFuelVolumeL","string"
		attribute "totalFuelVolumeL","string"
		attribute "totalCostUsd", "string"
		attribute "totalDurationS", "string"
		attribute "totalNbTrips", "string"
		attribute "totalHardAccels", "string"
		attribute "totalHardBrakes", "string"
		attribute "tripsAvgScoreSpeeding", "string"
		attribute "tripsAvgScoreEvents", "string"


		attribute "tripsAvgAverageKmplInPeriod","string"
		attribute "tripsAvgDistanceMInPeriod","string"
		attribute "tripsAvgDurationSInPeriod","string"
		attribute "totalDistanceMInPeriod","string"
		attribute "tripsAvgCostUsdInPeriod", "string"
		attribute "tripsAvgFuelVolumeLInPeriod","string"
		attribute "totalFuelVolumeLInPeriod","string"
		attribute "totalCostUsdInPeriod", "string"
		attribute "totalDurationSInPeriod", "string"
		attribute "totalAverageKmplInPeriod", "string"
		attribute "totalNbTripsInPeriod", "string"
		attribute "totalHardAccelsInPeriod", "string"
		attribute "totalHardBrakesInPeriod", "string"
		attribute "totalScoreSpeedingInPeriod", "string"
		attribute "totalScoreEventsInPeriod", "string"
		attribute "tripsAvgScoreSpeedingInPeriod", "string"
		attribute "tripsAvgScoreEventsInPeriod", "string"
		

		/* Stats for yesterday */
  
		attribute "yesterdayTripsAvgAverageKmpl","string"
		attribute "yesterdayTripsAvgDistanceM","string"
		attribute "yesterdayTripsAvgDurationS","string"
		attribute "yesterdayTotalDistanceM","string"
		attribute "yesterdayTripsAvgCostUsd", "string"
		attribute "yesterdayTripsAvgFuelVolumeL","string"
		attribute "yesterdayTotalFuelVolumeL","string"
		attribute "yesterdayTotalCostUsd", "string"
		attribute "yesterdayTotalDurationS", "string"
		attribute "yesterdayTotalNbTrips", "string"
		attribute "yesterdayTotalHardAccels", "string"
		attribute "yesterdayTotalHardBrakes", "string"
		attribute "yesterdayTripsAvgScoreSpeeding", "string"
		attribute "yesterdayTripsAvgScoreEvents", "string"

		/* Stats for the last 7 days (week) */
        
		attribute "weeklyTripsAvgAverageKmpl","string"
		attribute "weeklyTripsAvgDistanceM","string"
		attribute "weeklyTripsAvgDurationS","string"
		attribute "weeklyTotalDistanceM","string"
		attribute "weeklyTripsAvgCostUsd", "string"
		attribute "weeklyTripsAvgFuelVolumeL","string"
		attribute "weeklyTotalFuelVolumeL","string"
		attribute "weeklyTotalCostUsd", "string"
		attribute "weeklyTotatDurationS", "string"
		attribute "weeklyTotalNbTrips", "string"
		attribute "weeklyTotalHardAccels", "string"
		attribute "weeklyTotalHardBrakes", "string"
		attribute "weeklyTripsAvgScoreSpeeding", "string"
		attribute "weeklyTripsAvgScoreEvents", "string"


		/* Stats for the last 30 days (month) */
        
		attribute "monthlyTripsAvgAverageKmpl","string"
		attribute "monthlyTripsAvgDistanceM","string"
		attribute "monthlyTripsAvgDurationS","string"
		attribute "monthlyTotalDistanceM","string"
		attribute "monthlyTripsAvgCostUsd", "string"
		attribute "monthlyTripsAvgFuelVolumeL","string"
		attribute "monthlyTotalFuelVolumeL","string"
		attribute "monthlyTotalCostUsd", "string"
		attribute "monthlyTotalDurationS", "string"
		attribute "monthlyTotalNbTrips", "string"
		attribute "monthlyTotalHardAccels", "string"
		attribute "monthlyTotalHardBrakes", "string"
		attribute "monthlyTripsAvgScoreSpeeding", "string"
		attribute "monthlyTripsAvgScoreEvents", "string"

		attribute "eventVehicleId", "string"    
		attribute "eventType", "string"    
		attribute "eventTripId", "string"    
		attribute "eventTripDistanceM", "string"
		attribute "eventTripAvgFuelMPG", "string"
		attribute 'eventTripLocAccuracyM',"string"
		attribute "eventTripStartLocation", "string"
		attribute "eventTripEndLocation","string"
		attribute "eventTripStartAddress", "string"
		attribute "eventTripEndAddress","string"
		attribute "eventTripSpeedKPH","string"
		attribute "eventTripGForce","string"
		attribute "eventTripRegionStatus", "string"
		attribute "eventTripRegionName", "string"
		attribute "eventTripRegionTag","string"
		attribute "eventTripCode","string"
		attribute "eventTripDescription","string"
		attribute "eventTripLocationLat", "string"
		attribute "eventTripLocationLon", "string"
		attribute "eventTripStartedAt", "string"
		attribute "eventTripEndedAt", "string"
		attribute "eventTripcreatedAt", "string"

}

	simulator {
		// TODO: define status and reply messages here
	}

	// UI tile definitions
	tiles {
		valueTile(	"make", "device.make",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					icon: "st.Transportation.transportation2",
					label:'Make\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"model", "device.model",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					label:'Model\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"submodel", "device.submodel",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					label:'Submodel\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"year", "device.year",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					label:'Year\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
/*        
		valueTile(	"color", "device.color",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					label:'Color\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
*/        
		valueTile(	"tripsAvgAverageKmpl", "device.tripsAvgAverageKmpl",width: 1, height: 1,canChangeIcon: false,
 					decoration: "flat"
				) 
        	{
			state("default",
					label:'Avg\nConsmption\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"tripsAvgDistanceM", "device.tripsAvgDistanceM",width: 1, height: 1,canChangeIcon: false,
 					decoration: "flat"
				) 
        	{
			state("default",
					label:'Avg dist/trip\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"tripsAvgDurationS", "device.tripsAvgDurationS", unit:'min.',width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					label:'Avg time/trip\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"totalDistanceM", "device.totalDistanceM",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Total Distance\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"totalFuelVolumeL", "device.totalFuelVolumeL",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Fuel Volume\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"totalNbTrips", "device.totalNbTrips",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Total Trips\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"tripsAvgScoreSpeeding", "device.tripsAvgScoreSpeeding",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Avg Score Speed\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"tripsAvgScoreEvents", "device.tripsAvgScoreEvents",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Avg Score Events\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
        
		// yesterday tiles

		valueTile(	"yestripsAvgAverageKmpl", "device.yesterdayTripsAvgAverageKmpl",width: 1, height: 1,canChangeIcon: false,
 					decoration: "flat"
				) 
        	{
			state("default",
					label:'Yesterday Avg Cons\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"yestripsAvgDistanceM", "device.yesterdayTripsAvgDistanceM",width: 1, height: 1,canChangeIcon: false,
 					decoration: "flat"
				) 
        	{
			state("default",
					label:'Yesterday Avg dist/trip\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"yestripsAvgDurationS", "device.yesterdayTripsAvgDurationS", unit:'min.',width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					label:'Yesterday Avg time/trip\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"yestotalDistanceM", "device.yesterdayTotalDistanceM",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Yesterday Total Dist.\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}

		valueTile(	"yestotalFuelVolumeL", "device.yesterdayTotalFuelVolumeL",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Yesterday Fuel Vol.\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"yestotalNbTrips", "device.yesterdayTotalNbTrips",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Yesterday Total Trips\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"yestripsAvgScoreSpeeding", "device.yesterdayTripsAvgScoreSpeeding",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Yesterday Avg Score Speed\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"yestripsAvgScoreEvents", "device.yesterdayTripsAvgScoreEvents",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Yesterday Avg Score Events\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		// weekly tiles

		valueTile(	"weektripsAvgAverageKmpl", "device.weeklyTripsAvgAverageKmpl",width: 1, height: 1,canChangeIcon: false,
 					decoration: "flat"
				) 
        	{
			state("default",
					label:'Week Avg Consmption\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"weektripsAvgDistanceM", "device.weeklyTripsAvgDistanceM",width: 1, height: 1,canChangeIcon: false,
 					decoration: "flat"
				) 
        	{
			state("default",
					label:'Week Avg dist/trip\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"weektripsAvgDurationS", "device.weeklyTripsAvgDurationS", unit:'min.',width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					label:'Week Avg time/trip\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"weektotalDistanceM", "device.weeklyTotalDistanceM",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Week Total Dist.\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}

		valueTile(	"weektotalFuelVolumeL", "device.weeklyTotalFuelVolumeL",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Week Fuel Vol.\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"weektotalNbTrips", "device.weeklyTotalNbTrips",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Week Total Trips\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"weektripsAvgScoreSpeeding", "device.weeklyTripsAvgScoreSpeeding",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Week Avg Score Speed\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"weektripsAvgScoreEvents", "device.weeklyTripsAvgScoreEvents",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Week Avg Score Events\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}

/*	Removed monthly stats due to rate limiting (need to be implemented by stats API on Automatic side
		// monthly tiles

		valueTile(	"monthtripsAvgAverageKmpl", "device.monthlyTripsAvgAverageKmpl",width: 1, height: 1,canChangeIcon: false,
 					decoration: "flat"
				) 
        	{
			state("default",
					label:'Month Avg Consmption\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"monthtripsAvgDistanceM", "device.monthlyTripsAvgDistanceM",width: 1, height: 1,canChangeIcon: false,
 					decoration: "flat"
				) 
        	{
			state("default",
					label:'Month Avg dist/trip\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"monthtripsAvgDurationS", "device.monthlyTripsAvgDurationS", unit:'min.',width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat"
				)
        	{
			state("default",
					label:'Month Avg time/trip\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"monthtotalDistanceM", "device.monthlyTotalDistanceM",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Month Total Dist.\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}	

		valueTile(	"monthtotalFuelVolumeL", "device.monthlyTotalFuelVolumeL",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Month Fuel Vol.\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"monthtotalNbTrips", "device.monthlyTotalNbTrips",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Month Total Trips\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"monthtripsAvgScoreSpeeding", "device.monthlyTripsAvgScoreSpeeding",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Month Avg Score Speed\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
		valueTile(	"monthtripsAvgScoreEvents", "device.monthlyTripsAvgScoreEvents",width: 1, height: 1,canChangeIcon: false,
  					decoration: "flat",
				)
        	{
			state("default",
					label:'Month Avg Score Events\n${currentValue}',
					backgroundColor: "#ffffff"
				)
		}
*/
		standardTile("refresh", "device.make", inactiveLabel: false, decoration: "flat") {
			state "default", action:"polling.poll", icon:"st.secondary.refresh"
		}

		main(["make", "model"])
		details(["make", "model",  "refresh", "submodel", "year", 
			"tripsAvgAverageKmpl", "tripsAvgDistanceM", "tripsAvgDurationS","totalDistanceM",
			"totalFuelVolumeL","totalNbTrips", "tripsAvgScoreSpeeding", "tripsAvgScoreEvents",
			"yestripsAvgAverageKmpl", "yestripsAvgDistanceM", "yestripsAvgDurationS","yestotalDistanceM",
			"yestotalFuelVolumeL","yestotalNbTrips", "yestripsAvgScoreSpeeding", "yestripsAvgScoreEvents",
			"weektripsAvgAverageKmpl", "weektripsAvgDistanceM", "weektripsAvgDurationS","weektotalDistanceM",
			"weektotalFuelVolumeL","weektotalNbTrips","weektripsAvgScoreSpeeding", "weektripsAvgScoreEvents",
/*			Removed monthly stats due to rate limiting (need to be implemented by stats API on Automatic side
			"monthtripsAvgAverageKmpl", "monthtripsAvgDistanceM", "monthtripsAvgDurationS", "monthtotalDistanceM",
			"monthtotalFuelVolumeL","monthtotalNbTrips","monthtripsAvgScoreSpeeding", "monthtripsAvgScoreEvents",
*/            
		])        


	}
}

// handle commands

 

void poll() {
    
	
	def vehicleId= determine_vehicle_id("") 	    
        
	String dateInLocalTime = new Date().format("yyyy-MM-dd", location.timeZone)

	// generate all stats only once every day
	if (state?.lastGeneratedStatsDate != dateInLocalTime) {
    
		// call getCurrentUserInfo() to update basic info on the user
        
		getCurrentUserInfo() 

		// Update the vehicle information
        
		getVehicles(vehicleId)

		if (settings.trace) {
			log.debug "poll>about to call generateTripStats,dateInLocalTime=${dateInLocalTime},state.lastGeneratedDate= $state.lastGeneratedDate"
		}
		generateTripStats(vehicleID)
		state.lastGeneratedStatsDate= dateInLocalTime       
    
	}

	def dataEvents = [
		userid:data?.user.id,
		username:data?.user.username,
		email:data?.user.email,
		firstName:data?.user.first_name,
		lastName:data?.user.last_name,
		vehicleId:data?.vehicles.results[0]?.id,
		make:data?.vehicles.results[0]?.make,
		model:data?.vehicles.results[0]?.model,
		submodel:data?.vehicles.results[0]?.submodel,
		displayName:data?.vehicles.results[0]?.display_name,
		year:data?.vehicles.results[0]?.year.toString()
	]



	// Generate trip stats for today
	String timezone = new Date().format("zzz", location.timeZone)
	String dateAtMidnight = dateInLocalTime + " 00:00 " + timezone    
	if (settings.trace) {
		log.debug("poll>date at Midnight in local time= ${dateAtMidnight}")
	}
	Date startDate = formatDate(dateAtMidnight)
	Date endDate= new Date()
//	Generate Events since last poll() call only
	getTrips("","", startDate,endDate, state?.lastPollTimestamp)
	state.lastPollTimestamp = now()
    
	String exceptionCheck = device.currentValue("verboseTrace").toString()
	if ((exceptionCheck.contains("exception")) || (exceptionCheck.contains("error"))) {  
	// check if there is any exception or an error reported in the verboseTrace associated to the device 
		log.error "poll>vehicleId=$vehicleId,$exceptionCheck" 
		return    
	}

	def tripsAvgAverageKmplInPeriod =  device.currentValue("tripsAvgAverageKmplInPeriod")
	def tripsAvgDistanceMInPeriod =  device.currentValue("tripsAvgDistanceMInPeriod")
	def tripsAvgDurationSInPeriod =  device.currentValue("tripsAvgDurationSInPeriod")
	def totalDistanceMInPeriod =  device.currentValue("totalDistanceMInPeriod")
	def tripsAvgFuelVolumeLInPeriod = device.currentValue("tripsAvgFuelVolumeLInPeriod")
	def tripsAvgCostUsdInPeriod =  device.currentValue("tripsAvgCostUsdInPeriod")
	def totalFuelVolumeLInPeriod =  device.currentValue("totalFuelVolumeLInPeriod")
	def totalCostUsdInPeriod =  device.currentValue("totalCostUsdInPeriod")
	def totalDurationSInPeriod =  device.currentValue("totalDurationSInPeriod")
	def totalNbTripsInPeriod =  device.currentValue("totalNbTripsInPeriod")
	def totalHardAccelsInPeriod= device.currentValue("totalHardAccelsInPeriod")
	def totalHardBrakesInPeriod = device.currentValue("totalHardBrakesInPeriod")
	def tripsAvgScoreSpeedingInPeriod = device.currentValue("tripsAvgScoreSpeedingInPeriod")
	def tripsAvgScoreEventsInPeriod = device.currentValue("tripsAvgScoreEventsInPeriod")
    
	float tripsAvgAverageKmpl =  (tripsAvgAverageKmplInPeriod)? tripsAvgAverageKmplInPeriod.toFloat():0
	float tripsAvgDistanceM =  (tripsAvgDistanceMInPeriod)?tripsAvgDistanceMInPeriod.toFloat():0
	float tripsAvgDurationS =  (tripsAvgDurationSInPeriod)?tripsAvgDurationSInPeriod.toFloat():0
	float totalDistanceM =  (totalDistanceMInPeriod)?totalDistanceMInPeriod.toFloat():0
	float tripsAvgFuelVolumeL =  (tripsAvgFuelVolumeLInPeriod)? tripsAvgFuelVolumeLInPeriod.toFloat():0
	float tripsAvgCostUsd = (tripsAvgCostUsdInPeriod)?tripsAvgCostUsdInPeriod.toFloat():0 
	float totalFuelVolumeL =  (totalFuelVolumeLInPeriod)? totalFuelVolumeLInPeriod.toFloat():0
	float totalCostUsd = (totalCostUsdInPeriod)?totalCostUsdInPeriod.toFloat():0 
	float totalDurationS = (totalDurationSInPeriod)?totalDurationSInPeriod.toFloat():0 
	int totalNbTrips = (totalNbTripsInPeriod)?totalNbTripsInPeriod.toInteger():0 
	long totalHardAccels= (totalHardAccelsInPeriod)?totalHardAccelsInPeriod.toLong():0
	long totalHardBrakes = (totalHardBrakesInPeriod)?totalHardBrakesInPeriod.toLong():0
	float tripsAvgScoreSpeeding= (tripsAvgScoreSpeedingInPeriod)? tripsAvgScoreSpeedingInPeriod.toFloat():0
	float tripsAvgScoreEvents = (tripsAvgScoreEventsInPeriod)?tripsAvgScoreEventsInPeriod.toFloat():0
    
	dataEvents = dataEvents + [
		'tripsAvgAverageKmpl':tripsAvgAverageKmpl,
		'tripsAvgDistanceM':tripsAvgDistanceM,
		'tripsAvgDurationS':tripsAvgDurationS,
		'totalDistanceM': totalDistanceM,
		'tripsAvgFuelVolumeL':tripsAvgFuelVolumeL,
		'tripsAvgCostUsd':tripsAvgCostUsd,
		'totalFuelVolumeL':totalFuelVolumeL,
		'totalCostUsd':totalCostUsd,
		'totalDurationS':totalDurationS, 
		'totalNbTrips':totalNbTrips.toString(), 
		'totalHardAccels':totalHardAccels.toString(),
		'totalHardBrakes': totalHardBrakesInPeriod.toString(),
		'tripsAvgScoreSpeeding':tripsAvgScoreSpeeding,
		'tripsAvgScoreEvents': tripsAvgScoreEvents
	]
	generateEvent(dataEvents)
	sendEvent name: "verboseTrace", value:
			"poll>done for vehicleId = ${vehicleId}"

}


private void generateEvent(Map results) {
	if (settings.trace) {
		log.debug "generateEvent>parsing data $results"
	}
    
	if(results) {
		results.each { name, value ->
			def isDisplayed = true
			if (name.toUpperCase().contains("COST")) { 

// 			Cost variable names contain 'cost' 
 				float costValue = value.toFloat().round(2)
				def isChange = isStateChange(device, name, costValue.toString())
				isDisplayed = isChange
				sendEvent(name: name, value: costValue.toString(), unit: "USD", displayed: isDisplayed)                                     									 
			} else if (name.toUpperCase().contains("KMPL")) { 

// 			Consumption in kmpl variable names contain 'kmpl' 
 				float kmplValue = getConsumptionInKmpl(value).toFloat().round(1)
				def isChange = isStateChange(device, name, kmplValue.toString())
				isDisplayed = isChange
				sendEvent(name: name, value: kmplValue.toString(), unit: getConsumptionScale(),displayed: isDisplayed)                                     									 
			} else if (name.toUpperCase().contains("MPG")) { 

// 			Consumption in mpg variable names contain 'mpg' 
 				float mpgValue = getConsumptionInMpg(value).toFloat().round(1)
				def isChange = isStateChange(device, name, mpgValue.toString())
				isDisplayed = isChange
				sendEvent(name: name, value: mpgValue.toString(), unit: getConsumptionScale(),displayed: isDisplayed)                                     									 
			} else if (name.toUpperCase().contains("SCORE")) { 
// 			Score variable names contain 'score' 
 				float scoreValue = value.toFloat().round(1)
				def isChange = isStateChange(device, name, scoreValue.toString())
				isDisplayed = isChange
				sendEvent(name: name, value: scoreValue.toString(), displayed: isDisplayed)                                     									 
			} else if (name.toUpperCase().contains("VOLUME")) { 
// 			Volume variable names contain 'volume' 
 				float volumeValue = getVolume(value).toFloat().round(1)
				def isChange = isStateChange(device, name, volumeValue.toString())
				isDisplayed = isChange
				sendEvent(name: name, value: volumeValue.toString(), unit: getVolumeScale(), displayed: isDisplayed)                                     									 
			} else if (name.toUpperCase().contains("DURATION")) { 

// 			Duration variable names contain 'duration' (in seconds)
 				float durationValue = getDuration(value).toFloat().round(1)
				def isChange = isStateChange(device, name, durationValue.toString())
				isDisplayed = isChange
				sendEvent(name: name, value: durationValue.toString(), unit: "min", displayed: isDisplayed)                                     									 
			} else if (name.toUpperCase().contains("DISTANCE")) { 
// 			Distance variable names contain 'distance'
 				float distanceValue = getDistance(value).toFloat().round(1)
				def isChange = isStateChange(device, name, distanceValue.toString())
				isDisplayed = isChange
				sendEvent(name: name, value: distanceValue.toString(), unit: getDistanceScale(), displayed: isDisplayed)                                     									 
			} else if (name.toUpperCase().contains("SPEED")) { 
// 			Speed variable names contain 'speed' (in kph)

 				float speedValue = getSpeed(value).toFloat().round(1)
				def isChange = isStateChange(device, name, speedValue.toString())
				isDisplayed = isChange
				sendEvent(name: name, value: speedValue.toString(), unit: getSpeedScale(), displayed: isDisplayed)                                     									 
 			} else {
				def isChange = isStateChange(device, name, value)
				isDisplayed = isChange
				sendEvent(name: name, value: value, isStateChange: isChange)       
			}
		}
	}
}

private def getDuration(value) {
	if (!value) {
		return 0    
	}    
	return (value/60)
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


private def kmplToMpg(value) {
	if (!value) {
    	return 0
	}        
	return (value * 2.352145833)  
}

private def mpgToKmpl(value) {
	if (!value) {
    	return 0
	}        
	return (value * 0.4251)  
}

private def getConsumptionInMpg(value) {
	if (getTemperatureScale() == "F"){
		return value    
    }
	return (kmplToMpg(value))
}

private def getConsumptionInKmpl(value) {
	if (getTemperatureScale() == "C"){
		return value    
    }
	return (kmplToMpg(value))
}

private def getVolumeScale() {
	def scale= getTemperatureScale()
	if (scale == 'C') {
		return "liters"
	}
	return "gallons"
}

private def getVolume(value) {
	if (getTemperatureScale() == "C"){
		return value    
    }
	if (!value) {
    	return 0
	}        
	return (value * 0.26417)
}

private def getConsumptionScale() {
	def scale= getTemperatureScale()
	if (scale == 'C') {
		return "kmpl"
	}
	return "mpg"
}

private def getDistanceScale() {
	def scale= getTemperatureScale()
	if (scale == 'C') {
		return "km"
	}
	return "mi"
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

void refresh() {
	poll()
}
private def api(method, args, success={}) {

	String URI_ROOT = "${get_URI_ROOT()}"
	if (!isLoggedIn()) {
		login()
	}
	if (isTokenExpired()) {
		if (settings.trace) {
			log.debug "api> need to refresh tokens"
		}
//		refresh_tokens()
	}
	def methods = [
		'currentUserInfo': 
			[uri:"${URI_ROOT}/user/me/", type: 'get'],
		'trips': 
			[uri:"${URI_ROOT}/trip/${args}", 
          		type: 'get'],
		'vehicles': 
			[uri:"${URI_ROOT}/vehicle/", 
          		type: 'get']
	]
	def request = methods.getAt(method)
	if (settings.trace) {
		sendEvent name: "verboseTrace", value:
			"api> about to call doRequest with (unencoded) args = ${args}"
	}
	doRequest(request.uri, args, request.type, success)
}

// Need to be authenticated in before this is called. So don't call this. Call api.
private def doRequest(uri, args, type, success) {
        
	def params = [
		uri: uri,
		headers: [
			'Authorization': "${data.auth.token_type} ${data.auth.access_token}",
			'Content-Type': "application/json",
			'charset': "UTF-8",
			'Accept': "application/json"
		],
		body: args
	]
	try {
		if (settings.trace) {
//			sendEvent name: "verboseTrace", value: "doRequest>token= ${data.auth.access_token}"
			sendEvent name: "verboseTrace", value:
				"doRequest>about to ${type} with uri ${params.uri}, args= ${args}"
				log.debug "doRequest> ${type}> uri ${params.uri}, args= ${args}"
		}
		if (type == 'post') {
			httpPostJson(params, success) 
		} else if (type == 'get') {
			params.body = null // parameters already in the URL request
			httpGet(params, success) 
		}
	} catch (java.net.UnknownHostException e) {
		log.error "doRequest> Unknown host - check the URL " + params.uri
		sendEvent name: "verboseTrace", value: "doRequest>exception $e, Unknown host ${params.uri}" 
		throw e        
	} catch (java.net.NoRouteToHostException e) {
		log.error "doRequest> No route to host - check the URL " + params.uri
		sendEvent name: "verboseTrace", value: "doRequest>exception $e, No route to host ${params.uri}"
		throw e        
	} catch (e) {
		log.error "doRequest> exception $e " + params.uri
		sendEvent name: "verboseTrace", value: "doRequest>exception $e at ${params.uri}" 
		throw e        
	}
}

void generateTripStats(vehicleId) {

//	Generate stats for yesterday

	String nowInLocalTime = new Date().format("yyyy-MM-dd HH:mm", location.timeZone)
	String dateInLocalTime = new Date().format("yyyy-MM-dd", location.timeZone) 
	String timezone = new Date().format("zzz", location.timeZone)
	String dateAtMidnight = dateInLocalTime + " 00:00 " + timezone    

    
	if (settings.trace) {
		log.debug("generateTripStats>date at Midnight in UTC= ${dateAtMidnight}")
	}
	Date endDate = formatDate(dateAtMidnight) 
	Date startDate = (endDate -1)

	if (settings.trace) {
		log.debug("generateTripStats>yesterday: local date/time= ${nowInLocalTime}, startDate in UTC = ${String.format('%tF %<tT',startDate)}," +
			"endDate in UTC= ${String.format('%tF %<tT', endDate)}")
	}
	getTrips("","", startDate,endDate, null)

	def tripsAvgAverageKmplInPeriod =  device.currentValue("tripsAvgAverageKmplInPeriod")
	def tripsAvgDistanceMInPeriod =  device.currentValue("tripsAvgDistanceMInPeriod")
	def tripsAvgDurationSInPeriod =  device.currentValue("tripsAvgDurationSInPeriod")
	def totalDistanceMInPeriod =  device.currentValue("totalDistanceMInPeriod")
	def tripsAvgFuelVolumeLInPeriod = device.currentValue("tripsAvgFuelVolumeLInPeriod")
	def tripsAvgCostUsdInPeriod =  device.currentValue("tripsAvgCostUsdInPeriod")
	def totalFuelVolumeLInPeriod =  device.currentValue("totalFuelVolumeLInPeriod")
	def totalCostUsdInPeriod =  device.currentValue("totalCostUsdInPeriod")
	def totalDurationSInPeriod =  device.currentValue("totalDurationSInPeriod")
	def totalNbTripsInPeriod=  device.currentValue("totalNbTripsInPeriod")
	def totalHardAccelsInPeriod= device.currentValue("totalHardAccelsInPeriod")
	def totalHardBrakesInPeriod = device.currentValue("totalHardBrakesInPeriod")
	def tripsAvgScoreSpeedingInPeriod = device.currentValue("tripsAvgScoreSpeedingInPeriod")
	def tripsAvgScoreEventsInPeriod = device.currentValue("tripsAvgScoreEventsInPeriod")
    
	float tripsAvgAverageKmpl =  (tripsAvgAverageKmplInPeriod)? tripsAvgAverageKmplInPeriod.toFloat():0
	float tripsAvgDistanceM =  (tripsAvgDistanceMInPeriod)?tripsAvgDistanceMInPeriod.toFloat():0
	float tripsAvgDurationS =  (tripsAvgDurationSInPeriod)?tripsAvgDurationSInPeriod.toFloat():0
	float totalDistanceM =  (totalDistanceMInPeriod)?totalDistanceMInPeriod.toFloat():0
	float tripsAvgFuelVolumeL =  (tripsAvgFuelVolumeLInPeriod)? tripsAvgFuelVolumeLInPeriod.toFloat():0
	float tripsAvgCostUsd = (tripsAvgCostUsdInPeriod)?tripsAvgCostUsdInPeriod.toFloat():0 
	float totalFuelVolumeL =  (totalFuelVolumeLInPeriod)? totalFuelVolumeLInPeriod.toFloat():0
	float totalCostUsd = (totalCostUsdInPeriod)?totalCostUsdInPeriod.toFloat():0 
	float totalDurationS = (totalDurationSInPeriod)?totalDurationSInPeriod.toFloat():0 
	int totalNbTrips = (totalNbTripsInPeriod)?totalNbTripsInPeriod.toInteger():0 
	long totalHardAccels= (totalHardAccelsInPeriod)?totalHardAccelsInPeriod.toLong():0
	long totalHardBrakes = (totalHardBrakesInPeriod)?totalHardBrakesInPeriod.toLong():0
	float tripsAvgScoreSpeeding= (tripsAvgScoreSpeedingInPeriod)? tripsAvgScoreSpeedingInPeriod.toFloat():0
	float tripsAvgScoreEvents = (tripsAvgScoreEventsInPeriod)?tripsAvgScoreEventsInPeriod.toFloat():0
    

	def dataStats = ['yesterdayTripsAvgAverageKmpl':tripsAvgAverageKmpl,
		'yesterdayTripsAvgDistanceM':tripsAvgDistanceM,
		'yesterdayTripsAvgDurationS':tripsAvgDurationS,
		'yesterdayTotalDistanceM': totalDistanceM,
		'yesterdayTripsAvgFuelVolumeL':tripsAvgFuelVolumeL,
		'yesterdayTripsAvgCostUsd':tripsAvgCostUsd,
		'yesterdayTotalFuelVolumeL':totalFuelVolumeL,
		'yesterdayTotalCostUsd':totalCostUsd,
		'yesterdayTotalDurationS':totalDurationS,
		'yesterdayTotalNbTrips':totalNbTrips.toString(),
		'yesterdayTotalHardAccels':totalHardAccels.toString(),
		'yesterdayTotalHardBrakes': totalHardBrakes.toString(),
		'yesterdayTripsAvgScoreSpeeding':tripsAvgScoreSpeeding,
		'yesterdayTripsAvgScoreEvents': tripsAvgScoreEvents
	]    

	generateEvent(dataStats)
	generateWeeklyTripStats()     
//	generateMonthlyTripStats()
}

void generateWeeklyTripStats() {

	String nowInLocalTime = new Date().format("yyyy-MM-dd HH:mm", location.timeZone)
	String dateInLocalTime = new Date().format("yyyy-MM-dd", location.timeZone) 
	String timezone = new Date().format("zzz", location.timeZone)
	String dateAtMidnight = dateInLocalTime + " 00:00 " + timezone    
	if (settings.trace) {
		log.debug("generateTripStats>date at Midnight in UTC= ${dateAtMidnight}")
	}
	Date endDate = formatDate(dateAtMidnight) 

//	Generate stats for the past week

	Date startDate = (endDate -7)

	if (settings.trace) {
		log.debug("generateTripStats>past week (last 7 days): startDate in UTC = ${String.format('%tF %<tT',startDate)}," +
			"endDate in UTC= ${String.format('%tF %<tT', endDate)}")
	}
	getTrips("","", startDate,endDate, null)

	def tripsAvgAverageKmplInPeriod =  device.currentValue("tripsAvgAverageKmplInPeriod")
	def tripsAvgDistanceMInPeriod =  device.currentValue("tripsAvgDistanceMInPeriod")
	def tripsAvgDurationSInPeriod =  device.currentValue("tripsAvgDurationSInPeriod")
	def totalDistanceMInPeriod =  device.currentValue("totalDistanceMInPeriod")
	def tripsAvgFuelVolumeLInPeriod = device.currentValue("tripsAvgFuelVolumeLInPeriod")
	def tripsAvgCostUsdInPeriod =  device.currentValue("tripsAvgCostUsdInPeriod")
	def totalFuelVolumeLInPeriod =  device.currentValue("totalFuelVolumeLInPeriod")
	def totalCostUsdInPeriod =  device.currentValue("totalCostUsdInPeriod")
	def totalDurationSInPeriod =  device.currentValue("totalDurationSInPeriod")
	def totalNbTripsInPeriod=  device.currentValue("totalNbTripsInPeriod")
	def totalHardAccelsInPeriod= device.currentValue("totalHardAccelsInPeriod")
	def totalHardBrakesInPeriod = device.currentValue("totalHardBrakesInPeriod")
	def tripsAvgScoreSpeedingInPeriod = device.currentValue("tripsAvgScoreSpeedingInPeriod")
	def tripsAvgScoreEventsInPeriod = device.currentValue("tripsAvgScoreEventsInPeriod")
    
	float tripsAvgAverageKmpl =  (tripsAvgAverageKmplInPeriod)? tripsAvgAverageKmplInPeriod.toFloat():0
	float tripsAvgDistanceM =  (tripsAvgDistanceMInPeriod)?tripsAvgDistanceMInPeriod.toFloat():0
	float tripsAvgDurationS =  (tripsAvgDurationSInPeriod)?tripsAvgDurationSInPeriod.toFloat():0
	float totalDistanceM =  (totalDistanceMInPeriod)?totalDistanceMInPeriod.toFloat():0
	float tripsAvgFuelVolumeL =  (tripsAvgFuelVolumeLInPeriod)? tripsAvgFuelVolumeLInPeriod.toFloat():0
	float tripsAvgCostUsd = (tripsAvgCostUsdInPeriod)?tripsAvgCostUsdInPeriod.toFloat():0 
	float totalFuelVolumeL =  (totalFuelVolumeLInPeriod)? totalFuelVolumeLInPeriod.toFloat():0
	float totalCostUsd = (totalCostUsdInPeriod)?totalCostUsdInPeriod.toFloat():0 
	float totalDurationS = (totalDurationSInPeriod)?totalDurationSInPeriod.toFloat():0 
	int totalNbTrips = (totalNbTripsInPeriod)?totalNbTripsInPeriod.toInteger():0 
	long totalHardAccels= (totalHardAccelsInPeriod)?totalHardAccelsInPeriod.toLong():0
	long totalHardBrakes = (totalHardBrakesInPeriod)?totalHardBrakesInPeriod.toLong():0
	float tripsAvgScoreSpeeding= (tripsAvgScoreSpeedingInPeriod)? tripsAvgScoreSpeedingInPeriod.toFloat():0
	float tripsAvgScoreEvents = (tripsAvgScoreEventsInPeriod)?tripsAvgScoreEventsInPeriod.toFloat():0
    

	def dataStats  = [
    	'weeklyTripsAvgAverageKmpl':tripsAvgAverageKmpl,
		'weeklyTripsAvgDistanceM':tripsAvgDistanceM,
		'weeklyTripsAvgDurationS':tripsAvgDurationS,
		'weeklyTotalDistanceM': totalDistanceM,
		'weeklyTripsAvgFuelVolumeL':tripsAvgFuelVolumeL,
		'weeklyTripsAvgCostUsd':tripsAvgCostUsd,
		'weeklyTotalFuelVolumeL':totalFuelVolumeL,
		'weeklyTotalCostUsd':totalCostUsd,
		'weeklyTotalDurationS':totalDurationS,
		'weeklyTotalNbTrips':totalNbTrips.toString(),
		'weeklyTotalHardAccels':totalHardAccels.toString(),
		'weeklyTotalHardBrakes': totalHardBrakes.toString(),
		'weeklyTripsAvgScoreSpeeding':tripsAvgScoreSpeeding,
		'weeklyTripsAvgScoreEvents': tripsAvgScoreEvents
	]    
    
	generateEvent(dataStats)
    
}

void generateMonthlyTripStats() {

	String nowInLocalTime = new Date().format("yyyy-MM-dd HH:mm", location.timeZone)
   
//	Generate stats for the past month

	Calendar oneMonthAgoCal = new GregorianCalendar()
	oneMonthAgoCal.add(Calendar.MONTH, -1)
	Date oneMonthAgo = oneMonthAgoCal.getTime()
	Date endDate = new Date()
	if (settings.trace) {
		log.debug("getTripsStats>past month: startDate in UTC = ${String.format('%tF %<tT',oneMonthAgo)}," +
			"endDate in UTC= ${String.format('%tF %<tT', endDate)}")
	}
	getTrips("","", startDate,endDate, null)

	def tripsAvgAverageKmplInPeriod =  device.currentValue("tripsAvgAverageKmplInPeriod")
	def tripsAvgDistanceMInPeriod =  device.currentValue("tripsAvgDistanceMInPeriod")
	def tripsAvgDurationSInPeriod =  device.currentValue("tripsAvgDurationSInPeriod")
	def totalDistanceMInPeriod =  device.currentValue("totalDistanceMInPeriod")
	def tripsAvgFuelVolumeLInPeriod = device.currentValue("tripsAvgFuelVolumeLInPeriod")
	def tripsAvgCostUsdInPeriod =  device.currentValue("tripsAvgCostUsdInPeriod")
	def totalFuelVolumeLInPeriod =  device.currentValue("totalFuelVolumeLInPeriod")
	def totalCostUsdInPeriod =  device.currentValue("totalCostUsdInPeriod")
	def totalDurationSInPeriod =  device.currentValue("totalDurationSInPeriod")
	def totalNbTripsInPeriod=  device.currentValue("totalNbTripsInPeriod")
	def totalHardAccelsInPeriod= device.currentValue("totalHardAccelsInPeriod")
	def totalHardBrakesInPeriod = device.currentValue("totalHardBrakesInPeriod")
	def tripsAvgScoreSpeedingInPeriod = device.currentValue("tripsAvgScoreSpeedingInPeriod")
	def tripsAvgScoreEventsInPeriod = device.currentValue("tripsAvgScoreEventsInPeriod")
    
	float tripsAvgAverageKmpl =  (tripsAvgAverageKmplInPeriod)? tripsAvgAverageKmplInPeriod.toFloat():0
	float tripsAvgDistanceM =  (tripsAvgDistanceMInPeriod)?tripsAvgDistanceMInPeriod.toFloat():0
	float tripsAvgDurationS =  (tripsAvgDurationSInPeriod)?tripsAvgDurationSInPeriod.toFloat():0
	float totalDistanceM =  (totalDistanceMInPeriod)?totalDistanceMInPeriod.toFloat():0
	float tripsAvgFuelVolumeL =  (tripsAvgFuelVolumeLInPeriod)? tripsAvgFuelVolumeLInPeriod.toFloat():0
	float tripsAvgCostUsd = (tripsAvgCostUsdInPeriod)?tripsAvgCostUsdInPeriod.toFloat():0 
	float totalFuelVolumeL =  (totalFuelVolumeLInPeriod)? totalFuelVolumeLInPeriod.toFloat():0
	float totalCostUsd = (totalCostUsdInPeriod)?totalCostUsdInPeriod.toFloat():0 
	float totalDurationS = (totalDurationSInPeriod)?totalDurationSInPeriod.toFloat():0 
	int totalNbTrips = (totalNbTripsInPeriod)?totalNbTripsInPeriod.toInteger():0 
	long totalHardAccels= (totalHardAccelsInPeriod)?totalHardAccelsInPeriod.toLong():0
	long totalHardBrakes = (totalHardBrakesInPeriod)?totalHardBrakesInPeriod.toLong():0
	float tripsAvgScoreSpeeding= (tripsAvgScoreSpeedingInPeriod)? tripsAvgScoreSpeedingInPeriod.toFloat():0
	float tripsAvgScoreEvents = (tripsAvgScoreEventsInPeriod)?tripsAvgScoreEventsInPeriod.toFloat():0
   	
	def dataStats  = [
		'monthlyTripsAvgAverageKmpl':tripsAvgAverageKmpl,
		'monthlyTripsAvgDistanceM':tripsAvgDistanceM,
		'monthlyTripsAvgDurationS':tripsAvgDurationS,
		'monthlyTotalDistanceM': totalDistanceM,
		'monthlyTripsAvgFuelVolumeL':tripsAvgFuelVolumeL,
		'monthlyTripsAvgCostUsd':tripsAvgCostUsd,
		'monthlyTotalFuelVolumeL':totalFuelVolumeL,
		'monthlyTotalCostUsd':totalCostUsd,
		'monthlyTotalDurationS':totalDurationS,
		'monthlyTotalNbTrips':totalNbTrips.toString(),
		'monthlyTotalHardAccels':totalHardAccels.toString(),
		'monthlyTotalHardBrakes': totalHardBrakes.toString(),
		'monthlyTripsAvgScoreSpeeding':tripsAvgScoreSpeeding,
		'monthlyTripsAvgScoreEvents': tripsAvgScoreEvents
	]
	generateEvent(dataStats)
    
}
private def ISODateFormat(dateString) {
 	SimpleDateFormat ISO8601format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
	def ISOdate = ISO8601format.parse(dateString)
	return ISOdate
}

private def formatDate(dateString) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm zzz")
	Date aDate = sdf.parse(dateString)
	return aDate
}

private String formatDateInLocalTime(dateInString) {
	if ((dateInString==null) || (dateInString.trim()=="")) {
		return ""    
	}    
	SimpleDateFormat ISODateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
	Date ISODate = ISODateFormat.parse(dateInString)
	String dateInLocalTime = ISODate.format("yyyy-MM-dd HH:mm", location.timeZone)
	return dateInLocalTime
}
// 	vehicleId - Id of the vehicle, by default the current one  
//	tripId - Id of the trip, by default, all trips are selected 
//	startDateTime - start timestamp for the query
//	endDateTime - end timestamp for the query
//	eventTimestamp - event timestamp for generating events (ex. hard acceleration, hard brake, speeding, etc.)
//		if null, do not generate events
//	postData - indicates whether the data should be posted as is in the tripsData attribute
void getTrips(vehicleId,tripId,startDateTime,endDateTime, eventTimestamp,postData='false') {
	def AUTOMATIC_SUCCESS=200
	def MAX_TRIP_DATA=50    
	float totalDistanceM=0, totalDurationS=0, totalAverageKmpl=0, totalCostUsd=0,totalFuelVolumeL=0
	long totalHardAccels=0, totalHardBrakes=0, totalScoreSpeeding=0, totalScoreEvents=0
	float tripsAvgDistanceM=0,tripsAvgDurationS,tripsAvgCostUsd=0,tripsAvgFuelVolumeL= 0
	float tripsAvgAverageKmpl=0,tripsAvgScoreSpeeding=0,tripsAvgScoreEvents=0

	int nbTrips=0
	def bodyReq=""
	def id    
	Double startTimestamp,endTimestamp    
    
	def tripsData=[]
	def tripsList=""
	vehicleId= determine_vehicle_id(vehicleId) 	    

	if (tripId) {
		bodyReq = "${tripId}/" 
	}        
//	Set the limit to 250 trips per page.    
	bodyReq=bodyReq + "?vehicle=" + vehicleId + "&limit=250"

	if (startDateTime) {
		startTimestamp = (startDateTime.getTime()/1000).toDouble().round()
		bodyReq = bodyReq+ "&started_at__gte=" + startTimestamp.intValue()      	// in epoch time in seconds
		if (endDateTime) {
			endTimestamp = (endDateTime.getTime()/1000).toDouble().round()
			bodyReq = bodyReq+ "&ended_at__lte=" + endTimestamp.intValue()     	
		}    

	}    
	int j=0        
	def statusCode=true
	while ((statusCode!= AUTOMATIC_SUCCESS) && (j++ <2)) { // retries once if api call fails
		api('trips', bodyReq) {resp->
			statusCode = resp.status        
			if (statusCode == AUTOMATIC_SUCCESS) {
 				data?.trips=resp.data
				if (settings.trace) {
					log.debug "getTrips>metadata=${data.trips._metadata}" 
				}				                
                
				data.trips.results.each {
					nbTrips++                    
					id= it.id
					def startedAt=it.started_at
					def endedAt=it.ended_at
					def distanceM=it.distance_m
					def durationS=it.duration_s
					def vehicleURL=it.vehicle
					def startLocation=it.start_location
					def startAddress=it.start_address
					def endLocation=it.end_location
					def endAddress=it.end_address
					def startTimezone=it.start_timezone       		
					def endTimezone=it.end_timezone       		
					def tags= it.tags       		
					def fuelCostUsd=it.fuel_cost_usd
					def fuelVolumeL=it.fuel_volume_l                    
					def averageKmpl=it.average_kmpl
					def hardAccels=it.hard_accels
					def hardBrakes=it.hard_brakes
					def scoreSpeeding=it.score_speeding
					def scoreEvents=it.score_events
            
					if (averageKmpl) {
						totalAverageKmpl =totalAverageKmpl +averageKmpl.toFloat()                        
					}	
					if (distanceM) {
						totalDistanceM =totalDistanceM +distanceM.toFloat()
					}
					if (durationS) {
						totalDurationS =totalDurationS +durationS.toFloat()
					}
					if (fuelCostUsd) {
						totalCostUsd =totalCostUsd +fuelCostUsd.toFloat()
					}
					if (fuelVolumeL) {
						totalFuelVolumeL =totalFuelVolumeL +fuelVolumeL.toFloat()
					}
					if (hardAccels) {
						totalHardAccels =totalHardAccels + hardAccels.toInteger()
					}
					if (hardBrakes) {
						totalHardBrakes =totalHardBrakes + hardBrakes.toInteger()
					}
					if (scoreSpeeding) {
						totalScoreSpeeding =totalScoreSpeeding + scoreSpeeding.toInteger()
					}
					if (scoreEvents) {
						totalScoreEvents =totalScoreEvents + scoreEvents.toInteger()
					}
					                    
					if (postData == 'true') {
                    
						if (data.trips._metadata.count <= MAX_TRIP_DATA) {
							tripsData << it  // to be transformed into Json later
						} else {
							log.error "getTrips>vehicleId=${vehicleId},too much data to post, count=${data.trips._metadata.count} trips, no posting it"
						}                        
					}
					tripsList = tripsList + id + ','
					if (eventTimestamp) {
						// generate events when startedDate greater than eventTimestamp (to avoid generating the same events twice)
						Date startedDate=ISODateFormat(startedAt.substring(0,18) + 'Z')
						if (startedDate.getTime() > eventTimestamp) {                        
							generateVehicleEvents(it)
						}                            
					}                        
					if (settings.trace) {
						log.debug "getTrips>tripId=${id},startedAt=${startedAt},endedAt=${endedAt}," +
							"distanceM=${distanceM},durationS=${durationS},vehicleURL=${vehicleURL},startLocation=${startLocation},startAddress=${startAddress}," +
							"endLocation=${endLocation},endAddress=${endAddress},startTimezone=${startTimezone},endTimezone=${endTimezone}," +       		
							"averageKmpl=${averageKmpl},fuelVolumeL=${fuelVolumeL},fuelCostUsd=${fuelCostUsd}," +
							"hardAccels=${hardAccels},hardBrakes=${hardBrakes},scoreSpeeding=${scoreSpeeding},scoreEvents=${scoreEvents}\n" +
							"vehicle_events=${it.vehicle_events}"
						sendEvent name: "verboseTrace", value: "getTrips>tripId=${id},startedAt=${startedAt},endedAt=${endedAt}," +
							"distanceM=${distanceM},durationS=${durationS},vehicleURL=${vehicleURL},startLocation=${startLocation},startAddress=${startAddress}," +
							"endLocation=${endLocation},endAddress=${endAddress},startTimezone=${startTimezone},endTimezone=${endTimezone}," +       		
							"averageKmpl=${averageKmpl},fuelVolumeL=${fuelVolumeL},fuelCostUsd=${fuelCostUsd}," +
							"hardAccels=${hardAccels},hardBrakes=${hardBrakes},scoreSpeeding=${scoreSpeeding},scoreEvents=${scoreEvents}\n" +
							"vehicle_events=${it.vehicle_events}"
					}
                        
				} /* end each */                    
				sendEvent name: "verboseTrace", value:"getTrips>done for vehicleId=${vehicleId}"
			} else {
				log.error "getTrips>error=${statusCode.toString()} for vehicleId=${vehicleId}"
				sendEvent name: "verboseTrace", value:"getTrips>error=${statusCode.toString()} for vehicleId=${vehicleId}"
                
			} /* end if statusCode */               
		}  /* end api call */              
	} /* end while */

	def tripsDataJson=""
	if (tripsData != []) {
		tripsDataJson = new groovy.json.JsonBuilder(tripsData)
	}
	
	sendEvent(name: "tripsList", value: "${tripsList.toString()}")
	sendEvent(name: "totalDistanceMInPeriod", value: "${totalDistanceM.toString()}")
	sendEvent(name: "totalFuelVolumeLInPeriod", value: "${totalFuelVolumeL.toString()}")
	sendEvent(name: "totalCostUsdInPeriod", value: "${totalCostUsd.toString()}")
	sendEvent(name: "totalDurationSInPeriod", value: "${totalDurationS.toString()}")
	sendEvent(name: "totalAverageKmplInPeriod", value: "${totalAverageKmpl.toString()}")
	sendEvent(name: "totalNbTripsInPeriod", value: "${data.trips._metadata.count.toString()}")
	sendEvent(name: "totalHardAccelsInPeriod", value:"${totalHardAccels.toString()}")
	sendEvent(name: "totalHardBrakesInPeriod", value: "${totalHardBrakes.toString()}")
	sendEvent(name: "totalScoreSpeedingInPeriod", value: "${totalScoreSpeeding.toString()}")
	sendEvent(name: "totalScoreEventsInPeriod", value: "${totalScoreEvents.toString()}")

	// Process Next Page
	if (data.trips._metadata.next) {
		if (settings.trace) {
			log.debug "getTrips>vehicleId=${vehicleId},nextPage=${data.trips._metadata.next}"
		}                
		processTripsNextPage(vehicleId,nbTrips,data.trips._metadata)			            
	} else {

		if (nbTrips >0) {
			tripsAvgDistanceM = totalDistanceM / nbTrips
			tripsAvgDurationS = totalDurationS / nbTrips
			tripsAvgCostUsd = totalCostUsd / nbTrips
			tripsAvgFuelVolumeL = totalFuelVolumeL / nbTrips
			tripsAvgAverageKmpl = totalAverageKmpl / nbTrips                         
			tripsAvgScoreSpeeding =totalScoreSpeeding / nbTrips
			tripsAvgScoreEvents =totalScoreEvents / nbTrips
		}        
        
		if (settings.trace) {
			log.trace "getTrips>nbTrips=${nbTrips}, totalDistanceM=${totalDistanceM},tripsAvgDistanceM=${tripsAvgDistanceM}" 
			log.trace "getTrips>nbTrips=${nbTrips}, totalDurationS=${totalDurationS},tripsAvgDurationS=${tripsAvgDurationS}" 
			log.trace "getTrips>nbTrips=${nbTrips}, totalCostUsd=${totalCostUsd},tripsAvgCostUsd=${tripsAvgCostUsd}" 
			log.trace "getTrips>nbTrips=${nbTrips}, totalFuelVolumeL=${totalFuelVolumeL},tripsAvgFuelVolumeL=${tripsAvgFuelVolumeL}" 
			log.trace "getTrips>nbTrips=${nbTrips}, totalAverageKmpl=${totalAverageKmpl},tripsAvgAverageKmpl=${tripsAvgAverageKmpl}" 
			log.trace "getTrips>nbTrips=${nbTrips}, totalScoreSpeeding=${totalScoreSpeeding},tripsAvgScoreSpeeding=${tripsAvgScoreSpeeding}" 
			log.trace "getTrips>nbTrips=${nbTrips}, totalScoreEvents=${totalScoreEvents},tripsAvgScoreEvents=${tripsAvgScoreEvents}" 
		}					                
		sendEvent(name: "tripsData", value: "${tripsDataJson.toString()}")
		sendEvent(name: "tripsAvgAverageKmplInPeriod", value: "${tripsAvgAverageKmpl.toString()}")
		sendEvent(name: "tripsAvgDistanceMInPeriod", value: "${tripsAvgDistanceM.toString()}")
		sendEvent(name: "tripsAvgDurationSInPeriod", value: "${tripsAvgDurationS.toString()}")
		sendEvent(name: "tripsAvgCostUsdInPeriod", value: "${tripsAvgCostUsd.toString()}")
		sendEvent(name: "tripsAvgFuelVolumeLInPeriod", value: "${tripsAvgFuelVolumeL.toString()}")
		sendEvent(name: "tripsAvgScoreSpeedingInPeriod", value: "${tripsAvgScoreSpeeding.toString()}")
		sendEvent(name: "tripsAvgScoreEventsInPeriod", value: "${tripsAvgScoreEvents.toString()}")
		    
    }

}

// 	processTripsNextPage: used when number of trips exceeds Automatic page's query limit, called by getTrips() only
// 	vehicleId - Id of the vehicle, by default the current one  
//	tripCounter - indicate the current trip record # 
//	metadata - metadata record for the overall query
def processTripsNextPage(vehicleId,tripCounter,metadata) {
	def AUTOMATIC_SUCCESS=200
	int nbTrips=tripCounter
	def id    
    
	def tripsList=device.currentValue("tripsList")

	def totalDistanceMInPeriod =  device.currentValue("totalDistanceMInPeriod")
	def totalFuelVolumeLInPeriod =  device.currentValue("totalFuelVolumeLInPeriod")
	def totalCostUsdInPeriod =  device.currentValue("totalCostUsdInPeriod")
	def totalDurationSInPeriod =  device.currentValue("totalDurationSInPeriod")
	def totalAverageKmplInPeriod =  device.currentValue("totalAverageKmplInPeriod")
	def totalHardAccelsInPeriod= device.currentValue("totalHardAccelsInPeriod")
	def totalHardBrakesInPeriod = device.currentValue("totalHardBrakesInPeriod")
	def totalScoreSpeedingInPeriod = device.currentValue("totalScoreSpeedingInPeriod")
	def totalScoreEventsInPeriod = device.currentValue("totalScoreEventsInPeriod")
    
	float totalFuelVolumeL =  (totalFuelVolumeLInPeriod)? totalFuelVolumeLInPeriod.toFloat():0
	float totalCostUsd = (totalCostUsdInPeriod)?totalCostUsdInPeriod.toFloat():0 
	float totalDistanceM =  (totalDistanceMInPeriod)?totalDistanceMInPeriod.toFloat():0
	float totalDurationS =  (totalDurationSInPeriod)?totalDurationSInPeriod.toFloat():0
	float totalAverageKmpl = (totalAverageKmplInPeriod)?totalAverageKmplInPeriod.toFloat():0
	long totalHardAccels= (totalHardAccelsInPeriod)?totalHardAccelsInPeriod.toLong():0
	long totalHardBrakes = (totalHardBrakesInPeriod)?totalHardBrakesInPeriod.toLong():0
	long totalScoreSpeeding = (totalScoreSpeedingInPeriod)? totalScoreSpeedingInPeriod.toLong():0
	long totalScoreEvents = (totalScoreEventsInPeriod)?totalScoreEventsInPeriod.toLong():0

	int j=0        
	def statusCode=true
	while ((statusCode!= AUTOMATIC_SUCCESS) && (j++ <2)) { // retries once if api call fails
		doRequest(metadata.next,null,'get') {resp->
			statusCode = resp.status        
        	if (statusCode == AUTOMATIC_SUCCESS) {
 				data?.trips=resp.data
				if (settings.trace) {
					log.debug "processTripsNextPage>nbTrips=${nbTrips},metadata=${data.trips._metadata}" 
				}				                
                
				data.trips.results.each {
					nbTrips++                    
					id= it.id
					def startedAt=it.started_at
					def endedAt=it.ended_at
					def distanceM=it.distance_m
					def durationS=it.duration_s
					def vehicleURL=it.vehicle
					def startLocation=it.start_location
					def startAddress=it.start_address
					def endLocation=it.end_location
					def endAddress=it.end_address
					def startTimezone=it.start_timezone       		
					def endTimezone=it.end_timezone       		
					def tags= it.tags       		
					def fuelCostUsd=it.fuel_cost_usd
					def fuelVolumeL=it.fuel_volume_l                    
					def averageKmpl=it.average_kmpl
					def hardAccels=it.hard_accels
					def hardBrakes=it.hard_brakes
					def scoreSpeeding=it.score_speeding
					def scoreEvents=it.score_events

					if (averageKmpl) {
						totalAverageKmpl =totalAverageKmpl +averageKmpl.toFloat()                        
					}	
					if (distanceM) {
						totalDistanceM =totalDistanceM +distanceM.toFloat()
					}
					if (durationS) {
						totalDurationS =totalDurationS +durationS.toFloat()
					}
					if (fuelCostUsd) {
						totalCostUsd =totalCostUsd +fuelCostUsd.toFloat()
					}
					if (fuelVolumeL) {
						totalFuelVolumeL =totalFuelVolumeL +fuelVolumeL.toFloat()
					}
					if (hardAccels) {
						totalHardAccels =totalHardAccels + hardAccels.toInteger()
					}
					if (hardBrakes) {
						totalHardBrakes =totalHardBrakes + hardBrakes.toInteger()
					}
					if (scoreSpeeding) {
						totalScoreSpeeding =totalScoreSpeeding + scoreSpeeding.toInteger()
					}
					if (scoreEvents) {
						totalScoreEvents =totalScoreEvents + scoreEvents.toInteger()
					}
					                    
					tripsList = tripsList + id + ','                     
					if (settings.trace) {
						log.debug "processTripsNextPage>tripId=${id},startedAt=${startedAt},endedAt=${endedAt}," +
							"distanceM=${distanceM},durationS=${durationS},vehicleURL=${vehicleURL},startLocation=${startLocation},startAddress=${startAddress}," +
							"endLocation=${endLocation},endAddress=${endAddress},startTimezone=${startTimezone},endTimezone=${endTimezone}," +       		
							"averageKmpl=${averageKmpl},fuelVolumeL=${fuelVolumeL},fuelCostUsd=${fuelCostUsd}," +
							"hardAccels=${hardAccels},hardBrakes=${hardBrakes},scoreSpeeding=${scoreSpeeding},scoreEvents=${scoreEvents}\n" +
							"vehicle_events=${it.vehicle_events}"
						sendEvent name: "verboseTrace", value: "processTripsNextPage>tripId=${id},startedAt=${startedAt},endedAt=${endedAt}," +
							"distanceM=${distanceM},durationS=${durationS},vehicleURL=${vehicleURL},startLocation=${startLocation},startAddress=${startAddress}," +
							"endLocation=${endLocation},endAddress=${endAddress},startTimezone=${startTimezone},endTimezone=${endTimezone}," +       		
							"averageKmpl=${averageKmpl},fuelVolumeL=${fuelVolumeL},fuelCostUsd=${fuelCostUsd}," +
							"hardAccels=${hardAccels},hardBrakes=${hardBrakes},scoreSpeeding=${scoreSpeeding},scoreEvents=${scoreEvents}\n" +
							"vehicle_events=${it.vehicle_events}"
						}
                        
				} /* end each */                    
				sendEvent name: "verboseTrace", value:"getTrips>done for vehicleId=${vehicleId}"
			} else {
				log.error "getTrips>error=${statusCode.toString()} for vehicleId=${vehicleId}"
				sendEvent name: "verboseTrace", value:"getTrips>error=${statusCode.toString()} for vehicleId=${vehicleId}"
                
			} /* end if statusCode */               
		}  /* end api call */              
	} /* end while */

	sendEvent(name: "tripsList", value: "${tripsList.toString()}")
	sendEvent(name: "totalDistanceMInPeriod", value: "${totalDistanceM.toString()}")
	sendEvent(name: "totalFuelVolumeLInPeriod", value: "${totalFuelVolumeL.toString()}")
	sendEvent(name: "totalCostUsdInPeriod", value: "${totalCostUsd.toString()}")
	sendEvent(name: "totalDurationSInPeriod", value: "${totalDurationS.toString()}")
	sendEvent(name: "totalAverageKmplInPeriod", value: "${totalAverageKmpl.toString()}")
	sendEvent(name: "totalHardAccelsInPeriod", value:"${totalHardAccels.toString()}")
	sendEvent(name: "totalHardBrakesInPeriod", value: "${totalHardBrakes.toString()}")
	sendEvent(name: "totalScoreSpeedingInPeriod", value: "${totalScoreSpeeding.toString()}")
	sendEvent(name: "totalScoreEventsInPeriod", value: "${totalScoreEvents.toString()}")
	
    // Process Next Page if any (recursive loop)
	if (data.trips._metadata.next) {
		if (settings.trace) {
			log.debug "processTripsNextPage>vehicleId=${vehicleId},nextPage=${data.trips._metadata.next}"
		}                
		processTripsNextPage(vehicleId,nbTrips,data.trips._metadata)			            
	} else {
    
		float tripsAvgDistanceM = totalDistanceM / nbTrips
		float tripsAvgDurationS = totalDurationS / nbTrips
		float tripsAvgCostUsd = totalCostUsd / nbTrips
		float tripsAvgFuelVolumeL = totalFuelVolumeL / nbTrips
		float tripsAvgAverageKmpl = totalAverageKmpl / nbTrips                         
		float tripsAvgScoreSpeeding =totalScoreSpeeding / nbTrips
		float tripsAvgScoreEvents =totalScoreEvents / nbTrips
	
		if (settings.trace) {
			log.trace "processTripsNextPage>nbTrips=${nbTrips}, totalDistanceM=${totalDistanceM},tripsAvgDistanceM=${tripsAvgDistanceM}" 
			log.trace "processTripsNextPage>nbTrips=${nbTrips}, totalDurationS=${totalDurationS},tripsAvgDurationS=${tripsAvgDurationS}" 
			log.trace "processTripsNextPage>nbTrips=${nbTrips}, totalCostUsd=${totalCostUsd},tripsAvgCostUsd=${tripsAvgCostUsd}" 
			log.trace "processTripsNextPage>nbTrips=${nbTrips}, totalFuelVolumeL=${totalFuelVolumeL},tripsAvgFuelVolumeL=${tripsAvgFuelVolumeL}" 
			log.trace "processTripsNextPage>nbTrips=${nbTrips}, totalAverageKmpl=${totalAverageKmpl},tripsAvgAverageKmpl=${tripsAvgAverageKmpl}" 
			log.trace "processTripsNextPage>nbTrips=${nbTrips}, totalScoreSpeeding=${totalScoreSpeeding},tripsAvgScoreSpeeding=${tripsAvgScoreSpeeding}" 
			log.trace "processTripsNextPage>>nbTrips=${nbTrips}, totalScoreEvents=${totalScoreEvents},tripsAvgScoreEvents=${tripsAvgScoreEvents}" 
		}					                
        
		sendEvent(name: "tripsAvgAverageKmplInPeriod", value: "${tripsAvgAverageKmpl.toString()}")
		sendEvent(name: "tripsAvgDistanceMInPeriod", value: "${tripsAvgDistanceM.toString()}")
		sendEvent(name: "tripsAvgDurationSInPeriod", value: "${tripsAvgDurationS.toString()}")
		sendEvent(name: "tripsAvgCostUsdInPeriod", value: "${tripsAvgCostUsd.toString()}")
		sendEvent(name: "tripsAvgFuelVolumeLInPeriod", value: "${tripsAvgFuelVolumeL.toString()}")
		sendEvent(name: "tripsAvgScoreSpeedingInPeriod", value: "${tripsAvgScoreSpeeding.toString()}")
		sendEvent(name: "tripsAvgScoreEventsInPeriod", value: "${tripsAvgScoreEvents.toString()}")
		    
    }

}

// 	vehicleId - Id of the vehicle, by default, retrieve all vehicles under a user account 
//	postData - indicates whether the data should be posted as event
void getVehicles(vehicleId, postData='false') {
	def AUTOMATIC_SUCCESS=200
	def vehiclesData=[]
	def vehiclesList=""
	def bodyReq=""
	def statusCode=true
	int j=0        
	def id    

	if (vehicleId) {
		bodyReq = "${vehicleId}/" 
	}        
    
	while ((statusCode!= AUTOMATIC_SUCCESS) && (j++ <2)) { // retries once if api call fails
		api('vehicles', bodyReq) {resp->
			statusCode= resp.status
			if (statusCode == AUTOMATIC_SUCCESS) {
				data?.vehicles=resp.data
				data.vehicles.results.each {
					if (settings.trace) {
						id = it.id
						def make = it.make
						def model = it.model
						def submodel = it.submodel
						def year = it.year
						def color = it.color
						def displayName = it.display_name
						sendEvent name: "verboseTrace", value:"getVehicles>vehicleId=${id},make=${make},model=${model}," +
							"submodel=${model},year=${year},color=${color},displayName=${displayName}"
					}
					if (postData == 'true') {
						if (settings.trace) {
							log.debug "getVehicles>adding ${data.vehicles[i]} to vehiclesData"
						}
						vehiclesData << it  // to be transformed into Json later
					}
					vehiclesList = vehiclesList + id + ','                     
				} /* end each vehicle */                
				sendEvent name: "verboseTrace", value:"getVehicles>done"
			} else {
				log.error "getVehicles>error=${statusCode.toString()}"
				sendEvent name: "verboseTrace", value:"getVehicles>error=${statusCode.toString()}"
			}                
		}  /* end api call */              
	} /* end while */
	def vehiclesDataJson=""
 
	if (vehiclesData != []) {
    
		vehiclesDataJson = new groovy.json.JsonBuilder(vehiclesData)
	}
/*	
	if (settings.trace) {
		log.debug "getVehicles>vehiclesDataJson=${vehiclesDataJson}"
	}
*/    
	def vehiclesListEvents = [
		vehiclesData: "${vehiclesDataJson.toString()}",
		vehiclesList: "${vehiclesList.toString()}"
	]
/*    
	if (settings.trace) {
		log.debug "getVehicles>vehiclesListEvents to be sent= ${vehiclesListEvents}"
	}
*/    
	generateEvent(vehiclesListEvents)

}

private def getEventName(type) {

	def events = [
		'ignition:on': 'Ignition On',
		'ignition:off': 'Ignition Off',
		'trip:finished': 'Trip Completed',
		'notification:speeding': 'Speed Exceeded Threshold',
		'notification:hard_brake': 'Hard Brake',
		'notification:hard_accel': 'Hard Acceleration',
		'region:changed': 'Region Changed',
		'parking:changed': 'Parking Location Changed',
		'mil:on': 'MIL (check engine light) On',
		'mil:off': 'MIL (check engine light) Cleared',
		'hmi:interaction': 'Car Interaction',
		'location:updated': 'Location Updated',
		'trip_finished': 'Trip Completed',
		'speeding': 'Speed Exceeded Threshold',
		'hard_brake': 'Hard Brake',
		'hard_accel': 'Hard Acceleration',
		'region_changed': 'Region Changed',
		'mil_on': 'MIL On(check engine light)',
		'mil_off': 'MIL Cleared(check engine light)',
	]    

	def event
	try {
		event = events.getAt(type)
	} catch (any) {
		event = 'unknown'
	}          
	return event
}

// trip - trip record
void generateVehicleEvents(trip) {
    
	def vehicleId=determine_vehicle_id(trip.vehicle)
                
    
	if (trip.vehicle_events) {
		log.debug "generateVehicleEvents>vehicleId= ${vehicleId}"
    
		trip.vehicle_events.each {
			def eventType=it.type
			switch (eventType) {
				case 'speeding': 
					generateEventSpeeding(vehicleId,eventType,trip.id,it)
					break
				case 'hard_accel': 
					generateEventHardAccel(vehicleId,eventType,trip.id,it)
					break
				case 'hard_brake': 
					generateEventHardBrake(vehicleId,eventType, trip.id, it)
					break
				default:
					log.error "generateVehicleEvents>event type unknown:${it.type}, data=${it}"
			} /* end switch */            
		} /* end each loop */                
	} /* end if vehicle_events */               
	generateEventTripFinished(vehicleId,'trip_finished',trip.id,trip)

	log.debug "generateVehicleEvents>done for vehicleId ${vehicleId}"

}

// 	vehicleId - Id of the vehicle, by default the current one  
// 	eventFields - event record as generated by Automatic for RT events or in vehicle_events field when calling getTrip()
void generateVehicleRTEvents(vehicleId, eventFields) {
	def eventType=eventFields.type
    
	vehicleId=determine_vehicle_id(vehicle_id)
    
	if (eventFields) {
		log.debug "generateVehicleRTEvents>vehicleId= ${vehicleId}"
		switch (eventType) {
			case 'trip:finished': 
				generateEventTripFinished(vehicleId,eventType,eventFields.trip.id,eventFields)        
				break
			case 'notification:speeding': 
				generateEventSpeeding(vehicleId,eventType,eventFields.trip.id,eventFields)
				break
			case 'notification:hard_accel': 
				generateEventHardAccel(vehicleId,eventType,eventFields.trip.id,eventFields)
				break
			case 'notification:hard_brake': 
				generateEventHardBrake(vehicleId,eventType,eventFields.trip.id,eventFields)
				break
			case 'region:changed': 
				generateEventRegionChanged(vehicleId,eventType,eventFields.trip.id,eventFields)
				break
			case 'mil:on':
			case 'mil:off':
				generateEventMilOnOff(vehicleId,eventType,eventFields.trip.id,eventFields)        
				break
			default:
				log.error "generateVehicleRTEvents>event type unknown:${eventFields.eventType}, fields=${eventFields}"
            
		}                
	} /* end if eventFields */               
	log.debug "generateVehicleRTEvents>done for vehicleId ${vehicleId}"
}
// 	vehicleId - Id of the vehicle, by default the current one  
//	eventType - type of events - see list in getEventName()  
//	tripId - Id of the trip 
// 	eventFields - event record as generated by Automatic for RT events or in vehicle_events field when calling getTrip()
def generateEventTripFinished(vehicleId,eventType,tripId,eventFields) {
    
	def type = getEventName(eventType)
	
	def vehicleEventData = [
		'eventType': type,    
		'eventVehicleId': vehicleId,    
		'eventTripId': tripId,
		'eventTripLocationAccuracyM': (eventType=='trip:finished')? eventFields.location.accuracy_m.toString():
			(eventFields.start_location.accurancy_m)?eventFields.start_location.accurancy_m.toString():'',
		'eventTripLocationLat': (eventType=='trip:finished')? 
			eventFields.location.lat.toString(): (eventFields.end_location.lat)?eventFields.end_location.lat.toString():'',
		'eventTripLocationLon': (eventType=='trip:finished')? 
			eventFields.location.lon.toString(): (eventFields.end_location.lon)?eventFields.end_location.lon.toString():'',
		'eventTripDistanceM': (eventType=='trip:finished')?
			eventFields.trip.distance_m:eventFields.distance_m, 
		'eventTripAvgFuelMPG': (eventType=='trip:finished')? 
			getConsumptionInKmpl(eventFields.trip.average_mpg): eventFields.average_kmpl,
		'eventTripStartAddress': (eventType=='trip:finished')?
			eventFields.trip.start_address.name:eventFields.start_address.name,
		'eventTripEndAddress': (eventType=='trip:finished')?
			eventFields.trip.end_address.name:eventFields.end_address.name,
		'eventTripCreatedAt': (eventType=='trip:finished')? 
			new Date(eventFields.created_at).format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone(eventFields.time_zone)):'',
		'eventTripStartedAt':(eventType=='trip:finished')?
			formatDateInLocalTime(eventFields.trip.started_at.substring(0,18) + 'Z'):formatDateInLocalTime(eventFields.started_at.substring(0,18) + 'Z'),
		'eventTripEndedAt':(eventType=='trip:finished')?
			formatDateInLocalTime(eventFields.trip.ended_at.substring(0,18) + 'Z'):formatDateInLocalTime(eventFields.ended_at.substring(0,18) + 'Z'),
	]
	String endAddress =  device.currentValue("eventTripEndAddress")
    
//	Check if endAddress affects presence settings    
	if (endAddress) {
		if ((settings.homeAddress) && (endAddress.contains(settings.homeAddress.toLowerCase()))) {
			vehicleEventData=vehicleEventData + ['presence': 'present']        
		}            
	} else if (settings.homeAddress) {
		vehicleEventData=vehicleEventData + ['presence': 'non present']        
	}    
    
	generateEvent(vehicleEventData)
    
}
    
// 	vehicleId - Id of the vehicle, by default the current one  
//	eventType - type of events - see list in getEventName()  
//	tripId - Id of the trip 
// 	eventFields - event record as generated by Automatic for RT events or in vehicle_events field when calling getTrip() 
def generateEventSpeeding(vehicleId,eventType,tripId,eventFields) {

	def type = getEventName(eventType)
	def vehicleEventData = [
		'eventType': type,    
		'eventTripId': tripId,
		'eventTripLocationLat': (eventType=='notification:speeding')? 
			eventFields.location.lat.toString(): '',
		'eventTripLocationLon': (eventType=='notification:speeding')? 
			eventFields.location.lon.toString(): '',
		'eventTripStartLocation':(eventType=='notification:speeding')?
			eventFields.trip.start_location.name : eventFields.start_distance_m.toString(),
		'eventTripEndLocation': (eventType=='notification:speeding')? 
			eventFields.trip.end_location.name :eventFields.end_distance_m.toString(),
		'eventTripSpeedKPH': (eventType=='notification:speeding')? 
			milesToKm(eventFields.speed_mpg):eventFields.velocity_kph,
		'eventTripCreatedAt': (eventType=='notification:speeding')?     
			new Date(eventFields.created_at).format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone(eventFields.time_zone)):
			formatDateInLocalTime(eventFields.started_at),
		'eventTripStartAddress': '',
		'eventTripEndAddress': '',
		'eventTripGForce': '',
		'eventTripDistanceM': '',
		'eventTripAvgFuelMPG': '',
		'eventTripLocationAccuracyM': '',
		'eventTripStartedAt': '',
		'eventTripEndedAt': ''
	]		        
    
	generateEvent(vehicleEventData)
}    
// 	vehicleId - Id of the vehicle, by default the current one  
//	eventType - type of events - see list in getEventName()  
//	tripId - Id of the trip 
// 	eventFields - event record as generated by Automatic for RT events or in vehicle_events field when calling getTrip() 
def generateEventHardAccel(vehicleId,eventType,tripId,eventFields) {

	def type = getEventName(eventType)
	def vehicleEventData = [
		'eventType': type,    
		'eventTripId': tripId,
		'eventTripLocationLat': (eventType=='notification:hard_accel')? 
			eventFields.location.lat.toString(): eventFields.lat.toString(),
		'eventTripLocationLon': (eventType=='notification:hard_accel')? 
			eventFields.location.lon.toString():eventFields.lon.toString(),
		'eventTripGForce': eventFields.g_force.toString(),
		'eventTripCreatedAt': (eventType=='notification:hard_accel')?     
			new Date(eventFields.created_at).format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone(eventFields.time_zone)):
			formatDateInLocalTime(eventFields.created_at),
		'eventTripStartLocation': '',
		'eventTripEndLocation': '',
		'eventTripStartAddress': '',
		'eventTripEndAddress': '',
		'eventTripDistanceM': '',
		'eventTripAvgFuelMPG': '',
		'eventTripSpeedKPH': '',
		'eventTripLocationAccuracyM': '',
		'eventTripStartedAt': '',
		'eventTripEndedAt': ''
	]
	generateEvent(vehicleEventData)
}
// 	vehicleId - Id of the vehicle, by default the current one  
//	eventType - type of events - see list in getEventName()  
//	tripId - Id of the trip 
// 	eventFields - event record as generated by Automatic for RT events or in vehicle_events field when calling getTrip() 
def generateEventHardBrake(vehicleId,eventType,tripId,eventFields) {

	def type = getEventName(eventType)
	def vehicleEventData = [
		'eventType': type,    
		'eventTripId': tripId,
		'eventTripLocationLat': (eventType=='notification:hard_brake')? 
			eventFields.location.lat.toString(): eventFields.lat.toString(),
		'eventTripLocationLon': (eventType=='notification:hard_brake')? 
			eventFields.location.lon.toString():eventFields.lon.toString(),
		'eventTripGForce': eventFields.g_force.toString(),
		'eventTripCreatedAt': (eventType=='notification:hard_brake')?  
			new Date(eventFields.created_at).format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone(eventFields.time_zone)):
			formatDateInLocalTime(eventFields.created_at),
		'eventTripStartLocation': '',
		'eventTripEndLocation': '',
		'eventTripStartAddress': '',
		'eventTripEndAddress': '',
		'eventTripDistanceM': '',
		'eventTripAvgFuelMPG': '',
		'eventTripSpeedKPH': '',
		'eventTripLocationAccuracyM': '',
		'eventTripStartedAt': '',
		'eventTripEndedAt': ''
	]
	generateEvent(vehicleEventData)
}
// 	vehicleId - Id of the vehicle, by default the current one  
//	eventType - type of events - see list in getEventName()  
//	tripId - Id of the trip 
// 	eventFields - event record as generated by Automatic for RT events or in vehicle_events field when calling getTrip() 
def generateEventRegionChanged(vehicleId,eventType,tripId,eventFields) {

	def type = getEventName(eventType)	
	def vehicleEventData = [
		'eventType': type,    
		'eventVehicleId': vehicleId,    
		'eventTripCreatedAt': (eventType=='region:changed')?
			new Date(eventFields.created_at).format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone(eventFields.time_zone)):
			formatDateInLocalTime(eventFields.created_at),
		'eventTripId': tripId,    
		'eventTripLocationLat': (eventType=='region:changed')?
			eventFields.location.lat.toString(): eventFields.lat.toString(),
		'eventTripLocationLon': (eventType=='region:changed')? 
			eventFields.location.lon.toString():eventFields.lon.toString(),
		'eventTripRegionStatus': (eventType=='region:changed')?
			eventFields.region.status:eventFields.region.status,
		'eventTripRegionName': (eventType=='region:changed')?
			eventFields.region.name:eventFields.region.name,
		'eventTripRegionTag': (eventType=='region:changed')?
			eventFields.region.tag: eventFields.region.tag,        
		'eventTripStartLocation': '',
		'eventTripEndLocation': '',
		'eventTripStartAddress': '',
		'eventTripEndAddress': '',
		'eventTripDistanceM': '',
		'eventTripAvgFuelMPG': '',
		'eventTripSpeedKPH': '',
		'eventTripLocationAccuracyM': '',
		'eventTripStartedAt': '',
		'eventTripEndedAt': ''
	]
	generateEvent(vehicleEventData)
}
// 	vehicleId - Id of the vehicle, by default the current one  
//	eventType - type of events - see list in getEventName()  
//	tripId - Id of the trip 
// 	eventFields - event record as generated by Automatic for RT events or in vehicle_events field when calling getTrip() 
def generateEventMilOnOff(vehicleId,eventType,eventFields) {

	String eventCreatedAt = new Date(eventFields.created_at).format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone(eventFields.time_zone))        
	def type = getEventName(eventType)
	
	eventsFields.dtcs.each {
		def vehicleEventData = [
			'eventVehicleId': vehicleId,    
			'eventTripId': eventFields.trip.id,    
			'eventTripCreatedAt': eventCreatedAt,    
			'eventType': type,    
			'eventTripLocationLat': eventFields.location.lat.toString(),
			'eventTripLocationLon': eventFields.location.lon.toString(),
			'eventTripCode': it.code,    
			'eventTripDescription': it.description,    
			'eventTripStartLocation': '',
			'eventTripEndLocation': '',
			'eventTripStartAddress': '',
			'eventTripEndAddress': '',
			'eventTripDistanceM': '',
			'eventTripAvgFuelMPG': '',
			'eventTripSpeedKPH': '',
			'eventTripLocationAccuracyM': '',
			'eventTripStartedAt': '',
			'eventTripEndedAt': ''
		]
		generateEvent(vehicleEventData)
	}
}

void getCurrentUserInfo() {
	def AUTOMATIC_SUCCESS=200

	def statusCode=true
	int j=0        
	while ((statusCode != AUTOMATIC_SUCCESS) && (j++ <2)) { // retries once if api call fails

		if (settings.trace) {
			log.debug "getCurrentUserInfo>about to call api"
		}
		api('currentUserInfo', null) {resp ->
			statusCode = resp.status        
			if (statusCode == AUTOMATIC_SUCCESS) {
        			data?.user=resp.data
				if (settings.trace) {
					log.debug "getCurrentUserInfo>resp data = ${resp.data}" 
                
				}
				def userid = data.user.id
				def username = data.user.username
				def email = data.user.email
				def firstName = data.user.first_name  
				def lastName = data.user.last_name  
				if (settings.trace) {
					sendEvent name: "verboseTrace", value: "getCurrentUserInfo>userId=${userId},name=${username},email=${email},firstName=${firstName},lastName=${lastName}"
				}
				sendEvent name: "verboseTrace", value:"getCurrentUserInfo>done"
			} else {
				log.error "getCurrentUserInfo>error=${statusCode.toString()}"
				sendEvent name: "verboseTrace", value:"getCurrentUserInfo>error=${statusCode.toString()}"
			} /* end if statusCode */                
		}  /* end api call */              
	} /* end while */
}


private def refresh_tokens() {
        
	def method = 
	[
		headers: [
			'Content-Type': "application/json",
			'charset': "UTF-8"
			],
		uri: "${get_URI_ACCOUNT_ROOT()}/oauth/access_token?", 
		body: toQueryString([grant_type:"refresh_token",client_id:get_appKey(),client_secret:get_refresh_token()])
	]
	if (settings.trace) {
		log.debug "refresh_tokens> uri = ${method.uri}"
	}
	def successRefreshTokens = {resp ->
		if (settings.trace) {
			log.debug "refresh_tokens> response = ${resp.data}"
		}
		data.auth.access_token = resp.data.access_token
		data.auth.refresh_token = resp.data.refresh_token
		data.auth.expires_in = resp.data.expires_in
		data.auth.token_type = resp.data.token_type
		data.auth.scope = resp.data.scope
	}
	try {
		httpPostJson(method, successRefreshTokens)
	} catch (java.net.UnknownHostException e) {
		log.error "refresh_tokens> Unknown host - check the URL " + method.uri
		sendEvent name: "verboseTrace", value: "refresh_tokens> Unknown host"
		return false
	} catch (java.net.NoRouteToHostException t) {
		log.error "refresh_tokens> No route to host - check the URL " + method.uri
		sendEvent name: "verboseTrace", value: "refresh_tokens> No route to host"
		return false
	} catch (java.io.IOException e) {
		log.error "refresh_tokens>Authentication error, automatic servers cannot be reached at " + method.uri
		sendEvent name: "verboseTrace", value: "refresh_tokens>Authentication error, automatic servers cannot be reached at " + method.uri
		return false
	} catch (any) {
		log.error "refresh_tokens> general error " + method.uri
		sendEvent name: "verboseTrace", value:
			"refresh_tokens> general error at ${method.uri}"
		return false
	}
	def authexptime = new Date((now() + (365 * 24 * 60 * 1000))).getTime() // token expires in a year
	data.auth.authexptime = authexptime

	if (data.auth.sensorId) {		// Created by initalSetup, need to refresh Parent tokens and other children
		refreshParentTokens()
	}        
	if (settings.trace) {
		log.debug "refresh_tokens> data_auth.expires_in in time = ${authexptime}"
		sendEvent name: "verboseTrace", value:
			"refresh_tokens>expire in ${data.auth.expires_in} minutes"
	}
	return true
}

void refreshChildTokens(auth) {
	if (settings.trace) {
		log.debug "refreshChildTokens>begin token auth= $auth"
	}
	data.auth.access_token = auth.authToken
	data.auth.refresh_token = auth.refreshToken
	data.auth.expires_in = auth.expiresIn
	data.auth.token_type = auth.tokenType
	data.auth.scope = auth.scope
	data.auth.authexptime = auth.authexptime
	if (settings.trace) {
		log.debug "refreshChildTokens>end data.auth=$data.auth"
	}
}

private void refreshParentTokens() {
	if (settings.trace) {
		log.debug "refreshParentTokens>begin data.auth = ${data.auth}"
	}
	if (settings.trace) {
		log.debug "refreshParentTokens>auth=$auth, about to call parent.setParentAuthTokens"
	}         
	parent.setParentAuthTokens(data.auth)
	if (settings.trace) {
		log.debug "refreshParentTokens>end"
	}         
}

private void login() {
	if (data?.auth.vehicleId) {
    	// Created by initalSetup
		if (settings.trace) {
			log.debug "login> about to call refreshThisChildAuthTokens"
		}
		parent.refreshThisChildAuthTokens(this)
	} else { 
		if (settings.trace) {
			log.debug "login> about to call setAuthTokens, data auth=$data?.auth"
		}
		setAuthTokens()
	}    
	if (!isLoggedIn()) {
		if (settings.trace) {
			log.debug "login> no auth_token..., failed"
		}
		return
	}
}



void setAuthTokens() {
	def method = 
	[
		headers: [
			'charset': "UTF-8",
			'Content-Type': "application/x-www-form-urlencoded"
			],
		uri: "${get_URI_ACCOUNT_ROOT()}/oauth/access_token?",
		body: toQueryString([grant_type:"client_credentials",client_id:get_appKey(),client_secret:get_client_secret()])
	]
	def successTokens = {resp ->
		if (settings.trace) {
			log.debug "setAuthTokens> resp data= ${resp.data}"
		}
        
        
		data?.auth = resp.data
		data.auth.access_token = resp.data.access_token
		data.auth.expires_in = resp.data.expires_in
		data.auth.token_type = resp.data.token_type
		if (settings.trace) {
			log.debug "setAuthTokens> accessToken= ${data.auth.access_token}," +
				"tokenType=${data.auth.token_type}"
		}
	}
	try {
		httpPostJson(method, successTokens)

	} catch (java.net.UnknownHostException e) {
		log.error "setAuthTokens> Unknown host - check the URL " + method.uri
		sendEvent name: "verboseTrace", value: "setAuthTokens> Unknown host " +
			method.uri
		return
	} catch (java.net.NoRouteToHostException t) {
		log.error "setAuthTokens> No route to host - check the URL " + method.uri
		sendEvent name: "verboseTrace", value: "setAuthTokens> No route to host" +
			method.uri
		return
	} catch (java.io.IOException e) {
		log.error "setAuthTokens> Auth error, automatic servers cannot be reached at " +
			method.uri
		sendEvent name: "verboseTrace", value: "setAuthTokens> Auth error " +
			method.uri
		return
	}	        

	// determine token's expire time
	def authexptime = new Date((now() + (data.auth.expires_in * 365 * 24* 60 * 1000))).getTime()
	data.auth.authexptime = authexptime
	if (settings.trace) {
		log.debug "setAuthTokens> expires in ${data.auth.expires_in} minutes"
		log.debug "setAuthTokens> data_auth.expires_in in time = ${authexptime}"
		sendEvent name: "verboseTrace", value:
			"setAuthTokens>expire in ${data.auth.expires_in} minutes"
	}
}
private def isLoggedIn() {
	if (data.auth == null) {
		if (settings.trace) {
			log.debug "isLoggedIn> no data auth"
		}
		return false
	} else {
		if (data.auth.access_token == null) {
			if (settings.trace) {
				log.debug "isLoggedIn> no access token"
				return false
			}
		}
	}
	return true
}
private def isTokenExpired() {
	def buffer_time_expiration=5   // set a 5 min. buffer time before token expiration to avoid auth_err 
	def time_check_for_exp = now() + (buffer_time_expiration * 60 * 1000);
	if (settings.trace) {
		log.debug "isTokenExpired> check expires_in: ${data.auth.authexptime} > time check for exp: ${time_check_for_exp}"
	}
	if (data.auth.authexptime > time_check_for_exp) {
		if (settings.trace) {
			log.debug "isTokenExpired> not expired"
		}
		return false
	}
	if (settings.trace) {
		log.debug "isTokenExpired> expired"
	}
	return true
}

// Determine id from settings or initalSetup
private def determine_vehicle_id(vehicle_id) {
	def vehicleId
    
	if ((vehicle_id != null) && (vehicle_id.trim() != "")) {
		vehicleId = vehicle_id.trim()
	} else if ((settings.vehicleId != null) && (settings.vehicleId.trim()  != "")) {
		vehicleId = settings.vehicleId.trim()
		if (settings.trace) {
			log.debug "determine_vehicle_id> vehicleId = ${settings.vehicleId}"
		}
	} else if (data?.auth?.vehicleId != null) {
    
		state.appKey = get_appKey() 
		settings.vehicleId = data.auth.vehicleId
		vehicleId=settings.vehicleId
		if (settings.trace) {
			log.debug "determine_vehicle_id> vehicleId from data.auth= ${vehicleId}"
		}
    
	} else  {
		settings.vehicleId = data.vehicles.results[0].id
		vehicleId=settings.vehicleId
		if (settings.trace) {
			log.debug "determine_vehicle_id> sensorId from data.vehicles.results[0].id= ${vehicleId}"
		}
	}
	return vehicleId
}

// Get the appKey for authentication
private def get_appKey() {
	return state.appKey
}    


// Get the client's refresh token

private def get_refresh_token() {
	return data.auth.refresh_token
}    

// Called by My AutomaticServiceMgr for initial creation of a child Device
void initialSetup(device_client_id, auth_data, device_automatic_id) {

	settings.trace='true'
	
	if (settings.trace) {
		log.debug "initialSetup>begin"
		log.debug "initialSetup> device_automatic_Id = ${device_automatic_id}"
		log.debug "initialSetup> device_client_id = ${device_client_id}"
	}	
	state?.appKey= device_client_id
	settings.vehicleId = device_automatic_id
	data?.auth = settings    
	data.auth.access_token = auth_data.authToken
	data.auth.refresh_token = auth_data.refreshToken
	data.auth.expires_in = auth_data.expiresIn
	data.auth.token_type = auth_data.tokenType
	data.auth.authexptime= auth_data.authexptime
	state.lastEndDate= (new Date() -1).getTime()     
    
	if (settings.trace) {
		log.debug "initialSetup> settings = $settings"
		log.debug "initialSetup> data_auth = $data.auth"
		log.debug "initialSetup>end"
	}
	getCurrentUserInfo()
	getVehicles(device_automatic_id)
	poll()
}

def toQueryString(Map m) {
	return m.collect { k, v -> "${k}=${URLEncoder.encode(v.toString())}" }.sort().join("&")
}

private def get_URI_ROOT() {
	return "https://api.automatic.com"
}

private def get_URI_ACCOUNT_ROOT() {
	return "https://accounts.automatic.com"
}

