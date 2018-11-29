/**
 * Defines the Factory related to 'REST_CALLS'
 * It is bound to "smart-test-config" module.
 */

(function() {
    var appFactory = function($http, REST_URLS) {
        
        var service = {};
        
        service.fetchConfigurationList = function(){
        	return $http.get(REST_URLS.fetchConfigurationList);
        }

        service.fetchUnitCodeDetails = function(){
        	return $http.get(REST_URLS.fetchUnitCodeDetails);
        }

        /* Getting Data For Delete - starts */
        service.deleteWorkStationDetails = function(id){
        	return $http.delete(REST_URLS.deleteWorkStationDetails + id);
        }

        service.deleteCanHardware = function(id){
        	return $http.delete(REST_URLS.deleteCanHardware + id);
        }

        service.deleteConfigSetting = function(id){
        	return $http.delete(REST_URLS.deleteConfigSetting + id);
        }
        
        service.deleteJdTesterHardware = function(id){
        	return $http.delete(REST_URLS.deleteJdTesterHardware + id);
        }
        /* Getting Data For Delete - Ends */
        /* Getting Data For Save - starts */
        service.savePlantStationDetails = function(obj){
        	return $http.post(REST_URLS.savePlantStationDetails, obj);
        }

        service.saveCanHardware = function(obj){
        	return $http.post(REST_URLS.saveCanHardware, obj);
        }

        service.saveConfigSetting = function(obj){
        	return $http.post(REST_URLS.saveConfigSetting, obj);
        }

        service.saveJdTesterHardware = function(obj){
        	return $http.post(REST_URLS.saveJdTesterHardware, obj);
        }

        service.saveAll = function(obj){
        	return $http.post(REST_URLS.saveAll, obj);
        }
        /* Getting Data For Save - Ends */
        /* Getting Data For Update - starts */
        service.fetchPlantStationDetails = function(id){
        	return $http.get(REST_URLS.fetchPlantStationDetails + id);
        }

        service.fetchCanHardware = function(plantStationId){
        	return $http.get(REST_URLS.fetchCanHardware + plantStationId);
        }

        service.fetchConfigSetting = function(plantStationId){
        	return $http.get(REST_URLS.fetchConfigSetting + plantStationId);
        }

        service.fetchJdTesterHardware = function(plantStationId){
        	return $http.get(REST_URLS.fetchJdTesterHardware + plantStationId);
        }
        
        /* Getting Data For Update - ends */
        return service;
    };

    appFactory.$inject = [ '$http', 'REST_URLS' ];

    angular.module('smarttestApp').factory('appFactory', appFactory);
}());