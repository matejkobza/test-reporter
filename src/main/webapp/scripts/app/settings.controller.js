'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service) {
        var vm = this;
        vm.deleteSetting = deleteSetting;

        service.loadSettings().then(function (response) {
            vm.settings = response.data;
        });

        function deleteSetting() {
            service.deleteSettings(vm.setting).then(function (response) {
                $state.go('settings');
            });
        }
        return vm;
    });