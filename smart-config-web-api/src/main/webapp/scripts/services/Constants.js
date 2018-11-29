/**
 * Defines the constants related to 'REST_URLS' and 'LANGUAGE'. 
 * It is bound to "smart-test-config" module.
 */

angular
		.module('smarttestApp')
		.constant(
				'REST_URLS',
				{
					fetchConfigurationList : 'api/v1/configurations',
					fetchUnitCodeDetails : 'api/v1/unitCodeDetails',

					deleteWorkStationDetails : 'api/v1/workStationDetails/',
					deleteCanHardware : 'api/v1/canHardware/',
					deleteConfigSetting : 'api/v1/configSetting/',
					deleteJdTesterHardware : 'api/v1/jdTesterHardware/',
					
					savePlantStationDetails : 'api/v1/plantStationDetails/',
					saveCanHardware : 'api/v1/canHardware/',
					saveConfigSetting : 'api/v1/configSetting/',
					saveJdTesterHardware : 'api/v1/jdTesterHardware/',
					saveAll : 'api/v1/saveAll/',

					fetchPlantStationDetails : 'api/v1/plantStationDetails/',
					fetchCanHardware : 'api/v1/canHardware/',
					fetchConfigSetting : 'api/v1/configSetting/',
					fetchJdTesterHardware : 'api/v1/jdTesterHardware/'
				
				})
