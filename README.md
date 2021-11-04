(DEPRECATED)
# device-type.myautomatic

Author:             Yves Racine

linkedIn profile:   ca.linkedin.com/pub/yves-racine-m-sc-a/0/406/4b/

Date:               2015-08-08


**************************************************************************************************

You can now download the code at 

<b>
http://www.maisonsecomatiq.com/#!store/tc3yr 
</b>

P.S. Technical support packages are also available.

Setup time: About 10-15 minutes (with real time processing) depending on your ST skills.

PREREQUISITES
=====================

- (a) Basic information about your car entered in the Automatic app or at the Automatic portal
    (ex.  model, submodel, color, etc)
- (b) Your Automatic connected vehicle fully operational
- (c) Your Automatic credentials (username/password)
- (d) Developer access to SmartThings (http://graph.api.smartthings.com/)
- (e) <b>Location set for your ST account under the ST classic mobile app</b> 

Under the ST classic mobile app, click on the 3-horizontal lines- "hamburger"- menu in the upper left corner, and then the "gear'" icon to review your location and save it.

https://support.smartthings.com/hc/en-us/articles/205956850-How-to-edit-Location-settings

- (f) <b> Determine your shard, please consult this thread: </b>

https://community.smartthings.com/t/faq-how-to-find-out-what-shard-cloud-slice-ide-url-your-account-location-is-on/53923

Or the SmartThings documentation here for more details:


http://docs.smartthings.com/en/latest/publishing/index.html#ensure-proper-location


<b>If you are on a different shard, you need to change the links below for your right shard. 
As an example, in North America, </b>

replace https://graph.api.smartthings.com/ide/devices by https://graph-na02-useast1.api.smartthings.com


Or use  https://consigliere-regional.api.smartthings.com/ to point to the right shard.

INSTALLATION STEPS
=====================



# 1) In the IDE, create a new device handler (My Automatic Device) for your device(s)

a) Go to https://graph.api.smartthings.com/ide/devices    (or whatever your shard is and click on My Device Handlers in the IDE's top menu)

b) Hit the "+New Device Handler" at the top right corner

c) Hit the "From Code" tab on the left corner

d) Copy and paste the code of the device type from the source file in the zip

After you purchase the code at my store, it is sent to your paypal verified email address by the sellfy e-commerce solution

e) Hit the create button at the bottom

f) Hit the "publish/for me" button at the top right corner (in the code window)


# 2) In the IDE, create a new smartapp (MyAutomaticServiceMgr)


a) Go to https://graph.api.smartthings.com/ide/apps    (or whatever your shard is and click on My Smartapps in the IDE's top menu)

b) Hit the "+New SmartApp" at the top right corner

c) Hit the "From Code" tab on the left corner

d) Copy and paste the code from MyAutomaticServiceMgr from the source file in the zip

After you purchase the code at my store, it is sent to your paypal verified email address by the sellfy e-commerce solution

e) Hit the create button at the bottom

<b>f) Make sure that enable OAuth in Smartapp settings is active</b> 

* Goto app settings (top right corner, click on it)
* Click on Oauth (middle of the page), and enable OAuth in Smart app
* Hit "Update" at the bottom

g) Go back to the code window, and hit the "publish/for me" button at the top right corner 

h) Keep the smartapp open in your IDE for the next step

If the instructions above are not clear enough, you can refer to the troubleshooting section below with some pictures:

http://thingsthataresmart.wiki/index.php?title=MyAutomaticServiceMgr#Issue_.231:_I_don.27t_know_how_to_create_a_custom_smartapp


# 3) At the automatic portal, create/login to your Automatic Developer account


<b>a) Open a new browser tab, and go to http://developer.automatic.com and create your developer account if needed</b>

<b>b) Go to https://developer.automatic.com/my-apps</b>    

<b>c) Create a new app with the name of your choice (ex. your own name to be unique).</b>

<b>d) Copy and paste your Automatic client id to the MyAutomaticServiceMgr smartapp at the bottom of the file where "insert Automatic Public Key here!" is indicated</b>

<b>e) Copy and paste your Automatic secret id to the MyAutomaticServiceMgr smartapp at the bottom of the file where "insert Automatic private Key here!" is indicated</b>

Examples of keys, not valid at Automatic:

def getSmartThingsClientId() { "kjPlS3AAQtaUGlmB30IU9g" }

def getSmartThingsPrivateKey() { "6Qg0niXeQDSk-dkfU475og" }

<b>f) Using the ST IDE, save and publish the MyAutomaticServiceMgr smartapp with your credentials.</b>


<b>g)(optional) For better presence detection, I've included the option to insert your GOOGLE KEY for the Location APIs.
As Automatic doesn't provide address info for people located outside of the US anymore (since July 2017), this is required
for people located outside of the US.

- Insert your GOOGLE API Key at the end of MyServiceAutomaticMgr file (only if you're located outside of the US)

Refer to the following instructions for more details:

// Go to https://developers.google.com/maps/documentation/geocoding/get-api-key

// Make sure that your key is registered for your project at https://console.developers.google.com/apis/credentials

def get_GOOGLE_LOCATION_API_KEY() { return "Insert your GOOGLE Key Here!" }


# 4) In the IDE, activate live logging for more tracing


Go to 

https://graph.api.smartthings.com/ide/logs   (or whatever your shard is and click on Live Logging in the IDE's top menu)

Note: In the next step, as Automatic does not presently support wildcard URL redirection to many ST users, you'd need to copy and paste the redirect URL generated by the smartapp at the Automatic portal.


# 5) Under the ST classic mobile app, execute MyAutomaticServiceMgr (MarketSpace>Smartapps>MyApps)


<b>a) Under the ST app, click on the Smartapps link in the upper section of the following Marketspace screen (last icon at the bottom), and then MyApps (last item in the list).</b>

<b>b) The smartapp will ask you to authenticate on the Automatic portal (by pressing Next on the first page)</b>

<b>c) Press on MyAutomatic in the middle of the login page</b>

<b>d) The Automatic login page will appear 


<b>e) In the IDE, under https://graph.api.smartthings.com/ide/logs (or according to your shard) or under the device's list of events, you should see the following trace:</b>

<i>buildRedirectUrl,redirectURL=https://graph.api.smartthings.com:port/api/token/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/smartapps/installations/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/swapToken</i>
 
<b>f) Copy and paste your base redirect URL (format: https://graph.api.smartthings.com:port/)  to the Automatic Developer portal under the URL field </b>

<b>g) Save your base URL value at the Automatic Developer Portal</b>

<b>h) Copy and paste the full redirect URL (format: https://graph.api.smartthings.com:port/api/token/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/smartapps/installations/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/swapToken)  to the Automatic Developer portal under the URL oAUth Redirect field and Save!</b>

 <b> P.S. If you don't save the Base URL prior to this field, the Automatic Developer portal will not save the full oAUth redirect URL correctly!!</b>

<b>i) Under the ST classic mobile app, in the MyAutomaticServiceMgr smartapp, enter your Automatic username and password and press 'Authorize' in the next page.

<b>j) After being authenticated and pressing 'done' and 'next', the smartapp will show you the list of device(s) under your Automatic Account</b>

If you get a blank screen after pressing 'Next or you get the following error: " Error - bad state' or 'Java.lang.NullPointerException: Cannot get property 'accessToken' on null object" in the IDE', <b>you'd need to enable oAuth as specified in step 2f) above.</b>

<b>For any other errors, you'd need to double check your base & redirect URLs. Make sure that they don't contain any extra spaces or other extra characters.</b>

<b>k) You may then select the Automatic device(s) to be exposed to SmartThings.</b>

*************************************************************************************************************************************
N.B. If you have any errors:

<b> At the end of the authorization flow,  if you have the following error message: "Unexpected error" even if you press several times, this probably means that you have not "saved & published" one of the Device Handler Type (MyAutomaticDevice) under the right shard.  Refer to the prerequisites & step 1 for more details.
 
Also, depending on the ST platform status, you may have to press "Save" several times if you have the following error message: "Error processing your request - please try again".  This is due to some ST platform timeouts due to rate limiting.</b> 
 
*************************************************************************************************************************************


The smartapp will instantiate the MyAutomatic device object under 

https://graph.api.smartthings.com/device/list<b>   (or whatever your shard is and click on My Devices in the IDE's top menu)


# 7) Under the ST classic mobile app, view the Automatic device(s) 

On your tablet or smartphone, you should then see the new Automatic Object(s) under the 'myHome/Things' shortcut on the dashboard

Click on it (or them)  and press refresh several times to populate its fields



# 8) (Optional) Set Device's preferences

Edit the preferences of MyAutomatic device(s) to set your home address or enable more tracing

Go to https://graph.api.smartthings.com/device/list   (or whatever your shard is and click on My Devices in the IDE's top menu)
- Click on the My Automatic object in the list
- Edit the preferences by clicking on 'edit' (middle of the page) 
- Set the homeAddress parameter to your zipcode or street name (minimum information for presence detection) 
- Set the trace input parameter to true (for debugging purposes only)
- Edit the localFuelCostPerVolUnit parameter to reflect your local fuel cost per gallon/liter
- Save the changes by clicking 'Save' at the bottom.

 You only need to edit the above parameters

 P.S. Don't enter any values the vehicleId or for the appKey as the values are only
    used for the PIN authentication method.  If you do it, you may
    experience authentication issues when used with MyAutomaticServiceMgr smartapp.
    

# 9) <i>NEW:</i> To enable near real-time automatic events processing in SmartThings


a) At the Automatic Developer portal, copy the OAuth Redirect URL field entered in step 5f)

The field's value should be similar to:

<i>https://graph.api.smartthings.com:port/api/token/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/smartapps/installations/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/swapToken</i> 
 
b) Paste the redirect URL to the Automatic Developer portal under Webhook URL field

<b>c) Substitute "swapToken" by "procEvent" in the field (at the end)</b>

The field value should now look like:

<i>https://graph.api.smartthings.com:port/api/token/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/smartapps/installations/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/procEvent</i> 

d) Make sure that the Event Delivery Preference field is set to "WEBHOOK"

e) Save the URL value at the Automatic Developer Portal




# 10) (optional) Install some of my SmartApps

See Under 

https://github.com/yracine/device-type.myautomatic/tree/master/smartapps  (or whatever your shard is and click on My Smartapps in the IDE's top menu)



<b>a) automaticReport</b>

The smartapp allows a ST user to generate daily reports on Automatic Connected vehicle's events such as Hard Acceleration,Hard Brake and Speeding.

<b>b) automaticCarHA</b>

The smartapp allows a ST user to create their own home automation scenarios based on the following list of real-time Automatic events.
It can turn on/off/flash some switch(es) and/or execute a routine.

The list of RT Automatic events are:

- 'ignition:on',
- 'ignition:off',
- 'trip:finished',
- 'notification:speeding',
- 'notification:hard_brake',
- 'notification:hard_accel',
- 'mil:on',  (check engine light On)
- 'mil:off', (check engine light Off)
- 'hmi:interaction',
- 'location:updated',


<b>c) MonitorAutomaticCar</b>

Available at my store:

www.ecomatiqhomes.com/store

<b>Typical Use Case: Parents may want to closely monitor their kids' car driving abilities.</b>

The smartapp can detect any Speeding, Hard Acceleration, Hard Brake events during a trip (in quasi real time) and alerts parents of bad driving behaviors.

Parents may want to set a minimum Speeding Score or Events Score and if the kids' scores go below these thresholds, the parents will be notified ASAP.

The monitoring could be even more tight during the wet/snow season. Based on weatherStation, it can automatically switch to a monitoring cycle interval in minutes instead of hours when it's raining or snowing outside.....

See the virtual weather station at

https://github.com/yracine/device-type.weatherstation
