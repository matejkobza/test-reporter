'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service, $state) {
        var vm = this;
        vm.deleteSetting = deleteSetting;

        service.loadSettings().then(function (response) {
            vm.settings = response.data;
        });


        function deleteSetting() {
            service.deleteSettings(vm.settings).then(function (response) {
                console.debug("DEBUG: ", vm.settings);
                $state.go('settings');
            });
        }
        return vm;
    });