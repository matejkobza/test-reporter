'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service) {
        var vm = this;
        vm.deleteController = deleteController;

        service.loadSettings().then(function (response) {
            vm.settings = response.data;
        });

        function deleteController() {
            service.deleteSettings(vm.setting).then(function (response) {
                $state.go('settings');
            });
        }

    });