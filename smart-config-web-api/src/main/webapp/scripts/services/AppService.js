/**
 * Defines the Factory related to 'REST_CALLS'
 * It is bound to "smart-test-config" module.
 */

angular.module('smarttestApp')
	.service('appService', function () {
		this.showLoading = function () {
			$("#loading").css("display", "block");
		}

		this.hideLoading = function () {
			$("#loading").css("display", "none");
		}

		this.toggleModal = function () {
			$('#myModal').modal('toggle');
		}

		this.addNewRowToCanHardware = function (canhardware) {
			canhardware.push({
				channelName: '',
				canDevice: '',
				hardwareIndex: '',
				channelIndex: '',
				hardwareType: '',
				aliasName: ''
			});
		}

		this.addNewRowToConfigSetting = function (configsetting) {
			configsetting.push({
				key: '',
				value: '',
				value2: ''
			});
		}

		this.addNewRowToJdTesterhw = function (jdtesterhw) {
			jdtesterhw.push({
				name: '',
				description: '',
				tla: '',
				felxBoxPin: '',
				typeCode: '',
				bulkHeadPin: '',
				pullUp: '',
				pwm: '',
				connector: '',
				fusesRelays: '',
				blockOffset: '',
				bitOffset: '',
				rawMinimum: '',
				rawMaximum: '',
				scalingFactor: '',
				scalingOffset: '',
				scaledMinimum: '',
				scaledMaximum: '',
				um: ''
			});
		}

		this.validateCanHardware = function (obj) {
			if(obj.length > 0){
				if(obj[obj.length-1].channelName != '' || obj[obj.length-1].canDevice != '' || obj[obj.length-1].hardwareIndex != ''
					|| obj[obj.length-1].channelIndex != '' || obj[obj.length-1].hardwareType != '' || obj[obj.length-1].aliasName != ''){
				return true;
				} else {
					alert('Please fill Can Hardware details.');
					return false;
				}
			} else {
				return true;
			}
		}

		this.validateConfigSetting = function (obj) {
			if(obj.length > 0){
				if(obj[obj.length-1].key != '' || obj[obj.length-1].value != '' || obj[obj.length-1].value2 != ''){
					return true;
				} else {
					alert('Please fill Config Setting details.');
					return false;
				}
			} else {
				return true;
			}
		}

		this.validateJDTesterHW = function (obj) {
			if(obj.length > 0){
				if(obj[obj.length-1].name != '' || obj[obj.length-1].description != '' || obj[obj.length-1].tla != ''
				|| obj[obj.length-1].felxBoxPin != '' || obj[obj.length-1].typeCode != '' || obj[obj.length-1].bulkHeadPin != ''){
					return true;
				} else {
					alert('Please fill JDTester HW details.');
					return false;
				}
			} else {
				return true;
			}
		}

		this.addPlantStationId = function(list, plantStationId){
			const result = list.slice();
			result.forEach(element => {
				//console.log(element);
				element.plantStationId = plantStationId;
			});
			console.log(result);
			return result;
		}
	});