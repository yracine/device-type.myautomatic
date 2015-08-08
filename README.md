# device-type.myautomatic

Author:             Yves Racine

linkedIn profile:   ca.linkedin.com/pub/yves-racine-m-sc-a/0/406/4b/

Date:               2015-03-15

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

b) Hit the "+New SmartDevice" at the top right corner

c) Hit the "From Code" tab on the left corner

d) Copy and paste the code from neurio.devicetype
under https://github.com/yracine/device-type.myautomatic/blob/master/myautomatic.devicetype.groovy

e) Hit the create button at the bottom

f) Hit the "publish/for me" button at the top right corner (in the code window)

/*******************************************************************************************************************/

<b>3) Create a new smartapp (MyAutomaticServiceMgr)</b>
/*******************************************************************************************************************/


a) Go to https://graph.api.smartthings.com/ide/apps

b) Hit the "+New SmartApp" at the top right corner

c) Hit the "From Code" tab on the left corner

d) Copy and paste the code from MyAutomaticServiceMgr
under https://github.com/yracine/device-type.myautomatic/tree/master/smartapps

e) Hit the create button at the bottom

f) <b>Make sure that enable OAuth in Smartapp settings is active</b> 

* Goto app settings (top right corner), 
* Click on Oauth (middle of the page), and enable OAuth in Smart app
* Hit "Update" at the bottom

g) Go back to the code window, and hit the "publish/for me" button at the top right corner 

/*******************************************************************************************************************/

<b>4) Activate live logging for more tracing</b> 
/*******************************************************************************************************************/

This is useful for debugging in case of any error/exception.

Go to https://graph.api.smartthings.com/ide/logs


/*******************************************************************************************************************/

<b>5) Use SmartSetup and execute MyAutomaticServiceMgr</b>
/*******************************************************************************************************************/


From your phone or tablet, within the smarttings app and on the main screen, click on '+' at the bottom, scroll right to to My Apps, and execute MyAutomaticServiceMgr.

The smartapp will ask you to authenticate on the Neurio portal (by pressing on MyAutomaticon the first page), and then
after the authentication, will show you the list of sensor(s) under your Automatic developer Account (by pressing 'Next' at the top right corner). 

On the next page, you can then select the sensor(s) to be exposed to SmartThings.


After pressing 'Done' on the last page, the smartapp will instantiate the MyNeurio device object under 

https://graph.api.smartthings.com/device/list


/*******************************************************************************************************************/

7) Under the SmartThings app (on your tablet or smartphone), you should then
see the new Automatic Object(s) under the 'Things' shortcut on the dashboard

/*******************************************************************************************************************/



/*******************************************************************************************************************/

8) (optional) After instantiation of MyAutomatic Objects, you can enable more tracing 
at the device level (for debugging only, can affect performance)

/*******************************************************************************************************************/


Edit the preferences of MyAutomatic device(s) to enable more tracing

- Go to https://graph.api.smartthings.com/device/list
- Click on the My Automatic object in the list
- Edit the preferences by clicking on 'edit' (middle of the page) 
- Set the trace input parameter to true 
- Set the homeAddress parameter to your zipcode or street name, city 
- Save the changes by clicking 'Save' at the bottom.




