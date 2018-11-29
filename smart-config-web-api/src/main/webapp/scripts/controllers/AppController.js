/**
 * Defines the Controller related to 'REST_CALLS'
 * It is bound to "smart-test-config" module.
 */

angular.module('smarttestApp', [])
  .controller("MainController", ['$scope', 'appFactory', 'appService', function ($scope, appFactory, appService) {

    $scope.selectBox = 'Plant Station Details';
    $scope.plantstation = {};
    $scope.canhardware = [];
    $scope.configsetting = [];
    $scope.jdtesterhw = [];
    $scope.plantStationId = "";


    $scope.init = function () {
      appService.showLoading();
      $scope.fetchUnitCodeDetails();
      appService.hideLoading();
    }

    $scope.getConfigurationList = function () {
      appFactory.fetchConfigurationList().then(function (response) {
        $scope.configurations = response.data;
      });
    }

    $scope.fetchUnitCodeDetails = function () {
      $scope.newWorkstationNo = "";
      var plantStationDetails = appFactory.fetchUnitCodeDetails();
      plantStationDetails.then(function (response) {
        $scope.plantStations = response.data;
      });
    }
    /* Delete - starts */
    $scope.deleteWorkStationInfo = function (id) {
      appService.showLoading();
      appFactory.deleteWorkStationDetails(id).then(function (response) {
        $scope.fetchUnitCodeDetails();
        appService.hideLoading();
      });
    }

    $scope.deleteCanHardware = function (id) {
      //appService.showLoading();
      appFactory.deleteCanHardware(id).then(function (response) {
        $scope.fetchUnitCodeDetails();
        //appService.hideLoading();
      });
    }

    $scope.deleteConfigSetting = function (id) {
      //appService.showLoading();
      appFactory.deleteConfigSetting(id).then(function (response) {
        $scope.fetchUnitCodeDetails();
        //appService.hideLoading();
      });
    }

    $scope.deleteJdTesterHardware = function (id) {
      //appService.showLoading();
      appFactory.deleteJdTesterHardware(id).then(function (response) {
        $scope.fetchUnitCodeDetails();
        //appService.hideLoading();
      });
    }
    /* Delete - Ends */
    /* Save - starts */
    $scope.savePlantStationDetails = function (plantstation) {
      appService.showLoading();
      appFactory.savePlantStationDetails(plantstation).then(function (response) {
        $scope.fetchUnitCodeDetails();
        appService.hideLoading();
      });
    }

    $scope.saveCanHardware = function (canhardware, id) {
      appService.showLoading();
      canhardware = appService.addPlantStationId(canhardware, id);
      appFactory.saveCanHardware(canhardware).then(function (response) {
        $scope.fetchUnitCodeDetails();
        appService.hideLoading();
      });
    }

    $scope.saveConfigSetting = function (configsetting, id) {
      appService.showLoading();
      configsetting = appService.addPlantStationId(configsetting, id);
      appFactory.saveConfigSetting(configsetting).then(function (response) {
        $scope.fetchUnitCodeDetails();
        appService.hideLoading();
      });
    }

    $scope.saveJdTesterHardware = function (jdtesterhw, id) {
      appService.showLoading();
      jdtesterhw = appService.addPlantStationId(jdtesterhw, id);
      appFactory.saveJdTesterHardware(jdtesterhw).then(function (response) {
        $scope.fetchUnitCodeDetails();
        appService.hideLoading();
      });
    }

    $scope.saveAll = function () {
      appService.showLoading();
      var workStationNewBean = {
        plantStationDetailsBean: $scope.plantstation,
        canHardwareBeanList: $scope.canhardware,
        configSettingBeanList: $scope.configsetting,
        jdTesterHardwareBeanList: $scope.jdtesterhw
      };
      console.log(workStationNewBean);
      appFactory.saveAll(workStationNewBean).then(function (response) {
        $scope.fetchUnitCodeDetails();
        appService.toggleModal();
        appService.hideLoading();
      });
    }

    /* Save - ends */

    $scope.openModalToUpdate = function (id) {
      appService.showLoading();
      appFactory.fetchPlantStationDetails(id).then(function (response) {
        $scope.plantstation = response.data;
        $scope.plantStationId = $scope.plantstation.id;
        $scope.newWorkstationNo = $scope.plantstation.stationNumber;
        appFactory.fetchCanHardware(id).then(function (response) {
          $scope.canhardware = response.data;
          appFactory.fetchConfigSetting(id).then(function (response) {
            $scope.configsetting = response.data;
            appFactory.fetchJdTesterHardware(id).then(function (response) {
              $scope.jdtesterhw = response.data;
              $scope.getConfigurationList();
              appService.toggleModal();
              appService.hideLoading();
            });
          });
        });
      });
    }

    $scope.openModalForNewEntry = function () {
      $scope.selectBox = 'Plant Station Details';
      $scope.getConfigurationList();
      $scope.clearForms();
      $scope.plantstation.stationNumber = $scope.newWorkstationNo;
    }

    $scope.clearForms = function () {
      $scope.plantstation = {};
      $scope.canhardware = [];
      $scope.configsetting = [];
      $scope.jdtesterhw = [];
    }

    $scope.addNewRow = function (type) {
      if (type === 'Can Hardware') {
        if (appService.validateCanHardware($scope.canhardware)) {
          appService.addNewRowToCanHardware($scope.canhardware);
        }
      } else if (type === 'Config Setting') {
        if (appService.validateConfigSetting($scope.configsetting)) {
          appService.addNewRowToConfigSetting($scope.configsetting);
        }
      } else if (type === 'JDTester HW') {
        if (appService.validateJDTesterHW($scope.jdtesterhw)) {
          appService.addNewRowToJdTesterhw($scope.jdtesterhw);
        }
      }
    }

    $scope.deleteRow = function (type, obj) {
      if (type === 'Can Hardware') {
        var index = $scope.canhardware.indexOf(obj);
        $scope.deleteCanHardware($scope.canhardware[index].id);
        $scope.canhardware.splice(index, 1);
      } else if (type === 'Config Setting') {
        var index = $scope.configsetting.indexOf(obj);
        $scope.deleteConfigSetting($scope.configsetting[index].id);
        $scope.configsetting.splice(index, 1);
      } else if (type === 'JDTester HW') {
        var index = $scope.jdtesterhw.indexOf(obj);
        $scope.deleteJdTesterHardware($scope.jdtesterhw[index].id);
        $scope.jdtesterhw.splice(index, 1);
      }
    }
   

    $scope.init();

  }]);