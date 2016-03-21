'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service, $state) {

        var vm = this;
        vm.deleteSetting = deleteSetting;
        vm.updateSetting = updateSetting;
        vm.findOneSetting = findOneSetting;

        service.loadSettings().then(function (response) {
              vm.settings = response.data;
        });


        function deleteSetting(subjects) {
            service.deleteSettings(subjects).then(function (response) {
                $state.go('settings');
            });
        }

        function updateSetting() {
            service.updateSettings(vm.settings).then(function (response) {
                $state.go('settings');
            });
        }

        function findOneSetting(subjects) {
            console.debug("DEBUG1: ", subjects);
            service.findOneSettings(subjects).then(function (response) {
                vm.settings = response.data;
                console.debug("DEBUG2: ", response.data);
            });
        }

        return vm;
    });