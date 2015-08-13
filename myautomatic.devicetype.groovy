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

