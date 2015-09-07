# device-type.myautomatic

Author:             Yves Racine

linkedIn profile:   ca.linkedin.com/pub/yves-racine-m-sc-a/0/406/4b/

Date:               2015-08-08

Code: http://github.com/yracine/device-type.myautomatic

**************************************************************************************************
If you like My Automatic device and related smartapps, please support the developer:


<br/> [![PayPal](https://www.paypalobjects.com/en_US/i/btn/btn_donate_SM.gif)](
https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=yracine%40yahoo%2ecom&lc=US&item_name=Maisons%20ecomatiq&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest)

=====================
INSTALLATION STEPS
=====================


/*******************************************************************************************************************/

<b>1) Create a new device type (My Automatic Device) for your device(s)</b>
/*******************************************************************************************************************/

a) Go to https://graph.api.smartthings.com/ide/devices

b) Hit the "+New Device Type" at the top right corner

c) Hit the "From Code" tab on the left corner

d) Copy and paste the code from myautomatic.devicetype
under https://github.com/yracine/device-type.myautomatic/blob/master/myautomatic.devicetype

e) Hit the create button at the bottom

f) Hit the "publish/for me" button at the top right corner (in the code window)

/*******************************************************************************************************************/

<b>2) Create a new smartapp (MyAutomaticServiceMgr)</b>
/*******************************************************************************************************************/

a) Go to https://graph.api.smartthings.com/ide/apps

b) Hit the "+New SmartApp" at the top right corner

c) Hit the "From Code" tab on the left corner

d) Copy and paste the code from MyAutomaticServiceMgr
under http://github.com/yracine/device-type.myautomatic/blob/master/smartapps/myAutomaticServiceMgr

e) Hit the create button at the bottom

f) <b>Make sure that enable OAuth in Smartapp settings is active</b> 

* Goto app settings (top right corner), 
* Click on Oauth (middle of the page), and enable OAuth in Smart app
* Hit "Update" at the bottom

g) Go back to the code window, and hit the "publish/for me" button at the top right corner 

h) Keep the smartapp open in your IDE for the next step

/*******************************************************************************************************************/

<b>3) Create/login to your Automatic Developer account</b>
/*******************************************************************************************************************/

a) Open a new browser tab, and go to http://developer.automatic.com and create your developer account if needed

b) Go to https://developer.automatic.com/my-apps

c) Create a new app and name it "SmartThings"

d) Copy and paste your Automatic client id to the MyAutomaticServiceMgr smartapp at the bottom of the file where "insert Automatic Public Key here!" is indicated

e) Copy and paste your Automatic secret id to the MyAutomaticServiceMgr smartapp at the bottom of the file where "insert Automatic private Key here!" is indicated

f) Using the ST IDE, save and Publish the MyAutomaticServiceMgr smartapp with your credentials.


/*******************************************************************************************************************/

<b>4) Activate live logging for more tracing</b> 
/*******************************************************************************************************************/


Go to 

https://graph.api.smartthings.com/ide/logs

Note: In the next step, as Automatic does not presently support wildcard URL redirection to many ST users, you'd need to copy and paste the redirect URL generated by the smartapp at the Automatic portal.


/*******************************************************************************************************************/

<b>5) Execute MyAutomaticServiceMgr</b>
/*******************************************************************************************************************/


a) From your phone or tablet, within the smartThings app and on the main screen, click on '+' at the bottom, under SmartApps, scroll down to My Apps, and execute MyAutomaticServiceMgr.

<b>If you have upgraded to the new UI, click on the Smartapps link in the upper section of any of the following
screens: Home & Marketspace, and then MyApps (last item in the list).</b>


b) The smartapp will ask you to authenticate on the Automatic portal (by pressing Next on the first page)

c) Press on MyAutomatic in the middle of the login page

d) The Automatic login page will appear with the following error message:

<i>Error: invalid request</i>

e) In the IDE, under https://graph.api.smartthings.com/ide/logs, you should see
the following trace:

<i>buildRedirectUrl,redirectURL=https://graph.api.smartthings.com/api/token/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/smartapps/installations/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/swapToken</i>
 
f) Copy and paste the redirect URL to the Automatic Developer portal under OAuth Redirect URL 

g) Save the URL redirect value at the Automatic Developer Portal

h) Press back on your device to re-login by pressing again on MyAutomatic in the middle of the page 

i) The Automatic login page should re-appear without any error message, enter your Automatic credentials

j) After being authenticated and pressing 'done' and 'next', the smartapp will show you the list of device(s) under your Automatic Account

k) You may then select the Automatic device(s) to be exposed to SmartThings.

After pressing 'Done' on the last page, the smartapp will instantiate the MyAutomatic device object under 

https://graph.api.smartthings.com/device/list


/*******************************************************************************************************************/

<b>7) Under the SmartThings app (on your tablet or smartphone), you should then
see the new Automatic Object(s) under the 'Things' shortcut on the dashboard</b>

/*******************************************************************************************************************/

Click on it (gear icon at the top right corner) and press refresh several times to populate its fields

/*******************************************************************************************************************/

<b>8) (optional) After instantiation of MyAutomatic object, you can edit its preferences and set your home
address for presence purposes</b>

/*******************************************************************************************************************/


Edit the preferences of MyAutomatic device(s) to set your home address or enable more tracing

- Go to https://graph.api.smartthings.com/device/list
- Click on the My Automatic object in the list
- Edit the preferences by clicking on 'edit' (middle of the page) 
- Set the homeAddress parameter to your zipcode or street name, city 
- Set the trace input parameter to true (for debugging purposes only)
- Save the changes by clicking 'Save' at the bottom.


/*******************************************************************************************************************/

<b>9) (optional) Install some of my SmartApp(s)</b>
/*******************************************************************************************************************/

See Under 

https://github.com/yracine/device-type.myautomatic/tree/master/smartapps

<b>a) MonitorAutomaticCar</b>

<b>Typical Use Case: Parents may want to closely monitor their kids' car driving abilities.</b>

The smartapp can detect any Speeding, Hard Acceleration, Hard Brake events after a trip has been completed and alerts parents of bad driving behaviors.

Parents may want to set a minimum Speeding Score or Events Score and if the kids' scores go below these thresholds, the parents will be notified ASAP.

The monitoring could be even more tight during the wet/snow season. Based on weatherStation, it can automatically switch to a monitoring cycle interval in minutes instead of hours when it's raining or snowing outside.....

See the virtual weather station at

https://github.com/yracine/device-type.weatherstation


<b>b) automaticReport</b>

The smartapp allows a ST user to generate daily reports on Automatic Connected vehicle's events.


